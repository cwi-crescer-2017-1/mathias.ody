/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void importCSV (File file) {
        final String filename = file.getName();
        if (!file.exists() || filename.endsWith(".csv") || file.isDirectory())
            return;
        
        final String tableName = filename.substring(0, filename.indexOf("."));      
        final String path = file.toPath().toString();
        
        String importedQueries = "LOAD DATA INFILE '" + path + "' INTO TABLE '" + tableName + "' (Id,Nome)";

        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(importedQueries)) {
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public File exportCSV(String query) {
        WriterUtils writer = new WriterUtilsImp();
        try {
            String result = executeQuery(query);
            String path = "exported.csv";
            writer.write(path, result);
            File file = new File(path);
            return file;
        } 
        
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    private String generateCSV (ResultSet resultSet) {
        try {
            StringBuilder result = new StringBuilder();
            ResultSetMetaData lines = resultSet.getMetaData();
            int columns = lines.getColumnCount();
            while (resultSet.next()) {
                for (int i = 0; i < columns; i++) {
                  result.append(resultSet.getString(i + 1)).append(", ");
                }
                result.deleteCharAt(result.length() - 2);
                result.append("\n");
            }
            return result;
        }
        catch (Exception e) {
            throw new RuntimeException ("Ocorreu um erro ao gerar o CSV");
        }
    }
}
