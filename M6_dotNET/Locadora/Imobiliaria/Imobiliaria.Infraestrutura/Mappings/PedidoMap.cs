using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedidos");

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));
        }
    }
}
