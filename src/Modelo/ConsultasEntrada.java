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
public class ConsultasEntrada extends Pool {
    public boolean siguenteIdEntrada(Entrada entrada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "SELECT auto_increment FROM information_schema.TABLES WHERE "
                + "TABLE_NAME ='entrada' and TABLE_SCHEMA='ventaCelulares'";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                entrada.setIdEntrada(rs.getInt("auto_increment"));
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
    }
    public boolean registrar(Entrada entrada){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "INSERT INTO entrada(idUsuario, idProveedor,"
                + "fechaCompra, total) values(?,?,?,?)";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setInt(1, entrada.getIdUsuario());
            ps.setInt(2, entrada.getIdProveedor());
            ps.setTimestamp(3,entrada.getFechaCompra());
            ps.setDouble(4, entrada.getTotal());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }
        
    }
    
    public void tablaEntrada(JTable tabla){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        PreparedStatement ps = null;
        String registros [] = new String [5];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT entrada.idEntrada, usuario.nombreUsuario,proveedor.nombre, "
                + "entrada.fechaCompra, entrada.total FROM entrada INNER JOIN "
                + "usuario ON entrada.idUsuario=usuario.idUsuario INNER JOIN "
                + "proveedor ON entrada.idProveedor=proveedor.idProveedor ORDER BY "
                + "entrada.fechaCompra DESC ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idEntrada");
                registros [1]=rs.getString("fechaCompra");
                registros [2]=rs.getString("nombreUsuario");
                registros [3]=rs.getString("nombre");
                registros [4]=rs.getString("total");
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
    
    public void consultar(JTable tabla,String texto){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a = model.getRowCount()-1;
        for(int i=a;i>=0;i--){
            model.removeRow(model.getRowCount()-1);
            
        }
        PreparedStatement ps = null;
        String registros [] = new String [5];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT entrada.idEntrada, usuario.nombreUsuario,proveedor.nombre, "
                + "entrada.fechaCompra, entrada.total FROM entrada INNER JOIN "
                + "usuario ON entrada.idUsuario=usuario.idUsuario INNER JOIN "
                + "proveedor ON entrada.idProveedor=proveedor.idProveedor WHERE "
                + "DATE_FORMAT(entrada.fechaCompra, '%Y-%m-%d') LIKE ? OR "
                + "usuario.nombreUsuario LIKE ? OR proveedor.nombre LIKE ? ORDER BY "
                + "entrada.fechaCompra DESC ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            ps.setString(3,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idEntrada");
                registros [1]=rs.getString("fechaCompra");
                registros [2]=rs.getString("nombreUsuario");
                registros [3]=rs.getString("nombre");
                registros [4]=rs.getString("total");
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
    
    
    
}
