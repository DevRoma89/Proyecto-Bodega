/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import MVC.Controlador.ControladorLogin;
import MVC.Vista.Login;

/**
 *
 * @author Manu
 */
public class Main {
    public static void main(String[] args) {
        
        Login login = new Login();
        ControladorLogin C_Login = new ControladorLogin(login);
        
        C_Login.setVisible(true);
        
    }
}
