import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest
{
    @Test
    public void estouComSorte() {
        SorteDoDia sorte = new SorteDoDia (new DadoFalso (2));
        assertTrue (sorte.estouComSorte());
    }

    @Test
    public void estouComAzar() {
        SorteDoDia sorte = new SorteDoDia (new DadoFalso (1));
        assertFalse (sorte.estouComSorte());
    }
}
