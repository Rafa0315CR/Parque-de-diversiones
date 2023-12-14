/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lgfon
 */
public class Entradas {

    private int id;
    private int mayores;
    private int menores;
    private int bebes;
    private int cantiPersonas;
    private String cantiAtracciones;
    private String fechaVisita;
    private double total;
    private String fechaVenta;


    public Entradas() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMayores() {
        return mayores;
    }

    public void setMayores(int mayores) {
        this.mayores = mayores;
    }

    public int getBebes() {
        return bebes;
    }

    public void setBebes(int medio) {
        this.bebes = medio;
    }

    public int getMenores() {
        return menores;
    }

    public void setMenores(int menores) {
        this.menores = menores;
    }

    public int getCantiPersonas() {
        return cantiPersonas;
    }

    public void setCantiPersonas(int cantiPersonas) {
        this.cantiPersonas = cantiPersonas;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
        public String getCantiAtracciones() {
        return cantiAtracciones;
    }

    public void setCantiAtracciones(String cantiAtracciones) {
        this.cantiAtracciones = cantiAtracciones;
    }
    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
        

}
