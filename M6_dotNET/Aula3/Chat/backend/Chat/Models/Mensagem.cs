using System;

namespace Chat.Models
{
    public class Mensagem
    {
        public string Texto { get; set; }
        public int Id { get; set; }
        public DateTime DataEnvio { get; set; }
        public Usuario Usuario { get; set; }
        //public int IdUsuario { get; private set; }
    }
}