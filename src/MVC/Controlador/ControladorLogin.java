package MVC.Controlador;

import MVC.Modelo.DAO.LoginDAO;
import MVC.Modelo.Usuario;
import MVC.Modelo.UsuarioActual;
import MVC.Vista.Login;
import MVC.Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorLogin extends Login implements ActionListener, KeyListener {

    Usuario usuario = new Usuario();
    LoginDAO dao = new LoginDAO();

    public ControladorLogin(Login login) {

        this.login_btn.addActionListener(this);
        this.txtContraseña.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_btn) {
            ValidarUsuario();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ValidarUsuario();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void ValidarUsuario() {

        usuario.setUser(txtUsuario.getText());
        usuario.setPass(txtContraseña.getText());
        int idUsuario = dao.ValidarUsuario(usuario);

        if (idUsuario != 0) {

            Menu m = new Menu();
            m.setVisible(true);
            usuario.setIdUsuario(idUsuario);
            UsuarioActual.setUsuario(usuario);

            cerrarVentana();

        } else {
            txtUsuario.setText("");
            txtContraseña.setText("");
        }

    }

}
