using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public Livro Criar(Livro livro) {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }

        public void Excluir(Livro livro)
        {
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

    }
}
