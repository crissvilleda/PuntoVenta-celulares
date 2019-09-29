/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author criss
 */
public class Compra {
    private int idCompra;
    private int idUsuario;
    private int idProveedor;
    private Date fechaCompra;
    private double total;
    
    public Compra(){}
    public Compra(int ic, int iu,int ip,Date fc,double t){
        this.idCompra =ic;
        this.idUsuario = iu;
        this.idProveedor = ip;
        this.fechaCompra = fc;
        this.total = t;
    }

    public int getIdCompra() {
        
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }


    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
