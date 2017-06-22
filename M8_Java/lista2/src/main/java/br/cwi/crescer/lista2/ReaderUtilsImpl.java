/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author mathias
 */
public class ReaderUtilsImpl implements ReaderUtils{

    public String read(String string) {
        try {
            if (!string.contains(".txt")) { throw new Exception ("Arquivo não reconhecido ou em formato inválido."); }
        }
        catch (Exception e) { System.out.println(e.getCause()); }
        
        try (
            final Reader reader = new FileReader (string);
            final BufferedReader bufferedReader = new BufferedReader(reader);
            ) {
            final StringBuilder str = new StringBuilder();
            
            bufferedReader.lines()
                                .forEach (x -> str
                                .append (x + "\n"));
            
            return str.toString();
        }
        
        catch (Exception e) { System.out.println(e.getCause()); }
        
        return "Não foi possível ler o arquivo.";  
    }
}
