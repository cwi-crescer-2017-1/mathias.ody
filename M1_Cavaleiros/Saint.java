import java.util.ArrayList;
import java.security.*;

public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdeSentidosDespertados = 5;
    private int proximoGolpe = 0;
    
    public Saint (String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
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
        if (dano < 0) {throw new InvalidParameterException ("Parâmetro inválido!");}
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
    
    public int getValorCategoriaArmadura() {
        return armadura.getValorCategoria();
    }
    
    public int getQtdeDeSentidosDespertados () {
        return this.qtdeSentidosDespertados;
    }
    
    public ArrayList<Golpe> getGolpes () {
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe (Golpe golpe) {
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        Golpe retorno;
        ArrayList<Golpe> golpes = this.armadura.getConstelacao().getGolpes();
        retorno = golpes.get(proximoGolpe);
        proximoGolpe ++;
        
        if (proximoGolpe == golpes.size()) {
            proximoGolpe = 0;
        }
        return retorno;
    }
}