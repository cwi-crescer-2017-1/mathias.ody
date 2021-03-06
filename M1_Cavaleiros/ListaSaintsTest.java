import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void adicionarSaintAdicionaSaintAoFinalDaLista () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar (seiya);
        listaSaints.adicionar (hyoga);
        listaSaints.adicionar (shun);
        Saint saint = listaSaints.buscarPorNome ("Hyoga");
        assertEquals(saint, hyoga);
    }

    @Test
    public void buscarSaintExistenteComRepeticaoDeNome () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint hyoga2 = new BronzeSaint ("Hyoga", "Cisne");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint hyoga2 = new BronzeSaint ("Hyoga", "Cisne");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(seiya);
        seiya.perderVida (15.0);
        listaSaints.ordenar();
        assertEquals(listaSaints.get(0), seiya);
    }
    
    @Test
    public void ordenarOsElementosEmOrdemDescendenteDeVida () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.adicionar(seiya);
        seiya.perderVida (15.0);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaSaints.get(0), seiya);
    }
    
    @Test
    public void ordenarOsElementosEmOrdemAscendenteDeVidaComParametro () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
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
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
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
    
    @Test
    public void unirDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
        assertEquals(resultado.get(2), shun);
        assertEquals(resultado.get(3), aldebaran);
    }
    
    @Test
    public void unirDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), shun);
        assertEquals(resultado.get(1), aldebaran);
    }
    
    @Test
    public void unirDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.unir(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
    }
    
    @Test
    public void diffDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        Saint mu = new GoldSaint ("Mu", "Áries");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista1.adicionar (shun);
        lista1.adicionar (aldebaran);
        lista2.adicionar (seiya);
        lista2.adicionar (mu);
        lista2.adicionar (milo);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(shun, resultado.get(0));
        assertEquals(aldebaran, resultado.get(1));
    }
    
    @Test
    public void diffDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(resultado.todos().size(),0);
    }
    
    @Test
    public void diffDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.diff(lista2);
        assertEquals(resultado.get(0), seiya);
        assertEquals(resultado.get(1), milo);
    }
    
    @Test
    public void intersecDuasListas () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        Saint mu = new GoldSaint ("Mu", "Áries");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        lista1.adicionar (shun);
        lista2.adicionar (mu);
        lista2.adicionar (aldebaran);
        lista2.adicionar (seiya);
        lista2.adicionar (mu);
        lista2.adicionar (milo);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(seiya, resultado.get(0));
        assertEquals(milo, resultado.get(1));
    }
    
    @Test
    public void intersecDuasListasLista1Vazia() throws Exception {
        Saint shun = new BronzeSaint ("Shun", "Andrômeda");
        Saint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista2.adicionar (shun);
        lista2.adicionar (aldebaran);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(resultado.todos().size(), 0);
    }
    
    @Test
    public void intersecDuasListasLista2Vazia() throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Saint milo = new GoldSaint ("Milo", "Escorpião");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionar (seiya);
        lista1.adicionar (milo);
        ListaSaints resultado = lista1.intersec(lista2);
        assertEquals(resultado.todos().size(), 0);
    }
}
