import java.util.ArrayList;

public class ListaSaints
{
    private ArrayList<Saint> ListaSaints = new ArrayList<Saint>();

    public void adicionar(Saint saint) {
        this.ListaSaints.add (saint);
    }

    public Saint get (int indice) {
        return this.ListaSaints.get(indice);
    }

    public ArrayList<Saint> todos () {
        return this.ListaSaints;
    }
    
    public void remover (Saint saint) {
        this.ListaSaints.remove(saint);
    }
    
    public Saint buscarPorNome (String nome){
        for (Saint saint : ListaSaints){
            if (nome.equals (saint.getNome())) {
                return saint;
            }
        }
        return null;
    }
    
    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        ArrayList<Saint> saintsDaCategoria = new ArrayList<>();
        for (Saint saint : ListaSaints){
            if (categoria.equals (saint.getCategoriaArmadura())) {
                saintsDaCategoria.add(saint);
            }
        }
        return saintsDaCategoria;
    }
    
    public ArrayList<Saint> buscarPorStatus (Status status) {
        ArrayList<Saint> saintsComStatus = new ArrayList<>();
        for (Saint saint : ListaSaints){
            if (status.equals (saint.getStatus())) {
                saintsComStatus.add(saint);
            }
        }
        return saintsComStatus;
    }
    
    public Saint getSaintMaiorVida() {
        Saint saintComMaiorVida = null;
        double maiorVida = 0.0;
        for (Saint saint : ListaSaints){
            if (saint.getVida() > maiorVida) {
                saintComMaiorVida = saint;
                maiorVida = saint.getVida();
            }
        }
        return saintComMaiorVida;
    }
    
    public Saint getSaintMenorVida() {
        return null;
    }
    
    public void ordenar () {
        
    }
}
