public class Armadura {
    private Constelacao constelacao;
    private Categoria categoria;
    
    public Armadura (Constelacao constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    
    public Categoria getCategoria () {
        return this.categoria;
    }
    
    public int getValorCategoria () {
        return categoria.getValor();
    }
    
    public Constelacao getConstelacao () {
        return this.constelacao;
    }
}