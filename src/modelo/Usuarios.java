/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 50688
 */
public class Usuarios {
    
    public int cedula;
    public String contrasena;
    public String correo;
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String tipoUsuario;

    public Usuarios() {
    }

    public Usuarios(int cedula, String contrasena, String correo, String nombre, String apellido1, String apellido2, String tipoUsuario) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipoUsuario = tipoUsuario;
    }

    public int getCedula() {
        return cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
