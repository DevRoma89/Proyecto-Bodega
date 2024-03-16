package MVC.Controlador;

import MVC.Modelo.DAO.LoginDAO;
import MVC.Modelo.Usuario;
import MVC.Modelo.UsuarioActual;
import MVC.Vista.Login;
import MVC.Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin extends Login implements ActionListener {
    Usuario usuario = new Usuario();
    LoginDAO dao = new LoginDAO();
    
    public ControladorLogin(Login login){
    
        this.login_btn.addActionListener(this);
       
      
    }
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == login_btn){
      
          usuario.setUser(txtUsuario.getText());
          usuario.setPass(txtContraseña.getText());
          
          if( dao.ValidarUsuario(usuario) == true ){
              
              Menu m = new Menu();
              m.setVisible(true);
              
              UsuarioActual.setUsuario(usuario);
              
              cerrarVentana();
          
          }else{
              txtUsuario.setText("");
              txtContraseña.setText("");
          }
      
      }
    }


    
}
