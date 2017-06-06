namespace Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SubstituirIdIntPorIdGuid : DbMigration
    {
        public override void Up()
        {
            DropPrimaryKey("dbo.Usuarios");
            AddColumn("dbo.Permissoes", "Usuario_Id", c => c.Guid());

            DropColumn("dbo.Usuarios", "Id");
            AddColumn("dbo.Usuarios", "Id", c => c.Guid(nullable: false, identity: true));

            AddPrimaryKey("dbo.Usuarios", "Id");
            CreateIndex("dbo.Permissoes", "Usuario_Id");
            AddForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropPrimaryKey("dbo.Usuarios");

            DropColumn("dbo.Usuarios", "Id");
            AddColumn("dbo.Usuarios", "Id", c => c.Int(nullable: false, identity: true));

            DropColumn("dbo.Permissoes", "Usuario_Id");
            AddPrimaryKey("dbo.Usuarios", "Id");
        }
    }
}
