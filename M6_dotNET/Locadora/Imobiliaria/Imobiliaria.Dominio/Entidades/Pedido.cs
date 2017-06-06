using System;
using System.Collections.Generic;
using System.Text;

namespace Imobiliaria.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public int IdCliente { get; set; }
        public ItemPedido ItemPedido { get; set; }
        public int IdItemPedido { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataVencimento { get; set; }
        public DateTime? DataEntrega { get; set; }
        public decimal Multa { get; set; } //multa de acordo com diarias atrasadas
        public decimal ValorTotal { get; set; }
    }
}
