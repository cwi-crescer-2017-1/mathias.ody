import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
   @Test
   public void emSaintsDeMesmaCategoriaOPrimeiroAtaca () throws Exception {
       Saint saint1 = new Saint ("Silva", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Saint saint2 = new Saint ("Santos", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint2.getVida(),0.001);
       assertEquals (100.0, saint1.getVida(),0.001);
    }
    
    @Test
    public void primeiroSaintCategoriaMaisAltaSegundoTomaDano () throws Exception {
       Saint saint1 = new Saint ("Máscara Da Morte", new Armadura (new Constelacao ("Câncer"), Categoria.OURO));
       Saint saint2 = new Saint ("Santos", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint2.getVida(),0.001);
       assertEquals (100.0, saint1.getVida(),0.001);
       
       Saint saint3 = new Saint ("Silva", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Saint saint4 = new Saint ("Santos", new Armadura (new Constelacao ("Yolo"), Categoria.BRONZE));
       Batalha batalha2 = new Batalha (saint3, saint4);
       batalha2.iniciar();
       assertEquals (100.0, saint3.getVida(),0.001);
       assertEquals (90.0, saint4.getVida(),0.001);
    }
    
    @Test
    public void segundoSaintCategoriaMaisAltaPrimeiroTomaDano () throws Exception {
       Saint saint1 = new Saint ("Silva", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Saint saint2 = new Saint ("Máscara Da Morte", new Armadura (new Constelacao ("Câncer"), Categoria.OURO));
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint1.getVida(),0.001);
       assertEquals (100.0, saint2.getVida(),0.001);
       
       Saint saint3 = new Saint ("Silva", new Armadura (new Constelacao ("Yolo"), Categoria.BRONZE));
       Saint saint4 = new Saint ("Santos", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
       Batalha batalha2 = new Batalha (saint3, saint4);
       batalha2.iniciar();
       assertEquals (100.0, saint4.getVida(),0.001);
       assertEquals (90.0, saint3.getVida(),0.001);
    }
}
