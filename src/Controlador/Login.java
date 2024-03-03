/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author augusto.ojeda
 */
public class Login {
    
    Connection con;
    PreparedStatement ps; 
    ResultSet rs; 
    
    Conexion cn = new Conexion();
    
    
        public Usuario log(String User, String Pass){
        
            Usuario u = new Usuario();
            String sql = "SELECT * FROM \"Usuarios\" Where \"User\" = ? AND \"Pass\" = ? "; 
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, User);
                ps.setString(2, Pass);
                rs = ps.executeQuery();
                
                if(rs.next()){
                
                    u.setCodUsuario(rs.getInt("IdUsuario"));
                    u.setNombreUsuario(rs.getString("User"));
                    u.setContraseña(rs.getString("Pass"));
                
                } 
            
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            
        return u;
        }
    
    
    
    
    
    
}
