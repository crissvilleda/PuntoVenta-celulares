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
        String sql2 ="UPDATE inventario SET nArticulos=?,precioCompra=?,precioVenta=?"
                + "WHERE idProducto=?";
        String sql3= "INSERT INTO inventario(idProducto,nArticulos, "
                + "precioCompra, precioVenta) "
                + "values(?,?,?,?)";
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
                 ps.setInt(1, inventario.getIdProducto());
                 ps.setInt(2, inventario.getnArticulo());
                 ps.setDouble(3, inventario.getPrecioCompra());
                 ps.setDouble(4, inventario.getPrecioVenta());
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
    
    public boolean modificarCanInv(DetalleVenta detVenta){
        PreparedStatement ps=null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql1="SELECT inventario.nArticulos FROM inventario WHERE inventario.idProducto=? ";
        String sql2 ="UPDATE inventario SET inventario.nArticulos=? WHERE "
                + "inventario.idProducto=?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql1);
            ps.setInt(1, detVenta.getIdProducto());
            rs = ps.executeQuery();
            int nArticulosInv =0;
            while(rs.next()){
                nArticulosInv= rs.getInt("inventario.nArticulos");
            }
            ps = null;
            ps = (PreparedStatement)cn.prepareStatement(sql2);
            ps.setInt(1,nArticulosInv-detVenta.getnArticulo());
            ps.setInt(2, detVenta.getIdProducto());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
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
        String registros [] = new String [9];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT inventario.idInventario,producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre, inventario.nArticulos, "
                + "inventario.precioCompra, inventario.precioVenta FROM inventario "
                + "INNER JOIN producto ON inventario.idProducto=producto.idProducto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca=marca.idMarca ORDER BY "
                + "producto.nombre ASC";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idInventario");
                registros [1]=rs.getString("codigo");
                registros [2]=rs.getString("producto.nombre");
                registros [3]=rs.getString("descripcion");
                registros [4]=rs.getString("categoria.nombre");
                registros [5]=rs.getString("marca.nombre");
                registros [6]=rs.getString("nArticulos");
                registros [7]=rs.getString("precioCompra");
                registros [8]=rs.getString("precioVenta");
                
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
        String registros [] = new String [9];
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT inventario.idInventario,producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre, inventario.nArticulos, "
                + "inventario.precioCompra, inventario.precioVenta FROM inventario "
                + "INNER JOIN producto ON inventario.idProducto=producto.idProducto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca=marca.idMarca WHERE "
                + "producto.nombre LIKE ? OR producto.codigo LIKE ? OR producto.descripcion "
                + "LIKE ? ORDER BY producto.nombre ASC ";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            ps.setString(3,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("idInventario");
                registros [1]=rs.getString("codigo");
                registros [2]=rs.getString("producto.nombre");
                registros [3]=rs.getString("descripcion");
                registros [4]=rs.getString("categoria.nombre");
                registros [5]=rs.getString("marca.nombre");
                registros [6]=rs.getString("nArticulos");
                registros [7]=rs.getString("precioCompra");
                registros [8]=rs.getString("precioVenta");
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
    
    
    public void buscarProductoInv(JTable tabla,String texto){
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
        String sql ="SELECT producto.idProducto, producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre,inventario.nArticulos, "
                + "inventario.precioVenta FROM producto INNER JOIN inventario ON "
                + "inventario.idProducto= producto.idProducto INNER JOIN categoria ON "
                + "categoria.idCategoria=producto.idCategoria INNER JOIN marca on "
                + "marca.idMarca= producto.idMarca  WHERE inventario.nArticulos > 0 "
                + "AND (producto.codigo LIKE ? OR producto.nombre LIKE ? OR "
                + "producto.descripcion LIKE ?) "
                + "ORDER BY producto.nombre  ASC";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            ps.setString(3,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("producto.idProducto");
                registros [1]=rs.getString("producto.codigo");
                registros [2]=rs.getString("producto.nombre");
                registros [3]=rs.getString("producto.descripcion");
                registros [4]=rs.getString("categoria.nombre");
                registros [5]=rs.getString("marca.nombre");
                registros [6]=rs.getString("inventario.nArticulos");
                registros [7]=rs.getString("inventario.precioVenta");
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
    
    public void llenarTablaInv(JTable tabla){
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
        String sql ="SELECT producto.idProducto, producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre, marca.nombre,inventario.nArticulos, "
                + "inventario.precioVenta FROM producto INNER JOIN inventario ON "
                + "inventario.idProducto= producto.idProducto INNER JOIN categoria ON "
                + "categoria.idCategoria=producto.idCategoria INNER JOIN marca on "
                + "marca.idMarca= producto.idMarca  WHERE inventario.nArticulos> 0 "
                + "ORDER BY producto.nombre  ASC";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("producto.idProducto");
                registros [1]=rs.getString("producto.codigo");
                registros [2]=rs.getString("producto.nombre");
                registros [3]=rs.getString("producto.descripcion");
                registros [4]=rs.getString("categoria.nombre");
                registros [5]=rs.getString("marca.nombre");
                registros [6]=rs.getString("inventario.nArticulos");
                registros [7]=rs.getString("inventario.precioVenta");
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
