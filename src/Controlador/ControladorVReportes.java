/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Administrador;
import Vista.VReportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Orlando
 */

public class ControladorVReportes implements MouseListener, WindowListener{
    private VReportes vista;
    private Usuario modelo;
    private Administrador vistAdmin= new Administrador();
    
    //Constructor
    public ControladorVReportes(VReportes vista, Usuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.jlblInicio.addMouseListener(this);
        
        vista.addWindowListener(this);
    }


    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
     @Override
    public void windowOpened(WindowEvent e) {
        vista.jlblUsuario.setText(modelo.getNombreUsuario());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblInicio){
           ControladorAdministrador controAdmin =new ControladorAdministrador(vistAdmin,modelo);
           controAdmin.iniciar();
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
