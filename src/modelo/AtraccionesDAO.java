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
 * @author lgfon
 */
public class AtraccionesDAO {

    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();

    public int agregarAtracciones(Atracciones user) {

        int r = 0;
        String sql = "INSERT INTO atracciones (nombre, fechaInstalacion, capacidad, seccion, rangoEdad, precio) VALUES (?,?,?,?,?,?)";

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreAtraccion());
            ps.setString(2, user.getFechaInstalacion());
            ps.setInt(3, user.getCapacidad());
            ps.setString(4, user.getSeccion());
            ps.setString(5, user.getRangoEdad());
            ps.setInt(6, user.getPrecio());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public Atracciones buscarAtracciones(int Seccion) {
        String sql = "SELECT * FROM atracciones WHERE seccion = " + Seccion;
        Atracciones Resultado = new Atracciones();
        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Resultado.setIdAtraccion(rs.getInt("IdAtracciones"));
                Resultado.setNombreAtraccion(rs.getString("nombre"));
                Resultado.setFechaInstalacion(rs.getString("fechaInstalacion"));
                Resultado.setCapacidad(rs.getInt("capacidad"));
                Resultado.setSeccion(rs.getString("seccion"));
                Resultado.setRangoEdad(rs.getString("rangoEdad"));
                Resultado.setPrecio(rs.getInt("precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos " + e.getMessage());
            Resultado.setIdAtraccion(-1);
        }
        return Resultado;
    }


    public int eliminarAtracciones(int id) {

        int r = 0;
        String sql = "DELETE FROM atracciones WHERE IdAtracciones=" + id;
        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        String[] titulos = {"SECCION", "ID", "NOMBRE", "CAPACIDAD", "INSTALACION", "RANGO EDAD", "PRECIO"};
        String[] registros = new String[7];
        String sql = "SELECT * FROM atracciones WHERE seccion LIKE '%" + filtro + "%'";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("seccion");
                registros[1] = rs.getString("IdAtracciones");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("capacidad");
                registros[4] = rs.getString("fechaInstalacion");
                registros[5] = rs.getString("rangoEdad");
                registros[6] = rs.getString("precio");
                modelo.addRow(registros);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos " + e.getMessage());
        }
    }
}
