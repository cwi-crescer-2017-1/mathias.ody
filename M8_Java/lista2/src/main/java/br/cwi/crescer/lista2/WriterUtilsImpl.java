/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista2;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author mathias
 */
public class WriterUtilsImpl implements WriterUtils{

    public void write(String file, String conteudo) {
        try {
            if (!file.contains(".txt")) { throw new Exception ("Arquivo não reconhecido ou em formato inválido."); }
        }
        catch (Exception e) { System.out.println(e.getCause()); }
        
        try (
            final FileWriter fileWriter = new FileWriter (file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ){
                bufferedWriter.append(conteudo);
                bufferedWriter.newLine();
            }
        catch (Exception e) { System.out.println(e.getCause()); }
    }
}
