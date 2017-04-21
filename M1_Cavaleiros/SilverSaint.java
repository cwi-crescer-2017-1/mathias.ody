public class SilverSaint extends Saint {
    public SilverSaint (String nome, String nomeConstelacao) throws Exception {
        super (nome, new Armadura (new Constelacao (nomeConstelacao), Categoria.PRATA));
        this.qtdeSentidosDespertados = 6;
    }
}
