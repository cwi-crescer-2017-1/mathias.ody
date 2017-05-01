public enum Categoria
{
    //Insira os valores em ordem crescente
    BRONZE(1), PRATA(2), OURO(3);
    
    private int valor;
    private int indiceProximo = 0;
    
    private Categoria (int valor){
        this.valor = valor;
    } 
    
    public int getValor () {
        return this.valor;
    }
    
    public static int valorMix () {
        return Categoria.values()[0].getValor();
    }
    
    public static int valorMax () {
        return Categoria.values()[Categoria.values().length - 1].getValor();
    }
     
    public Categoria get (int indice){
        if (indiceProximo > Categoria.values().length - 1) {indiceProximo = 0;}
        return Categoria.values()[indiceProximo];
    } 
    
    public int getValor (Categoria categoria){
        if (indiceProximo > Categoria.values().length - 1) {indiceProximo = 0;}
        return Categoria.values()[indiceProximo].getValor();
    } 
    
    public static int getValorAnterior (int indice){
        int indiceAnterior = indice - 1;
        if (indiceAnterior < 0) {indiceAnterior = Categoria.values().length - 1;}
        return Categoria.values()[indiceAnterior].getValor();
    } 
    
    public static int getValorProximo (int indice){
        int indiceAnterior = indice + 1;
        if (indiceAnterior > Categoria.values().length - 1) {indiceAnterior = 0;}
        return Categoria.values()[indiceAnterior].getValor();
    } 
}
