import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoDeSaintsTest
{
    @Test
    public void CriandoUmaListExercitoHierarquico() throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));

        assertEquals (new GoldSaint("Aiolia", "Leão").getNome(),  defensoresDeAthena.get(4).getNome());
        assertEquals(new BronzeSaint("Hyoga", "Cisne").getNome(), defensoresDeAthena.get(0).getNome());
        assertEquals(new SilverSaint("Marin", "Águia").getNome(), defensoresDeAthena.get(3).getNome());
        assertEquals(new BronzeSaint("Seiya", "Pégaso").getNome(), defensoresDeAthena.get(1).getNome());
        assertEquals(new GoldSaint("Shura", "Capricórnio").getNome(), defensoresDeAthena.get(5).getNome());
        assertEquals(new BronzeSaint("Shiryu", "Dragão").getNome(), defensoresDeAthena.get(2).getNome());

    }

    @Test
    public void CriandoUmaListExercitoAlternando() throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        
        assertEquals(new BronzeSaint("Ikki", "Fênix").getNome(), impostores.get(0).getNome());
        assertEquals(new SilverSaint("Misty", "Lagarto").getNome(), impostores.get(1).getNome());
        assertEquals(new GoldSaint("Máscara da Morte", "Câncer").getNome(), impostores.get(2).getNome());
        assertEquals(new SilverSaint("Algol", "Perseu").getNome(), impostores.get(3).getNome());
        assertEquals(new GoldSaint("Saga", "Gêmeos").getNome(), impostores.get(4).getNome());
        assertEquals(new GoldSaint("Afrodite", "Peixes").getNome(), impostores.get(5).getNome());

    }
}
