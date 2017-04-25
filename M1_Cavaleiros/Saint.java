import java.util.ArrayList;
import java.security.InvalidParameterException;

public abstract class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdeSentidosDespertados = 5;
    private int proximoGolpe = 0;
    private int proximoMovimento = 0;
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private static int qtdSaints = 0;
    private static int ultimoId = 0;
    private int id;

    protected Saint (String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
        Saint.qtdSaints ++;
        id = ++ Saint.ultimoId;
    }
    
    //destrutor
    protected void finalize () throws Throwable {
        Saint.qtdSaints--;
    }

    public static int getQtdSaints () {
        return Saint.qtdSaints;
    }
    
    public static int getUltimoId() {
        return Saint.ultimoId;
    }

    public int  getId () {
        return this.id;
    }

    public String getNome () {
        return this.nome;
    }

    public void vestirArmadura () {
        this.armaduraVestida = true;
    }

    public boolean getArmaduraVestida () {
        return this.armaduraVestida;
    }

    public Genero getGenero () {
        return this.genero;
    }

    public void setGenero (Genero genero) {
        this.genero = genero;
    }

    public Status getStatus () {
        return this.status;
    }

    public void perderVida (double dano) throws InvalidParameterException {
        if (dano < 0) {throw new InvalidParameterException ("Parâmetro de dano inválido!");}
        if (this.status != Status.MORTO) {
            this.vida -= dano;
            if (this.vida < 1) {
                this.status = Status.MORTO;
                this.vida = 0.0;
            }
        }
    } 

    public double getVida () {
        return this.vida;
    }

    public double getVidaArredondada () {
        return (double) Math.round (this.vida * 100000.0) / 100000.0d;
    }

    public int getValorCategoriaArmadura() {
        return armadura.getValorCategoria();
    }

    public Categoria getCategoriaArmadura() {
        return this.armadura.getCategoria();
    }

    public int getQtdeDeSentidosDespertados () {
        return this.qtdeSentidosDespertados;
    }

    public Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
    }

    public ArrayList<Golpe> getGolpes () {
        return getConstelacao().getGolpes();
    }

    public void aprenderGolpe (Golpe golpe) {
        getConstelacao().adicionarGolpe(golpe);
    }

    public Golpe getProximoGolpe() {
        Golpe retorno;
        ArrayList<Golpe> golpes = getConstelacao().getGolpes();
        retorno = golpes.get(proximoGolpe);
        proximoGolpe ++;

        if (proximoGolpe == golpes.size()) {
            proximoGolpe = 0;
        }
        return retorno;
    }

    public String getCSV() {
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s", 
            this.nome, 
            this.getVidaArredondada(), 
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
    }
    
    public boolean equals (Object object) {
        Saint saint = (Saint)object;
        if (saint.getNome().equals(this.nome) && saint.getConstelacao().equals(this.getConstelacao())) { return true;}
       
        return false;
    }
    
    public String toString() {
        return this.nome;
    }
    
    public void adicionarMovimento (Movimento movimento) {
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() {
        Movimento retorno;
        retorno = this.movimentos.get(proximoMovimento);
        proximoMovimento ++;

        if (proximoMovimento == this.movimentos.size()) {
            proximoMovimento = 0;
        }
        return retorno;
    }

    public void golpear (Saint golpeado){
        adicionarMovimento (new Golpear (this, golpeado));
    }
}