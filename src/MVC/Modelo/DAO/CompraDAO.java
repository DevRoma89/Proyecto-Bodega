package MVC.Modelo.DAO;

import MVC.Modelo.Compra;
import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {

    Connection con ;
    PreparedStatement ps;
    ResultSet rs ;
    Conexion conectar = new Conexion();
    Compra compra = new Compra();
    
    
    
    //Create
    
    public int InsertarDetalle(){
        int r = 0;
        
        
        
        
        return r;
    }
    
    //Read
    //Update
    //Delete
    
    
}
