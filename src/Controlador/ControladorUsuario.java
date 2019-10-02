/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.RegistroUsuario;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentListener;

/**
 *
 * @author criss
 */
public class ControladorUsuario implements ActionListener, MouseListener, 
        WindowListener,DocumentListener  {
    private VUsuario vista;
    private Usuario  modelo;
    private Administrador vistaAdmin = new Administrador();
    private RegistroUsuario vistaRegistro = new RegistroUsuario();
    private ConsultasUsuario consulta = new ConsultasUsuario();
    
    public ControladorUsuario(VUsuario vista,Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.jtableUsuario.addMouseListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.jlblInicio.addMouseListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.addWindowListener(this);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevo){
            ControladorRegistroUsuario controlador = 
                    new ControladorRegistroUsuario(vistaRegistro,modelo);
            controlador.iniciar();
            vista.dispose();
        }else if(ae.getSource()==vista.btnEliminar){
            //metodo elimiar usuarios
            Usuario usu = new Usuario();
            int row = vista.jtableUsuario.getSelectedRow();
            usu.setIdUsuario(Integer.parseInt((String) 
                    vista.jtableUsuario.getModel().getValueAt(row,0)));
            int result=JOptionPane.showConfirmDialog(null, "Desea eliminar este Usuario?","Exit",JOptionPane.YES_NO_OPTION);
            if (result==0){
                if(consulta.eliminar(usu)){
                ((DefaultTableModel)vista.jtableUsuario.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(null,"Usuario Eliminado");
                vista.btnEliminar.setEnabled(false);
                vista.btnModificar.setEnabled(false);
                
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                }
         
            
            } 
        }
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
  
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            ControladorAdministrador controlador = 
                    new ControladorAdministrador(vistaAdmin,modelo);
            controlador.iniciar();
            vista.dispose();
            
        }else if(me.getSource()==vista.jtableUsuario){
            vista.btnEliminar.setEnabled(true);
            vista.btnModificar.setEnabled(true);
            if(me.getClickCount()==2){
                vista.jtableUsuario.clearSelection();
                vista.btnModificar.setEnabled(false);
                vista.btnEliminar.setEnabled(false);
            }
            
        }
    }
    @Override
    public void windowOpened(WindowEvent we) {
        consulta.listaUsuarios(vista.jtableUsuario);
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        vista.btnEliminar.setEnabled(false);
        vista.btnModificar.setEnabled(false);
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableUsuario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableUsuario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableUsuario, vista.jtxtBuscar.getText());
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
