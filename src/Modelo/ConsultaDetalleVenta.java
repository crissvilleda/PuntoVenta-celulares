/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author criss
 */
public class ConsultaDetalleVenta extends Pool{
    public boolean registar(DetalleVenta detVenta){
        PreparedStatement ps = null;
        Connection cn =(Connection)getConnection();
        String sql ="INSERT INTO detalleVenta(idVenta,idProducto,precioCompra,precioVenta,"
                + "nArticulo,subtotalCompra,subtotalVenta) VALUES(?,?,?,?,?,?,?) ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, detVenta.getIdVenta());
            ps.setInt(2, detVenta.getIdProducto());
            ps.setDouble(3, detVenta.getPrecioCompra());
            ps.setDouble(4, detVenta.getPrecioVenta());
            ps.setInt(5, detVenta.getnArticulo());
            ps.setDouble(6, detVenta.getSubtotalCompra());
            ps.setDouble(7, detVenta.getSubtotalVenta());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            return false;
        }
        
    }
    
}
