using Imobiliaria.Dominio.Entidades;
using System;

namespace Imobiliaria.Api.Models
{
    public class EditarClienteModel
    {
        public int Id { get;  set; }
        public string Nome { get;  set; }
        public string CPF { get;  set; }
        public string Telefone { get;  set; }
        public string Endereco { get;  set; }
        public Genero Genero { get;  set; }
        public DateTime DataNascimento { get;  set; }

        public EditarClienteModel (int Id,
                        string Nome,
                        string CPF,
                        string Telefone,
                        string Endereco,
                        Genero Genero,
                        DateTime DataNascimento)
        {
            this.Id = Id;
            this.Nome = Nome;
            this.CPF = CPF;
            this.Telefone = Telefone;
            this.Endereco = Endereco;
            this.Genero = Genero;
            this.DataNascimento = DataNascimento;
        }
    }
}