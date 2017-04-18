public class GoldSaint extends Saint {
    public GoldSaint (String nome, Armadura armadura) throws Exception {
        super (nome, armadura);
        this.qtdeSentidosDespertados = 7;
        
        Constelacao constelacao = armadura.getConstelacao();
            if ( !constelacao.getNome().equals("Áries") 
            && !constelacao.getNome().equals("Touro")
            && !constelacao.getNome().equals("Gêmeos")
            && !constelacao.getNome().equals("Câncer")
            && !constelacao.getNome().equals("Virgem")
            && !constelacao.getNome().equals("Leão")
            && !constelacao.getNome().equals("Libra")
            && !constelacao.getNome().equals("Escorpião")
            && !constelacao.getNome().equals("Sagitário")
            && !constelacao.getNome().equals("Capricórnio")
            && !constelacao.getNome().equals("Aquário")
            && !constelacao.getNome().equals("Peixes")) {
                // dar erro
                throw new Exception("Constelação inválida");
            }
    }
}
