/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GENATCHI
 */
public class ConexaoDB {
    
    public static Connection ligarBD(){
    
        //String URL_DB="jdbc:mysql://localhost:3306/bd_ataximanager?useSSL=false&serverTimezone=UTC";
        String URL_DB="jdbc:mysql://localhost:3306/bd_ataximanager?serverTimezone=UTC";
        String DRIVER8="com.mysql.cj.jdbc.Driver";
        String DRIVER5="com.mysql.jdbc.Driver";
        String USER ="root1";
        String PASSWORD="1234";
        
        Connection conn;
    
        try {
            Class.forName(DRIVER5);
            return conn=DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro de conexao\t"+ex.getLocalizedMessage());
             return null;
        }
    
   
    }
    
    
}
