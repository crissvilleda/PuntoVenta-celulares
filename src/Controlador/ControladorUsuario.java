/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author criss
 */
public class ControladorUsuario implements ActionListener, MouseListener, 
        WindowListener {
    private VUsuario vista;
    private Usuario  modelo;
    private Administrador vistaAdmin = new Administrador();
    private vista
    private ConsultasUsuario consulta = new ConsultasUsuario();
    public ControladorUsuario(VUsuario vista,Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnNuevo.addActionListener(this);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevo){
            
            
        }
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        vista.jlblInicio.addMouseListener(this);
        vista.addWindowListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            ControladorAdministrador controlador = 
                    new ControladorAdministrador(vistaAdmin,modelo);
            controlador.iniciar();
            vista.dispose();
            
        }
    }
    @Override
    public void windowOpened(WindowEvent we) {
        consulta.listaUsuarios(vista.jtableUsuario);
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
    
}
