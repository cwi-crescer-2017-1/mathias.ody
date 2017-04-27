import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
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
        prata.aprenderGolpe (new Golpe ("Bicada Louca do Covo", 3));
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        ouroGolpear.executar();
        prataGolpear.executar();
        assertEquals (20.0, prata.getVida(), 0.01);
        assertEquals (61.0, ouro.getVida(), 0.01);
    }
    
    @Test
    public void batalhaUsandoMovimentos () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Saga", "Gêmeos");
        ouro.aprenderGolpe(new Golpe ("Outra Dimensão", 10));
        ouro.aprenderGolpe(new Golpe ("Explosão Galática", 20));
        prata.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 10));
        prata.aprenderGolpe (new Golpe ("Bicada Louca do Covo", 10));
        ouro.adicionarMovimento (new Golpear(ouro,prata));
        prata.adicionarMovimento (new Golpear(prata,ouro));
        Batalha batalha = new Batalha (ouro, prata);
        batalha.iniciar();
        assertEquals (0.0, prata.getVida(), 0.01);
        assertEquals (40.0, ouro.getVida(), 0.01);
    }
    
    @Test
    public void batalhaUsandoMovimentosComArmadura () throws Exception {
        SilverSaint prata = new SilverSaint ("Jamian", "Corvo");
        GoldSaint ouro = new GoldSaint ("Saga", "Gêmeos");
        ouro.aprenderGolpe(new Golpe ("Outra Dimensão", 10));
        ouro.aprenderGolpe(new Golpe ("Explosão Galática", 20));
        prata.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 10));
        prata.aprenderGolpe (new Golpe ("Bicada Louca do Covo", 10));
        ouro.adicionarMovimento (new VestirArmadura (ouro));
        ouro.adicionarMovimento (new Golpear(ouro,prata));
        prata.adicionarMovimento (new Golpear(prata,ouro));
        Batalha batalha = new Batalha (ouro, prata);
        batalha.iniciar();
        assertEquals (0.0, prata.getVida(), 0.01);
        assertEquals (70.0, ouro.getVida(), 0.01);
    }
}