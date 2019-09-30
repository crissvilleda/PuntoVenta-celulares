/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Administrador;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author criss
 */
public class ControladorUsuario implements ActionListener, MouseListener {
    private VUsuario vista;
    private Usuario  modelo;
    private Administrador vistaAdmin = new Administrador();
    
    public ControladorUsuario(VUsuario vista,Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        vista.jlblInicio.addMouseListener(this);
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
