import java.util.ArrayList;
import java.util.stream.Collectors;

public final class ListaSaints
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
        //JAVA 8 LAMBDA
        return this.listaSaints.stream()
        .filter (s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);

        //interfaces fluentes
    }

    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        return (ArrayList<Saint>) this.listaSaints.stream()
        .filter (s -> s.getCategoriaArmadura().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
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
        ordenar (TipoOrdenacao.ASCENDENTE);
    }

    public void ordenar (TipoOrdenacao ordenacao) {
        boolean isAscendente = (TipoOrdenacao.ASCENDENTE == ordenacao);
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = false; 
                precisaTrocar = isAscendente? atual.getVida() > proximo.getVida() : atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
    }

    public ListaSaints unir (ListaSaints lista) {
        ArrayList<Saint> listaAtual = this.listaSaints;
        ArrayList<Saint> listaParaAdicionar = lista.todos();
        ListaSaints resultado = new ListaSaints();
        for (Saint saint : listaAtual) {
            resultado.adicionar (saint);
        }
        for (Saint saint : listaParaAdicionar) {
            resultado.adicionar (saint);
        }
        return resultado;
    }

    public ListaSaints diff (ListaSaints lista) {
        ListaSaints resultado = new ListaSaints();
        ArrayList<Saint> lista1 = this.listaSaints;
        ArrayList<Saint> lista2 = lista.todos();
        for (Saint saint1 : lista1) {  
            boolean duplicado = false;
            for (Saint saint2 : lista2) {
                if (saint1.equals(saint2)) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) { resultado.adicionar (saint1);}
        }
        return resultado;
    }

    public ListaSaints intersec (ListaSaints lista) {
        ListaSaints resultado = new ListaSaints();
        ArrayList<Saint> lista1 = this.listaSaints;
        ArrayList<Saint> lista2 = lista.todos();
        for (Saint saint1 : lista1) {  
            for (Saint saint2 : lista2) {
                if (saint1.equals(saint2)) {
                    resultado.adicionar (saint1);
                    break;
                }
            }
        }
        return resultado;
    }

    public String getCSV() {
        if (listaSaints.isEmpty()) {return "";}
        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder (512);
        builder.append (listaSaints.get(0).getCSV());
        builder.append(separador);
        for (int i = 1; i < listaSaints.size(); i++) {
            builder.append (listaSaints.get(i).getCSV());
            if (i < (listaSaints.size() - 1)) {builder.append (separador);}
        }
        return builder.toString();
    }
}
