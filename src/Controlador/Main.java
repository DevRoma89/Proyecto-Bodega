/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.MenuHorizontal.Paises;
import Vista.menu;
import Vista.vista;
import java.sql.SQLException;

/**
 *
 * @author augusto.ojeda
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        vista v = new vista();
        Paises oPaises = new Paises();
        PaisDAO oPaisesDAO = new PaisDAO(oPaises);
        Login login = new Login(v);
        
        v.setVisible(true);
       
       
        
        
    }
    
}
