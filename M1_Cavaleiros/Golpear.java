public class Golpear implements Movimento
{
    protected Saint golpeador;
    protected Saint golpeado;

    public Golpear (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public Golpear () {}

    public void setup (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar () {
        int danoBase = golpeador.getProximoGolpe().getFatorDano();
        aplicarGolpe(danoBase);
    }

    protected void aplicarGolpe (int dano) {
        if (golpeador.getArmaduraVestida()){
            int multiplicador = golpeador.getValorCategoriaArmadura() + 1;
            golpeado.perderVida((double)dano * multiplicador);
        }
        else {
            golpeado.perderVida((double)dano);
        }
    }

    public boolean equals (Object outroObj) {
        Golpear outro = (Golpear)outroObj;
        return outro.golpeador.equals(this.golpeador) &&
        outro.golpeado.equals(this.golpeado);
    }
}
