public class Batalha {
    private Saint saint1;
    private Saint saint2;
    private final double dano = 10.0; //Final == constante
    
    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    public void iniciar () throws Exception {
        if (saint1.getValorCategoriaArmadura() >= saint2.getValorCategoriaArmadura()) {
            this.saint2.perderVida(dano);
        }
        else {
            this.saint1.perderVida(dano);
        }
    }
}