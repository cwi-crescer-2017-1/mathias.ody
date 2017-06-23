/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import br.cwi.crescer.lista2.ReaderUtilsImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author mathias
 */
public class SQLUtilsImpl implements SQLUtils {
    
    public void runFile(String filename) {
        if(!filename.endsWith(".sql"))
            throw new RuntimeException ("Tentativa de ler um arquivo de querrys com extensão não suportada.");
        
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()){
            final String text = new ReaderUtilsImpl().read(filename);
            
            String[] splitedQueries = text.split(";");
            for (String query : splitedQueries) {
                statement.executeQuery (query);
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String executeQuery (String query) {
        try (final Statement statement = ConnectionUtils.getConnection().createStatement();
             final ResultSet result = statement.executeQuery(query);){
            return generateCSV(result);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void importCSV (File file) {
        final String filename = file.getName();
        if (!file.exists() || filename.endsWith(".csv") || file.isDirectory())
            return;
        
        final String tableName = filename.substring(0, filename.lastIndexOf("."));
        
        try (
                final Reader reader = new FileReader(file);
                final BufferedReader bufferReader = new BufferedReader(reader);
            ) 
        {
            List<String> lines = bufferReader.lines().collect(toList());
            if(lines.size() <= 1) return; //vazio
            
            try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
                for (String line : lines) {
                    String[] expressions = line.split(",");
                    
                    for(int i = 0; i < expressions.length - 1; i++) {
                        statement.addBatch(expressions[i - 1]);
                    }
                    statement.executeBatch();
                }
                } 
                catch (Exception e) {
                    throw new RuntimeException("Erro: " + e.getMessage());
                }
            } 
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Object read(String absolutePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
