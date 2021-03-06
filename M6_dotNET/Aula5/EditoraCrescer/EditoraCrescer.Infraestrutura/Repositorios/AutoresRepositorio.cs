﻿using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutoresRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> ObterLista()
        {
            return contexto.Autores.ToList();
        }

        public Autor ObterAutor(int id)
        {
            return contexto.Autores.FirstOrDefault(a => a.Id == id);
        }

        public List<Livro> ObterLivrosAutor (int id)
        {
            return contexto.Livros.Where(l => l.IdAutor == id).ToList();
        }

        public Autor Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
            return autor;
        }

        public void Alterar(int id, Autor autor)
        {
            contexto.Entry(autor).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public bool Excluir(int idAutor)
        {
            Autor autor = contexto.Autores.FirstOrDefault(l => l.Id == idAutor);
            if (autor != null)
            {
                contexto.Autores.Remove(autor);
                contexto.SaveChanges();
                return true;
            }
            return false;
        }

        public bool AutorExiste(int id)
        {
            return contexto.Autores.Count(a => a.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
