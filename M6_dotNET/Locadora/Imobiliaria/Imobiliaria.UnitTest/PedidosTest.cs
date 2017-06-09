using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Imobiliaria.Infraestrutura.Repositorios;
using Imobiliaria.Api.Models;
using System.Collections.Generic;

namespace Imobiliaria.UnitTest
{
    //Teste manual para cadastro de pedido
    [TestClass]
    public class PedidosTest
    {
        [TestMethod]
        public void CriarPedido()
        {
            PedidoRepositorio repositorio = new PedidoRepositorio();
            ItensPedidoRepositorio repositorioItens = new ItensPedidoRepositorio();

            ItemPedidoModel[] listaItens = new ItemPedidoModel[3];
            var item1 = new ItemPedidoModel();
            item1.idProduto = 2; item1.Quantidade = 1;
            var item2 = new ItemPedidoModel();
            item2.idProduto = 5; item2.Quantidade = 1;
            var item3 = new ItemPedidoModel();
            item3.idProduto = 8; item3.Quantidade = 3;
            listaItens[0] = item1;
            listaItens[1] = item2;
            listaItens[2] = item3;

            EnviarPedidoModel model = new EnviarPedidoModel();
            model.DiariasAlugadas = 2;
            model.idCliente = 11;
            model.Itens = listaItens;

            var idPedido = repositorio.Adicionar(model.idCliente, DateTime.Now, model.DiariasAlugadas);

            //Adicionar
            foreach (ItemPedidoModel item in model.Itens)
            {
                repositorioItens.Adicionar(item.idProduto, item.Quantidade, idPedido);
            }

            repositorio.SetValorTotal(idPedido, model.DiariasAlugadas);

            Assert.IsNull(null);
        }
    }
}
