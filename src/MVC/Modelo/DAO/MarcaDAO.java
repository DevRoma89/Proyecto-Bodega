package MVC.Modelo.DAO;

import MVC.Modelo.Conexion;
import MVC.Modelo.Marca;
import MVC.Modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MarcaDAO {
    Conexion conectar = new Conexion();
    Connection con ; 
    PreparedStatement ps;
    ResultSet rs ; 
    

    
    
//Create 
  public int Insertar(Marca oMarca){
    int r = 0 ; 
        
        String sql =" INSERT INTO \"Marcas\"(\"NombreMarca\") VALUES (?)";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql); 
            ps.setString(1, oMarca.getNombreMarca());
            r = ps.executeUpdate(); 
            
            if (r == 1 ){
                JOptionPane.showMessageDialog(null, "Se a agregado correctamento");
                return 1;  
            }else{
                JOptionPane.showMessageDialog(null, "No se a agregado correctamento");
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    return r; 

}

//Read
  public List listar(){
        List<Marca> datos = new ArrayList<>();
        
        try {
            String sql = " SELECT * FROM \"Marcas\" ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            Marca m = new Marca();
            m.setIdMarca(rs.getInt(1));
            m.setNombreMarca(rs.getString(2));
            datos.add(m);
            }
            
        } catch (SQLException e) {
        }
        
        return datos;
    } 
  
  public List buscar(String Busqueda){
        List<Marca> datos = new ArrayList<>();
        
        try {
            String sql = " SELECT * FROM \"Marcas\" WHERE \"NombreMarca\" ILIKE ? ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Busqueda + "%"  );
            rs = ps.executeQuery();
            
            while(rs.next()){
            Marca m = new Marca();
            m.setIdMarca(rs.getInt(1));
            m.setNombreMarca(rs.getString(2));
            datos.add(m);
            }
            
        } catch (SQLException e) {
        }
        
        return datos;
    } 
 
//Update
  public int Actualizar(int id, String nombre){
        int r = 0; 
        
        String sql = "UPDATE \"Marcas\" SET \"NombreMarca\"= ? WHERE \"idMarca\" = ?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1,nombre);
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
        
        String sql =" DELETE FROM \"Marcas\" WHERE \"IdMarca\" = " + Id;
        
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
 
 
 
}






