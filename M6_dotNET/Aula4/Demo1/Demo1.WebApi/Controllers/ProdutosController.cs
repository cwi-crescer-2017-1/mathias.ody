using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositiorios;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class ProdutosController : ApiController
    {
        ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
        public IHttpActionResult Post (Produto produto)
        {
            var mensagens = new List<string>();
            if (!produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

            produtoRepositorio.Criar(produto);

            return Ok(produto);
        }

        public IHttpActionResult Get ()
        {
            var produtos = produtoRepositorio.Listar();

            return Ok(produtos);
        }
    }
}