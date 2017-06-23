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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathias
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String path, String conteudo) {
        if(path.endsWith(".txt") || path.endsWith(".sql") || path.endsWith(".csv")) {
            final File file = new File(path);
            if(file.isDirectory())
                throw new RuntimeException("Nao é possível executar sobre a pasta.");
            if(!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(WriterUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try (
                final Writer writer = new FileWriter(file);
                final BufferedWriter bufferReader = new BufferedWriter(writer);
            ){
                bufferReader.append(conteudo);
                //bufferReader.flush();
            }

            catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        else {
            throw new RuntimeException("Arquivo em formato não reconhecido.");
        }
    }
}
