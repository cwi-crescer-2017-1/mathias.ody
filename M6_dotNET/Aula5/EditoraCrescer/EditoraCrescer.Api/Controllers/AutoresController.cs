using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
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

            if (autor == null)
                return BadRequest("Esse autor não se encontra cadastrado");

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
            return Ok(new { dados = autorRetorno });
        }

        [HttpPut]
        [Route("{id}")]
        public IHttpActionResult AlterarAutor(int id, Autor autor)
        {
            if (id != autor.Id)
                return BadRequest("O autor que você informou não é o mesmo que quer editar");

            if (!repositorio.AutorExiste(autor.Id))
                return BadRequest("Esse autor não se encontra cadastrado");

            repositorio.Alterar(id, autor);
            return Ok(new { dados = autor });
        }

        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            bool sucesso = repositorio.Excluir(id);

            if (sucesso)
                return Ok();

            else
                return BadRequest("Esse autor não se encontra cadastrado");
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}