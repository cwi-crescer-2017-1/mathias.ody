﻿using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Mapppings
{
    public class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");
        }
    }
}
