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
public class CorteCaja {
    private int idCorte;
    private double saldoInicial;
    private double totalCorte;
    private double totalVenta;
    private double sobrante;
    private Timestamp fechaCorte;

    public double getSobrante() {
        return sobrante;
    }

    public void setSobrante(double sobrante) {
        this.sobrante = sobrante;
    }
    
    public int getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(int idCorte) {
        this.idCorte = idCorte;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getTotalCorte() {
        return totalCorte;
    }

    public void setTotalCorte(double totalCorte) {
        this.totalCorte = totalCorte;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Timestamp getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Timestamp fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    

  
}
