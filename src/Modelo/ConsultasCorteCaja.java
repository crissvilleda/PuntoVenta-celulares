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
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author criss
 */
public class ConsultasCorteCaja extends Pool {
    
    public boolean registrar(CorteCaja caja,String usuario,String fechaI,String fechaF) throws SQLException{
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sqlCorte = "INSERT INTO corteCaja(fecha,saldoInicial,totalCaja,totalVentaCorte,"
                + "sobrante) VALUES (?,?,?,?,?)";
        String sqlIdVenta = "SELECT venta.idVenta FROM venta INNER JOIN usuario "
                + "ON usuario.idUsuario=venta.idUsuario WHERE usuario.nombreUsuario=? "
                + "AND (DATE_FORMAT(venta.fecha, '%Y-%m-%d')>= ? AND "
                + "DATE_FORMAT(venta.fecha, '%Y-%m-%d')<=?)";
        String sqlDetVenta ="INSERT INTO detalleCorte(idCorte,idVenta) VALUES (?,?)";
        try{
            cn.setAutoCommit(false);
            ps = (PreparedStatement)cn.prepareStatement(sqlCorte,Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1,caja.getFechaCorte());
            ps.setDouble(2, caja.getSaldoInicial());
            ps.setDouble(3, caja.getTotalCorte());
            ps.setDouble(4, caja.getTotalVenta());
            ps.setDouble(5,caja.getSobrante());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            int corteId=0;
            if(rs.next()){
                corteId = rs.getInt(1); 
            }
            ps = null;
            rs =null;
            ps = (PreparedStatement)cn.prepareStatement(sqlIdVenta);
            ps.setString(1,usuario);
            ps.setString(2,fechaI);
            ps.setString(3, fechaF);
            rs = ps.executeQuery();
            ps = null;
            while(rs.next()){
                ps = (PreparedStatement)cn.prepareStatement(sqlDetVenta);
                ps.setInt(1, corteId);
                ps.setInt(2, rs.getInt("venta.idVenta"));
                ps.executeUpdate();
                
            }
            
            cn.commit();
            cn.setAutoCommit(true);
           return true;
        }catch(SQLException e){
            cn.rollback();
            return false;
            
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch (SQLException e){
                    System.err.print(e);
                }
            }
        }
    }
    
    
    
    public boolean getTotalVenta(String usuario,String fechaI,String fechaF,JTextField total){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql="SELECT sum(venta.totalVenta) as total FROM venta INNER JOIN "
                + "usuario ON usuario.idUsuario=venta.idUsuario WHERE "
                + "usuario.nombreUsuario=? AND (DATE_FORMAT(venta.fecha, '%Y-%m-%d')"
                + ">= ? AND DATE_FORMAT(venta.fecha, '%Y-%m-%d')<=?)";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, fechaI);
            ps.setString(3, fechaF);
            rs= ps.executeQuery();
            
            while(rs.next()){
                if(!(rs.getString("total") == null)){
                    total.setText(String.format("%.2f",rs.getDouble("total")));
                    return true;
                    
                }else{
                    return false;
                }
            
            }
            return false;
            
        }catch(SQLException e){
            return false;
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch (SQLException e){
                    System.err.print(e);
                }
            }
        }
            

       
    }
    
}
