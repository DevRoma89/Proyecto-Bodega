

package MVC.Modelo.DAO;

import MVC.Modelo.Ciudad;
import MVC.Modelo.Conexion;
import MVC.Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ProveedorDAO {

    Connection con ;
    PreparedStatement ps;
    ResultSet rs ; 
    Proveedor proveedor = new Proveedor();
    Conexion conectar = new Conexion();
    
    
    //Create
    
    public int Insertar(Proveedor proveedor){
        int r = 0 ;
        
        String sql = "Insert into \"Proveedores\" (\"Nombre\", \"RUC\", \"Contacto\", \"SitioWeb\", \"IdCiudad\") VALUES (?,?,?,?,?)";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1,proveedor.getNombreProveedor());
            ps.setString(2,proveedor.getRUC());
            ps.setString(3,proveedor.getContacto());
            ps.setString(4,proveedor.getSitioWeb());
            ps.setInt(5,proveedor.getIdCiudad());
            
            r = ps.executeUpdate();
            
            if( r == 1){
                JOptionPane.showMessageDialog(null, "Se a agregado correctamento");
                return 1;
            }else{
                JOptionPane.showMessageDialog(null, "No se a agregado correctamento");
                return 0;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return r ;
    }
    
    //Read
    
    public List Listar (){
        
         List<Proveedor> datos = new ArrayList<>();
        
        try {
            String sql = "SELECT p.\"IdProveedor\" , p.\"Nombre\" , p.\"RUC\" , p.\"Contacto\" , p.\"SitioWeb\" , c.\"NombreCiudad\"  \n" +
                         "FROM \"Proveedores\" as p \n" +
                         "INNER JOIN \"Ciudades\" as c ON p.\"IdCiudad\" = c.\"idCiudad\"    ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt(1));
                proveedor.setNombreProveedor(rs.getString(2));
                proveedor.setRUC(rs.getString(3));
                proveedor.setContacto(rs.getString(4));
                proveedor.setSitioWeb(rs.getString(5));
                proveedor.setNombreCiudad(rs.getString(6));
                datos.add(proveedor);
            }
            
        } catch (SQLException e) {
             System.out.println(e.toString());
        }
        
        return datos;
    
    }
    
    //Update
    
    //Delete 
    
    //AUX
    public JComboBox CB_Ciudad(JComboBox comboId, JComboBox comboNombre){
        
        String sql =" SELECT \"idCiudad\" , \"NombreCiudad\" FROM \"Ciudades\" ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
            int id = rs.getInt("IdCiudad");
            String nombre = rs.getString("NombreCIudad");

            comboNombre.addItem(nombre);
            comboId.addItem(id);
                
            }
            
            
        } catch (SQLException e) {
        }
        return null;
        
    }
    
    

    
}
