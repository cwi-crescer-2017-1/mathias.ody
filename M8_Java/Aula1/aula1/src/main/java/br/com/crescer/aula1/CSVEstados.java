/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.util.Arrays;

/**
 *
 * @author mathias.ody
 */
public class CSVEstados {
    
    /*public static*/ void main (String[] args){
        
        Estados[] estados = Estados.values();
        String [] nomeEstados = new String [estados.length];
        for (int i = 0; i < estados.length; i++) {
            nomeEstados[i] = estados[i].getNome();
        }
        
        Arrays.sort (nomeEstados);
        
        StringBuffer buffer = new StringBuffer("");
        
        buffer = getCSV(nomeEstados, buffer);
        
        System.out.println(buffer);
    }
    
    static StringBuffer getCSV(String [] array, StringBuffer buffer){
        //Adicionar primeiro
        buffer.append(array[0]);
        
        //Adicionar restantes
        for (int j = 0; j < array.length; j++) {
            buffer.append (", ");
            buffer.append(array[j]);
        }
        return buffer;
    }
}
