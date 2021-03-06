import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    
    @After
    public void tearDown () {
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida () throws Exception {
        //AAA 
        //1. Arrange - Montagem dos dados de teste
        GoldSaint milo = new GoldSaint ("Milo", "Escorpião");
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals (true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        assertEquals (false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        BronzeSaint shaka = new BronzeSaint ("Shaka", "Virgem");
        assertEquals (Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void aoCriarSaintStatusEVivo () throws Exception {
        BronzeSaint juca = new BronzeSaint ("Juca", "Yolo");
        assertEquals (Status.VIVO, juca.getStatus());
    }

    @Test
    public void aoCriarSaintVidaE100 () throws Exception {
        BronzeSaint yuri = new BronzeSaint ("Yuri", "Yolo");
        assertEquals (100.0, yuri.getVida(), 0.001);
    }

    @Test
    public void generoMudaAoTrocarGenero () throws Exception {
        BronzeSaint etienne = new BronzeSaint ("Etienne", "Yolo");
        etienne.setGenero(Genero.FEMININO);
        assertEquals (Genero.FEMININO, etienne.getGenero());
    }

    @Test
    public void descontarValorVidaAoPerder10DeVida () throws Exception {
        Saint mu = new GoldSaint ("Mu", "Áries");
        mu.perderVida (10.0);
        assertEquals (90.0, mu.getVida(), 0.001);
    }

    @Test
    public void descontarValorVidaAoPerder100DeVida () throws Exception {
        Saint shaka = new GoldSaint ("Shaka", "Virgem");
        shaka.perderVida (100.0);
        assertEquals (0.0, shaka.getVida(), 0.001);
    }

    @Test
    public void atualizarStatusPraMortoQuandoVidaMenorQue1Dano100 () throws Exception {
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());
    }

    @Test
    public void atualizarStatusPraMortoQuandoVidaMenorQue1Dano60E60 () throws Exception {
        Saint shaka = new GoldSaint ("Shaka", "Virgem");
        shaka.perderVida (60.0);
        assertEquals (Status.VIVO, shaka.getStatus());
        shaka.perderVida (60.0);
        assertEquals (Status.MORTO, shaka.getStatus());
    }

    @Test
    public void saintNaoPodeTerVidaAlteradaQuandoMorto () throws Exception {
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());
        assertEquals (0.0, milo.getVida(), 0.001);
        milo.perderVida (10.0);
        assertEquals (0.0, milo.getVida(), 0.001);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void lancarExcecaoSeParametroDeDanoNegativo() throws InvalidParameterException, Exception {
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        milo.perderVida (-1000.0);
    }

    @Test
    public void aoCriarSaintSentidosDespertadosDeveSer5 () throws Exception {
        Saint santo = new BronzeSaint ("Santo", "Yolo");
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint santo = new BronzeSaint ("Santo", "Yolo");
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint santo = new SilverSaint ("Santo", "Yolo");
        assertEquals (6, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        assertEquals (7, aldebaran.getQtdeDeSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        GoldSaint jack = new GoldSaint ("Jack", "Yolo");
    }

    @Test
    public void aprenderGolpeInsereGolpeNaConstelacaoDoSaint () throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        aldebaran.aprenderGolpe (new Golpe ("Grande Chifre", 6));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Grande Chifre", 6));
    }
    
    @Test
    public void aprenderVariosGolpesInsereGolpesNaConstelacaoDoSaint () throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        aldebaran.aprenderGolpe (new Golpe ("Grande Chifre", 6));
        aldebaran.aprenderGolpe (new Golpe ("Socão", 3));
        aldebaran.aprenderGolpe (new Golpe ("Chutão", 3));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Grande Chifre", 6));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Socão", 3));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Chutão", 3));
    }

    @Test 
    public void proximoGolpePegaGolpesDeManeiraCircular () throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        hyoga.aprenderGolpe (new Golpe ("Pó de Diamante", 2));
        hyoga.aprenderGolpe (new Golpe ("Trovão Aurora Ataque", 3));
        hyoga.aprenderGolpe (new Golpe ("Execução Aurora", 4));

        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Pó de Diamante", 2));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Trovão Aurora Ataque", 3));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Execução Aurora", 4));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Pó de Diamante", 2));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Trovão Aurora Ataque", 3));
    }
    
    @Test 
    public void proximoMovimentoDeManeiraCircular () throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        BronzeSaint seiya = new BronzeSaint ("Seiya", "Pégaso");
        hyoga.adicionarMovimento (new Golpear (hyoga, seiya));
        hyoga.adicionarMovimento (new VestirArmadura (hyoga));

        assertTrue(hyoga.getProximoMovimento() instanceof Golpear);
        assertTrue(hyoga.getProximoMovimento() instanceof VestirArmadura);
        assertTrue( hyoga.getProximoMovimento() instanceof Golpear);
    }

    @Test 
    public void golpearAdicionaGolpeNaListaDeMovimentos () throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        BronzeSaint seiya = new BronzeSaint ("Seiya", "Pégaso");
        hyoga.aprenderGolpe (new Golpe ("Pó de Diamante", 10));
        hyoga.golpear(seiya);

        assertTrue(hyoga.getProximoMovimento().equals(new Golpear (hyoga, seiya)));
    }
    
    @Test 
    public void criarSaintAumentaQtdSaints () throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        assertEquals(1, Saint.getQtdSaints());
    }
    
    @Test 
    public void saintsRecebemIdsEmSequencia () throws Exception {
        int idAntes = Saint.getUltimoId();
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        BronzeSaint seiya = new BronzeSaint ("Seiya", "Pégaso");
        GoldSaint afrodite = new GoldSaint ("Afrodite", "Peixes");
        assertEquals((idAntes + 1), hyoga.getId());
        assertEquals((idAntes + 2), seiya.getId());
        assertEquals((idAntes + 3), afrodite.getId());
    }
}
