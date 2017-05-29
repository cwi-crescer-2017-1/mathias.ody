using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Chat.Models;

namespace UnitTests
{
    [TestClass]
    public class UnitTests
    {
        [TestMethod]
        public void AndreNunesEhTrocadoPorCifroes()
        {
            string frase = "Churrasqueiro profissional esse André Nunes, não acha?";
            frase = PalavrasReservadas.Filtrar(frase);
            string fraseEsperada = "Churrasqueiro profissional esse $$$$$ $$$$$, não acha?";
            Assert.AreEqual(fraseEsperada, frase);
        }
    }
}
