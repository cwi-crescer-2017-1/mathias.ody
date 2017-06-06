using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    public class Permissao
    {
        [Required]
        public string Nome { get; private set; }
        public int Id { get; private set; }

        public Permissao()
        { }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
