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
public class ConsultasProducto extends Pool {
    
    public boolean registrar(Producto pro){
        
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO producto(codigo, nombre, descripcion,"
                + "idCategoria, idMarca) values(?,?,?,?,?)";
        
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setString(1, pro.getCodigo());
             ps.setString(2, pro.getNombre());
             ps.setString(3, pro.getDescripcion());
             ps.setInt(4, pro.getIdCategoria());
             ps.setInt(5, pro.getIdMarca());
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
    
    
    public boolean modificar(Producto pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "UPDATE producto SET codigo=?, nombre=?, descripcion=?"
                + "idCategoria=?, idMarca=? WHERE idProducto=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getIdCategoria());
            ps.setInt(5, pro.getIdMarca());
            ps.setInt(6, pro.getIdProducto());
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
    public boolean eliminar(Producto pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "DELETE FROM producto WHERE idProducto=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, pro.getIdProducto());
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
    
    
    
    public boolean consultar(Producto pro){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM producto WHERE codigo=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs =ps.executeQuery();
            if(rs.next()){
                pro.setIdProducto(rs.getInt("idProducto"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setIdCategoria(rs.getInt("idCategoria"));
                pro.setIdMarca(rs.getInt("idMarca"));
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
    
    public void buscar(JTable tabla,String texto){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a = model.getRowCount()-1;
        for(int i=a;i>=0;i--){
            model.removeRow(model.getRowCount()-1);
            
        }
        PreparedStatement ps = null;
        String registros [] = new String [6];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM producto WHERE nombre LIKE ? or descripcion LIKE ?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idProducto");
                registros [1]=rs.getString("codigo");
                registros [2]=rs.getString("nombre");
                registros [3]=rs.getString("descripcion");
                registros [4]=rs.getString("idCategoria");
                registros [5]=rs.getString("idMarca");
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
    
    public void llenarTabla(JTable tabla){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a = model.getRowCount()-1;
        for(int i=a;i>=0;i--){
            model.removeRow(model.getRowCount()-1);
            
        }
        PreparedStatement ps = null;
        String registros [] = new String [6];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM producto WHERE idProducto>=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idProducto");
                registros [1]=rs.getString("codigo");
                registros [2]=rs.getString("nombre");
                registros [3]=rs.getString("descripcion");
                registros [4]=rs.getString("idCategoria");
                registros [5]=rs.getString("idMarca");
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
