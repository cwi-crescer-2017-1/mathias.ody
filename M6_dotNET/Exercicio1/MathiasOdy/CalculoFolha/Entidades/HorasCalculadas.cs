using System;

namespace CalculoFolha.Entidades
{
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double salarioBaseHora)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = Utils.WeirdRound(salarioBaseHora * qtdHoras,2);
        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
