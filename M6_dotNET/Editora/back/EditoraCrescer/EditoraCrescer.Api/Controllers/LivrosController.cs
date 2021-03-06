﻿using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
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
       
        public IHttpActionResult ObterPagina(int jump, int bring, bool full = false)
        {
            object livros;
            if (full == true)
                livros = repositorio.ObterPaginaCompleta(jump, bring);
            else
                livros = repositorio.ObterPaginaApenasPublicados(jump, bring);
            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivro(int isbn)
        {
            var livro = repositorio.ObterLivro(isbn);

            if (livro == null)
                return BadRequest("Esse livro não se encontra cadastrado");

            return Ok(new { dados = livro });
        }

        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult ObterLivroGenero(string genero)
        {
            var livros = repositorio.ObterLivrosGenero(genero);
            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("Lancamentos")]
        public IHttpActionResult ObterLancamentos()
        {
            var livros = repositorio.ObterLancamentos();
            return Ok(new { dados = livros });
        }

        [HttpPost]
        [BasicAuthorization(Roles = "Administrador,Publicador,Revisor,Colaborador")]
        public IHttpActionResult AdicionarLivro(Livro livro)
        {
            var livroRetorno = repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [HttpPost]
        [Route("lista")]
        [BasicAuthorization(Roles = "Administrador,Publicador,Revisor,Colaborador")]
        public IHttpActionResult AdicionarListaLivros(Livro[] livros)
        {
            foreach (Livro livro in livros)
            {
                repositorio.Criar(livro);
            }
            return Ok(new { dados = livros });
        }

        [HttpPut]
        [Route("{isbn}")]
        [BasicAuthorization(Roles = "Administrador,Publicador,Revisor,Colaborador")]
        public IHttpActionResult AlterarLivro(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return BadRequest("O livro que você informou não é o mesmo que quer editar");

            if (!repositorio.LivroExiste(livro.Isbn))
                return BadRequest("Esse livro não se encontra cadastrado");

            repositorio.Alterar(isbn,livro);
            return Ok();
        }

        [HttpPut]
        [Route("revisar/{isbn}")]
        [BasicAuthorization(Roles = "Revisor")]
        public IHttpActionResult RevisarLivro(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return BadRequest("O livro que você informou não é o mesmo que quer editar");

            if (!repositorio.LivroExiste(livro.Isbn))
                return BadRequest("Esse livro não se encontra cadastrado");

            livro.DataRevisao = DateTime.Now;
            
            repositorio.Alterar(isbn, livro);
            return Ok();
        }

        [HttpPut]
        [Route("publicar/{isbn}")]
        [BasicAuthorization(Roles = "Publicador")]
        public IHttpActionResult PublicarLivro(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return BadRequest("O livro que você informou não é o mesmo que quer editar");

            if (!repositorio.LivroExiste(livro.Isbn))
                return BadRequest("Esse livro não se encontra cadastrado");

            livro.DataPublicacao = DateTime.Now;

            repositorio.Alterar(isbn, livro);
            return Ok();
        }

        [HttpDelete]
        [Route("{isbn}")]
        [BasicAuthorization(Roles = "Administrador,Publicador,Revisor,Colaborador")]
        public IHttpActionResult Delete(int isbn)
        {
            bool sucesso = repositorio.Excluir(isbn);
            if (sucesso)
                return Ok();

            else
                return BadRequest("Esse livro não se encontra cadastrado");
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
