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
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ConsultasVenta extends Pool{
    
    public boolean registrar(JTable tabla,Venta venta) throws SQLException{
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        PreparedStatement ps = null;
        Connection cn= (Connection)getConnection();
        ResultSet rs = null;
        String sqlVenta="INSERT INTO venta(idUsuario,idCliente,fecha,nArticulo,"
                + "totalCompra,totalVenta) VALUES(?,?,?,?,?,?)";
        String sqlDetVenta="INSERT INTO detalleVenta(idVenta,idProducto,precioCompra,precioVenta,"
                + "nArticulo,subtotalCompra,subtotalVenta) VALUES(?,?,?,?,?,?,?) ";
        String sqlCanInvI ="SELECT inventario.nArticulos FROM inventario WHERE inventario.idProducto=?";
        String sqlCanInvF ="UPDATE inventario SET inventario.nArticulos=? WHERE "
                + "inventario.idProducto=?";
        try{
            cn.setAutoCommit(false);
            //**********venta**********//
            ps = (PreparedStatement)cn.prepareStatement(sqlVenta,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getIdUsuario());
            ps.setInt(2, venta.getIdCliente());
            ps.setTimestamp(3, venta.getFecha());
            ps.setInt(4, venta.getnArticulo());
            ps.setDouble(5, venta.getTotaCompra());
            ps.setDouble(6, venta.getTotalVenta());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                venta.setIdVenta(rs.getInt(1));    
            }
            ps = null;
            rs = null;
            for(int i = 0; i< model.getRowCount();i++){
                //********detalle venta*******//
                ps = (PreparedStatement)cn.prepareStatement(sqlDetVenta);
                ps.setInt(1, venta.getIdVenta());
                ps.setInt(2, Integer.parseInt(model.getValueAt(i, 0).toString()));
                ps.setDouble(3, Double.parseDouble(model.getValueAt(i, 5).toString()));
                ps.setDouble(4, Double.parseDouble(model.getValueAt(i, 6).toString()));
                ps.setInt(5, Integer.parseInt(model.getValueAt(i, 4).toString()));
                ps.setDouble(6, Double.parseDouble((String)model.getValueAt(i, 4))*
                            Double.parseDouble((String)model.getValueAt(i, 5)));
                ps.setDouble(7, Double.parseDouble(model.getValueAt(i, 7).toString()));
                ps.executeUpdate();
                ps=null;
                
                //*****Acutaliza cantidad en inventario***//
                ps = (PreparedStatement)cn.prepareStatement(sqlCanInvI);
                ps.setInt(1, Integer.parseInt(model.getValueAt(i, 0).toString()));
                rs = ps.executeQuery();
                int nArticulosInv =0;
                while(rs.next()){
                    nArticulosInv= rs.getInt("inventario.nArticulos");
                }
                ps = null;
                rs= null;
                ps = (PreparedStatement)cn.prepareStatement(sqlCanInvF);
                ps.setInt(1,nArticulosInv-Integer.parseInt(model.getValueAt(i, 4).toString()));
                ps.setInt(2, Integer.parseInt(model.getValueAt(i, 0).toString()));
                ps.executeUpdate();
                
            }
            
            cn.commit();
            cn.setAutoCommit(true);
            return true;
        }catch(SQLException e){
            cn.rollback();
            return false;
            
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch(SQLException e){
                    
                }
            }
            
        }
        
    }
    
    
    public boolean siguenteIdVenta(JLabel label){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = (Connection)getConnection();
        String sql = "SELECT auto_increment FROM information_schema.TABLES WHERE "
                + "TABLE_NAME ='venta' and TABLE_SCHEMA='ventaCelulares'";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                label.setText(rs.getString("auto_increment"));
                return true;
            }
            return false;
            
        }catch(SQLException e){
            System.err.print(e);
            return false;
        }finally{
            if(cn!=null){
                try{
                    cn.close();
                }catch(SQLException e){
                    
                }
            }
            
        }
    }
    
}
