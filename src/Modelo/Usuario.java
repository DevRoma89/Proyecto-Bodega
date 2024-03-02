/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author augusto.ojeda
 */
public class Usuario {
    
    private int CodUsuario;
    private String NombreUsuario;
    private String Contraseña;

    public Usuario() {
    }

    public Usuario(int CodUsuario, String NombreUsuario, String Contraseña) {
        this.CodUsuario = CodUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }

    public int getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
    
    
    
    
}
