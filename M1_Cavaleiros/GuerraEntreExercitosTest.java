import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest
{
    @Test
    public void batalhaEntreExercitosUmaBatalha () throws Exception {
        SilverSaint jamian = new SilverSaint ("Jamian", "Corvo");
        GoldSaint saga = new GoldSaint ("Saga", "Gêmeos");
        saga.aprenderGolpe(new Golpe ("Outra Dimensão", 10));
        saga.aprenderGolpe(new Golpe ("Explosão Galática", 20));
        jamian.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 10));
        jamian.aprenderGolpe (new Golpe ("Bicada Louca do Covo", 10));
        saga.adicionarMovimento(new Golpear());
        jamian.adicionarMovimento(new Golpear());
       
       ExercitoDeSaints exercito1 = new ExercitoQueAtacaEmOrdemAlternada();
       exercito1.alistar (saga);
       ExercitoDeSaints exercito2 = new ExercitoQueAtacaEmOrdemHierarquica();
       exercito2.alistar (jamian);
       GuerraEntreExercitos guerra = new GuerraEntreExercitos (exercito1, exercito2);
       guerra.iniciar();
       int vitoriasExercito1 = guerra.getVitoriasExercito1();
       int vitoriasExercito2 = guerra.getVitoriasExercito2();
       assertEquals (vitoriasExercito1, 1);
       assertEquals (vitoriasExercito2, 0);
    }
    
    @Test
    public void batalhaEntreExercitosComElesVazios () throws Exception {
       ExercitoDeSaints exercito1 = new ExercitoQueAtacaEmOrdemAlternada();
       ExercitoDeSaints exercito2 = new ExercitoQueAtacaEmOrdemHierarquica();
       GuerraEntreExercitos guerra = new GuerraEntreExercitos (exercito1, exercito2);
       guerra.iniciar();
       int vitoriasExercito1 = guerra.getVitoriasExercito1();
       int vitoriasExercito2 = guerra.getVitoriasExercito2();
       assertEquals (vitoriasExercito1, 0);
       assertEquals (vitoriasExercito2, 0);
    }
    
    @Test
    public void batalhaEntreExercitosTresBatalhas () throws Exception {
        SilverSaint jamian = new SilverSaint ("Jamian", "Corvo");
        GoldSaint saga = new GoldSaint ("Saga", "Gêmeos");
        saga.aprenderGolpe(new Golpe ("Outra Dimensão", 10));
        saga.aprenderGolpe(new Golpe ("Explosão Galática", 20));
        jamian.aprenderGolpe (new Golpe ("Eixo das Asas Negras", 10));
        jamian.aprenderGolpe (new Golpe ("Bicada Louca do Covo", 10));
        saga.adicionarMovimento(new Golpear());
        jamian.adicionarMovimento(new Golpear());
        
        BronzeSaint seiya = new BronzeSaint ("Seiya", "Corvo");
        GoldSaint mu = new GoldSaint ("Mu", "Áries");
        mu.aprenderGolpe(new Golpe ("Parede", 10));
        seiya.aprenderGolpe(new Golpe ("Meteoro de Pégaso", 10));
        seiya.aprenderGolpe(new Golpe ("Turbilhão de Pégaso", 30));
        seiya.adicionarMovimento (new ContraAtacar(new DadoFalso(2)));
        seiya.adicionarMovimento (new Golpear());
        mu.adicionarMovimento (new Golpear());
        
        BronzeSaint hyoga = new BronzeSaint ("Hyoga", "Cisne");
        GoldSaint aldebaran = new GoldSaint ("Aldebaran", "Touro");
        hyoga.aprenderGolpe(new Golpe ("Pó de Diamante", 30));
        hyoga.adicionarMovimento (new AtaqueDuplo(new DadoFalso(3)));
        aldebaran.aprenderGolpe(new Golpe ("Grande Chifre", 20));
        aldebaran.adicionarMovimento (new Golpear());
       
       ExercitoDeSaints exercito1 = new ExercitoQueAtacaEmOrdemAlternada();
       exercito1.alistar (saga);
       exercito1.alistar (mu);
       exercito1.alistar (hyoga);
       ExercitoDeSaints exercito2 = new ExercitoQueAtacaEmOrdemHierarquica();
       exercito2.alistar (jamian);
       exercito2.alistar (seiya);
       exercito2.alistar (aldebaran);
       GuerraEntreExercitos guerra = new GuerraEntreExercitos (exercito1, exercito2);
       guerra.iniciar();
       int vitoriasExercito1 = guerra.getVitoriasExercito1();
       int vitoriasExercito2 = guerra.getVitoriasExercito2();
       assertEquals (2, vitoriasExercito1);
       assertEquals (1, vitoriasExercito2);
    }
}
