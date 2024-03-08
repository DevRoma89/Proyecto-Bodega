package MVC.Modelo;

public class Ciudad {

    private int IdCiudad;
    private String NombreCiudad;
    private int IdPais;

    public Ciudad() {
    }

    public Ciudad(int IdCiudad, String NombrePais, int IdPais) {
        this.IdCiudad = IdCiudad;
        this.NombreCiudad = NombreCiudad;
        this.IdPais = IdPais;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public String getNombreCiudad() {
        return  NombreCiudad;
    }

    public void setNombreCiudad(String NombrePais) {
        this. NombreCiudad =  NombreCiudad;
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }
    
    
    
    
}
