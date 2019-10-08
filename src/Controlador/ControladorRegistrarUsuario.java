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
public class ControladorRegistrarUsuario implements ActionListener, KeyListener, 
         MouseListener, DocumentListener{
    private Usuario usuario;
    private RegistroUsuario vista;
    private Usuario modelo;
    private VUsuario vistaUsuario = new VUsuario();
    private ConsultasUsuario consulta = new ConsultasUsuario();
    
    
    public ControladorRegistrarUsuario(RegistroUsuario vista, Usuario modelo){
        this.vista = vista;
        this.modelo= modelo;
        
        vista.jlblInicio.addMouseListener(this);
        vista.btnRegistrar.addActionListener(this);
        
        vista.jtxtNombre.addKeyListener(this);
        vista.jtxtApellido.addKeyListener(this);
        vista.jtxtEmail.addKeyListener(this);
        vista.jtxtTelefono.addKeyListener(this);
        vista.jtxtUsuario.addKeyListener(this);
        vista.txtGenero.addKeyListener(this);
        vista.jContraseña1.addKeyListener(this);
        
        vista.jtxtNombre.getDocument().addDocumentListener(this);
        vista.jtxtApellido.getDocument().addDocumentListener(this);
        vista.jtxtEmail.getDocument().addDocumentListener(this);
        vista.jtxtTelefono.getDocument().addDocumentListener(this);
        vista.jtxtUsuario.getDocument().addDocumentListener(this);
        vista.txtGenero.getDocument().addDocumentListener(this);
        vista.jContraseña1.getDocument().addDocumentListener(this);
        vista.jContraseña.getDocument().addDocumentListener(this);
        
        vista.btnRegistrar.setEnabled(false);
        vista.jtxtNombre.requestFocus();
        
    
    }
    public ControladorRegistrarUsuario(RegistroUsuario vista,Usuario usu,Usuario modelo){
        this.vista = vista;
        this.usuario = usu;
        this.modelo= modelo;
        
        vista.jlblInicio.addMouseListener(this);
        vista.btnRegistrar.addActionListener((ActionEvent)->{
        modificar();
        });
        
        vista.jtxtNombre.addKeyListener(this);
        vista.jtxtApellido.addKeyListener(this);
        vista.jtxtEmail.addKeyListener(this);
        vista.jtxtTelefono.addKeyListener(this);
        vista.jtxtUsuario.addKeyListener(this);
        vista.txtGenero.addKeyListener(this);
        vista.jContraseña1.addKeyListener(this);
        
        vista.jtxtNombre.getDocument().addDocumentListener(this);
        vista.jtxtApellido.getDocument().addDocumentListener(this);
        vista.jtxtEmail.getDocument().addDocumentListener(this);
        vista.jtxtTelefono.getDocument().addDocumentListener(this);
        vista.jtxtUsuario.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                verificadorUsuario();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                verificadorUsuario();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                verificadorUsuario();
            }
        });
        vista.txtGenero.getDocument().addDocumentListener(this);
        vista.jContraseña1.getDocument().addDocumentListener(this);
        vista.jContraseña.getDocument().addDocumentListener(this);
        
        vista.jtxtNombre.setText(usuario.getNombre());
        vista.jtxtApellido.setText(usuario.getApellido());
        vista.jtxtEmail.setText(usuario.getEmail());
        vista.jtxtTelefono.setText(usuario.getTelefono());
        vista.txtGenero.setText(String.valueOf(usuario.getGenero()));
        vista.jtxtUsuario.setText(usuario.getNombreUsuario());
        vista.jContraseña.setText(usuario.getContraseña());
        vista.jContraseña1.setText(usuario.getContraseña());
        vista.cbxTipo.getModel().setSelectedItem(usuario.getTipo());
        
        vista.btnRegistrar.setEnabled(false);
    
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
            vista.jtxtNombre.setText("");
            vista.jtxtApellido.setText("");
            vista.jtxtEmail.setText("");
            vista.jtxtTelefono.setText("");
            vista.txtGenero.setText("");
            vista.jtxtUsuario.setText("");
            vista.jContraseña.setText("");
            vista.jContraseña1.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
       
        
    }
    public void modificar(){
        
        usuario.setNombre(vista.jtxtNombre.getText());
        usuario.setApellido(vista.jtxtApellido.getText());
        usuario.setEmail(vista.jtxtEmail.getText());
        usuario.setTelefono(vista.jtxtTelefono.getText());
        usuario.setGenero(vista.txtGenero.getText().charAt(0));
        usuario.setNombreUsuario(vista.jtxtUsuario.getText());
        usuario.setContraseña(String.copyValueOf(vista.jContraseña.getPassword()));
        usuario.setTipo(vista.cbxTipo.getItemAt(vista.cbxTipo.getSelectedIndex()));
        if(consulta.modificar(usuario)){
            JOptionPane.showMessageDialog(null,"Modificacion Exitoso");
            vista.btnRegistrar.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
        
    }
 
    public void verificadorContraseña(){
       if(String.valueOf(vista.jContraseña.getPassword()).
               equals(String.valueOf(vista.jContraseña1.
                       getPassword())) &&  vista.jContraseña.getPassword().length >0
                       ){
           vista.btnRegistrar.setEnabled(true);
       }else{
           vista.btnRegistrar.setEnabled(false);
       }
    }
    public void verificadorUsuario(){
       if(!consulta.verificarNombreUsuario(vista.jtxtNombre.getText())){
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
            ControladorUsuario controladorU = new ControladorUsuario( vistaUsuario ,modelo);
            controladorU.iniciar();
            vista.dispose();         
        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtNombre){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtApellido.requestFocus();
                
            }
                
        }else if(ke.getSource()==vista.jtxtApellido){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtEmail.requestFocus();
            }
            
        }else if(ke.getSource()==vista.jtxtEmail){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtTelefono.requestFocus();
            }
            
        }else if(ke.getSource()==vista.jtxtTelefono){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.txtGenero.requestFocus();
                
            }
            
        }else if(ke.getSource()==vista.txtGenero){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtUsuario.requestFocus();
            }   
        }else if(ke.getSource()==vista.jtxtUsuario){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jContraseña1.requestFocus();
            }   
        }else if(ke.getSource()==vista.jContraseña1){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jContraseña.requestFocus();
            }   
        }
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        verificadorContraseña();
        
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        verificadorContraseña();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        verificadorContraseña();
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
