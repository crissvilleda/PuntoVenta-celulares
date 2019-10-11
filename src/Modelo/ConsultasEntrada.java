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

/**
 *
 * @author criss
 */
public class ConsultasEntrada extends Pool {
    public boolean siguenteIdEntrada(Entrada entrada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "SELECT auto_increment FROM information_schema.TABLES WHERE "
                + "TABLE_NAME ='entrada' and TABLE_SCHEMA='ventaCelulares'";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                entrada.setIdEntrada(rs.getInt("auto_increment"));
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    public boolean registrar(Entrada entrada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO entrada(idUsuario, idProveedor,"
                + "fechaCompra, total) values(?,?,?,?)";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, entrada.getIdUsuario());
            ps.setInt(2, entrada.getIdProveedor());
            ps.setTimestamp(3,entrada.getFechaCompra());
            ps.setDouble(4, entrada.getTotal());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
        
    }
    
}
