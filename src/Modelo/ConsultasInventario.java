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
public class ConsultasInventario extends Pool{
    
    public boolean registrar(Inventario inventario){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO inventario(idProducto,fechaLote,nArticulos, "
                + "precioCompra, precioVenta) "
                + "values(?,?,?,?,?)";
        
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setInt(1, inventario.getIdProducto());
             ps.setTimestamp(2, inventario.getFechaLote());
             ps.setInt(3, inventario.getnArticulo());
             ps.setDouble(4, inventario.getPrecioCompra());
             ps.setDouble(5, inventario.getPrecioVenta());
             ps.execute();
             return true;
             
        }catch(SQLException e){
            System.err.print(e);
            return false;
            
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch(SQLException e){
                    System.err.print(e);
                }
            }
        }
        
        
    }
    
}
