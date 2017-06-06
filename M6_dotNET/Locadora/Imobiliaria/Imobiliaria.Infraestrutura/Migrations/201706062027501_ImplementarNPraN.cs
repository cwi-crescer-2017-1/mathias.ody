namespace Imobiliaria.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ImplementarNPraN : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Pedidos", "IdItemPedido", "dbo.ItensPedido");
            DropIndex("dbo.Pedidos", new[] { "IdItemPedido" });
            AddColumn("dbo.ItensPedido", "IdPedido", c => c.Int(nullable: false));
            CreateIndex("dbo.ItensPedido", "IdPedido");
            AddForeignKey("dbo.ItensPedido", "IdPedido", "dbo.Pedidos", "Id", cascadeDelete: true);
            DropColumn("dbo.Pedidos", "IdItemPedido");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Pedidos", "IdItemPedido", c => c.Int(nullable: false));
            DropForeignKey("dbo.ItensPedido", "IdPedido", "dbo.Pedidos");
            DropIndex("dbo.ItensPedido", new[] { "IdPedido" });
            DropColumn("dbo.ItensPedido", "IdPedido");
            CreateIndex("dbo.Pedidos", "IdItemPedido");
            AddForeignKey("dbo.Pedidos", "IdItemPedido", "dbo.ItensPedido", "Id", cascadeDelete: true);
        }
    }
}
