/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.DOMINGO;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.QUARTA_FEIRA;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.QUINTA_FEIRA;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.SABADO;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.SEGUNDA_FEIRA;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.SEXTA_FEIRA;
import static br.cwi.crescer.lista1.CalendarUtils.DiaSemana.TERCA_FEIRA;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author carloshenrique
 */
public class ManipulacaoDatasTest {

    private final CalendarUtils calendarUtils = new ManipulacaoDatas();
    private static final Calendar CALENDAR = Calendar.getInstance();

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Domingo() {
        CALENDAR.set(2017, 5, 18, 0, 0, 0); // 2017-06-18 00:00:00

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(DOMINGO, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SegundaFeira() {
        CALENDAR.set(2017, 5, 19, 0, 0, 0); // 2017-06-19 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SEGUNDA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_TercaFeira() {
        CALENDAR.set(2017, 5, 20, 0, 0, 0); // 2017-06-20 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(TERCA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuartaFeira() {
        CALENDAR.set(2017, 5, 21, 0, 0, 0); // 2017-06-21 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUARTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuintaFeira() {
        CALENDAR.set(2017, 5, 22, 0, 0, 0); // 2017-06-22 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUINTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SextaFeira() {
        CALENDAR.set(2017, 5, 23, 0, 0, 0); // 2017-06-23 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SEXTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Sabado() {
        CALENDAR.set(2017, 5, 24, 0, 0, 0); // 2017-06-24 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SABADO, diaSemana);
    }

    /**
     * Test of tempoDecorrido method, of class CalendarUtils.
     */
    @Test
    public void testTempoDecorrido() {
        final Period between = Period.between(LocalDate.of(1985, Month.JANUARY, 29), LocalDate.now());

        CALENDAR.set(1985, 0, 29, 0, 0, 0); // 1985-01-29 00:00:00    

        final String tempo = calendarUtils.tempoDecorrido(CALENDAR.getTime());
        final String format = String.format("%s ano(s), %s messe(s) e %s dia(s)", 
                between.getYears(), 
                between.getMonths(), 
                between.getDays());

        assertEquals(format, tempo);
    }

}