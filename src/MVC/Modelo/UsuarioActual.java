package MVC.Modelo;

public class UsuarioActual {
    private static Usuario usuario;
    
    private UsuarioActual() {
    }
    
    public static Usuario getUsuario(){
        return usuario;
    }
    
    public static void setUsuario(Usuario usuario) {
        UsuarioActual.usuario = usuario;
    }
    
    
}
