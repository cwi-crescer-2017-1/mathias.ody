import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ConstelacaoTest
{
    @Test
    public void adicionarGolpesAdicionaGolpes () {
        Constelacao dragao = new Constelacao ("Dragão");
        dragao.adicionarGolpe(new Golpe ("Cólera do Dragão", 3));
        dragao.adicionarGolpe(new Golpe ("Dragão Voador", 4));
        ArrayList<Golpe> golpes = dragao.getGolpes();
        assertEquals(golpes.get(0).getNome(), "Cólera do Dragão");
        assertEquals(golpes.get(1).getNome(), "Dragão Voador");
    }
}
