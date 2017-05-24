using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            /*var entradas = new int[] { };

            while (true)
            {
                Console.WriteLine("Digite um valor:");
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }
                Array.Resize(ref entradas, entradas.Length + 1);
                entradas[entradas.Length - 1] = int.Parse(entrada);
            }

            string resultado = "";
            foreach (int i in entradas)
            {
                resultado += i + " ";
            }
            Console.WriteLine(resultado);
            Console.ReadKey();*/


            List<int> entradas = new List<int>();

            while (true)
            {
                Console.WriteLine("Digite um valor:");
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }
                entradas.Add(int.Parse(entrada));
            }

            string resultado = "";
            foreach (int i in entradas)
            {
                resultado += i + " ";
            }
            Console.WriteLine(resultado);
            Console.ReadKey();
        }
    }
}
