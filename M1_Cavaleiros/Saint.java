public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdeSentidosDespertados = 5;
    
    public Saint (String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
        
        if (this.armadura.getCategoria() == Categoria.PRATA) {
            this.qtdeSentidosDespertados = 6;
        }
        else if (this.armadura.getCategoria() == Categoria.OURO) {
            this.qtdeSentidosDespertados = 7;
            
            String constelacao = armadura.getConstelacao();
            if ( !constelacao.equals("Áries") 
            && !constelacao.equals("Touro")
            && !constelacao.equals("Gêmeos")
            && !constelacao.equals("Câncer")
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Leão")
            && !constelacao.equals("Libra")
            && !constelacao.equals("Escorpião")
            && !constelacao.equals("Sagitário")
            && !constelacao.equals("Capricórnio")
            && !constelacao.equals("Aquário")
            && !constelacao.equals("Peixes")) {
                // dar erro
                throw new Exception("Constelação inválida");
            }
        }
    }
    
    public void vestirArmadura () {
        this.armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida () {
        return this.armaduraVestida;
    }
    
    public Genero getGenero () {
        return this.genero;
    }
    
    public void setGenero (Genero genero) {
        this.genero = genero;
    }
    
    public Status getStatus () {
        return this.status;
    }
    
    public void perderVida (double valor) {
        this.vida -= valor;
    } 
    
    public double getVida () {
        return this.vida;
    }
    
    public int getValorCategoriaArmadura() {
        return armadura.getValorCategoria();
    }
    
    public int getQtdeDeSentidosDespertados () {
        return this.qtdeSentidosDespertados;
    }
}