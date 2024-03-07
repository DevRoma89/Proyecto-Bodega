
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PaisDAO {
    
    PreparedStatement ps ; 
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Pais pais = new Pais();
    
    public int Actualizar(int id, String nombre){
        int r = 0; 
        
        String sql = "UPDATE \"Paises\" SET \"NombrePais\"= ? WHERE \"idPais\" = ?";
        
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
    public int Insertar(Pais oPais){
        int r = 0 ; 
        
        String sql =" INSERT INTO \"Paises\"(\"NombrePais\") VALUES (?)";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql); 
            ps.setString(1, oPais.getNombre());
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
        return r ; 
    }
    
    public int eliminar(int Id){
        int r = 0 ; 
        
        String sql =" DELETE FROM \"Paises\" WHERE \"idPais\" = " + Id;
        
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
    
    
    public List listar(){
        List<Pais> datos = new ArrayList<>();
        
        try {
            String sql = " SELECT * FROM \"Paises\" ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            Pais p = new Pais();
            p.setIdPais(rs.getInt(1));
            p.setNombre(rs.getString(2));
            datos.add(p);
            }
            
        } catch (SQLException e) {
        }
        
        return datos;
    } 
    
    public List buscar(String Busqueda){
        List<Pais> datos = new ArrayList<>();
        
        try {
            String sql = " SELECT * FROM \"Paises\" WHERE \"NombrePais\" ILIKE ? ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Busqueda + "%"  );
            rs = ps.executeQuery();
            
            while(rs.next()){
            Pais p = new Pais();
            p.setIdPais(rs.getInt(1));
            p.setNombre(rs.getString(2));
            datos.add(p);
            }
            
        } catch (SQLException e) {
        }
        
        return datos;
    } 
    
    
    
    
    
}
