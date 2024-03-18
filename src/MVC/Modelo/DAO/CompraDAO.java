package MVC.Modelo.DAO;

import MVC.Modelo.Compra;
import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompraDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    Compra compra = new Compra();

    //Create
    public int InsertarCabecera(Compra compra) {

        int idGenerado = 0;

        String sql = "insert into \"Compras\" (\"IdUsuario\", \"Total\",\"IdProveedor\") Values (?,0,?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getIdUsuario());
            ps.setInt(2, compra.getIdProveedor());
            int r = ps.executeUpdate();

            if (r > 0) {

                ResultSet Id = ps.getGeneratedKeys();
                if (Id.next()) {

                    JOptionPane.showMessageDialog(null, "Se a establecido correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    idGenerado = Id.getInt(1);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se a establecido correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {

            System.out.println(e.toString());

        }

        return idGenerado;
    }

    //Read
    //Update
    //Delete
    //Create
    public int InsertarDetalle(Compra compra) {
        int r = 0;
        String sql = " insert into \"DetalleCompra\" (\"IdCompra\", \"IdArticulo\",\"CantidadArticulo\",\"PrecioUnidad\",\"Total\") Values (?,?,?,?,?) ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getIdCompra());
            ps.setInt(2, compra.getFkIdArticulo());
            ps.setInt(3, compra.getCantidadArticulo());
            ps.setDouble(4, compra.getPrecioArticulo());
            ps.setDouble(5, compra.getTotalDetalle());

            r = ps.executeUpdate();

            if (r > 0) {
                JOptionPane.showMessageDialog(null, "El articulo se agrego correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El articulo no se agrego correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
        }

        return r;
    }

    //Read
    public List BuscarDetalle(Compra compra) {
        List<Compra> datos = new ArrayList<>();

        String sql = " Select dc.\"IdCompra\", art.\"Nombre\",dc.\"CantidadArticulo\",dc.\"PrecioUnidad\",dc.\"Total\"\n"
                + "From \"DetalleCompra\" as dc\n"
                + "Inner Join \"Compras\" as c on dc.\"IdCompra\" = c.\"IdCompra\"\n"
                + "Inner Join \"Articulos\" as art on dc.\"IdArticulo\" = art.\"idArticulo\"\n"
                + "where dc.\"IdCompra\" = ? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,compra.getIdCompra());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
            
                   Compra c = new Compra();
                   
                   c.setIdCompra(rs.getInt(1));
                   c.setNombreArticulo(rs.getString(2));
                   c.setCantidadArticulo(rs.getInt(3));
                   c.setPrecioArticulo(rs.getInt(4));
                   c.setTotalDetalle(rs.getInt(5));
                   
                   datos.add(c);
            
            }
            
            
        } catch (SQLException e) {
        }

        return datos;
    }

    //Update
    //Delete
}
