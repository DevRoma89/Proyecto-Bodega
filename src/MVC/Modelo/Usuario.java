package MVC.Modelo;


public class Usuario {
    
    private int IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String Correo;
    private String Telefono;
    private int IdCiudad;
    private String User;
    private String Pass;
    private int Rol;

    public Usuario() {
    }

    public Usuario(int IdUsuario, String Nombre, String Apellido, String Cedula, String Correo, String Telefono, int IdCiudad, String User, String Pass, int Rol) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.IdCiudad = IdCiudad;
        this.User = User;
        this.Pass = Pass;
        this.Rol = Rol;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }
    
    
    
}
