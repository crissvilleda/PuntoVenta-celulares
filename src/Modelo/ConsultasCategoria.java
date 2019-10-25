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
public class ConsultasCategoria  extends Pool{
    
    public boolean registrar(Categoria cat){
        
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO categoria(nombre,estado)"
                + "values(?,1)";
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setString(1, cat.getNombre());
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
    public boolean modificar(Categoria cat){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        String sql = "UPDATE categoria SET nombre=?"
                + " WHERE idCategoria=? AND estado=1";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, cat.getNombre());
            ps.setInt(2, cat.getIdCategoria());
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
    
    public boolean eliminar(Categoria cat){
        PreparedStatement ps=null;
        Connection cn=(Connection)getConnection();
        String sql="UPDATE categoria SET estado=0 WHERE idCategoria=?";
        try{
            ps=(PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1,cat.getIdCategoria());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }finally{
            if (cn!=null){
                try{
                    cn.close();
                }
                catch(SQLException e){
                    System.err.print(e);
                }
            }
        }
    }
        
    public boolean getIdCategoria(Categoria cat){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql = "SELECT idCategoria FROM categoria WHERE nombre=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, cat.getNombre());
            rs = ps.executeQuery();
            while(rs.next()){
                cat.setIdCategoria(rs.getInt("idCategoria"));
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
   
    public void limpiarTabla(JTable tabla){
        DefaultTableModel model=(DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a=model.getRowCount()-1;
        for (int i=a; i>=0;i--){
            model.removeRow(model.getRowCount()-1);
        }
        PreparedStatement ps=null;
        String registros[]= new String[2];
        Connection cn=(Connection)getConnection();
        ResultSet rs=null;
        String sql=("SELECT *FROM categoria WHERE estado=1");
        try{
            ps=(PreparedStatement)cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                registros[0]=rs.getString("idCategoria");
                registros[1]=rs.getString("nombre");
                model.addRow(registros);
            }
           tabla.setModel(model);
        }
        catch(SQLException e){
            System.err.print(e);
        }
        finally{
            if (cn!=null){
                try{
                    cn.close();
                }
                catch(SQLException e){
                    System.err.print(e);
                }
            }
        }
        
    }
        
        
        
    
    public void listaCategorias(JComboBox cb){
        DefaultComboBoxModel model = (DefaultComboBoxModel)cb.getModel();
        String registro;
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM categoria";
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
