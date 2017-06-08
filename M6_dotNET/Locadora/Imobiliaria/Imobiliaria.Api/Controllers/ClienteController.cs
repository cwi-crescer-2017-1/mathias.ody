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

        // Get cliente por CPF
        [Route("")]
        [HttpGet, Route("CPF")]
        public IHttpActionResult Obter(string CPF)
        {
            var cliente = repositorio.Obter(CPF);
            return Ok(new { dados = cliente });
        }

        // Post cliente
        [HttpPost, Route("")]
        public IHttpActionResult AdicionarCliente([FromBody]RegistrarClienteModel model)
        {
            var cliente = new Cliente(model.Nome, model.CPF, model.Telefone, model.Endereco, model.Genero, model.DataNascimento);
            repositorio.Criar(cliente);
            return Ok(new { dados = cliente });
        }

        // Alterar cliente
        [HttpPut, Route("{id}")]
        public IHttpActionResult AlterarLivro(int id, EditarClienteModel model)
        {
            var cliente = new Cliente(model.Id, model.Nome, model.CPF, model.Telefone, model.Endereco, model.Genero, model.DataNascimento);

            if (id != cliente.Id)
                return BadRequest("O livro que você informou não é o mesmo que quer editar");

            /*if (!repositorio.LivroExiste(livro.Isbn))
                return BadRequest("Esse livro não se encontra cadastrado");*/

            repositorio.Alterar(cliente);
            return Ok();
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