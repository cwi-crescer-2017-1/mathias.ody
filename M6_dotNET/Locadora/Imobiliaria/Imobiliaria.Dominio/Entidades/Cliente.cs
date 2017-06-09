using System;

namespace Imobiliaria.Dominio.Entidades
{
    public class Cliente :EntidadeBasica
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

        public Cliente( int Id,
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

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(CPF))
                Mensagens.Add("CPF é inválido.");

            if (string.IsNullOrWhiteSpace(Telefone))
                Mensagens.Add("Telefone é inválido.");

            if (string.IsNullOrWhiteSpace(Endereco))
                Mensagens.Add("Endereco é inválido.");

            if (DataNascimento < new DateTime(1900))
                Mensagens.Add("Data de nascimento é inválida.");

            return Mensagens.Count == 0;
        }
    }
}
