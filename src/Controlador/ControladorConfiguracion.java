/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.ConsultasCategoria;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.Configuracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Orlando
 */
public class ControladorConfiguracion implements ActionListener, MouseListener , 
        DocumentListener, KeyListener,WindowListener{
    private Configuracion vista;
    private Usuario modelo;
    private Administrador vistaAdmin = new Administrador();
    ConsultasCategoria consultasC = new ConsultasCategoria();
    
    public ControladorConfiguracion(Configuracion vista, Usuario modelo){
        this.vista=vista;
        this.modelo= modelo;
        //
        vista.jtxtCategoria.getDocument().addDocumentListener(this);
        vista.jtxtCategoria.addKeyListener(this);
        vista.jlblInicio.addMouseListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnEliminarC.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        consultasC.tablaCategorias(vista.jtableCategoria);
        vista.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnGuardar){
            registrar();
        }else if (e.getSource()==vista.btnEliminarC){
            
        }
        else if(e.getSource()==vista.btnNuevo){
            vista.jtxtCategoria.setText("");
            vista.jtxtCategoria.requestFocus();
            
        }
    }
    public void registrar(){
        Categoria cat= new Categoria();
        cat.setNombre(vista.jtxtCategoria.getText());
        if(consultasC.registrar(cat)){
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            vista.jtxtCategoria.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
    }
    public void eliminar(){
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblInicio){
           ControladorAdministrador controladorA = 
                   new ControladorAdministrador(vistaAdmin,modelo);
           controladorA.iniciar();
           vista.dispose();
        }
    }
     @Override
    public void windowOpened(WindowEvent e) {
        vista.btnGuardar.setEnabled(false);
        vista.btnModificarC.setEnabled(false);
        vista.btnEliminarC.setEnabled(false);
        vista.btnGuardarM.setEnabled(false);
        vista.btnModificarLM.setEnabled(false);
        vista.btnEliminarLM.setEnabled(false);
        
    }
    
    public void verificarLabels(){
        if(vista.jtxtCategoria.getText().length()>2){
             vista.btnGuardar.setEnabled(true);
            }
        else{
            vista.btnGuardar.setEnabled(false);
        }
    }
    
    
    
    
    
    
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarLabels();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarLabels();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarLabels();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

   
    
    
    
}
