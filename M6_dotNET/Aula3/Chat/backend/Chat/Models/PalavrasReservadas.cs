using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;

namespace Chat.Models
{
    public static class PalavrasReservadas
    {
        private static List<PalavraReservada> palavrasReservadas = new List<PalavraReservada> {
            new PalavraReservada("ANDRÉ NUNES", "$$$$$ $$$$$"),
            new PalavraReservada("BERNARDO", "Illuminati"),
            new PalavraReservada("PUTA MERDA", "PUTA VIDA"),
            new PalavraReservada("Oi", "Oi, gata ;)"),
        };

        public static string Filtrar (string frase)
        {
            string fraseFinal = frase;
            foreach (PalavraReservada palavraReservada in palavrasReservadas)
            {
                /* Não usada nesse caso por causa do "$"
                string pattern = @"\b" + palavraReservada.palavra + @"\b";
                Regex regex = new Regex(pattern, RegexOptions.IgnoreCase);
                fraseFinal = regex.Replace(fraseFinal, palavraReservada.substituta);*/
                int firstIndex = frase.IndexOf(palavraReservada.palavra, StringComparison.OrdinalIgnoreCase);
                if (firstIndex >= 0)
                {
                    fraseFinal = frase.Remove(firstIndex, palavraReservada.palavra.Length);
                    fraseFinal = fraseFinal.Insert(firstIndex, palavraReservada.substituta);
                }
            }
            return fraseFinal;
        }
    }
}