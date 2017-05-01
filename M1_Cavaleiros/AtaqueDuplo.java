public class AtaqueDuplo extends Golpear implements Movimento
{   
    Sorteador sorteador;
    public AtaqueDuplo (Saint golpeador, Saint golpeado, Sorteador sorteador) {
        super (golpeador, golpeado);
        this.sorteador= sorteador;
    }
    
    public AtaqueDuplo (Sorteador sorteador) {
        this.sorteador= sorteador;
    }
    
    public void setup (Saint saint1, Saint saint2) {
        super.golpeador = saint1;
        super.golpeado = saint2;
    }
    
    public void executar () {
        int valorDado = sorteador.sortear();
        int danoBase = 0;
        if(valorDado % 3 == 0) {
            danoBase = golpeador.getProximoGolpe().getFatorDano() * 2;
            super.aplicarGolpe(danoBase);
        }
        else {
            super.executar();
            golpeador.perderVida(golpeador.getVida() * 0.05);
        }
    }

    public boolean equals (Object outroObj) {
        AtaqueDuplo outro = (AtaqueDuplo)outroObj;
        return outro.golpeador.equals(this.golpeador) &&
               outro.golpeado.equals(this.golpeado);
    }
}
