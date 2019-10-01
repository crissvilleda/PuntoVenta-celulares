/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.RegistroUsuario;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author criss
 */
public class ControladorRegistroUsuario implements ActionListener, KeyListener, 
         MouseListener, DocumentListener{
    private RegistroUsuario vista;
    private Usuario modelo;
    private VUsuario vistaUsuario = new VUsuario();
    private ConsultasUsuario consulta = new ConsultasUsuario();
    
    
    public ControladorRegistroUsuario(RegistroUsuario vista, Usuario modelo){
        this.vista = vista;
        this.modelo= modelo;
        
        vista.jlblInicio.addMouseListener(this);
        vista.btnRegistrar.addActionListener(this);
        vista.jContraseña.getDocument().addDocumentListener(this);
        vista.jtxtUsuario.getDocument().addDocumentListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnRegistrar){
            registrar();
            
        }
    }
    
    public void registrar(){
        Usuario usu = new Usuario();
        usu.setNombre(vista.jtxtNombre.getText());
        usu.setApellido(vista.jtxtApellido.getText());
        usu.setEmail(vista.jtxtEmail.getText());
        usu.setTelefono(vista.jtxtTelefono.getText());
        usu.setGenero(vista.txtGenero.getText().charAt(0));
        usu.setNombreUsuario(vista.jtxtUsuario.getText());
        usu.setContraseña(String.copyValueOf(vista.jContraseña.getPassword()));
        usu.setTipo(vista.cbxTipo.getItemAt(vista.cbxTipo.getSelectedIndex()));
        if(consulta.registrar(usu)){
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
       
        
    }
 
    public void verificador(){
       if(String.valueOf(vista.jContraseña.getPassword()).
               equals(String.valueOf(vista.jContraseña1.
                       getPassword())) && !consulta.verificarNombreUsuario(
                       vista.jtxtUsuario.getText()) && vista.jContraseña.getPassword().length >0
                       ){
           vista.btnRegistrar.setEnabled(true);
       }else{
           vista.btnRegistrar.setEnabled(false);
       }
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            ControladorUsuario controlador = new ControladorUsuario( vistaUsuario ,modelo);
            controlador.iniciar();
            vista.dispose();         
        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jContraseña){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                registrar();
            }
        }
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jContraseña.getDocument()){
            verificador();
        }else if(de.getDocument()==vista.jtxtUsuario.getDocument()){
            verificador();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jContraseña.getDocument()){
            verificador();
        }else if(de.getDocument()==vista.jtxtUsuario.getDocument()){
            verificador();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jContraseña.getDocument()){
            verificador();
        }else if(de.getDocument()==vista.jtxtUsuario.getDocument()){
            verificador();
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    @Override
    public void keyReleased(KeyEvent ke) {
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
