import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
   @Test
   public void emSaintsDeMesmaCategoriaOPrimeiroAtaca () throws Exception {
       SilverSaint saint1 = new SilverSaint ("Silva", "Yolo");
       SilverSaint saint2 = new SilverSaint ("Santos","Yolo");
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint2.getVida(),0.001);
       assertEquals (100.0, saint1.getVida(),0.001);
    }
    
    @Test
    public void primeiroSaintCategoriaMaisAltaSegundoTomaDano () throws Exception {
       GoldSaint saint1 = new GoldSaint ("Máscara Da Morte","Câncer");
       SilverSaint saint2 = new SilverSaint ("Santos", "Yolo");
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint2.getVida(),0.001);
       assertEquals (100.0, saint1.getVida(),0.001);
       
       SilverSaint saint3 = new SilverSaint ("Silva","Yolo");
       BronzeSaint saint4 = new BronzeSaint ("Santos","Yolo");
       Batalha batalha2 = new Batalha (saint3, saint4);
       batalha2.iniciar();
       assertEquals (100.0, saint3.getVida(),0.001);
       assertEquals (90.0, saint4.getVida(),0.001);
    }
    
    @Test
    public void segundoSaintCategoriaMaisAltaPrimeiroTomaDano () throws Exception {
       SilverSaint saint1 = new SilverSaint ("Silva", "Yolo");
       GoldSaint saint2 = new GoldSaint ("Máscara Da Morte", "Câncer");
       Batalha batalha = new Batalha (saint1, saint2);
       batalha.iniciar();
       assertEquals (90.0, saint1.getVida(),0.001);
       assertEquals (100.0, saint2.getVida(),0.001);
       
       BronzeSaint saint3 = new BronzeSaint ("Silva", "Yolo");
       SilverSaint saint4 = new SilverSaint ("Santos", "Yolo");
       Batalha batalha2 = new Batalha (saint3, saint4);
       batalha2.iniciar();
       assertEquals (100.0, saint4.getVida(),0.001);
       assertEquals (90.0, saint3.getVida(),0.001);
    }
}
