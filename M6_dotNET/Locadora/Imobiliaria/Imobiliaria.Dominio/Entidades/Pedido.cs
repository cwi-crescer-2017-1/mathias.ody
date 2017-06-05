using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    class Pedido
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public ItensPedido ItensPedido { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataVencimento { get; set; }
        public DateTime? DataEntrega { get; set; }
        public decimal Multa { get; set; } //multa de acordo com diarias atrasadas
        public decimal ValorTotal { get; set; }
    }
}
