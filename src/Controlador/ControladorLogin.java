/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Vista.Login;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class ControladorLogin implements ActionListener {
    private Login vista;
    private Usuario modelo;
    private ConsultasUsuario consulta = new ConsultasUsuario();
    
    
    
    
    public ControladorLogin(Login vista, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        //lee el evento del boton
        vista.btnIniciarSesion.addActionListener((ActionEvent ae) -> {
            //obtiene la informacion para poder iniciar session
            modelo.setNombreUsuario(vista.jtxtUsuario.getText());
            modelo.setContraseña(vista.jPassword.toString());
            //verifica existe el usuario
            if(consulta.iniciarSesion(modelo)){
                //ingreso exitoso       
                JOptionPane.showMessageDialog(null,"Ingreso Exitoso");
            }else{
                //usuario no existe
                JOptionPane.showMessageDialog(null,"Nombre de usuario o contraseña");
                vista.jtxtUsuario.setText("");
                vista.jPassword.setText("");
                
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
           }
    
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
 

    
    
    
}
