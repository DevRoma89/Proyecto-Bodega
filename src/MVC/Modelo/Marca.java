
package MVC.Modelo;


public class Marca {
    private int idMarca;
    private String NombreMarca;

    public Marca() {
    }

    public Marca(int idMarca, String NombreMarca) {
        this.idMarca = idMarca;
        this.NombreMarca = NombreMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }
    
    
}
