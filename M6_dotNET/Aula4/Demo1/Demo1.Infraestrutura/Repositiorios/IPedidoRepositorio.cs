using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System.Collections.Generic;

namespace Demo1.Infraestrutura.Repositorios
{
    public interface IPedidoRepositorio
    {
        void Alterar(Pedido pedido);
        void Criar(Pedido pedido);
        void Excluir(int id);
        IEnumerable<Pedido> Listar();
        Pedido Obter(int id);
    }
}