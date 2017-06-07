using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public void Criar(Produto produto)
        {
            contexto.Produtos.Add(produto);
            contexto.SaveChanges();
        }

        public void Alterar(Produto produto)
        {
            contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public bool Excluir(int id)
        {
            var produto = contexto.Produtos
                                  .Where(x => x.Id == id)
                                  .First();
            if (produto == null)
                return false;

            contexto.Produtos.Remove(produto);
            contexto.SaveChanges();
            return true;
        }

        public IEnumerable<Produto> Listar()
        {
            return contexto.Produtos.ToList();
        }

        public Produto Obter(int Id)
        {
            return contexto.Produtos
                .Where(x => x.Id == Id)
                .Include(x => x.TipoProduto)
                .FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
