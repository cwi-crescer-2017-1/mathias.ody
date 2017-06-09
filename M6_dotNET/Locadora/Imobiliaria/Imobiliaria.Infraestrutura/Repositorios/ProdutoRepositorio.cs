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

        public IEnumerable<object> Listar()
        {
            List<object> produtos = new List<object>();
            for (int i = 0; i < 3; i++)
            {
                produtos.Add (contexto.Produtos
                                      .Where(x => (int)x.TipoProduto == i)
                                      .ToList());
            }

            return produtos;
        }

        public Produto Obter(int Id)
        {
            return contexto.Produtos
                .Where(x => x.Id == Id)
                .FirstOrDefault();
        }

        public bool ChecarEstoque (int Quantidade, int idProduto, out string mensagem)
        {
            var produto = contexto.Produtos.Where(x => x.Id == idProduto).FirstOrDefault();
            if (produto.Quantidade < Quantidade) {
                mensagem = @"Não há {produto.Nome} suficiente!";
                return false;
            }
            mensagem = "";
            return true;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
