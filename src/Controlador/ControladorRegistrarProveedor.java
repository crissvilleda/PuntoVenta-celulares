/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasCategoria;
import Modelo.ConsultasMarca;
import Modelo.ConsultasProveedor;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vista.RegistroProveedor;
import Vista.VProveedor;
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
 * @author criss
 */
public class ControladorRegistrarProveedor implements ActionListener, KeyListener,
        MouseListener, WindowListener, DocumentListener {
    private Proveedor proveedor;
    private RegistroProveedor vista;
    private Usuario modelo;
    private VProveedor vistaProveedor = new VProveedor();
    private ConsultasProveedor consulta= new ConsultasProveedor();
    
    public ControladorRegistrarProveedor(RegistroProveedor vista, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        vista.jlblCerrar.addMouseListener(this);
        vista.jtxtNombre.addKeyListener(this);
        vista.jtxtDireccion.addKeyListener(this);
        vista.jtxtEmail.addKeyListener(this);
        vista.jtxtCiudad.addKeyListener(this);
        vista.jtxtPais.addKeyListener(this);
        vista.addWindowListener(this);
        
        vista.btnRegistrar.addActionListener(this);
        vista.jtxtNombre.getDocument().addDocumentListener(this);
        vista.jtxtDireccion.getDocument().addDocumentListener(this);
        vista.jtxtEmail.getDocument().addDocumentListener(this);
        vista.jtxtTelefono.getDocument().addDocumentListener(this);
        vista.jtxtPais.getDocument().addDocumentListener(this);
        vista.jtxtCiudad.getDocument().addDocumentListener(this);
        vista.jtxtRepresentante.getDocument().addDocumentListener(this);
        
    }
    public ControladorRegistrarProveedor(RegistroProveedor vista,Proveedor pro, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.proveedor = pro;
        vista.jlblCerrar.addMouseListener(this);
        vista.jtxtNombre.addKeyListener(this);
        vista.jtxtDireccion.addKeyListener(this);
        vista.jtxtEmail.addKeyListener(this);
        vista.jtxtCiudad.addKeyListener(this);
        vista.jtxtPais.addKeyListener(this);
        vista.addWindowListener(this);
        vista.btnRegistrar.addActionListener((ActionEvent)->{
            Modificar(); 
        });
        
        vista.jtxtNombre.getDocument().addDocumentListener(this);
        vista.jtxtDireccion.getDocument().addDocumentListener(this);
        vista.jtxtEmail.getDocument().addDocumentListener(this);
        vista.jtxtTelefono.getDocument().addDocumentListener(this);
        vista.jtxtPais.getDocument().addDocumentListener(this);
        vista.jtxtCiudad.getDocument().addDocumentListener(this);
        vista.jtxtRepresentante.getDocument().addDocumentListener(this);
        vista.jtxtNombre.setText(proveedor.getNombre());
        vista.jtxtDireccion.setText(pro.getDireccion());
        vista.jtxtEmail.setText(pro.getEmail());
        vista.jtxtCiudad.setText(proveedor.getCiudad());
        vista.jtxtTelefono.setText(pro.getTelefono());
        vista.jtxtPais.setText(pro.getPais());
        vista.jtxtRepresentante.setText(pro.getRepresentante());
        
    }
    
    
    public void registrar(){
        Proveedor pro = new Proveedor();
        pro.setNombre(vista.jtxtNombre.getText());
        pro.setDireccion(vista.jtxtDireccion.getText());
        pro.setEmail(vista.jtxtEmail.getText());
        pro.setCiudad(vista.jtxtCiudad.getText());
        pro.setPais(vista.jtxtPais.getText());
        pro.setRepresentante(vista.jtxtRepresentante.getText());
        if(consulta.registrar(pro)){
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            vista.jtxtNombre.setText("");
            vista.jtxtEmail.setText("");
            vista.jtxtDireccion.setText("");
            vista.jtxtCiudad.setText("");
            vista.jtxtPais.setText("");
            vista.jtxtRepresentante.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
        
    }
    public void Modificar(){
        proveedor.setNombre(vista.jtxtNombre.getText());
        proveedor.setDireccion(vista.jtxtDireccion.getText());
        proveedor.setEmail(vista.jtxtEmail.getText());
        proveedor.setTelefono(vista.jtxtTelefono.getText());
        proveedor.setCiudad(vista.jtxtCiudad.getText());
        proveedor.setPais(vista.jtxtPais.getText());
        proveedor.setRepresentante(vista.jtxtRepresentante.getText());
        if(consulta.modificar(proveedor)){
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            vista.jtxtNombre.setText("");
            vista.jtxtEmail.setText("");
            vista.jtxtDireccion.setText("");
            vista.jtxtTelefono.setText("");
            vista.jtxtCiudad.setText("");
            vista.jtxtPais.setText("");
            vista.jtxtRepresentante.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
        
    }
    //verifica si cada una de las cajas de texto no estan vacias
    public void verificarLabels(){
        if(vista.jtxtNombre.getText().length()>0 && vista.jtxtCiudad.getText().length()>0 
                && vista.jtxtEmail.getText().length()>0 &&vista.jtxtRepresentante.getText().length()>0){
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnRegistrar){
            registrar();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblCerrar){
            ControladorProveedor controlador = new ControladorProveedor(vistaProveedor ,modelo);
            controlador.iniciar();
            vista.dispose();         
        }
        
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtNombre){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtDireccion.requestFocus();
                
            }
                
        }else if(ke.getSource()==vista.jtxtDireccion){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtEmail.requestFocus();
            }
            
        }else if(ke.getSource()==vista.jtxtEmail){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtCiudad.requestFocus();
            }
            
        }else if(ke.getSource()==vista.jtxtCiudad){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtPais.requestFocus();
                
            }
            
        }else if(ke.getSource()==vista.jtxtPais){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtRepresentante.requestFocus();
            }   
        }
    }
    @Override
    public void windowOpened(WindowEvent we) {
        vista.btnRegistrar.setEnabled(false);
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        verificarLabels();
        
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        verificarLabels();
        
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        verificarLabels();
        
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
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
    
}
