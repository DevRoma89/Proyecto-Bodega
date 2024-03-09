package MVC.Modelo;

public class Ciudad {

    private int IdCiudad;
    private String NombreCiudad;
    private int IdPais;
    private String NombrePais;

    public Ciudad() {
    }

    public Ciudad(int IdCiudad, String NombreCiudad, int IdPais, String NombrePais) {
        this.IdCiudad = IdCiudad;
        this.NombreCiudad = NombreCiudad;
        this.IdPais = IdPais;
        this.NombrePais = NombrePais;
    }

    public String getNombrePais() {
        return NombrePais;
    }

    public void setNombrePais(String NombrePais) {
        this.NombrePais = NombrePais;
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

    public void setNombreCiudad(String NombreCiudad) {
        this. NombreCiudad =  NombreCiudad;
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }
    
    
    
    
}
