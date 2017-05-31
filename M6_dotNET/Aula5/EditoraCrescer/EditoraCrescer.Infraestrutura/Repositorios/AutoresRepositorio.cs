using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutoresRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public Autor Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
            return autor;
        }

        public void Excluir(int idAutor)
        {
            Autor autor = contexto.Autores.Where(l => l.Id == idAutor).FirstOrDefault();
            if (autor != null)
            {
                contexto.Autores.Remove(autor);
                contexto.SaveChanges();
            }
        }
    }
}
