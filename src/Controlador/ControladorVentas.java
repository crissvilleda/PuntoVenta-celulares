/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConsultasCliente;
import Modelo.ConsultasProducto;
import Modelo.ConsultasVenta;
import Modelo.Producto;
import Modelo.Usuario;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorVentas implements ActionListener, MouseListener,KeyListener {
    private Ventas vista;
    private Usuario modelo;
    private ConsultasVenta consultaVenta = new ConsultasVenta();
    private ConsultasCliente consultaCliente = new ConsultasCliente();

    public ControladorVentas(Ventas vista, Usuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnAgregarCarrito.addActionListener(this);
        vista.btnEliminarCarrito.addActionListener(this);
        vista.btnRealizar.addActionListener(this);
        vista.btnCerrarSesion.addActionListener(this);
        vista.jtxtNit.addKeyListener(this);
        vista.jtxtIngreseCodigo.addKeyListener(this);
        
        consultaVenta.siguenteIdVenta(vista.jlblIdVenta);
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        vista.jlblArtsVendidos.setText("0");
        vista.jlblCambioVenta.setText("00.00");
        vista.jlblTotal.setText("00.00");
        vista.jtxtCantidad.setText("1");
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtNit){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                Cliente cliente = new Cliente();
                cliente.setNit(vista.jtxtNit.getText());
                if(consultaCliente.consultar(cliente)){
                    vista.jtxtNombre.setText(cliente.getNombre());
                    vista.jtxtApellido.setText(cliente.getApellido());
                    vista.jtxtNit.setText(cliente.getNit());
                    vista.jtxtDpi.setText(cliente.getDpi());
                    vista.jtxtIngreseCodigo.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"CLiente no existe");
                    vista.jtxtNombre.setText("");
                    vista.jtxtApellido.setText("");
                    vista.jtxtNit.setText(cliente.getNit());
                    vista.jtxtDpi.setText("");
                    
                }
                
            }
        }else if (ke.getSource()==vista.jtxtIngreseCodigo){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                ConsultasProducto cp = new ConsultasProducto();
                String regProducto [] = new String[7];
                DefaultTableModel model = (DefaultTableModel)vista.jtableVentas.getModel();
                //si el registro ya existe el la tabla
                boolean existe = false;
                
                regProducto[1] =vista.jtxtIngreseCodigo.getText(); 
                regProducto[4] = vista.jtxtCantidad.getText();
                        
                for(int i=0; i<model.getRowCount();i++){
                    if(model.getValueAt(i, 1).toString().equals(regProducto[1])){
                        regProducto[4]=String.valueOf(Integer.parseInt((String)
                                model.getValueAt(i, 4))+Integer.parseInt(regProducto[4]));
                        existe =true;
                        if(cp.verificarExistencia(regProducto)){
                            model.setValueAt(regProducto[4], i, 4);
                            
                        }else{
                            JOptionPane.showMessageDialog(null,"Existencia insuficiente");
                          
                        }   
                    }
                    
                }
                    
                if(!existe){
                    if(cp.verificarExistencia(regProducto)){
                        model.addRow(regProducto);
                    }else{
                        System.out.print("no hay suficiente en el sistema");
                    }

                }
                vista.jtableVentas.setModel(model);
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        
        
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
    public void keyReleased(KeyEvent ke) {
    }
    
    
}
