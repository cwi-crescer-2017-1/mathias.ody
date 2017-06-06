using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuarios");

            Property(x => x.Nome)
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.Email)
                .IsRequired()
                .HasMaxLength(100);

            Property(x => x.Senha)
                .IsRequired()
                .HasMaxLength(100);
        }
    }
}
