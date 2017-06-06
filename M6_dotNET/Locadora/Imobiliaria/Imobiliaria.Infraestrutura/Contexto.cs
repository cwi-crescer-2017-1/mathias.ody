using Imobiliaria.Dominio.Entidades;
using Infraestrutura.Mappings;
using System.Data.Entity;

namespace Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        { }

        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<ItemPedido> ItemPedido { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Produto> Produto { get; set; }
        public DbSet<Pedido> Pedido { get; set; }

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
