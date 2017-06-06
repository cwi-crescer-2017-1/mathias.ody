namespace Infraestrutura.Migrations
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
                        Nome = c.String(),
                        CPF = c.Int(nullable: false),
                        Telefone = c.Int(nullable: false),
                        Endereco = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ItensPedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdProduto = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                        PrecoUnidade = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Produtos", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Tipo = c.String(),
                        Quantidade = c.Int(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdCliente = c.Int(nullable: false),
                        IdItemPedido = c.Int(nullable: false),
                        DataPedido = c.DateTime(nullable: false),
                        DataVencimento = c.DateTime(nullable: false),
                        DataEntrega = c.DateTime(),
                        Multa = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
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
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedidos", "IdItemPedido", "dbo.ItensPedido");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.ItensPedido", "IdProduto", "dbo.Produtos");
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
