/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AppPackage.AnimationClass;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.Configuracion;
import Vista.CortedeCaja;
import Vista.Login;
import Vista.VEntrada;
import Vista.VInventario;
import Vista.VProveedor;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class ControladorAdministrador implements ActionListener, MouseListener {
    private Administrador vista;
    private Usuario modelo;
    private VUsuario vistaUsuario = new VUsuario();
    private VProveedor vistaProveedor = new VProveedor();
    private VEntrada vistaEntrada = new VEntrada();
    private Configuracion vistaConfig = new Configuracion();
    private VInventario vistaInv = new VInventario();
    private CortedeCaja vistaCorCaj= new CortedeCaja();
    
//inicializa en controlador
    public ControladorAdministrador(Administrador vista, Usuario modelo){
        this.vista = vista;
        this.modelo = modelo;
        //lee el evento al hacer clic de cada icono del menu principal
        vista.jlblConfiguracion.addMouseListener(this);
        //vista.jlblCorteCaja.addMouseListener(this);
        vista.jlblCorteCaja.addMouseListener(this);
        vista.jlblEntradas.addMouseListener(this);
        vista.jlblFacturas.addMouseListener(this);
        vista.jlblInventario.addMouseListener(this);
        vista.jlblProveedores.addMouseListener(this);
        vista.jlblReportes.addMouseListener(this);
        vista.jlblUsuarios.addMouseListener(this);
        vista.jlblMinimizar.addMouseListener(this);
        vista.btnCerrarSesion.addActionListener(this);
        vista.jlblFacturas.setEnabled(false);
        //vista.jlblCorteCaja.setEnabled(false);
        vista.jlblReportes.setEnabled(false);
        
    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //evento para el boton cerrar
        if(ae.getSource()==vista.btnCerrarSesion){
            ControladorLogin controlLigin = new ControladorLogin(new Login());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        //filtra el evento deacuedo al objeto que lo produzca
        if(me.getSource()==vista.jlblUsuarios){
            //carga el controlador de la vista usuario y activa la vista
            ControladorUsuario controladorU = 
                    new ControladorUsuario(vistaUsuario,modelo);
            controladorU.iniciar();
            vista.dispose();
            
        }else if(me.getSource()==vista.jlblProveedores){
            ControladorProveedor controladorP = 
                    new ControladorProveedor(vistaProveedor,modelo);
            controladorP.iniciar();
            vista.dispose();
            
        }else if(me.getSource()==vista.jlblEntradas){
            ControladorEntrada controladorE = 
                    new ControladorEntrada(vistaEntrada, modelo);
            controladorE.iniciar();
            vista.dispose();
        
        }else if(me.getSource()==vista.jlblInventario){
            ControladorInventario controladorInv =
                    new ControladorInventario(vistaInv,modelo);
            controladorInv.iniciar();
            vista.dispose();
        
        }else if(me.getSource()==vista.jlblReportes){
        
        }else if(me.getSource()==vista.jlblFacturas){
        
        }else if(me.getSource()==vista.jlblCorteCaja){
            ControladorCorteCaja controladorCorCaj = new ControladorCorteCaja(vistaCorCaj,modelo);
            controladorCorCaj.iniciar();
            vista.dispose();
            
        }else if(me.getSource()==vista.jlblConfiguracion){
            ControladorConfiguracion controladorC =
                    new ControladorConfiguracion(vistaConfig,modelo);
            controladorC.iniciar();
            vista.dispose();
        
        }
        
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
        
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
