public class Batalha {
    private Saint saint1;
    private Saint saint2;
    private EventoEspecial evento;
    //private final double dano = 10.0; //Final == constante

    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar () throws Exception {
        boolean isVezDeSaint1 = saint1.getValorCategoriaArmadura() >= saint2.getValorCategoriaArmadura();
        boolean nenhumMorto = true;
        while (nenhumMorto) {
            if (evento != null) {
                evento.executar();
                isVezDeSaint1 = !isVezDeSaint1;
                if (evento.estaFinalizado()) {evento = null;}
            }
            else {
                if (isVezDeSaint1) {
                    executarMovimento(this.saint1.getProximoMovimento());
                }
                else {
                    executarMovimento(this.saint2.getProximoMovimento());
                }
                isVezDeSaint1 = !isVezDeSaint1;
                nenhumMorto = saint1.getStatus() != Status.MORTO && 
                saint2.getStatus() != Status.MORTO;
            }
        }
    }

    private void executarMovimento (Movimento movimento) {
        if (evento == null && movimento instanceof EventoEspecial && ((EventoEspecial)movimento).isValido()){
            evento = (EventoEspecial)movimento;
        }
        else {movimento.executar ();}
    }
}