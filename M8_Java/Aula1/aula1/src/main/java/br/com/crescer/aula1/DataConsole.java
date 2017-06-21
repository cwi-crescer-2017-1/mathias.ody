/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mathias.ody
 */
public class DataConsole {
    public static void main (String[] args){
        
        System.out.println("Bem vindo ao manipulador de datas para preguiçosos");
        try (Scanner scanner = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("Insira o comando. 'help' para ajuda ou 'exit' para sair.");
                System.out.print(">");
                String comando = scanner.nextLine();

                switch (comando) {
                    case "exit":
                        break OUTER;
                    case "help":
                        System.out.println("\nSomar datas => sum dd/MM/yyyy nDias\n");
                        break;
                    default:
                        System.out.print(analisarComando(comando));
                        break;
                }
            } 
        }
    }
    
    public static String analisarComando(String comando) {
        String [] partes = comando.split(" ");
        switch (partes[0]) {
                    case "sum":
                        return somar(partes[1],partes[2]);
                    default:
                        return "Comando não reconhecido.";
                }
    }
    
    public static String somar(String dataStr, String addStr) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int add = Integer.parseInt(addStr); 
        try {
            Date date = dateFormat.parse(dataStr);
            calendar.setTime(date); 
        }
        catch (Exception e) { return "Data em formato incorreto."; }
        
        calendar.add(Calendar.DATE, add);
        
        return "" + dateFormat.format(calendar.getTime()) + "\n";
    } 
}
