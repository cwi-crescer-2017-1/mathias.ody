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
                .HasForeignKey(x => x.IdProduto);
        }
    }
}
