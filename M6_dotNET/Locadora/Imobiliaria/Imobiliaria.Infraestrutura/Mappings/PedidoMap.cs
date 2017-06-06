using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Infraestrutura.Mappings
{
    class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedidos");

            HasRequired(x => x.ItemPedido)
                .WithMany()
                .HasForeignKey(x => x.IdItemPedido);

            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);
        }
    }
}
