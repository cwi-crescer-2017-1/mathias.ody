/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author mathias
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String path, String conteudo) {
        try {
            final File file = new File(path);
            final Writer writer = new FileWriter(file);
            final BufferedWriter bufferReader = new BufferedWriter(writer);
            bufferReader.append(conteudo);
            bufferReader.flush();
            
            if(file.isFile() == false){
                throw new RuntimeException("Formato de arquivo não reconhecido ou válido");
            }
                              
        } 
        
        catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
