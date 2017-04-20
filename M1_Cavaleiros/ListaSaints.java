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
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
    }

    public void ordenar (TipoOrdenacao ordenacao) {
        if (ordenacao.ASCENDENTE == ordenacao) {
            this.ordenar();
        }
        else {
            boolean posicoesSendoTrocadas;
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < listaSaints.size() - 1; i++) {
                    Saint atual = this.listaSaints.get(i);
                    Saint proximo = this.listaSaints.get(i + 1);
                    boolean precisaTrocar = atual.getVida() < proximo.getVida();
                    if (precisaTrocar) {
                        this.listaSaints.set(i, proximo);
                        this.listaSaints.set(i + 1, atual);
                        posicoesSendoTrocadas = true;
                    }
                }
            } while (posicoesSendoTrocadas);
        }
    }
}
