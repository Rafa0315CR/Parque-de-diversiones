/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Usuarios;
import modelo.UsuariosDAO;
import vista.frmManteUsuarios;

/**
 *
 * @author 50688
 */
public class ControllerUsuarios implements ActionListener{
    frmManteUsuarios vistaUsuarios = new frmManteUsuarios();
    Usuarios v = new Usuarios();
    UsuariosDAO dao = new UsuariosDAO();

    public ControllerUsuarios(frmManteUsuarios frm) { 
        this.vistaUsuarios= frm;
        this.vistaUsuarios.btnGuardar.addActionListener(this);
        this.vistaUsuarios.btnEditar.addActionListener(this);
        this.vistaUsuarios.btnEliminar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaUsuarios.btnGuardar) {

            if (vistaUsuarios.txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe ingresar una contraseña");
            } else if (vistaUsuarios.txtCorreo.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe ingresar un correo");
            } else if (vistaUsuarios.txtNombre.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe ingresar un nombre");
            } else if (vistaUsuarios.txtApellido1.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe ingresar el primer apellido");
            } else if (vistaUsuarios.txtApellido2.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe ingresar el segundo apellido");
              
            } else {
                agregarUsuario();
            }       
        }
        if (e.getSource() == vistaUsuarios.btnEditar) {

            if (vistaUsuarios.txtCedula.getText().equals("")) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe de seleccionar un registro en la tabla");
            } else if (vistaUsuarios.txtContrasena.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe seleccionar la contraseña");
            } else if (vistaUsuarios.txtCorreo.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe seleccionar un correo");
            } else if (vistaUsuarios.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe de seleccionar un nombre ");
            } else if (vistaUsuarios.txtApellido1.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe seleccionar el primer apellido");
            } else if (vistaUsuarios.txtApellido2.toString().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuarios, "Debe seleccionar el segundo apellido");
           
            } else {
                actualizarUsuarios();
            }
            
        }
        if (e.getSource() == vistaUsuarios.btnEliminar) {
            eliminarUsuarios();
        }
        
    }
    private void agregarUsuario() {
        String contrasena = vistaUsuarios.txtContrasena.getText();
        String correo = vistaUsuarios.txtCorreo.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String apellido1 = vistaUsuarios.txtApellido1.getText();
        String apellido2 = vistaUsuarios.txtApellido2.getText();
        String tipoUsuario = vistaUsuarios.cbTipo.getSelectedItem().toString ();
        
        v.setContrasena(contrasena);
        v.setCorreo(correo);
        v.setNombre(nombre);
        v.setApellido1(apellido1);
        v.setApellido2(apellido2);
        v.setTipoUsuario(tipoUsuario);
        

        int r = dao.agregarUsuario(v);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaUsuarios, "USUARIO AGREGADO CORRECTAMENTE");
            filtrarTablaPorNombre(vistaUsuarios.tblUsuarios, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaUsuarios, "USUARIO NO AGREGADO CORRECTAMENTE");

        }
    }

    public void actualizarUsuarios() {
        
        int id = Integer.parseInt(vistaUsuarios.txtCedula.getText());
        String contrasena = vistaUsuarios.txtContrasena.getText();
        String correo = vistaUsuarios.txtCorreo.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String apellido1 = vistaUsuarios.txtApellido1.getText();
        String apellido2 = vistaUsuarios.txtApellido2.getText();
        String tipoUsuario = vistaUsuarios.cbTipo.getSelectedItem().toString ();
     
        v.setCedula(id);
        v.setContrasena(contrasena);
        v.setCorreo(correo);
        v.setNombre(nombre);
        v.setApellido1(apellido1);
        v.setApellido2(apellido2);
        v.setTipoUsuario(tipoUsuario);
        

        int r = dao.actualizarUsuario(v);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaUsuarios, "USUARIO ACTUALIZADO CON EXITO");
            filtrarTablaPorNombre(vistaUsuarios.tblUsuarios, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaUsuarios, "USUARIO NO ACTUALIZADO");
        }
    }

    public void eliminarUsuarios() {
        int fila = vistaUsuarios.tblUsuarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Debe seleccionar un registro en la tabla");
        } else {
            int id = Integer.parseInt(vistaUsuarios.tblUsuarios.getValueAt(fila, 0).toString());
            int r = dao.eliminarUsuario(id);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaUsuarios, "El Usuario se eliminó con exito");
                filtrarTablaPorNombre(vistaUsuarios.tblUsuarios, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaUsuarios, "El Usuario NO se eliminó");
            }
        }
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }

    public void limpiarCampos() {

        vistaUsuarios.txtCedula.setText("");
        vistaUsuarios.txtContrasena.setText("");
        vistaUsuarios.txtCorreo.setText("");
        vistaUsuarios.txtNombre.setText("");
        vistaUsuarios.txtApellido1.setText("");
        vistaUsuarios.txtApellido2.setText("");
        vistaUsuarios.cbTipo.setSelectedIndex(0);
    }

    public void inicio() {
        filtrarTablaPorNombre(vistaUsuarios.tblUsuarios, "");
        limpiarCampos();
    }
        
}
