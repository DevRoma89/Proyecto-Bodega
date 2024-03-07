
package MVC.Modelo.DAO;

import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class CiudadDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
    
    
    public JComboBox CB_Pais (JComboBox comboBox){
        
        String sql =" SELECT \"NombrePais\" FROM \"Paises\" ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
              comboBox.addItem(rs.getString(1));
                
            }
            
            
        } catch (Exception e) {
        }
        
        return comboBox;
    }
    
    
}
