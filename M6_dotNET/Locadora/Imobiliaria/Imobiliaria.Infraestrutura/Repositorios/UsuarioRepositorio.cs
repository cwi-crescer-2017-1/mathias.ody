using Imobiliaria.Dominio.Entidades;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        static UsuarioRepositorio()
        {
            /*// YWRtaW5AY3dpLmNvbS5icjoxMjM0NTY=
            var usrAdmin = new Usuario("admin", "admin@cwi.com.br", "123456");
            usrAdmin.AtribuirPermissoes("Administrador");
            _usuarios.Add(usrAdmin.Email, usrAdmin);

            // Z2lvdmFuaUBjd2kuY29tLmJyOjEyMzQ1Ng==
            var usrGiovani = new Usuario("giovani", "giovani@cwi.com.br", "123456");
            _usuarios.Add(usrGiovani.Email, usrGiovani);*/
        }

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }
        public void Excluir(Usuario usuario)
        {
            contexto.Usuarios.Remove(usuario);
            contexto.SaveChanges();
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios
                .Where(u => u.Email == email)
                .Include(u => u.Permissoes)
                .FirstOrDefault();
        }
    }
}
