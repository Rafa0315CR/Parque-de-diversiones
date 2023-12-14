/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lgfon
 */
public class Atracciones {

    private int IdAtraccion;
    private String nombreAtraccion;
    private String fechaInstalacion;
    private int capacidad;
    private String seccion;
    private String rangoEdad;
    private int precio;

    public Atracciones() {
    }

    public int getIdAtraccion() {
        return IdAtraccion;
    }

    public void setIdAtraccion(int IdAtraccion) {
        this.IdAtraccion = IdAtraccion;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public String getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(String fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String sección) {
        this.seccion = sección;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
