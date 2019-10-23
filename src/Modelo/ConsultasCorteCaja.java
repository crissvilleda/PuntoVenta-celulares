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
public class ConsultasCorteCaja extends Pool {
    public Double getTotalVenta(){
        Double total = null;
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        try{
            
        
            while(rs.next()){}
            
        }catch(SQLException e){
                
        }
            

        
        return total;
    }
    
}
