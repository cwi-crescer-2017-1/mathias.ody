namespace EditoraCrescer.Infraestrutura.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }
        public int Id { get; set; }

        public Permissao()
        { }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}