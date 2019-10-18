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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ConsultasMarca extends Pool {
    
    public boolean registrar(Marca mar){
        PreparedStatement ps=null;
        Connection cn=(Connection)getConnection();
        String sql="INSERT INTO marca (nombre, estado) values (?,1)";
        try{
            ps=(PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, mar.getNombre());
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
    
    public boolean modificar(Marca mar){
        PreparedStatement ps=null;
        Connection cn=(Connection)getConnection();
        String sql="UPDATE marca SET nombre=? WHERE idMarca=? AND estado=1";
        try{
            ps=(PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, mar.getNombre());
            ps.setInt(2,mar.getIdMarca());
            ps.execute();
            return true;
        }catch(SQLException e){
                System.err.print(e);
                return false;
        }finally{    
            if (cn!=null){
                try{
                    cn.close();
                }catch(SQLException e){
                    System.err.print(e);
                }
            }
        }
        
    }
    
    public boolean eliminar(Marca mar){
        PreparedStatement ps=null;
        Connection cn=(Connection)getConnection();
        String sql="UPDATE marca SET estado=0 WHERE idMarca=?";
        try{
            ps=(PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1,mar.getIdMarca());
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
    
    public void tablaMarca(JTable tabla){
        DefaultTableModel model=(DefaultTableModel)tabla.getModel();
        //LimpiarTabla
        int a=model.getRowCount()-1;
        for(int i=a; i>=0;i--){
            model.removeRow(model.getRowCount()-1);
        }
        PreparedStatement ps=null;
        String registros[] =new String[2];
        Connection cn=(Connection)getConnection();
        ResultSet rs=null;
        String sql="SELECT *FROM marca WHERE estado=1";
        try{
            ps=(PreparedStatement)cn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
             registros[0]=rs.getString("idMarca");
             registros[1]=rs.getString("nombre");
             model.addRow(registros);
            }
            tabla.setModel(model);
        }catch(SQLException e){
            System.err.print(e);
        }finally{
            if (cn!=null){
                try{
                    cn.close();
                }catch(SQLException e){
                    System.err.print(e);
                }
            }
        }
    }
    
    
    
    
    
    
    public boolean getIdMarca(Marca marca){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql = "SELECT idMarca FROM marca WHERE nombre=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, marca.getNombre());
            rs = ps.executeQuery();
            while(rs.next()){
                marca.setIdMarca(rs.getInt("idMarca"));
                return true;
            }
            return false;
            
        }catch (SQLException e){
            System.err.print(e);
            return false;
        }
        
    }
    
    public void listaMarcas(JComboBox cb){
        DefaultComboBoxModel model = (DefaultComboBoxModel)cb.getModel();
        String registro;
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT * FROM marca";
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
