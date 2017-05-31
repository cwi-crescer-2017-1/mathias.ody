using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutoresRepositorio repositorio = new AutoresRepositorio();

        [HttpGet]
        [Route("")]
        public IHttpActionResult ObterLista()
        {
            var autores = repositorio.ObterLista();
            return Ok(new { dados = autores });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterAutor(int id)
        {
            var autor = repositorio.ObterAutor(id);
            return Ok(new { dados = autor });
        }

        [HttpGet]
        [Route("{id}/Livros")]
        public IHttpActionResult ObterLivrosDoAutor(int id)
        {
            var livros = repositorio.ObterLivrosAutor(id);
            return Ok(new { dados = livros });
        }

        [HttpPost]
        [Route("")]
        public IHttpActionResult AdicionarAutor(Autor autor)
        {
            var autorRetorno = repositorio.Criar(autor);
            return Ok(autorRetorno);
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarAutor(int id, Autor autor)
        {
            repositorio.Alterar(id, autor);
            return Ok();
        }

        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}