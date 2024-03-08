
package MVC.Modelo.DAO;

import MVC.Modelo.Ciudad;
import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CiudadDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    Ciudad ciudad = new Ciudad();
    
 
    
    
//Create
    
    public int Insertar(Ciudad ciudad){
        int r= 0;
        
        String sql = "INSERT INTO \"Ciudades\" (\"NombreCiudad\" , \"IdPais\") VALUES (?,?) ";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombreCiudad());
            ps.setInt(2,ciudad.getIdPais());
            r = ps.executeUpdate();
            if( r == 1){
                JOptionPane.showMessageDialog(null,("Se agrego correctamente") );
            }else {
                JOptionPane.showMessageDialog(null,("No se agrego correctamente") );
            }
        } catch (SQLException e) {
        }
        
        
        return r; 
    }
    
    
    
//Read
//Update
//Delate    
    
//AUX
    public JComboBox CB_Pais(JComboBox comboId, JComboBox comboNombre){
        
        String sql =" SELECT \"idPais\" , \"NombrePais\" FROM \"Paises\" ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
            int id = rs.getInt("idPais");
            String nombre = rs.getString("NombrePais");

            comboNombre.addItem(nombre);
            comboId.addItem(id);
                
            }
            
            
        } catch (SQLException e) {
        }
        return null;
        
    }
       
    
 
}
