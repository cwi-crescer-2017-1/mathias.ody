﻿using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public object ObterLista()
        {
            return contexto.Livros
                .Select(l => new
                {
                    l.Isbn,
                    l.Titulo,
                    l.Capa,
                    l.Autor.Nome,
                    l.Genero
                }).ToList();
        }

        public Livro ObterLivro(int isbn)
        {
            return contexto.Livros
                .Include(l => l.Autor)
                .Include(l => l.Revisor)
                .FirstOrDefault(l => l.Isbn == isbn);
        }

        public dynamic ObterLivrosGenero(string genero)
        {
            return contexto.Livros
                .Where(l => l.Genero.Contains(genero))
                .Select(l => new
                {
                    l.Isbn,
                    l.Titulo,
                    l.Capa,
                    l.Autor.Nome,
                    l.Genero
                }).ToList();
        }

        public dynamic ObterLancamentos()
        {
            DateTime semanaAnterior = DateTime.Now.AddDays(-7);
            return contexto.Livros
                .Where(l => (l.DataPublicacao > semanaAnterior))
                .Select(l => new
                {
                    l.Isbn,
                    l.Titulo,
                    l.Capa,
                    l.Autor.Nome,
                    l.Genero
                }).ToList();
        }

        public Livro Criar(Livro livro) {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }

        public void Alterar(int isbn, Livro livro)
        {
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(int isbnLivro)
        {
            Livro livro = contexto.Livros.FirstOrDefault(l => l.Isbn == isbnLivro);
            if (livro != null)
            {
                contexto.Livros.Remove(livro);
                contexto.SaveChanges();
            }
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
