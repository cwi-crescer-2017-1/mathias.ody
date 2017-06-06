namespace Imobiliaria.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public TipoProduto TipoProduto { get; private set; }
        public int Quantidade { get; private set; }
        public decimal Preco { get; private set; }
    }
}
