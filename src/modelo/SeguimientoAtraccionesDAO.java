/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author ashle
 */
public class SeguimientoAtraccionesDAO {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();

    public int agregarSeguimiento(SeguimientoAtracciones user) {

        int r = 0;
        String sql = "INSERT INTO atracciones (nombre, fechaInstalacion, capacidad, seccion, rangoEdad, precio) VALUES (?,?,?,?,?,?)";

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getAtraccion());
            ps.setString(2, user.getEnteRevisor());
            ps.setString(3, user.getFechaRevision());
            ps.setBoolean(4, user.getError());
            ps.setString(5, user.getDescripcionE());
            ps.setString(6, user.getComentario());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        String[] titulos = {"ATRACCION", "ENTE REVISOR", "FECHA REVISION", "ERROR", "DESCRIPCION ERROR", "COMENTARIO"};
        String[] registros = new String[6];
        String sql = "SELECT * FROM seguimiento WHERE seccion LIKE '%" + filtro + "%'";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("atraccion");
                registros[1] = rs.getString("enteRevisor");
                registros[2] = rs.getString("fechaRevision");
                registros[3] = rs.getString("error");
                registros[4] = rs.getString("descripcionError");
                registros[5] = rs.getString("comentario");
                modelo.addRow(registros);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos " + e.getMessage());
        }
    }
}
 