namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class TornarDatasOpcionaisEmLivro : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime());
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime(nullable: false));
        }
    }
}
