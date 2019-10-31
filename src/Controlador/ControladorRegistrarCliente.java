/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Vista.RegistroCliente;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author criss
 */
public class ControladorRegistrarCliente implements MouseListener,DocumentListener ,ActionListener {
    private RegistroCliente vista;
    private ConsultasCliente conCliente = new ConsultasCliente();
    private JTextField JTextNit;
    private JTextField JTextCodigo;
    private Cliente cliente;
    private Ventas vistaVenta;
   
            
    public ControladorRegistrarCliente(RegistroCliente regCliente,Ventas vistaVenta) {
        this.vista = regCliente;
        this.vistaVenta=vistaVenta;
        
        this.vista.jtxtNombre.requestFocus();
        this.vista.btnRegistrar.setEnabled(false);
        
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.jtxtNombre.getDocument().addDocumentListener(this);
        this.vista.jtxtApellido.getDocument().addDocumentListener(this);
        this.vista.jtxtNIT.getDocument().addDocumentListener(this);
        this.vista.jlblInicio.addMouseListener(this);
        
        this.vista.jtxtNIT.setText(this.vistaVenta.jtxtNit.getText());
        
        this.vista.jtxtNombre.setText("");
        this.vista.jtxtApellido.setText("");
        this.vista.jtxtDPI.setText("");
        this.vista.jtxtEmail.setText("");
        this.vista.txtTelefono.setText("");
        this.vista.jtxtCiudad.setText("");
        this.vista.jtxtDireccion.setText("");
        this.vista.btnRegistrar.setEnabled(false);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnRegistrar){
            try{
                Cliente cli = new Cliente();
                cli.setNombre(this.vista.jtxtNombre.getText());
                cli.setApellido(this.vista.jtxtApellido.getText());
                cli.setNit(this.vista.jtxtNIT.getText());
                cli.setDpi(this.vista.jtxtDPI.getText());
                cli.setTelefono(this.vista.txtTelefono.getText());
                cli.setEmail(this.vista.jtxtEmail.getText());
                cli.setCiudad(this.vista.jtxtCiudad.getText());
                cli.setDireccion(this.vista.jtxtDireccion.getText());
                if(conCliente.registrar(cli)){
                    this.vistaVenta.jtxtNombre.setText(cli.getNombre());
                    this.vistaVenta.jtxtApellido.setText(cli.getApellido());
                    this.vistaVenta.jtxtDpi.setText(cli.getDpi());
                    this.vistaVenta.jtxtNit.setText(cli.getNit());
                    this.vistaVenta.jtxtIdCliente.setText(String.valueOf(cli.getIdCliente()));
                    this.vistaVenta.jtxtNit.requestFocus();
                    this.vistaVenta.jtxtNombre.setEditable(false);
                    this.vistaVenta.jtxtApellido.setEditable(false);
                    this.vistaVenta.jtxtDpi.setEditable(false);
                    this.vista.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Error al registar al cliente");
                }
                
                
            }catch(Exception e){
                System.err.println(e);
            }
            
        }
    }
    
    
    private void verificarJtxt(){
        if(this.vista.jtxtNIT.getText().length()>0 && this.vista.jtxtNombre.getText().length()>0 
                && this.vista.jtxtApellido.getText().length() >0){
            this.vista.btnRegistrar.setEnabled(true);
        }else{
            this.vista.btnRegistrar.setEnabled(false);
        }
        
    }
    /*public void setJTxt(Ventas venta){
       this.vistaVenta=venta;
       vista
    }
*/
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        verificarJtxt();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        verificarJtxt();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        verificarJtxt();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            this.vista.dispose();
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
