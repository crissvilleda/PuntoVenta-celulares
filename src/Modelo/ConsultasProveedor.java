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
public class ConsultasProveedor extends Pool {
    public boolean registrar(Proveedor pro){
        
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO proveedor(nombre, email,telefono,"
                + "pais, ciudad, direccion, representante) "
                + "values(?,?,?,?,?,?,?)";
        
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setString(1, pro.getNombre());
             ps.setString(2, pro.getEmail());
             ps.setString(3, pro.getTelefono());
             ps.setString(4, pro.getPais());
             ps.setString(5, pro.getCiudad());
             ps.setString(6, pro.getDireccion());
             ps.setString(7, pro.getRepresentante());
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
    
    
    public boolean modificar(Proveedor pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "UPDATE proveedor SET nombre=?, email=?,telefono=?"
                + "pais=?, ciudad=?, direccion=?, representate=?"
                + "WHERE idProveedor=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getEmail());
            ps.setString(3, pro.getTelefono());
            ps.setString(4, pro.getPais());
            ps.setString(5, pro.getCiudad());
            ps.setString(6, pro.getDireccion());
            ps.setString(7, pro.getRepresentante());
            ps.setInt(8, pro.getIdProveedor());
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
    public boolean eliminar(Proveedor pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "DELETE FROM proveedor WHERE idProveedor=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, pro.getIdProveedor());
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
    
    
    
    public boolean consultar(Proveedor pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM proveedor WHERE idProveedor=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, pro.getIdProveedor());
            rs =ps.executeQuery();
            if(rs.next()){
                pro.setIdProveedor(rs.getInt("idProveedor"));
                pro.setNombre(rs.getString("nombre"));
                pro.setEmail(rs.getString("email"));
                pro.setTelefono(rs.getString("telefono"));
                pro.setPais(rs.getString("pais"));
                pro.setCiudad(rs.getString("ciudad"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setRepresentante(rs.getString("representante"));
             
            } 
            return true;
            
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
