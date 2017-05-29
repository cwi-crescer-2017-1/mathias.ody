using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Chat.Models
{
    public class PalavraReservada
    {
        public PalavraReservada(string palavra, string substituta) {
            this.palavra = palavra;
            this.substituta = substituta;
        }

        public string palavra { get; set; }
        public string substituta { get; set; }
    }
}