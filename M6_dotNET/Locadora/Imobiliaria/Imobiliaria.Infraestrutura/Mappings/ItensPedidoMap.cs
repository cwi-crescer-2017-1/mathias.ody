using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class ItemPedidoMap : EntityTypeConfiguration<ItemPedido>
    {
        public ItemPedidoMap()
        {
            ToTable("ItensPedido");

            HasRequired(x => x.Produto)
                .WithMany()
                .Map(x => x.MapKey("IdProduto"));

            HasRequired(x => x.Pedido)
                .WithMany()
                .Map(x => x.MapKey("IdPedido"));

        }
    }
}
