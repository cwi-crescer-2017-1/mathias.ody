using Imobiliaria.Dominio.Entidades;
using Imobiliaria.Infraestrutura.Mappings;
using System.Data.Entity;

namespace Imobiliaria.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        { }

        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<ItemPedido> ItemPedidos { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Pedido> Pedidos { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new ItemPedidoMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new PedidoMap());
        }
    }
}
