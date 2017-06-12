using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ItensPedidoRepositorio
    {

        public void Adicionar(int idProduto, int quantidade, int idPedido, ref Contexto contextoPedido)
        {
            //var produto = new ProdutoRepositorio().Obter(idProduto);
            //var pedido = new PedidoRepositorio().Obter(idPedido);
            var produto = contextoPedido.Produtos
                                                .Where (x => x.Id == idProduto)
                                                .FirstOrDefault();
            bool sucesso = produto.Baixar(quantidade);
            if (!sucesso)
                return;

            var pedido = contextoPedido.Pedidos
                                                .Where(x => x.Id == idPedido)
                                                .FirstOrDefault();

            var itemPedido = new ItemPedido(produto, pedido, quantidade);

            contextoPedido.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contextoPedido.ItemPedidos.Add(itemPedido);
            contextoPedido.SaveChanges();
        }
    }
}
