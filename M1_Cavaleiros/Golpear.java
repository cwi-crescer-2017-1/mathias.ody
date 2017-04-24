public class Golpear implements Movimento
{
    private Saint golpeador;
    private Saint golpeado;
    public Golpear (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar () {
        int danoBase = golpeador.getProximoGolpe().getFatorDano();
        if (golpeador.getArmaduraVestida()){
            int multiplicador = golpeador.getValorCategoriaArmadura() + 1;
            golpeado.perderVida((double)danoBase * multiplicador);
        }
        else {
            golpeado.perderVida((double)danoBase);
        }
    }

	public boolean equals (Object outroObj) {
		Golpear outro = (Golpear)outroObj;
		return outro.golpeador.equals(this.golpeador) &&
			   outro.golpeado.equals(this.golpeado);
	}
}
