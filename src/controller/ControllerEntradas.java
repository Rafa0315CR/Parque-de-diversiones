/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Entradas;
import modelo.EntradasDAO;
import vista.frmManteEntradas;

/**
 *
 * @author lgfon
 */
public class ControllerEntradas implements ActionListener {

    frmManteEntradas vistaEntradas = new frmManteEntradas();
    Entradas e = new Entradas();
    EntradasDAO dao = new EntradasDAO();

    public ControllerEntradas(frmManteEntradas frm) {
        this.vistaEntradas = frm;
        this.vistaEntradas.btnVolver2.addActionListener(this);
        this.vistaEntradas.btnPagar1.addActionListener(this);
        this.vistaEntradas.btnPagar2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // paso #2
        if (e.getSource() == vistaEntradas.btnPagar2) {
            calcular();
            suma();
            agregarEntradas();
            limpiarCampos();
        }
        if (e.getSource() == vistaEntradas.btnPagar1) {
            calcular1();
            suma1();
            agregarEntradas1();
            limpiarCampos();
        }
        
    }
        public void agregarEntradas() {

        String cantidad = vistaEntradas.lblVisita2.getText();
        String fecha = vistaEntradas.jdFecha.getDate().toString();
        String mayores = vistaEntradas.SpMayores.getValue().toString();
        String menores = vistaEntradas.SpMenores.getValue().toString();
        String bebes = vistaEntradas.SpBebes.getValue().toString();
        String total = vistaEntradas.lblTotal2.getText();
        String atracciones = vistaEntradas.lbl13.getText();
        String fechaVenta = vistaEntradas.lblFechaVenta.getText();
        e.setCantiPersonas(Integer.parseInt(cantidad));
        e.setFechaVisita(fecha);
        e.setTotal(Double.parseDouble(total));
        e.setMayores(Integer.parseInt(mayores));
        e.setMayores(Integer.parseInt(menores));
        e.setMayores(Integer.parseInt(bebes));
        e.setCantiAtracciones(atracciones);
        e.setFechaVenta(fechaVenta);
        int r = dao.agregarEntradas(e);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaEntradas, "ESTUDIANTE AGREGADO CORRECTAMENTE");
            filtrarTablaPorNombre(vistaEntradas.tblEntradas, "");
        } else {
            JOptionPane.showMessageDialog(vistaEntradas, "ESTUDIANTE NO AGREGADO CORRECTAMENTE");
        }
    }
    public void agregarEntradas1() {

        String cantidad = vistaEntradas.SpCantidad1.getValue().toString();
        String cantidad1 = vistaEntradas.SpCantidad.getValue().toString();
        String fecha = vistaEntradas.jdFecha1.getDate().toString();
        String mayores = vistaEntradas.SpMayores.getValue().toString();
        String menores = vistaEntradas.SpMenores.getValue().toString();
        String bebes = vistaEntradas.SpBebes.getValue().toString();
        String total = vistaEntradas.lblTotal2.getText();
        String fechaVenta = vistaEntradas.lblFechaVenta.getText();
        e.setCantiPersonas(Integer.parseInt(cantidad));
        e.setCantiAtracciones(cantidad1);
        e.setFechaVisita(fecha);
        e.setTotal(Double.parseDouble(total));
        e.setMayores(Integer.parseInt(mayores));
        e.setMayores(Integer.parseInt(menores));
        e.setMayores(Integer.parseInt(bebes));
        e.setFechaVenta(fechaVenta);

        int r = dao.agregarEntradas(e);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaEntradas, "ESTUDIANTE AGREGADO CORRECTAMENTE");
            filtrarTablaPorNombre(vistaEntradas.tblEntradas, "");
        } else {
            JOptionPane.showMessageDialog(vistaEntradas, "ESTUDIANTE NO AGREGADO CORRECTAMENTE");
        }
    }
    public void limpiarCampos() {
        vistaEntradas.lblVisita2.setText("");
        vistaEntradas.lblTotal2.setText("");
        vistaEntradas.jdFecha.setDate(null);
        vistaEntradas.jdFecha1.setDate(null);
        vistaEntradas.SpCantidad1.setValue(0);
        vistaEntradas.SpCantidad.setValue(0);
        vistaEntradas.SpMayores.setValue(0);
        vistaEntradas.SpBebes.setValue(0);
        vistaEntradas.SpMenores.setValue(0);
    }
    public String calcular() {

        double mayores = Double.parseDouble(vistaEntradas.SpMayores.getValue().toString());
        double menores = Double.parseDouble(vistaEntradas.SpMenores.getValue().toString());
        double entrada1 = (mayores * 8000);
        double entrada2 = (menores * 5000);
        double resultado = (entrada1 + entrada2);
        vistaEntradas.lblTotal2.setText(String.valueOf(resultado));
        return null;
    }
    public String calcular1() {

        double cantidad = Double.parseDouble(vistaEntradas.SpCantidad.getValue().toString());
        double cantidad1 = Double.parseDouble(vistaEntradas.SpCantidad1.getValue().toString());
        double total = cantidad*(cantidad1 * 3000);
        vistaEntradas.lblTotal2.setText(String.valueOf(total));
        return null;
    }
    public String suma() {
        int mayores = Integer.parseInt(vistaEntradas.SpMayores.getValue().toString());
        int menores = Integer.parseInt(vistaEntradas.SpMenores.getValue().toString());
        int bebes = Integer.parseInt(vistaEntradas.SpBebes.getValue().toString());
        int cantidad = (bebes  + menores + mayores);
        vistaEntradas.lblVisita2.setText(String.valueOf(cantidad));
        return null;
    }
    public String suma1() {
        int suma = Integer.parseInt(vistaEntradas.SpCantidad.getValue().toString());
        int cantidad = (suma);
        vistaEntradas.lblVisita2.setText(String.valueOf(cantidad));
        return null;
    }
    
    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }
    public void inicio() {
        filtrarTablaPorNombre(vistaEntradas.tblEntradas, "");
        limpiarCampos();
    }
        public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYY");
        return formatoFecha.format(fecha);
    }
}
