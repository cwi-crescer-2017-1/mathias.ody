/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.lista2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author mathias
 */
public class FileUtilsImpl implements FileUtils {

    public boolean mk(String string) {
        try{
            return new File(string).createNewFile();
        }
        catch (IOException e){ return false; }
    }

    public boolean rm(String string) {
        File file = new File (string);
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
        try {
            File file = new File(in);
            if (file.isDirectory()){
                return false;
            }
            return file.renameTo(new File(out));
        }
        catch (Exception e) { return false; }
    }
    
}
