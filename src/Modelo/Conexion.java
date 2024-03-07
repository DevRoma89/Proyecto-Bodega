/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
            String myDB = "jdbc:postgresql://localhost:5432/bodega";
            con = DriverManager.getConnection(myDB, "postgres", "root");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return null;
    
    }
    
    
    
}
