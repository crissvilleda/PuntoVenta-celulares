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

/**
 *
 * @author criss
 */
public class ControladorRegistrarProveedor implements ActionListener, KeyListener,
        MouseListener, WindowListener {
    private RegistroProveedor vista;
    private Usuario modelo;
    private VProveedor vistaProveedor = new VProveedor();
    private ConsultasProveedor consulta= new ConsultasProveedor();
    
    public ControladorRegistrarProveedor(RegistroProveedor vista, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        vista.jlblCerrar.addMouseListener(this);
        vista.jtxtRepresentante.addKeyListener(this);
        vista.addWindowListener(this);
        
        
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
            ControladorProveedor controlador = new ControladorProveedor( vistaProveedor ,modelo);
            controlador.iniciar();
            vista.dispose();         
        }
        
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtRepresentante){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                registrar();
                
            }
            
        }
    }
    @Override
    public void windowOpened(WindowEvent we) {
        vista.btnRegistrar.setEnabled(false);
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
