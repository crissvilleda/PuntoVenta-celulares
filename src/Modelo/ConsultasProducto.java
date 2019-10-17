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
    
    
    
    public boolean consultar(String[] registros ){
        PreparedStatement ps = null;
        Connection cn = (Connection)getConnection();
        ResultSet rs = null;
        String sql ="SELECT producto.idProducto, producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre,marca.nombre FROM producto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca= marca.idMarca WHERE producto.codigo = ?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1, registros[1]);
            rs =ps.executeQuery();
            if(rs.next()){
                registros[0]=(rs.getString("producto.idProducto"));
                registros[1]=(rs.getString("producto.codigo"));
                registros[2]=(rs.getString("producto.nombre"));
                registros[3]=(rs.getString("producto.descripcion"));
                registros[4]=(rs.getString("categoria.nombre"));
                registros[5]=(rs.getString("marca.nombre"));
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
        String sql ="SELECT producto.idProducto, producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre,marca.nombre FROM producto"
                + " INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca= marca.idMarca WHERE producto.nombre"
                + " LIKE ? or producto.descripcion LIKE ?";
        try{
            ps = (PreparedStatement)cn.prepareStatement(sql);
            ps.setString(1,"%"+texto+"%");
            ps.setString(2,"%"+texto+"%");
            rs =ps.executeQuery();
            while(rs.next()){
                registros [0]=rs.getString("producto.idProducto");
                registros [1]=rs.getString("producto.codigo");
                registros [2]=rs.getString("producto.nombre");
                registros [3]=rs.getString("producto.descripcion");
                registros [4]=rs.getString("categoria.nombre");
                registros [5]=rs.getString("marca.nombre");
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
        String sql ="SELECT producto.idProducto, producto.codigo, producto.nombre, "
                + "producto.descripcion, categoria.nombre,marca.nombre FROM producto "
                + "INNER JOIN categoria ON producto.idCategoria=categoria.idCategoria "
                + "INNER JOIN marca ON producto.idMarca= marca.idMarca";
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
    
public boolean verificarExistencia(String[] regPro){
    PreparedStatement ps = null;
    Connection cn = (Connection)getConnection();
    ResultSet rs = null;
    String sql = "SELECT producto.idProducto, producto.nombre, producto.descripcion, "
            + "inventario.nArticulos,inventario.precioVenta, inventario.fechaLote"
            + " FROM producto INNER JOIN inventario ON producto.idProducto=inventario.idProducto "
            + "WHERE producto.codigo=? ORDER BY inventario.fechaLote DESC ";
    try{
        ps = (PreparedStatement)cn.prepareStatement(sql);
        ps.setString(1, regPro[1]);
        rs = ps.executeQuery();
        while(rs.next()){
            if(Integer.parseInt(rs.getString("inventario.nArticulos")) >= Integer.parseInt(regPro[4])){
                regPro[0]=rs.getString("producto.idProducto");
                regPro[2]=rs.getString("producto.nombre");
                regPro[3]=rs.getString("producto.descripcion");
                regPro[5]=rs.getString("inventario.precioVenta");
                regPro[6]=String.valueOf(Integer.parseInt(regPro[4])*Integer.parseInt(regPro[5]));
                return true;
            }else{
                return false;
            }
        }
        return false;
    }catch(Exception e){
        return false;
    }
    
}    
    
}
