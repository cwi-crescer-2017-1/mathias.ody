public class Batalha {
    private Saint saint1;
    private Saint saint2;
    //private final double dano = 10.0; //Final == constante

    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar () throws Exception {
        boolean isVezDeSaint1 = saint1.getValorCategoriaArmadura() >= saint2.getValorCategoriaArmadura();
        boolean nenhumMorto = true;
        while (nenhumMorto) {
            if (isVezDeSaint1) {
                this.saint1.getProximoMovimento().executar();
                if (saint2.getStatus() == Status.MORTO) { nenhumMorto = false;}
            }
            else {
                this.saint2.getProximoMovimento().executar();
                if (saint1.getStatus() == Status.MORTO) { nenhumMorto = false;}
            }
            isVezDeSaint1 = !isVezDeSaint1;
        }
    }
}