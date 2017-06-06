﻿using System.Data.Entity.ModelConfiguration;
using Imobiliaria.Dominio.Entidades;

namespace Infraestrutura.Mappings
{
    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Clientes");
        }
    }
}
