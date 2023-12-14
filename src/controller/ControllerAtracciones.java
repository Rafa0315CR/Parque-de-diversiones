/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Atracciones;
import modelo.AtraccionesDAO;
import vista.frmManteAtracciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmManteListado;

/**
 *
 * @author ashle
 */
public class ControllerAtracciones implements ActionListener{
    
    frmManteAtracciones vistaAtracciones = new frmManteAtracciones();
    frmManteListado vistaListado = new frmManteListado();
    Atracciones a = new Atracciones();
    AtraccionesDAO dao = new AtraccionesDAO();

    public ControllerAtracciones (frmManteAtracciones frm) { //Paso 3
        
        this.vistaAtracciones= frm;
        this.vistaAtracciones.btnGuardar.addActionListener(this);
        this.vistaAtracciones.btnVolver.addActionListener(this);
    }

    public ControllerAtracciones (frmManteListado frm) {
        
        this.vistaListado= frm;
        this.vistaListado.btnVolver1.addActionListener(this);
        this.vistaListado.btnBuscar1.addActionListener(this);
        this.vistaListado.btnRefrescar1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaAtracciones.btnGuardar) {

            if (vistaAtracciones.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar un nombre");
            } else if (vistaAtracciones.txtCapacidad.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la capacidad");
            } else if (vistaAtracciones.txtEdad.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el rango de edad");
            } else if (vistaAtracciones.txtPrecio.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el precio");
            } else {
                agregarAtracciones();
                limpiarCampos();
            }
        }
        if (e.getSource() == vistaListado.btnBuscar1) {
            filtrarTablaPorNombre(vistaListado.tblAtracciones1, vistaListado.txtBuscar1.getText());
        }
        if (e.getSource() == vistaListado.btnRefrescar1) {
            filtrarTablaPorNombre(vistaListado.tblAtracciones1, "");
        }
    }

    private void agregarAtracciones() {
        
        String nombre = vistaAtracciones.txtNombre.getText();
        String capacidad = vistaAtracciones.txtCapacidad.getText();
        String rango = vistaAtracciones.txtEdad.getText();
        String precio = vistaAtracciones.txtPrecio.getText();
        String seccion = vistaAtracciones.cbSeccion.getSelectedItem().toString ();
        String fecha = vistaAtracciones.dcFecha.getDate().toString();

        a.setNombreAtraccion(nombre);
        a.setCapacidad(Integer.parseInt(capacidad));
        a.setRangoEdad(rango);
        a.setPrecio(Integer.parseInt(precio));
        a.setSeccion(seccion);
        a.setFechaInstalacion(fecha);

        int r = dao.agregarAtracciones(a);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaListado, "USUARIO AGREGADO CORRECTAMENTE");
            filtrarTablaPorNombre(vistaListado.tblAtracciones1, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaListado, "USUARIO NO AGREGADO CORRECTAMENTE");

        }
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }

    public void limpiarCampos() {

        vistaAtracciones.txtIdentificador.setText("");
        vistaAtracciones.txtCapacidad.setText("");
        vistaAtracciones.txtNombre.setText("");
        vistaAtracciones.txtEdad.setText("");
        vistaAtracciones.txtPrecio.setText("");
        vistaAtracciones.cbSeccion.setSelectedIndex(0);
        vistaAtracciones.dcFecha.setDate(null);
    }

    public void inicio() {
        filtrarTablaPorNombre(vistaListado.tblAtracciones1, "");
    }
}