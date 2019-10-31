/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Vista.RegistroCliente;
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
            
    public ControladorRegistrarCliente(RegistroCliente regCliente) {
        this.vista = regCliente;
        
        this.vista.jtxtNombre.requestFocus();
        this.vista.btnRegistrar.setEnabled(false);
        
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.jtxtNombre.getDocument().addDocumentListener(this);
        this.vista.jtxtApellido.getDocument().addDocumentListener(this);
        this.vista.jtxtNIT.getDocument().addDocumentListener(this);
        this.vista.jlblInicio.addMouseListener(this);
        
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
                    this.vista.jtxtNombre.setText("");
                    this.vista.jtxtApellido.setText("");
                    this.vista.jtxtDPI.setText("");
                    this.vista.jtxtNIT.setText("");
                    this.vista.jtxtEmail.setText("");
                    this.vista.txtTelefono.setText("");
                    this.vista.jtxtCiudad.setText("");
                    this.vista.jtxtDireccion.setText("");
                    this.vista.btnRegistrar.setVisible(false);
                    this.vista.dispose();
                    this.JTextNit.setText(cli.getNit());
                    this.JTextCodigo.requestFocus();
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
    public void setJTxt(JTextField txtNit,JTextField txtCod){
        this.JTextNit = txtNit;
        this.JTextCodigo=txtCod;
    }
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
