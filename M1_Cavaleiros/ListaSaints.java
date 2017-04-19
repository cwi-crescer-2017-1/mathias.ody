import java.util.ArrayList;
import java.util.stream.Collectors;

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
        /*
        for (Saint saint : listaSaints){
        if (nome.equals (saint.getNome())) {
        return saint;
        }
        }
        return null;
         */
        //JAVA 8 LAMBDA
        return this.listaSaints.stream()
        .filter (s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);

        //interfaces fluentes
    }

    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        /*ArrayList<Saint> saintsDaCategoria = new ArrayList<>();
        for (Saint saint : listaSaints){
        if (categoria.equals (saint.getCategoriaArmadura())) {
        saintsDaCategoria.add(saint);
        }
        }
        return saintsDaCategoria;*/
        return (ArrayList<Saint>) this.listaSaints.stream()
        .filter (s -> s.getCategoriaArmadura().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
        /*ArrayList<Saint> saintsComStatus = new ArrayList<>();
        for (Saint saint : listaSaints){
        if (status.equals (saint.getStatus())) {
        saintsComStatus.add(saint);
        }
        }*/
        return (ArrayList<Saint>) this.listaSaints.stream()
        .filter (s -> s.getStatus().equals(status))
        .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida() {
        if (listaSaints.isEmpty()){
            return null;
        }

        Saint saintComMaiorVida = this.listaSaints.get(0);
        double maiorVida = this.listaSaints.get(0).getVida();
        for (int i = 1; i < listaSaints.size(); i++){
            if (listaSaints.get(i).getVida() > maiorVida) {
                saintComMaiorVida = listaSaints.get(i);
                maiorVida = listaSaints.get(i).getVida();
            }
        }
        return saintComMaiorVida;
    }

    public Saint getSaintMenorVida() {
        if (listaSaints.isEmpty()){
            return null;
        }

        Saint saintComMenorVida = this.listaSaints.get(0);
        double menorVida = this.listaSaints.get(0).getVida();
        for (int i = 1; i < listaSaints.size(); i++){
            if (listaSaints.get(i).getVida() < menorVida) {
                saintComMenorVida = listaSaints.get(i);
                menorVida = listaSaints.get(i).getVida();
            }
        }
        return saintComMenorVida;
    }

    public void ordenar () {
        //Poderia ter sido utilizado o método da bolha
        int proximoIndice = 0;
        int size = this.listaSaints.size();
        Saint [] tempSaints = new Saint [listaSaints.size()];
        tempSaints = listaSaints.toArray(tempSaints);
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
