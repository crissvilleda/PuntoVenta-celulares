/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInventario;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.VInventario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author criss
 */
public class ControladorInventario implements MouseListener, DocumentListener{
    private VInventario vista ;
    private Usuario modelo;
    private ConsultasInventario consultaInv = new ConsultasInventario();
    private Administrador vistaAdmin = new Administrador();
    
    public ControladorInventario(VInventario v, Usuario m){
        this.vista = v;
        this.modelo = m;
        vista.jlblInicio.addMouseListener(this);
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        consultaInv.tablaInventario(vista.jtableInventario);
        vista.jlblUsuario.setText(modelo.getNombreUsuario());
       
        
    }

    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
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
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.consultar(vista.jtableInventario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.consultar(vista.jtableInventario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.consultar(vista.jtableInventario, vista.jtxtBuscar.getText());
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
