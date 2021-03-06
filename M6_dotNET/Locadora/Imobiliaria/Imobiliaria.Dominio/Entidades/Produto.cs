﻿namespace Imobiliaria.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public TipoProduto TipoProduto { get; private set; }
        public int Quantidade { get; private set; }
        public decimal Preco { get; private set; }

        public Produto () { }

        public Produto(string Nome, int TipoProduto, int Quantidade, decimal Preco)
        {
            this.Nome = Nome;
            this.TipoProduto = (Entidades.TipoProduto)TipoProduto;
            this.Quantidade = Quantidade;
            this.Preco = Preco;
        }

        public bool Baixar (int quantidade)
        {
            if (this.Quantidade - quantidade < 0)
                return false;

            this.Quantidade -= quantidade;
            return true;
        }

        public void Subir(int quantidade)
        {
            this.Quantidade += quantidade;
        }
    }
}
