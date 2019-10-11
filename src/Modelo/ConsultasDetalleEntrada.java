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
public class ConsultasDetalleEntrada extends Pool {
    public boolean registrar(DetalleEntrada detalle){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO detalleEntrada(idEntrada, idProducto,nActiculo, "
                + "precioCompra,subTotal) "
                + "values(?,?,?,?,?)";
        
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setInt(1, detalle.getIdCompra());
             ps.setInt(2, detalle.getIdProducto());
             ps.setInt(3, detalle.getnActiculo());
             ps.setDouble(4, detalle.getPrecioCompra());
             ps.setDouble(5, detalle.getSubtotal());
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
