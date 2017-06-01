using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
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

            if (revisor == null)
                return BadRequest("Esse revisor não se encontra cadastrado");

            return Ok(new { dados = revisor });
        }

        [HttpPost]
        [Route("")]
        public IHttpActionResult AdicionarRevisor(Revisor revisor)
        {
            var revisorRetorno = repositorio.Criar(revisor);
            return Ok(new { dados = revisorRetorno });
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarRevisor(int id, Revisor revisor)
        {
            if (id != revisor.Id)
                return BadRequest("O revisor que você informou não é o mesmo que quer editar");

            if (!repositorio.RevisorExiste(revisor.Id))
                return BadRequest("Esse revisor não se encontra cadastrado");

            repositorio.Alterar(id, revisor);
            return Ok((new { dados = revisor }));
        }

        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            bool sucesso = repositorio.Excluir(id);

            if (sucesso)
                return Ok();

            else
                return BadRequest("Esse revisor não se encontra cadastrado");
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
