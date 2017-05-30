using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
            "Server=13.65.101.67;User Id=mathias.ody;Password=123456;DataBase=aluno01db";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                //inserir pedido
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"INSERT INTO PEDIDO (NomeCliente)
                        VALUES (@NomeCliente)";

                    comando.Parameters.AddWithValue("@NomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }




                foreach (ItemPedido item in pedido.Itens)
                {
                    //inserir itens pedido
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                            @"INSERT INTO ItemPedido (PedidoId,ProdutoId,Quantidade)
                            VALUES (@Pedido, @Produto, @Quantidade)";

                        comando.Parameters.AddWithValue("@Pedido", pedido.Id);
                        comando.Parameters.AddWithValue("@Produto", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                    }                

                    //diminuir quantidade do produto
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                        @"UPDATE Produto
                        SET Estoque = Estoque - @qtdeItens
                        WHERE Id = @IdProduto";

                        comando.Parameters.AddWithValue("@qtdeItens", item.Quantidade);
                        comando.Parameters.AddWithValue("@IdProduto", item.ProdutoId);

                        comando.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, NomeCliente FROM Pedido";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        pedidos.Add(pedido);
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Pedido.Id, Pedido.NomeCliente, ItemPedido.Id, ItemPedido.ProdutoId, ItemPedido.Quantidade
                        FROM (Pedido
                        INNER JOIN ItemPedido ON Pedido.Id = ItemPedido.PedidoId)
                        WHERE Pedido.Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens.Add (new ItemPedido ((int)dataReader["Id"],
                                                          (int)dataReader["ProdutoId"],
                                                          (int)dataReader["Quantidade"]));
                    }
                }
            }

            return pedido;
        }
    }
}
