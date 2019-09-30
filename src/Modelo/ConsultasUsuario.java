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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ConsultasUsuario extends Pool{
    
    public boolean registrar(Usuario usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO usuario(nombre,apellido,email,telefono,tipo,"
                + "genero,nombreUsuario,contraseña) values(?,?,?,?,?,?,?,?)";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setString(3, usu.getEmail());
            ps.setString(4, usu.getTelefono());
            ps.setString(5,usu.getTipo());
            ps.setString(6,String.valueOf(usu.getGenero()));
            ps.setString(7, usu.getNombreUsuario());
            ps.setString(8, usu.getContraseña());
            ps.execute();
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
    
    public boolean modificar(Usuario usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "UPDATE usuario SET nombre=?,apellido=?,email=?,telefono=?,"
                + "tipo=?,genero=?,nombreUsuario=?,contraseña=? WHERE idUsuario=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,usu.getNombre());
            ps.setString(2, usu.getApellido());
            ps.setString(3, usu.getEmail());
            ps.setString(4, usu.getTelefono());
            ps.setString(5,usu.getTipo());
            ps.setString(6,String.valueOf(usu.getGenero()));
            ps.setString(7, usu.getNombreUsuario());
            ps.setString(8, usu.getContraseña());
            ps.setInt(9, usu.getIdUsuario());
            ps.execute();
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
    
    public boolean eliminar(Usuario usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "DELETE FROM usuario WHERE idUsuario=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1,usu.getIdUsuario());
            ps.execute();
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
    
    public boolean consultar(Usuario usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario WHERE idUsuario=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, usu.getIdUsuario());
            rs =ps.executeQuery();
            if(rs.next()){
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setEmail(rs.getString("email"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setTipo(rs.getString("tipo"));
                usu.setGenero(rs.getString("genero").charAt(0));
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setContraseña(rs.getString("contreaseña"));
             
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
    
    
    public boolean iniciarSesion(Usuario usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario WHERE nombreUsuario=? AND contraseña=? "
                + "AND estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,usu.getNombreUsuario());
            ps.setString(2, usu.getContraseña());
            rs =ps.executeQuery();
            while(rs.next()){
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setEmail(rs.getString("email"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setTipo(rs.getString("tipo"));
                usu.setGenero(rs.getString("genero").charAt(0));
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setContraseña(rs.getString("contraseña"));
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
    
    public void listaUsuarios(JTable tabla){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        String registros [] = new String [8];
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario WHERE estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idUsuario");
                registros [1]=rs.getString("nombre");
                registros [2]=rs.getString("apellido");
                registros [3]=rs.getString("email");
                registros [4]=rs.getString("telefono");
                registros [5]=rs.getString("tipo");
                registros [6]=rs.getString("genero");
                registros [7]=rs.getString("nombreUsuario");
                model.addRow(registros);
            } 
            tabla.setModel(model);
        }catch (SQLException e){
            System.err.print(e);
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
