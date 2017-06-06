using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }
        public int Id { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
