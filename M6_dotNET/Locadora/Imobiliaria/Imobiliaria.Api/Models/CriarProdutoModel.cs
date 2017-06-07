using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Imobiliaria.Api.Models
{
    public class CriarProdutoModel
    {
        public string Nome { get; set; }
        public int Quantidade { get; set; }
        public int TipoProduto { get; set; }
        public decimal Preco { get; set; }
    }
}