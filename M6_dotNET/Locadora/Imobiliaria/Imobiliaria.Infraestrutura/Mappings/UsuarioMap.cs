using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuarios");
        }
    }
}
