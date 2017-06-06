using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        [Required]
        public string Nome { get; set; }
        [Required]
        public string Tipo { get; set; }
        public int Quantidade { get; set; }
        public decimal Preco { get; set; }
    }
}
