public class Armadura {
    private String constelacao;
    private Categoria categoria;
    
    public Armadura (String constelacao, Categoria categoria) {
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    
    public Categoria getCategoria () {
        return this.categoria;
    }
    
    public int getValorCategoria () {
        return categoria.getValor();
    }
    
    public String getConstelacao () {
        return this.constelacao;
    }
}