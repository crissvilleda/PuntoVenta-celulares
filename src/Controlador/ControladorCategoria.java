/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.ConsultasCategoria;
import Modelo.Marca;
import Modelo.Usuario;
import Vista.Configuracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Orlando
 */
public class ControladorCategoria implements ActionListener,MouseListener,KeyListener{
    private Categoria categoria;
    private Configuracion vista;
    private Usuario modelo;
   // private VProveedor vistaProveedor = new VProveedor();
    private ConsultasCategoria consulta= new ConsultasCategoria();
    
    public ControladorCategoria(Configuracion vista, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        vista.jlblInicio.addMouseListener(this);
        vista.jtxtCategoria.addKeyListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        
        
        
        vista.btnGuardar.setEnabled(false);
        vista.jtxtCategoria.requestFocus();
        
    }
    public ControladorCategoria(Configuracion vista,Categoria cat, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.categoria = cat;
        vista.jlblInicio.addMouseListener(this);
        
        vista.jtxtCategoria.addKeyListener(this);
        vista.btnGuardar.addActionListener((ActionEvent)->{
            Modificar(); 
        });
        
        vista.jtxtCategoria.setText(cat.getNombre());
        
        vista.btnGuardar.setEnabled(false);
        
    }
    
    
    public void registrar(){
        Categoria cat = new Categoria();
        cat.setNombre(vista.jtxtCategoria.getText());


        if(consulta.registrar(cat)){
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            vista.jtxtCategoria.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
        
    }
    public void Modificar(){
        categoria.setNombre(vista.jtxtCategoria.getText());
        if(consulta.modificar(categoria)){
            JOptionPane.showMessageDialog(null,"Modificacion Exitosa");
            vista.btnGuardar.setEnabled(false);

        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
        
    }

    //verifica si cada una de las cajas de texto no estan vacias
    public void verificarLabels(){
        if(vista.jtxtCategoria.getText().length()>0){
            vista.btnGuardar.setEnabled(true);
        }else{
            vista.btnGuardar.setEnabled(false);
        }
            
        }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
       
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnGuardar){
            registrar();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
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
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
    
}
