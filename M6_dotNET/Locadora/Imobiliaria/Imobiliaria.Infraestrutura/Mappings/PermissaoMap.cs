using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.Infraestrutura.Mappings
{
    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissoes");
        }
    }
}

