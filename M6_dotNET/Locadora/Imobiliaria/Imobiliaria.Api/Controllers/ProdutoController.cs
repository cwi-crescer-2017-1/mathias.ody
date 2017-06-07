using Imobiliaria.Api.Models;
using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Repositorios;
using System.Web.Http;

namespace Imobiliaria.Api.Controllers
{
    [RoutePrefix("api/produtos")]
    public class ProdutoController : ApiController
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        [HttpGet]
        [Route("")]
        public IHttpActionResult ObterLista()
        {
            var produtos = repositorio.Listar();
            return Ok(new { dados = produtos });
        }


        //
        // Métodos de uso do administrador
        //

        // Post produto
        [HttpPost, Route("")]
        [BasicAuthorization(Roles = "Administrador")]
        public IHttpActionResult AdicionarProduto([FromBody]CriarProdutoModel model)
        {
            var produto = new Produto(model.Nome,model.TipoProduto,model.Quantidade,model.Preco);

            repositorio.Criar(produto);
            return Ok(new { dados = produto });
        }

        // Delete produto
        [HttpDelete, Route("")]
        [BasicAuthorization(Roles = "Administrador")]
        public IHttpActionResult RemoverProduto (int id)
        {
            bool sucesso = repositorio.Excluir(id);
            if (sucesso)
                return Ok();

            else
                return BadRequest("Esse produto não existe.");
        }

        // Dispose
        protected override void Dispose (bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
