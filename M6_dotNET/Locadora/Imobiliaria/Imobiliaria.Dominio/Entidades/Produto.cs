using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Tipo { get; set; }
        public int Quantidade { get; set; }
        public decimal Preco { get; set; }
    }
}
