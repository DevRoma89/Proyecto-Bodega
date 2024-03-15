package MVC.Modelo.DAO;

import MVC.Modelo.Conexion;
import MVC.Modelo.Usuario;
import MVC.Vista.Login;
import MVC.Vista.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    Usuario usuario = new Usuario();
   
    public boolean ValidarUsuario(Usuario user) {
        
        String sql = " select \"User\" , \"Pass\"\n"
                + "    From \"Usuarios\"\n"
                + "    Where \"User\" = ? and \"Pass\"= ? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareCall(sql);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getPass());
            rs = ps.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Datos ingresados incorrectamente");
               
            }

        } catch (SQLException e) {
        }
        return false;

    }

}
