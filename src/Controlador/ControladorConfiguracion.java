/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Orlando
 */
public class ControladorConfiguracion implements ActionListener, MouseListener , 
        DocumentListener, KeyListener{
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
        vista.jlblAtras.addMouseListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.jbtnEliminar.addActionListener(this);
        consultasC.tablaCategorias(vista.jtableCategoria);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnGuardar){
                       
            registrar();
        }else if (e.getSource()==vista.jbtnEliminar){
            
        }
    }
    public void registrar(){
        
    }
    public void eliminar(){
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblAtras){
           ControladorAdministrador controladorA = 
                   new ControladorAdministrador(vistaAdmin,modelo);
           controladorA.iniciar();
           vista.dispose();
        
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
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
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

   
    
    
    
}
