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

/**
 *
 * @author criss
 */
public class ConsultasCategoria  extends Pool{
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
