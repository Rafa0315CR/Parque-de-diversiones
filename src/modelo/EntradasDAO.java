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
public class EntradasDAO {
    
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
      public int agregarEntradas(Entradas user) {

        int r = 0;
        String sql = "INSERT INTO entradas (mayores, menores, bebes, cantiPersonas,cantiAtracciones, fechaVisita, total, fechaVenta) VALUES (?,?,?,?,?,?,?,?);";

        try {
            con = conectar.getConecction();// 1: Abrir conexion con la BD
            ps = con.prepareStatement(sql);// 2: Prepara el query de sql
            ps.setInt(1, user.getMayores());//3: Completar el query
            ps.setInt(2, user.getMenores());
            ps.setInt(3, user.getBebes());
            ps.setInt(4, user.getCantiPersonas());
            ps.setString(5, user.getCantiAtracciones());
            ps.setString(6, user.getFechaVisita());
            ps.setDouble(7, user.getTotal());
            ps.setString(8, user.getFechaVenta());

            r = ps.executeUpdate();//4. Ejecutar query 0=Fallo 1= success modificacion en la base de datos
        } catch (Exception e) {
        }
        return r;
    } 
      
       public void filtrarTablaPorNombre(JTable table, String filtro) {
        String[] titulos = {"ID", "PERSONAS","ATRACCIONES","FECHA VISITA", "TOTAL", "VENTA"};
        String[] registros = new String[9];
        String sql = "SELECT * FROM entradas WHERE Id LIKE '%" + filtro + "%'"; //"Her"
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            con = conectar.getConecction();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("cantiPersonas");
                registros[2] = rs.getString("cantiAtracciones");
                registros[3] = rs.getString("fechaVisita");
                registros[4] = rs.getString("total");
                registros[5] = rs.getString("fechaVenta");
                modelo.addRow(registros);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos " + e.getMessage());
        }
    }
}
