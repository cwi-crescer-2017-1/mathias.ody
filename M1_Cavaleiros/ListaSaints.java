import java.util.ArrayList;

public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<Saint>();

    public void adicionar(Saint saint) {
        this.listaSaints.add (saint);
    }

    public Saint get (int indice) {
        return this.listaSaints.get(indice);
    }

    public ArrayList<Saint> todos () {
        return this.listaSaints;
    }

    public void remover (Saint saint) {
        this.listaSaints.remove(saint);
    }

    public Saint buscarPorNome (String nome){
        for (Saint saint : listaSaints){
            if (nome.equals (saint.getNome())) {
                return saint;
            }
        }
        return null;
    }

    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        ArrayList<Saint> saintsDaCategoria = new ArrayList<>();
        for (Saint saint : listaSaints){
            if (categoria.equals (saint.getCategoriaArmadura())) {
                saintsDaCategoria.add(saint);
            }
        }
        return saintsDaCategoria;
    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
        ArrayList<Saint> saintsComStatus = new ArrayList<>();
        for (Saint saint : listaSaints){
            if (status.equals (saint.getStatus())) {
                saintsComStatus.add(saint);
            }
        }
        return saintsComStatus;
    }

    public Saint getSaintMaiorVida() {
        Saint saintComMaiorVida = null;
        double maiorVida = 0.0;
        for (Saint saint : listaSaints){
            if (saint.getVida() > maiorVida) {
                saintComMaiorVida = saint;
                maiorVida = saint.getVida();
            }
        }
        return saintComMaiorVida;
    }

    public Saint getSaintMenorVida() {
        Saint saintComMenorVida = null;
        double menorVida = 100.0;
        for (Saint saint : listaSaints){
            if (saint.getVida() < menorVida) {
                saintComMenorVida = saint;
                menorVida = saint.getVida();
            }
        }
        return saintComMenorVida;
    }

    public void ordenar () {
        int proximoIndice = 0;
        int size = this.listaSaints.size();
        Saint [] tempSaints = new Saint [listaSaints.size()];
        tempSaints = listaSaints.toArray(tempSaints);
        //Saint [] resultSaints = new Saint [listaSaints.size()];
        listaSaints.clear();
        for (int i = 0; i < size; i++) {
            Saint saintComMenorVida = null;
            double menorVida = 100.0;
            int indiceMenorVida = -1;
            for (int j = 0; j < size; j++) {
                if (tempSaints[j] != null && tempSaints[j].getVida() < menorVida) {
                    saintComMenorVida = tempSaints[j];
                    menorVida = tempSaints[j].getVida();
                    indiceMenorVida = j;
                }
            }
            tempSaints[indiceMenorVida] = null;
            this.listaSaints.add(saintComMenorVida);
        }
    }
}
