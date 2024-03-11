
package MVC.Modelo;


public class Articulo {
 
    private int IdArticulo;
    private String Nombre;
    private int PrecioVenta;
    private int PrecioCompra;
    private int Stock;
    private int IdMarca;
    private String NombreMarca;
    
    public Articulo() {
    }

    public Articulo(int IdArticulo, String Nombre, int PrecioVenta, int PrecioCompra, int Stock, int IdMarca, String NombreMarca) {
        this.IdArticulo = IdArticulo;
        this.Nombre = Nombre;
        this.PrecioVenta = PrecioVenta;
        this.PrecioCompra = PrecioCompra;
        this.Stock = Stock;
        this.IdMarca = IdMarca;
        this.NombreMarca = NombreMarca;
 
    }

    public int getIdArticulo() {
        return IdArticulo;
    }

    public void setIdArticulo(int IdArticulo) {
        this.IdArticulo = IdArticulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public int getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(int PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }
    
}
