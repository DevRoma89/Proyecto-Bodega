package MVC.Modelo.DAO;

import MVC.Modelo.Articulo;
import MVC.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArticuloDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();
    Articulo articulo = new Articulo();

    //Create
    public int Insertar(Articulo articulo) {
        int r = 0;

        String sql = " INSERT INTO \"Articulos\"(\"Nombre\", \"PrecioVenta\", \"PrecioCompra\", \"Stock\", \"IdMarca\") VALUES (?, 0, 0, 0, ?); ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, articulo.getNombre());
            ps.setInt(2, articulo.getIdMarca());
            r = ps.executeUpdate();

            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Se agrego correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se agrego correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return r;
    }

    //Read
    public List Listar() {

        List<Articulo> datos = new ArrayList<>();

        String sql = "SELECT a.\"idArticulo\", a.\"Nombre\", m.\"NombreMarca\"\n"
                + "FROM \"Articulos\" as a\n"
                + "INNER JOIN \"Marcas\" as m ON a.\"IdMarca\" = m.\"IdMarca\" ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Articulo articulo = new Articulo();

                articulo.setIdArticulo(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setNombreMarca(rs.getString(3));

                datos.add(articulo);

            }

        } catch (SQLException e) {

            System.out.println(e.toString());

        }

        return datos;
    }

    public List Buscar(String Busqueda) {
        List<Articulo> datos = new ArrayList<>();

        try {
            String sql = "SELECT a.\"idArticulo\", a.\"Nombre\", m.\"NombreMarca\"\n"
                    + "FROM \"Articulos\" as a\n"
                    + "INNER JOIN \"Marcas\" as m ON a.\"IdMarca\" = m.\"IdMarca\" \n"
                    + "WHERE c.\"NombreCiudad\" ILIKE ? ";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Busqueda + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setIdArticulo(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setNombreMarca(rs.getString(3));
                datos.add(articulo);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return datos;
    }

    //Update
    public int Actualizar(Articulo articulo) {
        int r = 0;

        String sql = " UPDATE \"Articulos\"\n"
                + " SET  \"Nombre\"=?, \"IdMarca\"=?\n"
                + " WHERE \"idArticulo\" =? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, articulo.getNombre());
            ps.setInt(2, articulo.getIdMarca());
            ps.setInt(3, articulo.getIdArticulo());
            r = ps.executeUpdate();
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return r;

    }

    //Delete
    public int Eliminar(Articulo articulo) {
        int r = 0;

        String sql = "DELETE FROM \"Articulos\"\n"
                + "WHERE \"idArticulo\" = ? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareCall(sql);
            ps.setInt(1, articulo.getIdArticulo());
            r = ps.executeUpdate();

            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return r;

    }

    //AUX
    public JComboBox CB_Marca(JComboBox comboId, JComboBox comboNombre) {

        String sql = " SELECT * FROM \"Marcas\" ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                comboId.addItem(rs.getInt(1));
                comboNombre.addItem(rs.getString(2));

            }

        } catch (SQLException e) {
        }

        return null;
    }

}
