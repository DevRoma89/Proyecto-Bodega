
package MVC.Modelo.DAO;

import MVC.Modelo.Conexion;
import MVC.Modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class CiudadDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
    
 public JComboBox CB_Pais(JComboBox comboId, JComboBox comboNombre){
        
        String sql =" SELECT \"idPais\" , \"NombrePais\" FROM \"Paises\" ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Pais> paises = new ArrayList<>();
            
            
            while(rs.next()){
              int id = rs.getInt("idPais");
            String nombre = rs.getString("NombrePais");
            
            // Agregar el país a la lista
            paises.add(new Pais(id, nombre));
            
            // Agregar el nombre del país al JComboBox de nombres
            comboNombre.addItem(nombre);
                
            }
            
            
        } catch (Exception e) {
        }
        return null;
        
    }
       
    
 
}
