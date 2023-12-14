/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.SeguimientoAtracciones;
import modelo.SeguimientoAtraccionesDAO;
import vista.frmManteSeguimiento;

/**
 *
 * @author ashle
 */
public class ControllerSeguimientoAtracciones implements ActionListener{
    
    frmManteSeguimiento vistaManteSeguimiento = new frmManteSeguimiento();SeguimientoAtracciones a = new SeguimientoAtracciones();
    SeguimientoAtraccionesDAO dao = new SeguimientoAtraccionesDAO();

    public ControllerSeguimientoAtracciones (frmManteSeguimiento frm) { //Paso 3
        
        this.vistaManteSeguimiento= frm;
        this.vistaManteSeguimiento.btnGuardar.addActionListener(this);
        this.vistaManteSeguimiento.btnVolver.addActionListener(this);
    }

    private void agregarAtracciones() {
        String atraccion = vistaManteSeguimiento.cbAtracciones.getSelectedItem().toString();
        String enteRevisor = vistaManteSeguimiento.cbEnte.getSelectedItem().toString();
        String fechaRevision = vistaManteSeguimiento.jdFecha.getDate().toString();
        Boolean error =vistaManteSeguimiento.ccError.isSelected();
        String descripcionE = vistaManteSeguimiento.txtError.getText();
        String comentario = vistaManteSeguimiento.txtComentario.getText();

        a.setAtraccion(atraccion);
        a.setEnteRevisor(enteRevisor);
        a.setFechaRevision(fechaRevision);
        a.setError(error);
        a.setDescripcionE(descripcionE);
        a.setFechaRevision(fechaRevision);

        int r = dao.agregarSeguimiento(a);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaManteSeguimiento, "SEGUIMIENTO DE ATRACCION AGREGADO CORRECTAMENTE");
            filtrarTablaPorNombre(vistaManteSeguimiento.tblAtracciones, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaManteSeguimiento, "SEGUIMIENTO DE ATRACCION NO  AGREGADO CORRECTAMENTE");

        }
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }

    public void limpiarCampos() {

        vistaManteSeguimiento.cbAtracciones.setSelectedIndex(0);
        vistaManteSeguimiento.cbEnte.setSelectedIndex(0);
        vistaManteSeguimiento.jdFecha.setDate(null);
        vistaManteSeguimiento.ccError.setText("");
        vistaManteSeguimiento.txtError.setText("");
        vistaManteSeguimiento.txtComentario.setText("");
       
    }

    public void inicio() {
        filtrarTablaPorNombre(vistaManteSeguimiento.tblAtracciones, "");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
