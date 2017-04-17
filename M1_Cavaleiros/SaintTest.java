import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida () {
        //AAA 
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura ("Escorpiao", Categoria.OURO);
        Saint milo = new Saint ("Milo", escorpiao);
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals (true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint hyoga = new Saint ("Hyoga", new Armadura ("Cisne", Categoria.BRONZE));
        assertEquals (false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() {
        Saint shaka = new Saint ("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals (Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void aoCriarSaintStatusEVivo () {
        Saint juca = new Saint ("Juca", new Armadura ("Yolo", Categoria.PRATA));
        assertEquals (Status.VIVO, juca.getStatus());
    }

    @Test
    public void aoCriarSaintVidaE100 () {
        Saint yuri = new Saint ("Yuri", new Armadura ("Gagarin", Categoria.PRATA));
        assertEquals (100.0, yuri.getVida(), 0.001);
    }

    @Test
    public void generoMudaAoTrocarGenero () {
        Saint etienne = new Saint ("Etienne", new Armadura ("Loire", Categoria.PRATA));
        etienne.setGenero(Genero.FEMININO);
        assertEquals (Genero.FEMININO, etienne.getGenero());
    }

    @Test
    public void descontarValorVidaAoPerderVida () {
        Saint beatriz = new Saint ("Beatriz", new Armadura ("Yola", Categoria.OURO));
        beatriz.perderVida (10.0);
        assertEquals (90.0, beatriz.getVida(), 0.001);
        
        Saint joao = new Saint ("João", new Armadura ("Caminhão", Categoria.OURO));
        joao.perderVida (100.0);
        assertEquals (0.0, joao.getVida(), 0.001);
        
        Saint fulano = new Saint ("Fulano", new Armadura ("Ciclana", Categoria.OURO));
        fulano.perderVida (-1000.0);
        assertEquals (1100.0, fulano.getVida(), 0.001);
    }
    
    @Test
    public void aoCriarSaintSentidosDespertadosDeveSer5 () {
        Saint santo = new Saint ("Santo", new Armadura ("Cruz", Categoria.BRONZE));
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }
    
    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() {
        Saint santo = new Saint ("Santo", new Armadura ("Cruz", Categoria.BRONZE));
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }
    
    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() {
        Saint santo = new Saint ("Santo", new Armadura ("Cruz", Categoria.PRATA));
        assertEquals (6, santo.getQtdeDeSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() {
        Saint santo = new Saint ("Santo", new Armadura ("Cruz", Categoria.OURO));
        assertEquals (7, santo.getQtdeDeSentidosDespertados());
    }
}
