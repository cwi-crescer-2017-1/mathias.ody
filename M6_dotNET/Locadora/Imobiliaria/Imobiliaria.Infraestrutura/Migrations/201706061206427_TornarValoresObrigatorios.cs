namespace Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class TornarValoresObrigatorios : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Clientes", "Genero", c => c.String(nullable: false));
            AlterColumn("dbo.Clientes", "Nome", c => c.String(nullable: false));
            AlterColumn("dbo.Clientes", "CPF", c => c.String(nullable: false));
            AlterColumn("dbo.Clientes", "Telefone", c => c.String(nullable: false));
            AlterColumn("dbo.Clientes", "Endereco", c => c.String(nullable: false));
            AlterColumn("dbo.Produtos", "Nome", c => c.String(nullable: false));
            AlterColumn("dbo.Produtos", "Tipo", c => c.String(nullable: false));
            AlterColumn("dbo.Permissoes", "Nome", c => c.String(nullable: false));
            AlterColumn("dbo.Usuarios", "Nome", c => c.String(nullable: false));
            AlterColumn("dbo.Usuarios", "Email", c => c.String(nullable: false));
            AlterColumn("dbo.Usuarios", "Senha", c => c.String(nullable: false));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Usuarios", "Senha", c => c.String());
            AlterColumn("dbo.Usuarios", "Email", c => c.String());
            AlterColumn("dbo.Usuarios", "Nome", c => c.String());
            AlterColumn("dbo.Permissoes", "Nome", c => c.String());
            AlterColumn("dbo.Produtos", "Tipo", c => c.String());
            AlterColumn("dbo.Produtos", "Nome", c => c.String());
            AlterColumn("dbo.Clientes", "Endereco", c => c.String());
            AlterColumn("dbo.Clientes", "Telefone", c => c.Int(nullable: false));
            AlterColumn("dbo.Clientes", "CPF", c => c.Int(nullable: false));
            AlterColumn("dbo.Clientes", "Nome", c => c.String());
            DropColumn("dbo.Clientes", "Genero");
        }
    }
}
