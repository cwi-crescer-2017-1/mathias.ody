using Imobiliaria.Dominio.Entidades;
using System;

namespace Imobiliaria.Api.Models
{
    public class RegistrarClienteModel
    {
        public string Nome { get; set; }
        public string CPF { get; set; }
        public string Telefone { get; set; }
        public string Endereco { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}