using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    public class Cargo
    {
        public string Titulo { get; private set; }
        public double Salario { get; private set; }

        public Cargo(string titulo, double salario)
        {
            this.Titulo = titulo;
            this.Salario = salario;
        }

        public override bool Equals(object obj)
        {
            if(obj == null || obj.GetType() != this.GetType())
            {
                return false;
            }

            Cargo cargoComp = (Cargo)obj;

            return this.Titulo == cargoComp.Titulo
                && this.Salario == cargoComp.Salario;
        }

        public string GetSalarioReais()
        {
            double valorInteiro = Math.Truncate(Salario);
            double valorDecimal = (Salario % valorInteiro) * 100;
            return $"R$ {Convert.ToInt32(valorInteiro)},{Convert.ToInt32(valorDecimal)}";
        }

        public string GetSalarioDolares()
        {
            double valorInteiro = Math.Truncate(Salario);
            double valorDecimal = (Salario % valorInteiro) * 100;
            return $"${Convert.ToInt32(valorInteiro)}.{Convert.ToInt32(valorDecimal)}";
        }
    }
}
