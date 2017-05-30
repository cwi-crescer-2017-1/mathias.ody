namespace Demo1.Dominio.Entidades
{
    public class ItemPedido
    {
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }

        public ItemPedido (int Id, int ProdutoId, int Quantidade)
        {
            this.Id = Id;
            this.ProdutoId = ProdutoId;
            this.Quantidade = Quantidade;
        }
    }
}