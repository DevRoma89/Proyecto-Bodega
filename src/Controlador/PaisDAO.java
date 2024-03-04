/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pais;
import Vista.MenuHorizontal.Paises;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




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
            int filasInsert = ps.executeUpdate();
           oPaises.txtNombre.setText("");
            if( filasInsert > 0 ){
                JOptionPane.showMessageDialog(null,"Insert exitoso");
                
            }else{
               JOptionPane.showMessageDialog(null,"Insert fallido");
            }
             
             
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
              
    }
    
    public List<Pais> BuscarPaises(String nombre){
        List<Pais> listaPaises = new ArrayList<>();
        String sql = "SELECT * FROM \"Paises\" WHERE \"NombrePais\" LIKE ? ";
       
        try {
             con = oConexion.getConnection();
             ps = con.prepareStatement(sql);
             ps.setString(1, "%" + nombre + "%" );
             rs = ps.executeQuery(sql);
             
             while (rs.next()) {
                Pais oPais = new Pais(); 
                oPais.setIdPais(rs.getInt(1));
                oPais.setNombre(rs.getString(2));
                
                listaPaises.add(oPais);
            }
             
        } catch (SQLException e) {
        }
        
        
        
        return listaPaises;
    }
    
    
    public PaisDAO( Paises oPaises ){
       this.oPaises = oPaises;
       this.oPaises.btnCargar.addActionListener(this);
        
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}

  