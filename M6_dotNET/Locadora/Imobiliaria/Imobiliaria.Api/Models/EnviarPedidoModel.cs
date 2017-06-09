using Imobiliaria.Dominio.Entidades;
using System.Collections.Generic;

namespace Imobiliaria.Api.Models
{
    public class EnviarPedidoModel : EntidadeBasica
    {
        public ItemPedidoModel[] Itens { get; set; }
        public int idCliente { get; set; }
        public int DiariasAlugadas { get; set; }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (Itens == null)
                Mensagens.Add("Nenhum item selecionado");

            if (DiariasAlugadas <= 0)
                Mensagens.Add("Diárias menor ou igual a zero");

            return Mensagens.Count == 0;
        }
    }
}