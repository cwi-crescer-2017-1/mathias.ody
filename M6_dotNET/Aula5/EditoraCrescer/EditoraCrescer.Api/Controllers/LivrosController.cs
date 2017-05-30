using EditoraCrescer.Infraestrutura;
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
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }

        public IHttpActionResult Post(Livro livro)
        {
            return Ok(repositorio.Criar(livro));
        }

        public IHttpActionResult Delete(Livro livro)
        {
            repositorio.Excluir(livro);
            return Ok();
        }
    }
}
