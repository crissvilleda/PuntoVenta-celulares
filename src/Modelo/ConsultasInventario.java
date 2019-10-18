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
public class ConsultasInventario extends Pool{
    
    public boolean registrar(Inventario inventario){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        boolean existe= false;
        String sql="SELECT * FROM inventario WHERE idProducto = ?";
        String sql2 ="UPDATE inventario SET nArticulos=?,precioCompra=?,precioVenta?"
                + "WHERE inventario.idProducto=?";
        String sql3= "INSERT INTO inventario(idProducto,nArticulos, "
                + "precioCompra, precioVenta) "
                + "values(?,?,?,?,?)";
        String regInv[] =new String [4];
        try{
             ps = (PreparedStatement) cn.prepareStatement(sql);
             ps.setInt(1, inventario.getIdProducto());
             rs = ps.executeQuery();
             while(rs.next()){
                regInv[0]=rs.getString("idProducto");
                regInv[1]=rs.getString("nArticulos");
                regInv[2]=rs.getString("precioCompra");
                regInv[3]=rs.getString("precioVenta");
                existe= true;
                 
             }
             if(existe){
                 ps = (PreparedStatement) cn.prepareStatement(sql2);
                 ps.setInt(1,Integer.parseInt(regInv[1])+inventario.getnArticulo());
                 ps.setDouble(2,(Double.parseDouble(regInv[2])+inventario.getPrecioCompra())/2);
                 ps.setDouble(3, inventario.getPrecioVenta());
                 ps.setInt(4, inventario.getIdProducto());
                 ps.execute();
             }else{
                 ps = (PreparedStatement)cn.prepareStatement(sql3);
                 ps.setInt(0, inventario.getIdProducto());
                 ps.setInt(1, inventario.getnArticulo());
                 ps.setDouble(2, inventario.getPrecioCompra());
                 ps.setDouble(3, inventario.getPrecioVenta());
                 ps.execute();
                 
             }
             
             
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
    
   
    public void tablaInventario(JTable tabla){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        PreparedStatement ps = null;
        String registros [] = new String [10];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT inventario.idInventario,DATE_FORMAT(inventario.fechaLote, '%Y-%m-%d') as fecha"
                + ",producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre, inventario.nArticulos, "
                + "inventario.precioCompra, inventario.precioVenta FROM inventario "
                + "INNER JOIN producto ON inventario.idProducto=producto.idProducto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca=marca.idMarca ORDER BY "
                + "inventario.fechaLote DESC ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idInventario");
                registros [1]=rs.getString("fecha");
                registros [2]=rs.getString("codigo");
                registros [3]=rs.getString("producto.nombre");
                registros [4]=rs.getString("descripcion");
                registros [5]=rs.getString("categoria.nombre");
                registros [6]=rs.getString("marca.nombre");
                registros [7]=rs.getString("nArticulos");
                registros [8]=rs.getString("precioCompra");
                registros [9]=rs.getString("precioVenta");
                
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
    
    public void buscar(JTable tabla,String texto){
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //Limpiar tabla
        int a = model.getRowCount()-1;
        for(int i=a;i>=0;i--){
            model.removeRow(model.getRowCount()-1);
            
        }
        PreparedStatement ps = null;
        String registros [] = new String [10];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT inventario.idInventario,DATE_FORMAT(inventario.fechaLote, '%Y-%m-%d') as fecha"
                + ",producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre, inventario.nArticulos, "
                + "inventario.precioCompra, inventario.precioVenta FROM inventario "
                + "INNER JOIN producto ON inventario.idProducto=producto.idProducto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca=marca.idMarca WHERE "
                + "producto.nombre LIKE ? OR producto.codigo LIKE ? OR producto.descripcion "
                + "LIKE ? ORDER BY inventario.fechaLote DESC ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            ps.setString(3,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idInventario");
                registros [1]=rs.getString("fecha");
                registros [2]=rs.getString("codigo");
                registros [3]=rs.getString("producto.nombre");
                registros [4]=rs.getString("descripcion");
                registros [5]=rs.getString("categoria.nombre");
                registros [6]=rs.getString("marca.nombre");
                registros [7]=rs.getString("nArticulos");
                registros [8]=rs.getString("precioCompra");
                registros [9]=rs.getString("precioVenta");
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
