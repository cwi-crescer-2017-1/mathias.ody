namespace Imobiliaria.Dominio.Entidades
{
    public class ItemPedido
    {
        public int Id { get; private set; }
        public Produto Produto { get; private set; }
        public Pedido Pedido { get; private set; }
        public int Quantidade { get; private set; }
        public decimal PrecoUnidade { get; private set; }
    }
}