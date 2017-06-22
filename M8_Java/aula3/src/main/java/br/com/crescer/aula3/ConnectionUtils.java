package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathias.ody
 */
public final class ConnectionUtils {
    
    static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static String user = "CRESCER2017";
    static String pass = "CRESCER2017";
    
    public static void setConnectionUser (String username, String password) {
        user = username;
        pass = password;
    }
    
    public static Connection getConnection () throws SQLException{
        return DriverManager.getConnection(url, user, pass);
    }
}