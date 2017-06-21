/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mathias
 */
public class Parcelagem implements Parcelator{

    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, 
                                            int numeroParcelas, 
                                            double taxaJuros, 
                                            Date dataPrimeiroVencimento) {
    
    Map<String, BigDecimal> parcelas = new HashMap<String, BigDecimal>();
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dataPrimeiroVencimento);
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    BigDecimal juros = valorParcelar.add (valorParcelar.multiply(BigDecimal.valueOf(taxaJuros)));
    BigDecimal mensalidade = juros.divide(BigDecimal.valueOf(numeroParcelas));
    
    //StringBuilder str = new StringBuilder();
    
    for (int i = 0; i < numeroParcelas; i++) {
        parcelas.put(dateFormat.format(calendar.getTime()), mensalidade);
        calendar.add(Calendar.MONTH, 1);
    }

    return parcelas;
    }
    
}
