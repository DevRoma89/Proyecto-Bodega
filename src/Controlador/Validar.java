/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.menu;
import Vista.vista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author augusto.ojeda
 */
public class Validar  implements MouseListener {
    
    vista v = new vista();
    menu m = new menu();
    Usuario u = new Usuario();
    Login l = new Login();

    public Validar( vista v ) {
        this.v = v ;
        this.v.login_btn.addMouseListener(this);
    }
    
   
    
    
    
    public void ValidarLogin(){
    
          String User = v.txtUsuario.getText();
          String Pass = String.valueOf(v.txtContraseña.getText());
          
          u = l.log(User, Pass);
          
          if(u.getNombreUsuario()!= null && u.getContraseña()!= null ) {
            m.setVisible(true);
            v.dispose();
           }
          
          
                  
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ValidarLogin(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
