using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Imobiliaria.Api.Controllers;
using Imobiliaria.Api.Models;
using Imobiliaria.Infraestrutura.Repositorios;
using Imobiliaria.Dominio.Entidades;

namespace Imobiliaria.UnitTests
{
    [TestClass]
    public class UsuariosTest
    {
        UsuarioRepositorio UsuarioRepositorio = new UsuarioRepositorio();

        [TestMethod]
        public void AdicionarAdicionaUsuario ()
        {
            Usuario Usuario = new Usuario("Usuario Teste", "usuarioTeste@Teste.com", "asdrtyvbnm");
            UsuarioRepositorio.Criar(Usuario);
            Usuario UsuarioCriado = UsuarioRepositorio.Obter("usuarioTeste@Teste.com");

            Assert.IsNotNull(UsuarioCriado);
            Assert.AreEqual("Usuario Teste", UsuarioCriado.Nome);
        }

        [TestMethod]
        public void ExcluirDeletaUsuario()
        {
            Usuario Usuario = new Usuario("Usuario Teste", "usuarioTeste@Teste.com", "asdrtyvbnm");
            UsuarioRepositorio.Excluir(Usuario);
            Usuario UsuarioDeletado = UsuarioRepositorio.Obter("usuarioTeste@Teste.com");

            Assert.IsNull(UsuarioDeletado);
        }
    }
}
