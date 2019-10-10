/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.ConsultasCategoria;
import Modelo.ConsultasMarca;
import Modelo.ConsultasProducto;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Usuario;
import Vista.RegistroEntrada;
import Vista.RegistroProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class ControladorRegistroProducto implements ActionListener, MouseListener {
    private Usuario modelo;
    private RegistroProducto vista;
    private RegistroEntrada vistaEntrada = new RegistroEntrada();
    ConsultasMarca consultaMarca = new ConsultasMarca();
    ConsultasCategoria consultaCategoria = new ConsultasCategoria();
    ConsultasProducto consultaProducto = new ConsultasProducto();
    
    public ControladorRegistroProducto(RegistroProducto registro){
        this.vista= registro;
        
        vista.btnRegistrar.addActionListener(this);
        vista.jlblCerrar.addMouseListener(this);
        
        consultaMarca.listaMarcas(vista.jcmbMarca);
        consultaCategoria.listaCategorias(vista.jcmbCategoria);
        
    }
    public void iniciar(){
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnRegistrar){
            registrar();
            
        }
    }
    
    public void registrar(){
        Categoria categoria = new Categoria();
        Marca marca = new Marca();
        categoria.setNombre(vista.jcmbCategoria.getModel().getSelectedItem().toString());
        marca.setNombre(vista.jcmbMarca.getModel().getSelectedItem().toString());
        consultaCategoria.getIdCategoria(categoria);
        consultaMarca.getIdMarca(marca);
        Producto pro = new Producto();
        
        pro.setNombre(vista.jtxtNombre.getText());
        pro.setCodigo(vista.jtxtCodigo.getText());
        pro.setDescripcion(vista.jtxtDescripcion.getText());
        pro.setIdCategoria(categoria.getIdCategoria());
        pro.setIdMarca(marca.getIdMarca());
        
        if(consultaProducto.registrar(pro)){
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
            vista.jtxtNombre.setText("");
            vista.jtxtDescripcion.setText("");
            vista.jtxtCodigo.setText("");
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardar" );
            
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent me) {
        //if(me.getSource()==vista.jlblCerrar){
            //ControladorRegistrarEntrada controladorRE = 
                //    new ControladorRegistrarEntrada(vistaEntrada,modelo);
            //controladorRE.iniciar();
            vista.dispose();
            
            
        //}
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
