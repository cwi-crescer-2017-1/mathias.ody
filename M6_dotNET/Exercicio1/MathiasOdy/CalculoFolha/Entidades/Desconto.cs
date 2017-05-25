using System;

namespace CalculoFolha.Entidades
{
    public class Desconto
    {
        public Desconto(double aliquota, double salario)
        {
            Aliquota = aliquota;
            Valor = Utils.WeirdRound (salario * aliquota,2);
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
