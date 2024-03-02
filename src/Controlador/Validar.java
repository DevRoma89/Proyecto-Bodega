/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.menu;
import Vista.vista;

/**
 *
 * @author augusto.ojeda
 */
public class Validar {
    
    vista v = new vista();
    menu m = new menu();
    Usuario u = new Usuario();
    Login l = new Login();
    
    
    
    public void ValidarLogin(){
    
          String User = v.txtUsuario.getText();
          String Pass = String.valueOf(v.txtContraseña.getText());
          
          u = l.log(User, Pass);
          
          if(u.getNombreUsuario()!= null && u.getContraseña()!= null ) {
            m.setVisible(true);
            v.dispose();
           }
          
          
                  
    
    }
    
    
}
