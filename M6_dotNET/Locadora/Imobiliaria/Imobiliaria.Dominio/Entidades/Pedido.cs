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
    }
}
