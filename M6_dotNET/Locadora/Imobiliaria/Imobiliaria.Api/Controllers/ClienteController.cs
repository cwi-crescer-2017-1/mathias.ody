using Imobiliaria.Api.Models;
using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace Imobiliaria.Api.Controllers
{
    [RoutePrefix("api/clientes")]
    [BasicAuthorization]
    public class ClienteController : ApiController
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        // Get lista clientes
        [HttpGet,Route("")]
        public IHttpActionResult ObterLista()
        {
            var clientes = repositorio.Listar();
            return Ok(new { dados = clientes });
        }

        // Post cliente
        [HttpPost, Route("")]
        public IHttpActionResult AdicionarCliente([FromBody]RegistrarClienteModel model)
        {
            var cliente = new Cliente(model.Nome, model.CPF, model.Telefone, model.Endereco, model.Genero, model.DataNascimento);
            repositorio.Criar(cliente);
            return Ok(new { dados = cliente });
        }

        // Delete cliente
        [HttpDelete, Route("")]
        [BasicAuthorization(Roles = "Administrador")]
        public IHttpActionResult RemoverCliente(int id)
        {
            bool sucesso = repositorio.Excluir(id);
            if (sucesso)
                return Ok();

            else
                return BadRequest("Esse cliente não existe.");
        }

        // Dispose
        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}