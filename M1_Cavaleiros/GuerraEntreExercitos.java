import java.util.ArrayList;

public class GuerraEntreExercitos
{
    private ExercitoDeSaints exercito1;
    private ExercitoDeSaints exercito2;
    
    private ArrayList<Saint> listaSaints1;
    private ArrayList<Saint> listaSaints2;

    private int vitoriasExercito1;
    private int vitoriasExercito2;

    public GuerraEntreExercitos (ExercitoDeSaints exercito1, ExercitoDeSaints exercito2) {
        this.exercito1 = exercito1;
        this.exercito2 = exercito2;
        listaSaints1 = exercito1.getTodos();
        listaSaints2 = exercito2.getTodos();
        for (int i = 0; i < listaSaints1.size(); i++){
            Saint saint1 = listaSaints1.get(i);
            Saint saint2 = listaSaints2.get(i);
            saint1.inicializarTodosMovimentos(saint2);
            saint2.inicializarTodosMovimentos(saint1);
        }
    }

    public void iniciar() throws Exception {
        for (int i = 0; i < listaSaints1.size(); i++){
            Saint saint1 = listaSaints1.get(i);
            Saint saint2 = listaSaints2.get(i);
            Batalha batalha = new Batalha(saint1, saint2);
            batalha.iniciar();
            Saint vencedor = batalha.getVencedor();
            if (vencedor != null) {
                if (vencedor.equals(saint1)) {vitoriasExercito1 ++;}
                else {vitoriasExercito2 ++;}
            }
        }
    }
    
    public int getVitoriasExercito1 () {
        return vitoriasExercito1;
    }
    
    public int getVitoriasExercito2 () {
        return vitoriasExercito2;
    }
}
