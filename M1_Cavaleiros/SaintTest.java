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
    public void descontarValorVidaAoPerderVida () {
        Saint beatriz = new Saint ("Yola", new Armadura ("Yola", Categoria.OURO));
        double vidaInicial = beatriz.getVida();
        beatriz.perderVida (10.0);
        assertEquals ((100.0 - 10.0), beatriz.getVida(), 0.001);
    }
}
