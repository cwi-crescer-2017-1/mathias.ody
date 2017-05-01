public class ExercitoQueAtacaEmOrdemAlternada extends ExercitoDeSaints
{
    public ExercitoQueAtacaEmOrdemAlternada () {
        super();
    }
    
    public void alistar (Saint saint) {
        this.exercito.add (saint);
        this.ordenarAlternando();
    }
}
