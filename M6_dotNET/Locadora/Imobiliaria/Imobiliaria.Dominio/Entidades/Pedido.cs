using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; private set; }
        public Cliente Cliente { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataVencimento { get; private set; }
        public DateTime? DataEntrega { get; private set; }
        public decimal Multa { get; private set; } //multa de acordo com diarias atrasadas
        public decimal ValorTotal { get; private set; }

        public Pedido () { }

        public Pedido (Cliente Cliente, 
                       DateTime DataPedido,
                       int DiariasAlugadas)
        {
            this.Cliente = Cliente;
            this.DataPedido = DataPedido;
            this.DataVencimento = DataPedido.AddDays(DiariasAlugadas);
            this.Multa = 0m;
            this.ValorTotal = 0m;
        }

        public void Entregar(DateTime data)
        {
            DataEntrega = data;
        }

        public void SetValorTotal(decimal valorTotal)
        {
            ValorTotal = valorTotal;
        }
    }
}
