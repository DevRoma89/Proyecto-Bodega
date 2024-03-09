package MVC.Modelo;

public class Proveedor {


    private int IdProveedor;
    private String NombreProveedor;
    private String RUC;
    private String Contacto;
    private String SitioWeb;
    private int IdCiudad;
    private String NombreCiudad;

    public Proveedor() {
    }

    public Proveedor(int IdProveedor, String NombreProveedor, String RUC, String Contacto, String SitioWeb, int IdCiudad, String NombreCiudad) {
        this.IdProveedor = IdProveedor;
        this.NombreProveedor = NombreProveedor;
        this.RUC = RUC;
        this.Contacto = Contacto;
        this.SitioWeb = SitioWeb;
        this.IdCiudad = IdCiudad;
        this.NombreCiudad = NombreCiudad;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getSitioWeb() {
        return SitioWeb;
    }

    public void setSitioWeb(String SitioWeb) {
        this.SitioWeb = SitioWeb;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public String getNombreCiudad() {
        return NombreCiudad;
    }

    public void setNombreCiudad(String NombreCiudad) {
        this.NombreCiudad = NombreCiudad;
    }
    
    
        
}
