public class AtaqueDuplo implements Movimento
{
    private Saint golpeador;
    private Saint golpeado;
    
    public AtaqueDuplo (Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar () {
        Sorteador dado = new DadoD6();
        int valorDado = dado.sortear();
    }

	public boolean equals (Object outroObj) {
		AtaqueDuplo outro = (AtaqueDuplo)outroObj;
		return outro.golpeador.equals(this.golpeador) &&
			   outro.golpeado.equals(this.golpeado);
	}
}
