using System;

namespace Imobiliaria.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string CPF { get; private set; }
        public string Telefone { get; private set; }
        public string Endereco { get; private set; }
        public Genero Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }

        public Cliente () { }

        public Cliente (string Nome, 
                        string CPF, 
                        string Telefone, 
                        string Endereco, 
                        Genero Genero, 
                        DateTime DataNascimento)
        {
            this.Nome = Nome;
            this.CPF = CPF;
            this.Telefone = Telefone;
            this.Endereco = Endereco;
            this.Genero = Genero;
            this.DataNascimento = DataNascimento;
        }
    }
}
