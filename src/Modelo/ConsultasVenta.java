/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author criss
 */
public class ConsultasVenta extends Pool{
    public boolean registar(Venta venta){
        PreparedStatement ps = null;
        Connection cn =(Connection)getConnection();
        String sql ="INSERT INTO venta(idUsuario,idCliente,fecha,nArticulo,"
                + "totalCompra,totalVenta) VALUES(?,?,?,?,?,?) ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, venta.getIdUsuario());
            ps.setInt(2, venta.getIdCliente());
            ps.setTimestamp(3, venta.getFecha());
            ps.setInt(4, venta.getnArticulo());
            ps.setDouble(5, venta.getTotaCompra());
            ps.setDouble(6, venta.getTotalVenta());
            ps.execute();
            return true;
            
            
        }catch(SQLException e){
            return false;
        }
        
    }
    
    public boolean siguenteIdVenta(JLabel label){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "SELECT auto_increment FROM information_schema.TABLES WHERE "
                + "TABLE_NAME ='venta' and TABLE_SCHEMA='ventaCelulares'";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                label.setText(rs.getString("auto_increment"));
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    
}
