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

    @Test
    public void vestirArmaduraComMovimentoVestirArmadura () throws Exception {
        GoldSaint saint = new GoldSaint ("Máscara Da Morte", "Câncer");
        VestirArmadura vestir = new VestirArmadura(saint);
        vestir.executar();
        assertEquals (true, saint.getArmaduraVestida());
    }
    
    @Test
    public void golpearSemArmadura () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Máscara Da Morte", "Câncer");
        Golpear golpear = new Golpear(ouro, prata);
        ouro.aprenderGolpe(new Golpe ("Ondas do Inferno", 10));
        golpear.executar();
        assertEquals (90.0, prata.getVida(), 0.01);
    }
    
    @Test
    public void golpearSemArmaduraListaGolpes () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Saga", "Gêmeos");
        Golpear ouroGolpear = new Golpear(ouro, prata);
        Golpear prataGolpear = new Golpear(prata, ouro);
        ouro.aprenderGolpe(new Golpe ("Outra Dimensão", 5));
        ouro.aprenderGolpe(new Golpe ("Explosão Galática", 10));
        prata.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 5));
        prata.aprenderGolpe (new Golpe ("Bicada Louca do Corvo", 3));
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        assertEquals (80.0, prata.getVida(), 0.01);
        assertEquals (87.0, ouro.getVida(), 0.01);
    }
    
    @Test
    public void golpearComArmadura () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Máscara Da Morte", "Câncer");
        VestirArmadura vestirOuro = new VestirArmadura(ouro);
        vestirOuro.executar();
        VestirArmadura vestirPrata = new VestirArmadura(prata);
        vestirPrata.executar();
        
        Golpear golpear = new Golpear(ouro, prata);
        ouro.aprenderGolpe(new Golpe ("Ondas do Inferno", 10));
        golpear.executar();
        assertEquals (60.0, prata.getVida(), 0.01);
    }
    
    @Test
    public void golpearComArmaduraListaGolpes () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Saga", "Gêmeos");
        VestirArmadura vestirOuro = new VestirArmadura(ouro);
        vestirOuro.executar();
        VestirArmadura vestirPrata = new VestirArmadura(prata);
        vestirPrata.executar();
        
        Golpear ouroGolpear = new Golpear(ouro, prata);
        Golpear prataGolpear = new Golpear(prata, ouro);
        ouro.aprenderGolpe(new Golpe ("Outra Dimensão", 5));
        ouro.aprenderGolpe(new Golpe ("Explosão Galática", 10));
        prata.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 5));
        prata.aprenderGolpe (new Golpe ("Bicada Louca do Corvo", 3));
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        assertEquals (20.0, prata.getVida(), 0.01);
        assertEquals (61.0, ouro.getVida(), 0.01);
    }
}