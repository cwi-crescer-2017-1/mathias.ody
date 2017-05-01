import java.util.ArrayList;

public class ExercitoDeSaints
{
    protected ArrayList<Saint> exercito = new ArrayList<Saint>();

    public ExercitoDeSaints () {

    }

    public void alistar (Saint saint) {
        this.exercito.add (saint);
    }

    public Saint get (int indice) {
        return exercito.get(indice);
    }

    public void ordenarHierarquicamente () {
        ordenarHierarquicamente (this.exercito);
    }

    private ArrayList<Saint> ordenarHierarquicamente (ArrayList<Saint> exercito) {
        ArrayList<Saint> exercitoInicial = new ArrayList<Saint>();
        exercitoInicial.addAll(exercito);
        exercito.clear();

        for (Categoria categoria : Categoria.values()) {
            for (Saint saint : exercitoInicial) {
                if (saint.getCategoriaArmadura() == categoria) {
                    exercito.add(saint);
                }
            }
        }
        return exercito;
    }

    //Método Conan o Bárbaro total
    public void ordenarAlternando () {
        if (this.exercito.size() == 1) { return;}

        ArrayList<ArrayList<Saint>> listaParaIntercalar = new ArrayList<ArrayList<Saint>>();
        ArrayList<Integer> categoriasRegistradas = new ArrayList<>();
        for (Saint saint : this.exercito) {
            boolean foiAdicionado = false;
            int categoriaSaint = saint.getValorCategoriaArmadura();
            for (int i = 0; i < categoriasRegistradas.size(); i++) {
                if (categoriasRegistradas.get(i) == categoriaSaint){
                    listaParaIntercalar.get(i).add(saint);
                    foiAdicionado = true;
                    break;
                }
            }
            if (! foiAdicionado){
                ArrayList<Saint> lista = (new ArrayList<Saint>());
                lista.add(saint);
                listaParaIntercalar.add(lista);
                categoriasRegistradas.add(categoriaSaint);
            }
        } 
        
        this.exercito.clear();
        
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < listaParaIntercalar.size() - 1; i++) {
                Integer atual = 0;
                Integer proximo = 0;
                if (listaParaIntercalar.get(i + 1).size() > 0) {proximo = (listaParaIntercalar.get(i + 1).get(0)).getValorCategoriaArmadura();} else {break;}
                if (listaParaIntercalar.get(i).size() > 0) {atual = (listaParaIntercalar.get(i).get(0)).getValorCategoriaArmadura();} else {break;}
                boolean precisaTrocar = false; 
                precisaTrocar = atual > proximo;
                if (precisaTrocar) {
                    ArrayList<Saint> tempLista = listaParaIntercalar.get(i);
                    listaParaIntercalar.set (i, listaParaIntercalar.get(i + 1));
                    listaParaIntercalar.set(i + 1, tempLista);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
        

        for (int i = 0; true; i ++) {
            int numeroDeAdicoes = 0;
            for (ArrayList<Saint> listaSaints : listaParaIntercalar){
                if (listaSaints.size() > i) {
                    exercito.add(listaSaints.get(i));
                    numeroDeAdicoes ++;
                }
            }
            if (numeroDeAdicoes == 0){break;}
        }
    }

    public ArrayList<Saint> getTodos() {return this.exercito;}

    private boolean contem (Saint saintParaVerificar, ArrayList<Saint> lista) {
        boolean resultado = false;
        for (Saint saint : lista) {
            if (saint.equals(saintParaVerificar)){
                resultado = true;
            }
        }
        return resultado;
    }
}
