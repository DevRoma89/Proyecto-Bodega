
package main;

import MVC.Controlador.ControladorLogin;
import MVC.Vista.Login;


public class Main {
    public static void main(String[] args) {
        
        Login login = new Login();
        ControladorLogin C_Login = new ControladorLogin(login);
        
        C_Login.setVisible(true);
        
    }
}
