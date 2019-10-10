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
        String sql = "UPDATE proveedor SET nombre=?, email=?,telefono=?,"
                + "pais=?, ciudad=?, direccion=?, representante=?"
                + " WHERE idProveedor=?";
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
        String sql = "UPDATE proveedor SET estado=0 WHERE idProveedor=?";
        
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1,pro.getIdProveedor());
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
        String sql ="SELECT * FROM proveedor WHERE nombre LIKE ?  AND estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idProveedor");
                registros [1]=rs.getString("nombre");
                registros [2]=rs.getString("direccion");
                registros [3]=rs.getString("email");
                registros [4]=rs.getString("telefono");
                registros [5]=rs.getString("ciudad");
                registros [6]=rs.getString("pais");
                registros [7]=rs.getString("representante");
                model.addRow(registros);
             
            }tabla.setModel(model);
            
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
    
    public void tablaProveedores(JTable tabla){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        PreparedStatement ps = null;
        String registros [] = new String [8];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM proveedor WHERE estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idProveedor");
                registros [1]=rs.getString("nombre");
                registros [2]=rs.getString("direccion");
                registros [3]=rs.getString("email");
                registros [4]=rs.getString("telefono");
                registros [5]=rs.getString("ciudad");
                registros [6]=rs.getString("pais");
                registros [7]=rs.getString("representante");
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
    
    
    public void listaProveedores(JComboBox cb){
        DefaultComboBoxModel model = (DefaultComboBoxModel)cb.getModel();
        String registro;
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM proveedor";
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
