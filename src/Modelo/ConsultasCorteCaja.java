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
import javax.swing.JTextField;

/**
 *
 * @author criss
 */
public class ConsultasCorteCaja extends Pool {
    public boolean getTotalVenta(String fechaI,String fechaF,JTextField total){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql="SELECT sum(venta.totalVenta) as total FROM venta WHERE "
                + "(DATE_FORMAT(venta.fecha, '%Y-%m-%d')>= ? "
                + "AND DATE_FORMAT(venta.fecha, '%Y-%m-%d')<=?)";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, fechaI);
            ps.setString(2, fechaF);
            rs= ps.executeQuery();
            
            while(rs.next()){
                total.setText(String.format("%.2f",rs.getDouble("total")));
                return true;
            
            }
            return false;
            
        }catch(SQLException e){
            return false;
        }
            

       
    }
    
}
