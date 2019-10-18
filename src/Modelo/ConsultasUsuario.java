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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
        String sql = "UPDATE usuario SET estado=0 WHERE idUsuario=?";
        
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
    
    public void consultar(JTable tabla,String texto){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a = model.getRowCount()-1;
        for(int i=a;i>=0;i--){
            model.removeRow(model.getRowCount()-1);
            
        }
        PreparedStatement ps = null;
        String registros [] = new String [8];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario WHERE (nombre LIKE ? OR apellido LIKE ?) AND estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
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
        String registros [] = new String [9];
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
                registros [8]=rs.getString("contraseña");
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
    public boolean verificarNombreUsuario(String usu){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario WHERE nombreUsuario=? AND estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,usu);
            rs =ps.executeQuery();
            while(rs.next()){
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
    
    public void listUsu(JComboBox cb){
        DefaultComboBoxModel model = (DefaultComboBoxModel)cb.getModel();
        String registro;
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM usuario";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registro =rs.getString("nombre");
                model.addElement(registro);
            }
            cb.setModel(model);
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
