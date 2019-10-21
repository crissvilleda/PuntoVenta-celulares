/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author criss
 */
public class Venta {
    private int idVenta;
    private int idUsuario;
    private int idCliente;
    private Timestamp fecha;
    private int nArticulo;
    private double totalCompra;
    private double totalVenta;
    
    
    public Venta(){}

    public Venta(int idVenta, int idUsuario, int idCliente, Timestamp fecha, int nArticulo, double totaCompra, double totalVenta) {
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.nArticulo = nArticulo;
        this.totalCompra = totaCompra;
        this.totalVenta = totalVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getnArticulo() {
        return nArticulo;
    }

    public void setnArticulo(int nArticulo) {
        this.nArticulo = nArticulo;
    }

    public double getTotaCompra() {
        return totalCompra;
    }

    public void setTotaCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
   
    
    
    
}
