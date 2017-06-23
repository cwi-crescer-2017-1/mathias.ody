/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathias
 */
public class FileUtilsImpl implements FileUtils {

    public boolean mk(String string) {
        try{
            File file = new File(string);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            return file.exists() || string.matches(".*\\..{3}") ? file.createNewFile() : file.mkdir();
        }
        catch (IOException e){ 
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, e);
            return false; 
        }
    }

    public boolean rm(String string) {
        File file = new File (string);
        if(!file.exists())
            throw new RuntimeException("Arquivo não existe.");
        if(file.isDirectory())
            throw new RuntimeException("Arquivo é inválido");
        return file.delete();
    }

    public String ls(String string) {
        File file = new File(string);
        if (file.isDirectory()) {
            String [] nomeArquivos = file.list();
            return String.join ("\n", nomeArquivos);
        }
        else {
            return file.getAbsolutePath();
        }
    }

    public boolean mv(String in, String out) {
        File file = new File(in);
        File fileOut = new File (out);
        if (file.isDirectory() || fileOut.isDirectory()){
            throw new RuntimeException("Arquivo é inválido");
        }
        return file.renameTo(new File(out));
    }
    
}
