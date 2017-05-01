public class ExercitoQueAtacaEmOrdemHierarquica extends ExercitoDeSaints
{
    public ExercitoQueAtacaEmOrdemHierarquica () {
        super();
    }
    
    public void alistar (Saint saint) {
        super.alistar (saint);
        this.ordenarHierarquicamente();
        System.out.println(exercito.size());
    }
}
