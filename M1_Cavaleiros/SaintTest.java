import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida () throws Exception {
        //AAA 
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura (new Constelacao ("Escorpião"), Categoria.OURO);
        GoldSaint milo = new GoldSaint ("Milo", escorpiao);
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals (true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        assertEquals (false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        BronzeSaint shaka = new BronzeSaint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        assertEquals (Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void aoCriarSaintStatusEVivo () throws Exception {
        BronzeSaint juca = new BronzeSaint ("Juca", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        assertEquals (Status.VIVO, juca.getStatus());
    }

    @Test
    public void aoCriarSaintVidaE100 () throws Exception {
        BronzeSaint yuri = new BronzeSaint ("Yuri", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        assertEquals (100.0, yuri.getVida(), 0.001);
    }

    @Test
    public void generoMudaAoTrocarGenero () throws Exception {
        BronzeSaint etienne = new BronzeSaint ("Etienne", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        etienne.setGenero(Genero.FEMININO);
        assertEquals (Genero.FEMININO, etienne.getGenero());
    }

    @Test
    public void descontarValorVidaAoPerder10DeVida () throws Exception {
        Saint mu = new GoldSaint ("Mu", new Armadura (new Constelacao ("Áries"), Categoria.OURO));
        mu.perderVida (10.0);
        assertEquals (90.0, mu.getVida(), 0.001);
    }

    @Test
    public void descontarValorVidaAoPerder100DeVida () throws Exception {
        Saint shaka = new GoldSaint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        shaka.perderVida (100.0);
        assertEquals (0.0, shaka.getVida(), 0.001);
    }

    @Test
    public void atualizarStatusPraMortoQuandoVidaMenorQue1Dano100 () throws Exception {
        Saint milo = new GoldSaint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());
    }

    @Test
    public void atualizarStatusPraMortoQuandoVidaMenorQue1Dano60E60 () throws Exception {
        Saint shaka = new GoldSaint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        shaka.perderVida (60.0);
        assertEquals (Status.VIVO, shaka.getStatus());
        shaka.perderVida (60.0);
        assertEquals (Status.MORTO, shaka.getStatus());
    }

    @Test
    public void saintNaoPodeTerVidaAlteradaQuandoMorto () throws Exception {
        Saint milo = new GoldSaint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());
        assertEquals (0.0, milo.getVida(), 0.001);
        milo.perderVida (10.0);
        assertEquals (0.0, milo.getVida(), 0.001);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void lancarExcecaoSeParametroDeDanoNegativo() throws InvalidParameterException, Exception {
        Saint milo = new GoldSaint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (-1000.0);
    }

    @Test
    public void aoCriarSaintSentidosDespertadosDeveSer5 () throws Exception {
        Saint santo = new BronzeSaint ("Santo", new Armadura (new Constelacao ("Yolo"), Categoria.BRONZE));
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint santo = new BronzeSaint ("Santo", new Armadura (new Constelacao ("Yolo"), Categoria.BRONZE));
        assertEquals (5, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint santo = new SilverSaint ("Santo", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        assertEquals (6, santo.getQtdeDeSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        assertEquals (7, aldebaran.getQtdeDeSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        GoldSaint jack = new GoldSaint ("Jack", new Armadura (new Constelacao ("Yolo"), Categoria.OURO));
    }

    @Test
    public void aprenderGolpeInsereGolpeNaConstelacaoDoSaint () throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        aldebaran.aprenderGolpe (new Golpe ("Grande Chifre", 6));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Grande Chifre", 6));
    }
    
    @Test
    public void aprenderVariosGolpesInsereGolpesNaConstelacaoDoSaint () throws Exception {
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        aldebaran.aprenderGolpe (new Golpe ("Grande Chifre", 6));
        aldebaran.aprenderGolpe (new Golpe ("Socão", 3));
        aldebaran.aprenderGolpe (new Golpe ("Chutão", 3));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Grande Chifre", 6));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Socão", 3));
        assertEquals (aldebaran.getProximoGolpe(), new Golpe ("Chutão", 3));
    }

    @Test 
    public void proximoGolpePegaGolpesDeManeiraCircular () throws Exception {
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        hyoga.aprenderGolpe (new Golpe ("Pó de Diamante", 2));
        hyoga.aprenderGolpe (new Golpe ("Trovão Aurora Ataque", 3));
        hyoga.aprenderGolpe (new Golpe ("Execução Aurora", 4));

        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Pó de Diamante", 2));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Trovão Aurora Ataque", 3));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Execução Aurora", 4));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Pó de Diamante", 2));
        assertEquals(hyoga.getProximoGolpe(), new Golpe ("Trovão Aurora Ataque", 3));
    }
}
