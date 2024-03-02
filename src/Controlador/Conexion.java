/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author augusto.ojeda
 */
public class Conexion {
    
    Connection con;
    
    public Connection getConnection(){
    
        try {
            String myDB = "jdbc:mysql://localhost:3306:bodega?serverTimezone=UTC";
            con = DriverManager.getConnection(myDB, "root", "root");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return null;
    
    }
    
    
    
}
