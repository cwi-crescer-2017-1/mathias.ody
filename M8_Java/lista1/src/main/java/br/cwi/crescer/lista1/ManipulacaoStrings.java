/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista1;

import java.text.Normalizer;

/**
 *
 * @author mathias
 */
public class ManipulacaoStrings implements StringUtils {
    public boolean isEmpty(String string) {
        if(string == null || string.isEmpty())
            return true;
        else 
            return false;
    }

    public String inverter(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public int contaVogais(String string) {
        string = Normalizer.normalize(string, Normalizer.Form.NFD); //separa os acentos das letras
        string = string.replaceAll("[^\\p{ASCII}]", ""); //retirar acentos
        int vInicial = string.length();
        
        string = string.replaceAll("[aeiouAEIOU]", "");
        int vFinal = string.length();
        
        return vInicial - vFinal;
    }

    public boolean isPalindromo(String string) {
        string = string.replaceAll(" ", ""); 
        string = string.toUpperCase();
        String stringInvertida = inverter(string);
        return string.equals(stringInvertida);
    }
    
    
}
