/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.menu;
import Vista.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author augusto.ojeda
 */
public class Login implements ActionListener {
    Usuario u = new Usuario();
    vista v = new vista();
    menu m = new menu(); 
    Connection con;
    PreparedStatement ps; 
    ResultSet rs; 
    
    Conexion cn = new Conexion();
    
    
        public Usuario log(String User, String Pass){
        
            
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
        
        public Login ( vista v ) {
        this.v = v ;
        this.v.login_btn.addActionListener(this);
    }
        
        public void ValidarLogin(){
    
          String User = v.txtUsuario.getText();
          String Pass = String.valueOf(v.txtContraseña.getText());
          
          u = log(User, Pass);
          
          if(u.getNombreUsuario()!= null && u.getContraseña()!= null ) {
            m.setVisible(true);
            v.dispose();
           }else{

             JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
             v.txtUsuario.setText("");
             v.txtContraseña.setText("");
          }
          
          
                  
    
    }


    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == v.login_btn ){
          ValidarLogin();
      }
    }
    
    
    
    
    
    
}
