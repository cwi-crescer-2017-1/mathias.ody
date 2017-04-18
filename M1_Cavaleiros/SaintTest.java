import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida () throws Exception {
        //AAA 
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura (new Constelacao ("Escorpião"), Categoria.OURO);
        Saint milo = new Saint ("Milo", escorpiao);
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals (true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        assertEquals (false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new Saint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        assertEquals (Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void aoCriarSaintStatusEVivo () throws Exception {
        Saint juca = new Saint ("Juca", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        assertEquals (Status.VIVO, juca.getStatus());
    }

    @Test
    public void aoCriarSaintVidaE100 () throws Exception {
        Saint yuri = new Saint ("Yuri", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        assertEquals (100.0, yuri.getVida(), 0.001);
    }

    @Test
    public void generoMudaAoTrocarGenero () throws Exception {
        Saint etienne = new Saint ("Etienne", new Armadura (new Constelacao ("Yolo"), Categoria.PRATA));
        etienne.setGenero(Genero.FEMININO);
        assertEquals (Genero.FEMININO, etienne.getGenero());
    }

    @Test
    public void descontarValorVidaAoPerderVida () throws Exception {
        Saint mu = new Saint ("Mu", new Armadura (new Constelacao ("Áries"), Categoria.OURO));
        mu.perderVida (10.0);
        assertEquals (90.0, mu.getVida(), 0.001);

        Saint shaka = new Saint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        shaka.perderVida (100.0);
        assertEquals (0.0, shaka.getVida(), 0.001);
    }

    @Test(expected=Exception.class)
    public void lancarExcecaoSeParametroDeDanoIncorreto() throws Exception {
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (-1000.0);
    }

    @Test
    public void atualizarStatusPraMortoQuandoVidaMenorQue1 () throws Exception {
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());

        Saint shaka = new Saint ("Shaka", new Armadura (new Constelacao ("Virgem"), Categoria.OURO));
        shaka.perderVida (60.0);
        assertEquals (Status.VIVO, shaka.getStatus());
        shaka.perderVida (60.0);
        assertEquals (Status.MORTO, shaka.getStatus());
    }

    @Test
    public void saintNaoPodeTerVidaAlteradaQuandoMorto () throws Exception {
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        milo.perderVida (100.0);
        assertEquals (Status.MORTO, milo.getStatus());
        assertEquals (0.0, milo.getVida(), 0.001);
        milo.perderVida (10.0);
        assertEquals (0.0, milo.getVida(), 0.001);
    }

    @Test
    public void aoCriarSaintSentidosDespertadosDeveSer5 () throws Exception {
        Saint santo = new Saint ("Santo", new Armadura (new Constelacao ("Yolo"), Categoria.BRONZE));
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
}
