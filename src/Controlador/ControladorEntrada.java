/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Administrador;
import Vista.Entrada;
import Vista.RegistroEntrada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author criss
 */
public class ControladorEntrada implements ActionListener, MouseListener,
        DocumentListener{
    private Usuario modelo;
    private Entrada vista;
    private RegistroEntrada vistaNuevo = new RegistroEntrada();
    private Administrador vistaAdmin = new Administrador();
    
    public ControladorEntrada(Entrada entrada, Usuario modelo){
        this.vista = entrada;
        this.modelo = modelo;
        
        vista.btnNuevo.addActionListener(this);
        vista.jlblInicio.addMouseListener(this);
        vista.jtableEntrada.addMouseListener(this);
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.jtxtBuscar.requestFocus();
        
        
        
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevo){
            ControladorRegistrarEntrada controladorE =
                    new ControladorRegistrarEntrada(vistaNuevo,modelo);
            
            controladorE.iniciar();
            vista.dispose();
            
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
           ControladorAdministrador controladorA = 
                   new ControladorAdministrador(vistaAdmin,modelo);
           controladorA.iniciar();
           vista.dispose();
        
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
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
