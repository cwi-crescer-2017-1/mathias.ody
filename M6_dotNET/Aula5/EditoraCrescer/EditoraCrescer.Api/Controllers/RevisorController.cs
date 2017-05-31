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
    [RoutePrefix("api/revisores")]
    public class RevisorController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        [Route("")]
        public IHttpActionResult ObterLista()
        {
            var revisores = repositorio.ObterLista();
            return Ok(new { dados = revisores });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult ObterRevisor(int id)
        {
            var revisor = repositorio.ObterRevisor(id);
            return Ok(new { dados = revisor });
        }

        [HttpPost]
        [Route("")]
        public IHttpActionResult AdicionarRevisor(Revisor revisor)
        {
            var revisorRetorno = repositorio.Criar(revisor);
            return Ok(revisorRetorno);
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarRevisor(int id, Revisor revisor)
        {
            repositorio.Alterar(id, revisor);
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
