using System;

namespace CalculoFolha.Entidades
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, 
                                                double horasExtras, double horasDescontadas)
        {
            string categoria = GetCategoriaByHoras(horasCategoria);
            double salarioBaseHora = salarioBase / horasCategoria;

            HorasCalculadas horasExtrasCalculadas = new HorasCalculadas(horasExtras, salarioBaseHora);
            HorasCalculadas horasDescontadasCalculadas = new HorasCalculadas(horasDescontadas, salarioBaseHora);
            double totalProventos = salarioBase + horasExtrasCalculadas.ValorTotalHoras - horasDescontadasCalculadas.ValorTotalHoras;

            Desconto inss = new Desconto(GetAliquotaInss(totalProventos), totalProventos);
            double salarioComInssDeduzido = totalProventos - inss.Valor;

            Desconto irrf = new Desconto(GetAliquotaIrrf(salarioComInssDeduzido), salarioComInssDeduzido);

            double totalDescontos = inss.Valor + irrf.Valor;
            double totalLiquido = totalProventos - totalDescontos;

            Desconto fgts = new Desconto(0.11, totalProventos);

            return new Demonstrativo(
            Utils.WeirdRound(salarioBase,2),
            horasCategoria,
            horasExtrasCalculadas,
            horasDescontadasCalculadas,
            Utils.WeirdRound(totalProventos,2),
            inss,
            irrf,
            Utils.WeirdRound(totalDescontos,2),
            Utils.WeirdRound(totalLiquido,2),
            fgts);
        }

        private string GetCategoriaByHoras (double horas)
        {
            string categoria = "";
            if (Utils.AlmostEquals(horas, 170.0,0.01)) { categoria = "Comércio"; }
            else if (Utils.AlmostEquals(horas, 200.0, 0.01)) { categoria = "Indústria"; }
            else { categoria = "Não definida (N/A)"; }

            return categoria;
        }

        private double GetAliquotaInss(double salario)
        {
            if (salario < 1000.001)
            {
                return 0.08;
            }
            else if (salario < 1500.001)
            {
                return 0.09;
            }
            else
            {
                return 0.1;
            }
        }

        private double GetAliquotaIrrf(double salario)
        {
            if (salario < 1710.78)
            {
                return 0;
            }
            else if (salario < 2563.91)
            {
                return 0.075;
            }
            else if (salario < 3418.59)
            {
                return 0.15;
            }
            else if (salario < 4271.59)
            {
                return 0.225;
            }
            else
            {
                return 0.275;
            }
        }
    }
}
