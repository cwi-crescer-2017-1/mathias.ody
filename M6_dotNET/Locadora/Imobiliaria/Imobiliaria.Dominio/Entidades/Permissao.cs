namespace Imobiliaria.Dominio.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }
        public int Id { get; private set; }

        public Permissao()
        { }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
