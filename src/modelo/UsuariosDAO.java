/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 50688
 */
public class UsuariosDAO {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();

    public int agregarUsuario(Usuarios user) {

        int r = 0;
        String sql = "INSERT INTO usuarios (contrasena, correo, nombre, apellido1, apellido2, tipoUsuario) VALUES (?,?,?,?,?,?)";
        try {
            con = conectar.getConecction(); 
            ps = con.prepareStatement(sql); 
            ps.setString(1, user.getContrasena());
            ps.setString(2, user.getCorreo());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellido1());
            ps.setString(5, user.getApellido2());
            ps.setString(6, user.getTipoUsuario());                     
            r = ps.executeUpdate(); //4: Ejecutar query 0= Fallo 1= success
        } catch (SQLException e) {
        }
        return r;
    }

    public int actualizarUsuario(Usuarios user) {

        int r = 0;
        String sql = "UPDATE usuarios SET contrasena=?, correo=?, nombre=?, apellido1=?, apellido2=?, tipoUsuario=? WHERE IdUsuario=?"; //value1..value2
        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getContrasena());
            ps.setString(2, user.getCorreo());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellido1());
            ps.setString(5, user.getApellido2());
            ps.setString(6, user.getTipoUsuario());
            ps.setInt(7, user.getCedula());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int eliminarUsuario(int id) {

        int r = 0;
        String sql = "DELETE FROM usuarios WHERE IdUsuario=" + id;
        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        String[] titulos = {"CEDULA", "CONTRASEÑA", "CORREO", "NOMBRE", "APELLIDO1", "APELLIDO2", "TIPOUSUARIO"};
        String[] registros = new String[7];
        String sql = "SELECT * FROM usuarios WHERE nombre LIKE '%" + filtro + "%'"; 
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("IdUsuario");
                registros[1] = rs.getString("contrasena");
                registros[2] = rs.getString("correo");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("apellido1");
                registros[5] = rs.getString("apellido2");
                registros[6] = rs.getString("tipoUsuario");
                modelo.addRow(registros);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos " + e.getMessage());
        }
    }
        public boolean frmLogin(Usuarios user){

        String sql = "SELECT IdUsuario, nombre ,contrasena, tipoUsuario FROM usuarios WHERE nombre=?";
        
        try{
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            rs = ps.executeQuery();
            if(rs.next()){
                if(user.getContrasena().equals(rs.getString("contrasena"))&& user.getTipoUsuario().equals(rs.getString("tipoUsuario")) ){
                    user.setCedula(rs.getInt("IdUsuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setTipoUsuario(rs.getString("tipoUsuario"));
                    return true;
                } else{
                    return false;
                }
            }
        }
        catch(Exception e){
            return false;
        }
        return false;
    }
    


}
