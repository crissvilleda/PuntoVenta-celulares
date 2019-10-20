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
import Vista.Administrador;
import Vista.Login;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author criss
 */
public class ControladorVentas implements ActionListener, MouseListener,KeyListener,
        TableModelListener,DocumentListener{
    private Ventas vista;
    private Usuario modelo;
    private ConsultasVenta consultaVenta = new ConsultasVenta();
    private ConsultasCliente consultaCliente = new ConsultasCliente();
    private Login vistalogin = new Login();
    //registra si el jtable esta activo
    boolean active = false;

    public ControladorVentas(Ventas vista, Usuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnAgregarCarrito.addActionListener(this);
        vista.btnEliminarCarrito.addActionListener(this);
        vista.btnRealizar.addActionListener(this);
        vista.btnCerrarSesion.addActionListener(this);
        vista.jtxtNit.addKeyListener(this);
        vista.jtxtIngreseCodigo.addKeyListener(this);
        vista.jtableVentas.getModel().addTableModelListener(this);
        vista.jtxtImporte.getDocument().addDocumentListener(this);
        vista.jtableVentas.addMouseListener(this);
        vista.btnCerrarSesion.addActionListener(this);
        
        consultaVenta.siguenteIdVenta(vista.jlblIdVenta);
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        vista.jlblArtsVendidos.setText("0");
        vista.jlblCambioVenta.setText("00.00");
        vista.jlblTotal.setText("00.00");
        vista.jtxtCantidad.setText("1");
        vista.btnEliminarCarrito.setEnabled(false);
        vista.btnRealizar.setEnabled(false);
        
    }
    private void agregarProducto(){
        ConsultasProducto cp = new ConsultasProducto();
        String regProducto [] = new String[7];
        DefaultTableModel model = (DefaultTableModel)vista.jtableVentas.getModel();
        //si el registro ya existe el la tabla
        boolean existe = false;

        regProducto[1] =vista.jtxtIngreseCodigo.getText(); 
        regProducto[4] = vista.jtxtCantidad.getText();
        try{        
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
                     JOptionPane.showMessageDialog(null,"No hay producto en existencia");
                }

            }
        }catch(Exception e){}   
        vista.jtableVentas.setModel(model);
        vista.jtxtIngreseCodigo.setText("");
        vista.jtxtCantidad.setText("1");
    }
    private static TableModel calcularSubTotal(TableModel datos){
        for (int x =0; x<datos.getRowCount();x++){
            String valor = null;
            try{
                valor = String.valueOf(Integer.valueOf((String)datos.getValueAt(x, 4)) * 
                        Double.valueOf((String)datos.getValueAt(x, 5)));
            }catch(Exception e){}
            datos.setValueAt(valor, x, 6);
        
        }
        return datos;
    }
    private void calcularTotal(JLabel total){
        TableModel model = (TableModel)vista.jtableVentas.getModel();
        String valor ="0";
        for(int x=0; x<model.getRowCount();x++){
    
            try{
                double v = Double.valueOf((String)model.getValueAt(x, 6));
                valor = String.valueOf(v + Double.valueOf(valor));
                
            }catch(Exception e){}
        }
        total.setText(valor);
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnAgregarCarrito){
            agregarProducto();
        }else if(ae.getSource()==vista.btnBuscarProducto){
        
        }else if(ae.getSource()==vista.btnEliminarCarrito){
            DefaultTableModel model = (DefaultTableModel)vista.jtableVentas.getModel();
            int row = vista.jtableVentas.getSelectedRow();
            int op =JOptionPane.showConfirmDialog(null,"Desea eliminar este producto"
                    + "\nde la lista","Remover",JOptionPane.YES_NO_OPTION);
            if(op==0){
                model.removeRow(row);
            }
            vista.jtableVentas.setModel(model);
            vista.jtableVentas.clearSelection();
            
            vista.btnEliminarCarrito.setEnabled(false);
            
        }else if(ae.getSource()==vista.btnCerrarSesion){
            
            ControladorLogin controlLogin = new ControladorLogin(vistalogin);
          
            controlLogin.iniciar();
            vista.dispose();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jtableVentas){
           if(me.getClickCount()==1){
               vista.btnEliminarCarrito.setEnabled(true);
                      
           }
        }
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
                agregarProducto();
            }
        }
    }
    
    @Override
    public void tableChanged(TableModelEvent tme) {
       
        if(!active && tme.getType()==TableModelEvent.INSERT){
            active=true;
            calcularSubTotal(vista.jtableVentas.getModel());
            calcularTotal(vista.jlblTotal); 
            active=false;
        }else if(!active && tme.getType()==TableModelEvent.DELETE){
            active=true;
            calcularSubTotal(vista.jtableVentas.getModel());
            calcularTotal(vista.jlblTotal); 
            active=false;
        }else if(!active && tme.getType()==TableModelEvent.UPDATE ){
            active=true;
            calcularSubTotal(vista.jtableVentas.getModel());
            calcularTotal(vista.jlblTotal); 
            active=false;
        }
            
        
         
        
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){
            try{
                if(Double.parseDouble(vista.jtxtImporte.getText())>
                        Double.parseDouble(vista.jlblTotal.getText())){
                    vista.jlblCambioVenta.setText(String.valueOf(
                        Double.parseDouble(vista.jtxtImporte.getText())-
                                Double.parseDouble(vista.jlblTotal.getText())));
                    
                }else{
                    vista.jlblCambioVenta.setText("00.00");
                }
                
            }catch(NumberFormatException e){}
            
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){
            try{
                if(Double.parseDouble(vista.jtxtImporte.getText())>
                        Double.parseDouble(vista.jlblTotal.getText())){
                    vista.jlblCambioVenta.setText(String.valueOf(
                        Double.parseDouble(vista.jtxtImporte.getText())-
                                Double.parseDouble(vista.jlblTotal.getText())));
                    
                }else{
                    vista.jlblCambioVenta.setText("00.00");
                }
                
            }catch(Exception e){}
            
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){
            try{
                if(Double.parseDouble(vista.jtxtImporte.getText())>
                        Double.parseDouble(vista.jlblTotal.getText())){
                    vista.jlblCambioVenta.setText(String.valueOf(
                        Double.parseDouble(vista.jtxtImporte.getText())-
                                Double.parseDouble(vista.jlblTotal.getText())));
                    
                }else{
                    vista.jlblCambioVenta.setText("00.00");
                }
                    
                
            }catch(Exception e){}
            
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
