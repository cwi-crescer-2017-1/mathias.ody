namespace Imobiliaria.Dominio.Entidades
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
    }
}
