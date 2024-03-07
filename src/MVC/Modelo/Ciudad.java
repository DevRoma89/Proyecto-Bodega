package MVC.Modelo;

public class Ciudad {

    private int IdCiudad;
    private String NombrePais;
    private int IdPais;

    public Ciudad() {
    }

    public Ciudad(int IdCiudad, String NombrePais, int IdPais) {
        this.IdCiudad = IdCiudad;
        this.NombrePais = NombrePais;
        this.IdPais = IdPais;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public String getNombrePais() {
        return NombrePais;
    }

    public void setNombrePais(String NombrePais) {
        this.NombrePais = NombrePais;
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }
    
    
    
    
}
