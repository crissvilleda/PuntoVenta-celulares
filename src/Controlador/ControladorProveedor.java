/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProveedor;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.RegistroProveedor;
import Vista.VProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorProveedor implements ActionListener, MouseListener,
        WindowListener,DocumentListener{
    private VProveedor vista ;
    private Usuario modelo;
    private RegistroProveedor vistaRegistro = new RegistroProveedor();
    private ConsultasProveedor consulta = new ConsultasProveedor();
    private Administrador vistaAdmin = new Administrador();



    public ControladorProveedor(VProveedor vista,Usuario modelo){
        this.vista= vista;
        this.modelo = modelo;
        vista.btnEliminar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.jlblInicio.addMouseListener(this);
        vista.jtableProveedor.addMouseListener(this);
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.addWindowListener(this);
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==vista.btnNuevo){
            ControladorRegistrarProveedor controlador = 
                    new ControladorRegistrarProveedor(vistaRegistro,modelo);
            controlador.iniciar();
            vista.dispose();
            
            
        }else if(ae.getSource()==vista.btnEliminar){
            //metodo elimiar usuarios
            Proveedor pro = new Proveedor();
            int row = vista.jtableProveedor.getSelectedRow();
            pro.setIdProveedor(Integer.parseInt((String) 
                    vista.jtableProveedor.getModel().getValueAt(row,0)));
            int result=JOptionPane.showConfirmDialog(null, "Desea eliminar proveedor?","Exit",JOptionPane.YES_NO_OPTION);
            if (result==0){
                if(consulta.eliminar(pro)){
                ((DefaultTableModel)vista.jtableProveedor.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(null,"Proveedor Eliminado");
                vista.btnEliminar.setEnabled(false);
                vista.btnModificar.setEnabled(false);
                
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                }
         
            
            }
            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            ControladorAdministrador controlador = 
                    new ControladorAdministrador(vistaAdmin,modelo);
            controlador.iniciar();
            vista.dispose();
        }else if(me.getSource()==vista.jtableProveedor){
            if(me.getClickCount()==1){
                vista.btnEliminar.setEnabled(true);
                vista.btnModificar.setEnabled(true);
                
            }else if(me.getClickCount()==2){
                vista.jtableProveedor.clearSelection();
                vista.btnEliminar.setEnabled(false);
                vista.btnModificar.setEnabled(true);
                
            }
            
        }
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        vista.jlblUsuario.setText(modelo.getNombreUsuario());
        consulta.listaProveedores(vista.jtableProveedor);
        vista.btnEliminar.setEnabled(false);
        vista.btnModificar.setEnabled(false);
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableProveedor, vista.jtxtBuscar.getText());
        }
    }
    

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableProveedor, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consulta.consultar(vista.jtableProveedor, vista.jtxtBuscar.getText());
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
