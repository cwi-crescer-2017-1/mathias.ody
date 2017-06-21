/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import br.cwi.crescer.lista1.CalendarUtils.DiaSemana;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mathias
 */
public class Main {
    static ManipulacaoStrings stringMan;
    static ManipulacaoDatas datasMan;
    static Parcelagem parcelagem;
    
    public static void main (String[] args) throws Exception {
        stringMan = new ManipulacaoStrings();
        datasMan = new ManipulacaoDatas();
        parcelagem = new Parcelagem();
        
        //strings
        TesteIsEmpy();
        TesteReverse();
        TesteContaVogais();
        TestePalindromo();
        
        //datas
        TesteDiaSemana();
        TesteTempoDecorrido();
        
        //parcelas
        TesteParcelas();
    }
    
    static void TesteIsEmpy() throws Exception {
        if (stringMan.isEmpty("") == false)
            throw new Exception ("isEmpty não retornou true quando vazio");
        
        if (stringMan.isEmpty(null) == false)
            throw new Exception ("isEmpty não retornou true quando null");
        
        if (stringMan.isEmpty("Yolo") == true)
            throw new Exception ("isEmpty não retornou false quando existente");
    }
    
    static void TesteReverse() throws Exception {
        if (! stringMan.inverter("Yolo").equals("oloY"))
            throw new Exception ("inverter não inverteu Yolo");
        
        if (! stringMan.inverter("Green Day").equals("yaD neerG"))
            throw new Exception ("inverter não inverteu Green Day");      
    }
    
    static void TesteContaVogais() throws Exception {
        if (stringMan.contaVogais("Yolo") != 2) 
            throw new Exception ("contaVogais não acertou em Yolo");
        
        if (stringMan.contaVogais("Cácétì") != 3)
            throw new Exception ("contaVogais não acertou em Cácétì");      
    }
    
    static void TestePalindromo() throws Exception {
        if (stringMan.isPalindromo("Yolo") == true) 
            throw new Exception ("isPalindromo retornou true para Yolo");
        
        if (stringMan.isPalindromo("Ame a ema") == false)
            throw new Exception ("isPalindromo retornou false para Ame a ema");    
    }
    
    static void TesteDiaSemana() throws Exception {
        if (datasMan.diaSemana(new Date(117,5,15)) != DiaSemana.QUINTA_FEIRA) 
            throw new Exception ("diaSemana retornou errado");
    }
    
    static void TesteTempoDecorrido() throws Exception {
        if (! datasMan.tempoDecorrido(new Date(117,5,15)).equals ("0 ano(s), 0 mes(es) e 6 dia(s)")) //funcionou dia 21 =P
            throw new Exception ("tempoDecorrido retornou errado");
    }
    
    static void TesteParcelas() throws Exception {
        /**/
    }
}
