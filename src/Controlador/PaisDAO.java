/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pais;
import Vista.MenuHorizontal.Paises;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augusto.ojeda
 */
public class PaisDAO implements ActionListener {
    Paises oPaises = new Paises();
    Connection con ; 
    Conexion oConexion = new Conexion();
    PreparedStatement ps ;
    ResultSet rs ; 
    
    public void CargarPaises(String nombre) throws SQLException{
        
        
        String sql = " INSERT INTO \"Paises\"(\"NombrePais\") VALUES (?)";
        
        try {
            con = oConexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            int filasInsert = ps.executeUpdate(sql);
            
            if( filasInsert > 0 ){
                System.out.println("Insert exitoso");
            }else{
                System.out.println("Fallo en Insert");
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
              
    }
    
    public PaisDAO( Paises oPaises ){
       this.oPaises = oPaises;
       this.oPaises.btnCargar.addActionListener(this);
        
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == oPaises.btnCargar){
           String Nombre =  oPaises.txtNombre.getText();
           
           if(Nombre != null ){
               try {
                   CargarPaises(Nombre);
               } catch (SQLException ex) {
                   Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
        }
    }
    
    
    
}
