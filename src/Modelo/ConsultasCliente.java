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

/**
 *
 * @author criss
 */
public class ConsultasCliente extends Pool {
    
    public boolean registrar(Cliente cli){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO cliente(nombre,apellido,email,telefono,nit,"
                + "dpi,ciudad,direccion) values(?,?,?,?,?,?,?,?)";
        
        try{
            ps = (PreparedStatement) cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getEmail());
            ps.setString(4, cli.getTelefono());
            ps.setString(5, cli.getNit());
            ps.setString(6, cli.getDpi());
            ps.setString(7, cli.getCiudad());
            ps.setString(8, cli.getDireccion());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                cli.setIdCliente(rs.getInt(1));
                
            }
             
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
    
    
    public boolean modificar(Cliente cli){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "UPDATE cliente SET nombre=?, apellido=?,email=?"
                + "telefono=?, nit=?, dpi=?, ciudad=?, direccion=?"
                + "WHERE idCliente=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getEmail());
            ps.setString(4, cli.getTelefono());
            ps.setString(5, cli.getNit());
            ps.setString(6, cli.getDpi());
            ps.setString(7, cli.getCiudad());
            ps.setString(8, cli.getDireccion());
            ps.setInt(9, cli.getIdCliente());
            ps.execute();
            return true;            
            
        }catch(SQLException e){
            System.err.print(e);
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
    public boolean eliminar(Cliente cli){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "DELETE FROM cliente WHERE idCliente=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
            ps.execute();
            return true;            
            
        }catch(SQLException e){
            System.err.print(e);
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
    
    
    
    public boolean consultar(Cliente cli){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM cliente WHERE nit=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, cli.getNit());
            rs =ps.executeQuery();
            if(rs.next()){
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setNit(rs.getString("nit"));
                cli.setDpi(rs.getString("dpi"));
                cli.setCiudad(rs.getString("ciudad"));
                cli.setDireccion(rs.getString("direccion"));
                return true;
             
            } 
            return false;
            
        }catch (SQLException e){
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
