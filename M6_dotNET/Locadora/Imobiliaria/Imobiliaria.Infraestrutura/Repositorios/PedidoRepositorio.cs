using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();
        ItensPedidoRepositorio itensRepo = new ItensPedidoRepositorio();

        public int Adicionar(int idCliente, DateTime DataPedido, int DiariasAlugadas)
        {
            var cliente = new ClienteRepositorio().ObterPorId(idCliente);
            var pedido = new Pedido(cliente, DataPedido, DiariasAlugadas);
            //Avisando o Entity Framework que o cliente já existe:
            contexto.Entry(pedido.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();

            return pedido.Id;
        }

        public Pedido Obter(int id)
        {
            return contexto.Pedidos
                .Where(x => x.Id == id)
                .FirstOrDefault();
        }

        public object ObterAtrasados ()
        {
            var pedidos = contexto.Pedidos
                                  .Where(x => x.DataVencimento < DateTime.Now)
                                  .Include("Cliente")
                                  .OrderBy(x => x.DataVencimento)
                                  .ToList();

            foreach (Pedido pedido in pedidos)
            {
                pedido.Multa = pedido.CalcularMulta();
            }

            return pedidos.Select(x => new
            {
                IdPedido = x.Id,
                NomeCliente = x.Cliente.Nome,
                DataPedido = x.DataPedido,
                DataVencimento = x.DataVencimento,
                Valor = x.ValorTotal,
                Multa = x.Multa,
                ValorTotal = x.Multa + x.ValorTotal
            });
        }

        public object ObterAntesDaData(DateTime dataFinal)
        {
            DateTime dataInicial = dataFinal.AddDays(-30);

            var pedidos = contexto.Pedidos
                                  .Where(x => x.DataEntrega != null && x.DataEntrega < dataFinal && x.DataEntrega > dataInicial)
                                  .Include("Cliente")
                                  .ToList();

            foreach (Pedido pedido in pedidos)
            {
                pedido.Multa = pedido.CalcularMulta();
            }

            return pedidos.Select(x => new
            {
                IdPedido = x.Id,
                NomeCliente = x.Cliente.Nome,
                DataPedido = x.DataPedido,
                DataVencimento = x.DataVencimento,
                Valor = x.ValorTotal,
                Multa = x.Multa,
                ValorTotal = x.Multa + x.ValorTotal
            });
        }

        public void Devolver(int id)
        {
            var pedido = contexto.Pedidos
                                 .Where(x => x.Id == id)
                                 .FirstOrDefault();
            pedido.Entregar();
            pedido.CalcularMulta();
            Alterar(pedido);

            var itens = contexto.ItemPedidos
                                 .Include("Produto") 
                                 .Where(x => x.Pedido.Id == id)
                                 .ToList();

            foreach (ItemPedido item in itens)
            {
                var produto = contexto.Produtos
                                      .Where(x => x.Id == item.Produto.Id)
                                      .FirstOrDefault();
                produto.Subir(item.Quantidade);
                contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            }
            contexto.SaveChanges();
        }

        public object ObterPedidosADevolver()
        {
            List<Pedido> pedidos = contexto.Pedidos
                                   .Where(x => x.DataEntrega == null)
                                   .Include("Cliente")
                                   .ToList();

            foreach (Pedido pedido in pedidos)
            {
                pedido.Multa = pedido.CalcularMulta();
            }

            object pedidosResumidos = pedidos.Select(x => new
            {
                IdPedido = x.Id,
                NomeCliente = x.Cliente.Nome,
                DataPedido = x.DataPedido,
                DataVencimento = x.DataVencimento,
                Valor = x.ValorTotal,
                Multa = x.Multa,
                ValorTotal = x.Multa + x.ValorTotal
            });

            return pedidosResumidos;
        }

        public void SetValorTotal (int idPedido, int dias)
        {
            var pedido = Obter(idPedido);
            /*decimal valorTotal = contexto.ItemPedidos
                                .Include("Pedido")
                                .Where(x => x.Pedido.Id == idPedido)
                                .Sum(x => x.PrecoUnidade * x.Quantidade);*/
            decimal valorTotal = 0;
            List<ItemPedido> itens = contexto.ItemPedidos
                                             .Include("Pedido")
                                             .Where(x => x.Pedido.Id == idPedido).ToList();
            foreach (ItemPedido item in itens)
            {
                valorTotal += item.PrecoUnidade * item.Quantidade;
            }
            valorTotal *= dias;
            pedido.SetValorTotal(valorTotal);
            Alterar(pedido);
        }

        public void AdicionarItemPedido (int idProduto, int Quantidade, int idPedido)
        {
            itensRepo.Adicionar(idProduto, Quantidade, idPedido, ref contexto);
        }

        public List<Pedido> ListarRecentes ()
        {
            var pedidos = contexto.Pedidos
                          .ToList();//WHERE DATA PEDIDO < QUE OUTRADATA ORDER BY
            return pedidos;
        }

        public List<Pedido> ListarAtrasados()
        {
            var pedidos = contexto.Pedidos
                          .ToList();//WHERE DATA VENCIMENTO > QUE DATA PEDIDO ORDER BY
            return pedidos;
        }

        public void Alterar(Pedido pedido)
        {
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
