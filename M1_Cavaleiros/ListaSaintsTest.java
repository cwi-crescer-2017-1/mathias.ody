import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void adicionarSaintAdicionaSaintAoFinalDaLista () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        assertEquals(listaSaints.get(0), seiya);
        assertEquals(listaSaints.get(1), hyoga);
        assertEquals(listaSaints.get(2), shun);
    }

    @Test
    public void removerSaintRetiraSaintDaLista () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        listaSaints.remover (hyoga);
        assertEquals(listaSaints.get(0), seiya);
        assertEquals(listaSaints.get(1), shun);
    }

    @Test
    public void buscarSaintExistente () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        Saint saint = listaSaints.buscarPorNome ("Hyoga");
        assertEquals(saint, hyoga);
    }

    @Test
    public void buscarSaintExistenteComRepeticaoDeNome () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint hyoga2 = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (hyoga2);
        Saint saint = listaSaints.buscarPorNome ("Hyoga");
        assertEquals(saint, hyoga);
    }

    @Test
    public void buscarPorSaintInexistente () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint hyoga = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint hyoga2 = new Saint ("Hyoga", new Armadura (new Constelacao ("Cisne"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (hyoga2);
        Saint saint = listaSaints.buscarPorNome ("Manolo");
        assertNull(saint);
    }

    @Test
    public void buscarPorSaintComListaVazia () throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint saint = listaSaints.buscarPorNome ("Manolo");
        assertNull(saint);
    }

    @Test
    public void buscarPorCategoriaRetornaListaComSaintsDaCategoria () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        ArrayList<Saint> goldSaints = listaSaints.buscarPorCategoria (Categoria.OURO);
        assertEquals(goldSaints.get(0), milo);
        assertEquals(goldSaints.get(1), aldebaran);
    }

    @Test
    public void buscarPorStatusRetornaListaComSaintsNesseStatus () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        milo.perderVida (100.0);
        shun.perderVida (150.0);
        ArrayList<Saint> saintsMortos = listaSaints.buscarPorStatus (Status.MORTO);
        assertEquals(saintsMortos.get(0), milo);
        assertEquals(saintsMortos.get(1), shun);
    }

    @Test
    public void getSaintMaiorVidaRetornaSaintMaiorDeVida () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        seiya.perderVida (15.0);
        milo.perderVida (80.0);
        shun.perderVida (50.0);
        aldebaran.perderVida(5.0);
        assertEquals(listaSaints.getSaintMaiorVida(), aldebaran);
    }

    @Test
    public void getSaintMaiorVidaListaSaintsNula () throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        assertNull(listaSaints.getSaintMaiorVida());
    }

    @Test
    public void getSaintMenorVidaRetornaSaintMenorDeVida () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        seiya.perderVida (15.0);
        milo.perderVida (80.0);
        shun.perderVida (50.0);
        aldebaran.perderVida(5.0);
        assertEquals(listaSaints.getSaintMenorVida(), milo);
    }

    @Test
    public void getSaintMenorVidaListaSaintsNula () throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        assertNull(listaSaints.getSaintMenorVida());
    }

    @Test
    public void ordenarOsElementosEmOrdemAscendenteDeVida () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        seiya.perderVida (15.0);
        milo.perderVida (80.0);
        shun.perderVida (50.0);
        aldebaran.perderVida(5.0);
        listaSaints.ordenar();
        assertEquals(listaSaints.get(0), milo);
        assertEquals(listaSaints.get(1), shun);
        assertEquals(listaSaints.get(2), seiya);
        assertEquals(listaSaints.get(3), aldebaran);
    }
    
    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarOrdenaOsElementosEmOrdemAscendenteDeVidaComUmSo () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(seiya);
        seiya.perderVida (15.0);
        listaSaints.ordenar();
        assertEquals(listaSaints.get(0), seiya);
    }
    
    @Test
    public void ordenarOsElementosEmOrdemDescendenteDeVida () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        seiya.perderVida (15.0);
        milo.perderVida (80.0);
        shun.perderVida (50.0);
        aldebaran.perderVida(5.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaSaints.get(0), aldebaran);
        assertEquals(listaSaints.get(1), seiya);
        assertEquals(listaSaints.get(2), shun);
        assertEquals(listaSaints.get(3), milo);
    }
    
    @Test
    public void ordenarComListaVaziaComParametro() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarOrdenaOsElementosEmOrdemDescendenteDeVidaComUmSo () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(seiya);
        seiya.perderVida (15.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaSaints.get(0), seiya);
    }
    
    @Test
    public void ordenarOsElementosEmOrdemAscendenteDeVidaComParametro () throws Exception {
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        Saint shun = new Saint ("Shun", new Armadura (new Constelacao ("Andrômeda"), Categoria.BRONZE));
        Saint aldebaran = new Saint ("Aldebaran", new Armadura (new Constelacao ("Touro"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (milo);
        listaSaints.adicionar (shun);
        listaSaints.adicionar (aldebaran);
        seiya.perderVida (15.0);
        milo.perderVida (80.0);
        shun.perderVida (50.0);
        aldebaran.perderVida(5.0);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        assertEquals(listaSaints.get(0), milo);
        assertEquals(listaSaints.get(1), shun);
        assertEquals(listaSaints.get(2), seiya);
        assertEquals(listaSaints.get(3), aldebaran);
    }
    
    @Test
    public void getCSVRetornaStringComListaSaints () throws Exception{
        Saint seiya = new Saint ("Seiya", new Armadura (new Constelacao ("Pégaso"), Categoria.BRONZE));
        Saint milo = new Saint ("Milo", new Armadura (new Constelacao ("Escorpião"), Categoria.OURO));
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        seiya.perderVida (89.3);
        listaSaints.adicionar (milo);
        String csv = listaSaints.getCSV();
        String separador = System.getProperty("line.separator");
        String resultadoEsperado = "Seiya,10.7,Pégaso,BRONZE,VIVO,NAO_INFORMADO,false" + separador + "Milo,100.0,Escorpião,OURO,VIVO,NAO_INFORMADO,false";
        assertEquals(csv, resultadoEsperado);
    }
    
    @Test
    public void getCSVComListaVazia () throws Exception{
        ListaSaints listaSaints = new ListaSaints();
        String csv = listaSaints.getCSV();
        String resultadoEsperado = "";
        assertEquals(csv, resultadoEsperado);
    }
}
