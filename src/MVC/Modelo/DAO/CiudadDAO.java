
package MVC.Modelo.DAO;

import MVC.Modelo.Ciudad;
import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
             System.out.println(e.toString());
        }
        
        
        return r; 
    } 
    
//Read
  public List listar(){
        List<Ciudad> datos = new ArrayList<>();
        
        try {
            String sql = "select c.\"idCiudad\", c.\"NombreCiudad\" , p.\"NombrePais\" \n" +
                         "from \"Ciudades\" as c \n" +
                         "inner join \"Paises\" as p On c.\"IdPais\" = p.\"idPais\" ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt(1));
                ciudad.setNombreCiudad(rs.getString(2));
                ciudad.setNombrePais(rs.getString(3));
                
                datos.add(ciudad);
            }
            
        } catch (SQLException e) {
             System.out.println(e.toString());
        }
        
        return datos;
    } 
  
  public List buscar(String Busqueda){
        List<Ciudad> datos = new ArrayList<>();
        
        try {
            String sql = "select c.\"idCiudad\", c.\"NombreCiudad\" , p.\"NombrePais\" \n" +
                         "from \"Ciudades\" as c \n" +
                         "inner join \"Paises\" as p On c.\"IdPais\" = p.\"idPais\" "
                         + "WHERE c.\"NombreCiudad\" ILIKE ? ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Busqueda + "%"  );
            rs = ps.executeQuery();
            
            while(rs.next()){
            Ciudad ciudad = new Ciudad();
            ciudad.setIdCiudad(rs.getInt(1));
            ciudad.setNombreCiudad(rs.getString(2));
            ciudad.setNombrePais(rs.getString(3));
            datos.add(ciudad);
            }
            
        } catch (SQLException e) {
             System.out.println(e.toString());
        }
        
        return datos;
    } 
 
//Update
  public int Actualizar(Ciudad ciudad){
        int r = 0; 
        
        String sql = "UPDATE \"Ciudades\" SET \"NombreCiudad\"= ? , \"IdPais\"=? WHERE \"idCiudad\" = ?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, ciudad.getNombreCiudad());
            ps.setInt(2, ciudad.getIdPais());
            ps.setInt(3, ciudad.getIdCiudad());
            r = ps.executeUpdate();
            if (r == 1 ){
                JOptionPane.showMessageDialog(null, "Se a actualizado correctamento");
                return 1;  
            }else{
                JOptionPane.showMessageDialog(null, "No se a actualizado correctamento");
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return r ;
    }
 
//Delate 
  public int Eliminar(int Id){
        int r = 0 ; 
        
        String sql =" DELETE FROM \"Ciudades\" WHERE \"idCiudad\" = " + Id;
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate(); 
            
            if (r == 1 ){
                JOptionPane.showMessageDialog(null, "Se a elimino correctamento");
                return 1;  
            }else{
                JOptionPane.showMessageDialog(null, "No se a eliminado");
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return r ; 
    }   
    
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
