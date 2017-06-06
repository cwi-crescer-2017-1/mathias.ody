using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Clientes");

            Property (x => x.Nome)
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.CPF)
                .IsRequired()
                .HasMaxLength(20);

            Property(x => x.Endereco)
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.Telefone)
                .IsRequired()
                .HasMaxLength(12);
        }
    }
}
