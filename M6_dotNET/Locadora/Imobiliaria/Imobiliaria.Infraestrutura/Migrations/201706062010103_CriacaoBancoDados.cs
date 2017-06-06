namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoBancoDados : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 100),
                        CPF = c.String(nullable: false, maxLength: 20),
                        Telefone = c.String(nullable: false, maxLength: 12),
                        Endereco = c.String(nullable: false, maxLength: 100),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ItensPedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        PrecoUnidade = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Produtos", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 100),
                        TipoProduto = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataVencimento = c.DateTime(nullable: false),
                        DataEntrega = c.DateTime(),
                        Multa = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdItemPedido = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.ItensPedido", t => t.IdItemPedido, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdItemPedido);
            
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Usuario_Id = c.Guid(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Usuarios", t => t.Usuario_Id)
                .Index(t => t.Usuario_Id);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(nullable: false, maxLength: 100),
                        Email = c.String(nullable: false, maxLength: 100),
                        Senha = c.String(nullable: false, maxLength: 100),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropForeignKey("dbo.Pedidos", "IdItemPedido", "dbo.ItensPedido");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.ItensPedido", "IdProduto", "dbo.Produtos");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropIndex("dbo.Pedidos", new[] { "IdItemPedido" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropIndex("dbo.ItensPedido", new[] { "IdProduto" });
            DropTable("dbo.Usuarios");
            DropTable("dbo.Permissoes");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Produtos");
            DropTable("dbo.ItensPedido");
            DropTable("dbo.Clientes");
        }
    }
}
