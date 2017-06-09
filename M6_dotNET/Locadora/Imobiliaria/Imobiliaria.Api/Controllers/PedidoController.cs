using Imobiliaria.Api.Models;
using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura;
using Imobiliaria.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Imobiliaria.Api.Controllers
{
    [RoutePrefix("api/pedidos")]
    [BasicAuthorization]
    public class PedidoController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();
        private ProdutoRepositorio repositorioProdutos = new ProdutoRepositorio();

        // Post pedido
        [HttpPost, Route("")]
        public IHttpActionResult AdicionarPedido([FromBody]EnviarPedidoModel model)
        {
            //Validar
            model.Validar();

            foreach (ItemPedidoModel item in model.Itens)
            {
                string mensagem;
                if (!repositorioProdutos.ChecarEstoque(item.Quantidade, item.idProduto, out mensagem))
                {
                    return BadRequest(mensagem);
                }
            }

            var idPedido = repositorio.Adicionar(model.idCliente, DateTime.Now, model.DiariasAlugadas);

            //Adicionar
            foreach (ItemPedidoModel item in model.Itens)
            {
                repositorio.AdicionarItemPedido(item.idProduto, item.Quantidade, idPedido);
            }

            repositorio.SetValorTotal(idPedido, model.DiariasAlugadas);
            

            return Ok();
        }


        // Alterar cliente
        [HttpPut, Route("{id}")]
        public IHttpActionResult SetarDataPagamento(int id, DateTime data) //id sendo a rota, DateTime os dados
        {
            var pedido = repositorio.Obter(id);

            if (pedido != null)
                return BadRequest("Esse livro não se encontra cadastrado");

            pedido.Entregar(data);

            repositorio.Alterar(pedido);
            return Ok();
        }

        // Dispose
        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
