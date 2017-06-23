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
import static java.util.stream.Collectors.toList;

/**
 *
 * @author mathias
 */
public class ReaderUtilsImpl implements ReaderUtils{

    public String read(String string) {
        if(string.endsWith(".txt") || string.endsWith(".sql") || string.endsWith(".csv")) {
            final File file = new File(string);
            if(!file.exists())
                throw new RuntimeException("Arquivo não encontrado.");
            if(file.isDirectory())
                throw new RuntimeException("Arquivo inválido.");
            
            try (
                final Reader reader = new FileReader (string);
                final BufferedReader bufferedReader = new BufferedReader(reader);
                ) {
                
                return String.join("\n", bufferedReader.lines().collect(toList()));
            }

            catch (Exception e) { throw new RuntimeException("Erro: " + e.getMessage()); }
        }
        else {
            throw new RuntimeException("Arquivo não é um arquivo de leitura válido.");
        }
    }
}
