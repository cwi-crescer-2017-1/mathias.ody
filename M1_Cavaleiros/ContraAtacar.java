public class ContraAtacar extends EventoEspecial implements Movimento {
    private Saint executor;
    private Saint receptor;
    private Sorteador sorteador;
    private boolean finalizado = false;

    public ContraAtacar (Saint executor, Saint receptor, Sorteador sorteador) {
        this.executor = executor;
        this.receptor = receptor;
        this.sorteador = sorteador;
    }
    
    public ContraAtacar (Sorteador sorteador) {
        this.sorteador = sorteador;
    }

    public void setup (Saint saint1, Saint saint2) {
        this.executor = saint1;
        this.receptor = saint2;
    }

    public void executar(){
        Movimento movimentoReceptor = receptor.getProximoMovimento();
        boolean vaiContraAtacar = sorteador.sortear() % 3 == 0 || sorteador.sortear() % 2 == 0;
        if (vaiContraAtacar) {
            double dano = receptor.getVida() * 0.25;
            receptor.perderVida(dano);
        }
        else {
            movimentoReceptor.executar ();
        }
        finalizado = true;
    }

    public boolean isValido() {
        return executor.getVida() < Saint.getMaxVida() && !executor.getArmaduraVestida();
    }

    public boolean estaFinalizado(){
        return finalizado;
    }
}
