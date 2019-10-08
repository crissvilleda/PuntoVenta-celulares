/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Entrada;
import Vista.RegistroEntrada;
import Vista.RegistroProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author criss
 */
public class ControladorRegistrarEntrada implements ActionListener {
    private RegistroEntrada vista;
    private Usuario modelo;
    private Entrada vistaEntrada = new Entrada();
    private RegistroProducto vistaRegistro = new RegistroProducto();
    
    public ControladorRegistrarEntrada(RegistroEntrada vista, Usuario modelo){
        this.vista= vista;
        this.modelo= modelo;
        
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        vista.jlblRecibido.setText(modelo.getNombreUsuario());
        vista.btnNuevoProducto.addActionListener(this);
        vista.btnAtras.addActionListener(this);
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevoProducto){
            ControladorRegistroProducto controladorRP = 
                    new ControladorRegistroProducto(vistaRegistro,modelo);
            controladorRP.iniciar();
            vista.dispose();
            
        }else if(ae.getSource()==vista.btnAtras){
            ControladorEntrada controladorE = new ControladorEntrada(vistaEntrada,modelo);
            controladorE.iniciar();
            vista.dispose();
            
        }
    }
}
