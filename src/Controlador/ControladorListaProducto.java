/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.ListaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author criss
 */
public class ControladorListaProducto implements DocumentListener,MouseListener,
        ActionListener{
    private ListaProducto vista;

    public ControladorListaProducto(ListaProducto vista) {
        this.vista = vista;
        
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.jlblCerrar.addMouseListener(this);
        vista.btnSeleccionar.addActionListener(this);
        vista.btnSeleccionar.setVisible(false);
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

   
    
    
}
