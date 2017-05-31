using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterLista()
        {
            var livros = repositorio.ObterLista();
            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivro(int isbn)
        {
            var livro = repositorio.ObterLivro(isbn);
            return Ok(new { dados = livro });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult ObterLivroGenero(string genero)
        {
            var livros = repositorio.ObterLivrosGenero(genero);
            return Ok(new { dados = livros });
        }

        [HttpPost]
        public IHttpActionResult AdicionarLivro(Livro livro)
        {
            var livroRetorno = repositorio.Criar(livro);
            return Ok(livroRetorno);
        }


        [HttpPut]
        [Route("{isbn}")]
        public IHttpActionResult AlterarLivro(int isbn, Livro livro)
        {
            repositorio.Alterar(isbn,livro);
            return Ok();
        }

        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult Delete(int isbn)
        {
            repositorio.Excluir(isbn);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
