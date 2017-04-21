public class BronzeSaint extends Saint {
    public BronzeSaint (String nome, String nomeConstelacao) throws Exception {
        super (nome, new Armadura (new Constelacao (nomeConstelacao), Categoria.BRONZE));
        this.qtdeSentidosDespertados = 5;
    }
}