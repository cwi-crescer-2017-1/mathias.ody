using Imobiliaria.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Imobiliaria.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();

        public void Criar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

        public void Alterar(Cliente cliente)
        {
            contexto.Entry(cliente).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public bool Excluir(int id)
        {
            var cliente = contexto.Clientes
                                  .Where(x => x.Id == id)
                                  .First();
            if (cliente == null)
                return false;

            contexto.Clientes.Remove(cliente);
            contexto.SaveChanges();
            return true;
        }

        public IEnumerable<Cliente> Listar()
        {
            var clientes = contexto.Clientes.ToList();

            return clientes;
        }

        public Cliente Obter(string CPF)
        {
            return contexto.Clientes
                .Where(x => x.CPF == CPF)
                .FirstOrDefault();
        }

        public Cliente ObterPorId(int Id)
        {
            return contexto.Clientes
                .Where(x => x.Id == Id)
                .FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
