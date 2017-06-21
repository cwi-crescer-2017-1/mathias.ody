/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mathias
 */
public class ManipulacaoDatas implements CalendarUtils {

    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        return getDiaSemana(diaDaSemana);
    }

    public String tempoDecorrido(Date date) {
        Calendar calendarAtual = Calendar.getInstance();
	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int anosDiferenca = calendarAtual.get(Calendar.YEAR) - calendar.get(Calendar.YEAR); 
        int mesesDiferenca =  Math.abs(calendarAtual.get(Calendar.MONTH) - calendar.get(Calendar.MONTH));
        int diasDiferenca = Math.abs(calendarAtual.get(Calendar.DATE) - calendar.get(Calendar.DATE));
        return "" + anosDiferenca + " ano(s), " +
                    mesesDiferenca + " mes(es) e " +
                    diasDiferenca + " dia(s)";
    }
    
    DiaSemana getDiaSemana (int numDia) {
        switch (numDia) {
        case 1:
            return DiaSemana.DOMINGO;
        case 2:
            return DiaSemana.SEGUNDA_FEIRA;
        case 3: 
            return DiaSemana.TERCA_FEIRA;
        case 4:
            return DiaSemana.QUARTA_FEIRA;
        case 5: 
            return DiaSemana.QUINTA_FEIRA;
        case 6:
            return DiaSemana.SEXTA_FEIRA;
        case 7:
            return DiaSemana.SABADO;
        default:
            return DiaSemana.DOMINGO;
    	}
    }
}
