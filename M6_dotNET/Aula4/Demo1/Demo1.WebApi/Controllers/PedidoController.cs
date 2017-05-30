using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidoController : ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Post (Pedido pedido)
        {
            var mensagens = new List<string>();
            //se der erro
            if (!pedido.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));
            //senão criar pedido
            _pedidoRepositorio.Criar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Get(int? id = null)
        {
            if (id != null)
            {
                var pedido = _pedidoRepositorio.Obter((int)id);
                return Ok(pedido);
            }
            else
            {
                var pedidos = _pedidoRepositorio.Listar();
                return Ok(pedidos);
            }
        }

        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);
            return Ok();
        }
    }
}