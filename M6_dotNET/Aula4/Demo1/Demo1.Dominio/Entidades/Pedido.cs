using System.Collections.Generic;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar (out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (string.IsNullOrWhiteSpace(NomeCliente))
                mensagens.Add("Insira um nome válido.");

            foreach (ItemPedido item in Itens)
            {
                if (item.Quantidade <= 0)
                    mensagens.Add("A quantidade não pode ser zero ou negativa.");
            }


            return mensagens.Count == 0;
        }
    }
}