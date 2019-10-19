/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.CantPrecioEnt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorCantPrecioEnt implements ActionListener,MouseListener,
        KeyListener, DocumentListener {
    private CantPrecioEnt vista;
    private JTable tabla;
    private String [] regProducto;
    
    public ControladorCantPrecioEnt(CantPrecioEnt vista) {
        this.vista = vista;
        this.vista.btnSeleccionar.setEnabled(false);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.jtxtCantidad.getDocument().addDocumentListener(this);
        this.vista.jtxtPC.getDocument().addDocumentListener(this);
        this.vista.jtxtPV.getDocument().addDocumentListener(this);
        this.vista.jtxtCantidad.addKeyListener(this);
        this.vista.jtxtPC.addKeyListener(this);
        this.vista.jtxtPV.addKeyListener(this);
        this.vista.jlblCerrar2.addMouseListener(this);
    }
    
    public void VerificadorJtxt(){
        try{
            if(vista.jtxtCantidad.getText().length()>0 && vista.jtxtPC.getText().length()>0
                    && vista.jtxtPV.getText().length()>0&&Integer.parseInt(vista.jtxtCantidad.getText())>0
                    && Double.parseDouble(vista.jtxtPC.getText())< Double.parseDouble(vista.jtxtPV.getText())
                    && Double.parseDouble(vista.jtxtPC.getText())>0 && Double.parseDouble(vista.jtxtPV.getText())>0){
                vista.btnSeleccionar.setEnabled(true);

            }else{
                vista.btnSeleccionar.setEnabled(false);

            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error - Ingrese solo datos numericos");
        }
        
    }
    
    public void inciar(){
        vista.setLocationRelativeTo(null);
        vista.setAlwaysOnTop(true);
        vista.setVisible(true);
    }
    public void agregarProducto(){
        String registro [] = new String [10];
            DefaultTableModel model =(DefaultTableModel)this.tabla.getModel();
            try{
                registro[0]=regProducto[0];
                registro[1]=regProducto[1];
                registro[2]=regProducto[2];
                registro[3]=regProducto[3];
                registro[4]=regProducto[4];
                registro[5]=regProducto[5];
                registro[6]=this.vista.jtxtCantidad.getText();
                registro[7]=this.vista.jtxtPC.getText();
                registro[8]=String.valueOf(Double.parseDouble(this.vista.jtxtPV.getText()));
                registro[9]=String.valueOf(Integer.parseInt(vista.jtxtCantidad.getText())
                    *Double.parseDouble(vista.jtxtPC.getText()));
                model.addRow(registro);
                this.tabla.setModel(model);
                vista.dispose();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error - Ingrese solo datos numericos");
            
            }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if((ae.getSource()==vista.btnSeleccionar)){
            agregarProducto();
            
        } 
    }
    public void insertarProducto(JTable tabla,String[] registros){
        this.tabla=tabla;
        this.regProducto=registros;
        
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        VerificadorJtxt();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        VerificadorJtxt();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        VerificadorJtxt();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblCerrar2){
            vista.dispose();
        }
    }
    
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtCantidad){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtPC.requestFocus();
                
            }
            
        }else if(ke.getSource()==vista.jtxtPC){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtPV.requestFocus();
                
            }
            
        }else if (ke.getSource()==vista.jtxtPV){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.getRootPane().setDefaultButton(vista.btnSeleccionar);
                vista.btnSeleccionar.requestFocus();
               
            }
            
        }
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

    @Override
    public void keyTyped(KeyEvent ke) {
    }



    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
}
