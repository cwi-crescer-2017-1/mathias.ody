public class GoldSaint extends Saint {
    public GoldSaint (String nome, String nomeConstelacao) throws Exception {
        super (nome, new Armadura (new Constelacao (nomeConstelacao), Categoria.OURO));
        this.qtdeSentidosDespertados = 7;

            if ( !nomeConstelacao.equals("Áries") 
            && !nomeConstelacao.equals("Touro")
            && !nomeConstelacao.equals("Gêmeos")
            && !nomeConstelacao.equals("Câncer")
            && !nomeConstelacao.equals("Virgem")
            && !nomeConstelacao.equals("Leão")
            && !nomeConstelacao.equals("Libra")
            && !nomeConstelacao.equals("Escorpião")
            && !nomeConstelacao.equals("Sagitário")
            && !nomeConstelacao.equals("Capricórnio")
            && !nomeConstelacao.equals("Aquário")
            && !nomeConstelacao.equals("Peixes")) {
                // dar erro
                throw new ConstelacaoInvalidaException();
            }
    }
}
