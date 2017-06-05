using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
    }
}
