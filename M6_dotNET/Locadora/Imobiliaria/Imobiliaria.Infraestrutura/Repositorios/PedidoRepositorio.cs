using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
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

            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();

            return pedido.Id;
        }

        public Pedido Obter (int id)
        {
            return contexto.Pedidos
                .Where(x => x.Id == id)
                .FirstOrDefault();
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
