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
import Modelo.Usuario;
import Modelo.Venta;
import Vista.ListaProducto;
import Vista.Login;
import Vista.RegistroCliente;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class ControladorVentas implements WindowListener, ActionListener, MouseListener,KeyListener,
        TableModelListener,DocumentListener, FocusListener{
    private Ventas vista;
    private Usuario modelo;
    public Cliente cliente = null;
    private ListaProducto vistaListaPro = new ListaProducto();
    private ConsultasVenta consultaVenta = new ConsultasVenta();
    private ConsultasCliente consultaCliente = new ConsultasCliente();
    private Login vistaLogin = new Login();
    private RegistroCliente vistaCliente = new RegistroCliente();
    //registra si el jtable esta activo
    boolean active = false;

    public ControladorVentas(Ventas vista, Usuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnAgregarCarrito.addActionListener(this);
        this.vista.btnEliminarCarrito.addActionListener(this);
        this.vista.btnRealizar.addActionListener(this);
        this.vista.jtxtNit.addKeyListener(this);
        this.vista.jtxtIngreseCodigo.addKeyListener(this);
        this.vista.jtableVentas.getModel().addTableModelListener(this);
        this.vista.jtxtImporte.getDocument().addDocumentListener(this);
        this.vista.jtableVentas.addMouseListener(this);
        this.vista.lblSalir.addMouseListener(this);
        this.vista.btnBuscarProducto.addActionListener(this);
        this.vista.jtxtNit.addFocusListener(this);
        this.vista.jtxtImporte.addFocusListener(this);
        consultaVenta.siguenteIdVenta(vista.jlblIdVenta);
        this.vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        this.vista.jlblArtsVendidos.setText("0");
        this.vista.jlblCambioVenta.setText("00.00");
        this.vista.jlblTotal.setText("00.00");
        this.vista.jtxtCantidad.setText("1");
        this.vista.jtxtImporte.setText("0");
        this.vista.btnEliminarCarrito.setEnabled(false);
        this.vista.btnRealizar.setEnabled(false);
        this.vista.jtxtNit.setText("C/F");
        this.vista.jtxtNit.requestFocus();
        
    }
    private void agregarProducto(){
        ConsultasProducto cp = new ConsultasProducto();
        String regProducto [] = new String[8];
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
                valor = String.valueOf(Integer.parseInt((String)datos.getValueAt(x, 4)) * 
                        Double.parseDouble((String)datos.getValueAt(x, 6)));
            }catch(Exception e){}
            datos.setValueAt(valor, x, 7);
        
        }
        return datos;
    }
    private void calcularTotales(){
        try{
            TableModel model = (TableModel)vista.jtableVentas.getModel();
            //total productos
            int totalProducto=0;
            //total de venta
            double totalVenta=0;
            //importe
            double importe=Double.parseDouble(this.vista.jtxtImporte.getText());
            //cambio
            double cambio =0;
            for(int x=0; x<model.getRowCount();x++){
                try{
                    int vP = Integer.parseInt((String)model.getValueAt(x, 4));
                    totalProducto = vP + totalProducto;
                    double vT = Double.valueOf((String)model.getValueAt(x, 7));
                    totalVenta = vT + totalVenta;

                }catch(Exception e){}
            }
            cambio = importe-totalVenta;
            this.vista.jlblArtsVendidos.setText(String.valueOf(totalProducto));
            this.vista.jlblTotal.setText(String.valueOf(totalVenta));
            if(importe>=totalVenta && totalProducto>0){
                this.vista.jlblCambioVenta.setText(String.valueOf(cambio));
                this.vista.btnRealizar.setEnabled(true);
            }else{
                this.vista.jlblCambioVenta.setText("00.00");
                this.vista.btnRealizar.setEnabled(false);
            }
        }catch(NumberFormatException ex){}
    }
    
    private Double calcularTotalCompra(){
        TableModel model = (TableModel)vista.jtableVentas.getModel();
        Double valor = 0.0;
        for(int x=0; x<model.getRowCount();x++){
    
            try{
                double v = Double.parseDouble((String)model.getValueAt(x, 4))*
                        Double.parseDouble((String)model.getValueAt(x, 5));
                valor = valor + v;
                
            }catch(Exception e){}
        }
        return valor;
 
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }
    private void realizarVentaTransaccion(){
        try{
            Venta venta = new Venta();
            long now = System.currentTimeMillis();
            Timestamp sqlTimestamp = new Timestamp(now);
            
            if(this.cliente == null){
                venta.setIdCliente(1);
            }else{
                venta.setIdCliente(this.cliente.getIdCliente());
            }
            venta.setIdUsuario(modelo.getIdUsuario());
            venta.setFecha(sqlTimestamp);
            venta.setnArticulo(Integer.parseInt(this.vista.jlblArtsVendidos.getText()));
            venta.setTotaCompra(calcularTotalCompra());
            venta.setTotalVenta(Double.parseDouble(this.vista.jlblTotal.getText()));
            if(consultaVenta.registrar(this.vista.jtableVentas,venta)){
                String totalVenta = this.vista.jlblTotal.getText();
                String importe = this.vista.jtxtImporte.getText();
                String cambio = this.vista.jlblCambioVenta.getText();
                vista.jtxtNombre.setEditable(true);
                this.vista.jtxtApellido.setEditable(true);
                this.vista.jtxtDpi.setEditable(true);
                this.vista.jtxtNombre.setText("");
                this.vista.jtxtApellido.setText("");
                this.vista.jtxtDpi.setText("");
                this.vista.jtxtNit.setText("");
                this.vista.jtxtImporte.setText("0");
                this.vista.jlblArtsVendidos.setText("0");
                this.vista.jlblCambioVenta.setText("00.00");
                this.vista.jlblTotal.setText("00.00");
                this.vista.jtxtCantidad.setText("1");
                this.vista.jtxtNit.setText("C/F");
                this.cliente = null;
                consultaVenta.siguenteIdVenta(vista.jlblIdVenta);
                this.vista.btnEliminarCarrito.setEnabled(false);
                this.vista.btnRealizar.setEnabled(false);
                //limpio tabla
                DefaultTableModel model =(DefaultTableModel)this.vista.jtableVentas.getModel();
                while(model.getRowCount()>0){
                    model.removeRow(0);
                }
                this.vista.jtableVentas.setModel(model);
                
                JOptionPane.showMessageDialog(null,"\nVenta Exitosa\nTotal Venta: "+totalVenta
                +"\nImporte: "+importe+"\nCambio: "+cambio);


            }else{
                JOptionPane.showMessageDialog(null,"Error al guardar la venta\n"
                + "Informe al servicio tecnico de inmediato,Gracias");

            }
        }catch(SQLException ex){
            System.err.println(ex);

        }
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnAgregarCarrito){
            agregarProducto();
        }else if(ae.getSource()==vista.btnBuscarProducto){
            ControladorListaProducto controlLista = new ControladorListaProducto(vistaListaPro);
            controlLista.setTextField(vista.jtxtIngreseCodigo, vista.jtxtCantidad);
            controlLista.iniciar();
        
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
            
        }else if(ae.getSource()==this.vista.btnRealizar){
            realizarVentaTransaccion();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jtableVentas){
           if(me.getClickCount()==1){
               vista.btnEliminarCarrito.setEnabled(true);
                      
           }
        }else if(me.getSource()==vista.lblSalir){
            
            if(Integer.parseInt(this.vista.jlblArtsVendidos.getText())>0){
                int op = JOptionPane.showConfirmDialog(null,"Hay productos en la lista"
                        + " ¿Desea salir?\nperdera la informacion ya ingresada",
                        "Alerta",JOptionPane.YES_NO_OPTION);
                if(op==0){
                    ControladorLogin controlLogin = new ControladorLogin(vistaLogin);
                    controlLogin.iniciar();
                    vista.dispose();
                    
                }

            }else{
                ControladorLogin controlLogin = new ControladorLogin(vistaLogin);
                controlLogin.iniciar();
                vista.dispose();

            }

        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtNit){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                Cliente cli = new Cliente();
                cli.setNit(vista.jtxtNit.getText());
                if(consultaCliente.consultar(cli)){
                    this.cliente=cli;
                    vista.jtxtNombre.setText(cliente.getNombre());
                    vista.jtxtApellido.setText(cliente.getApellido());
                    vista.jtxtNit.setText(cliente.getNit());
                    vista.jtxtDpi.setText(cliente.getDpi());
                    vista.jtxtIngreseCodigo.requestFocus();
                    vista.jtxtNombre.setEditable(false);
                    vista.jtxtApellido.setEditable(false);
                    vista.jtxtDpi.setEditable(false);
                }else{
                    int op = JOptionPane.showConfirmDialog(null,"Cliente no existe"
                            + "\n¿Desea registrarlo?","Alerta",JOptionPane.YES_NO_OPTION);
                    if(op==0){
                        vista.jtxtNombre.setText("");
                        vista.jtxtApellido.setText("");
                        vista.jtxtDpi.setText("");
                        this.cliente=null;
                        ControladorRegistrarCliente regCliente = 
                                new ControladorRegistrarCliente(vistaCliente);
                        regCliente.setJTxt(vista.jtxtNit, vista.jtxtNombre, 
                                vista.jtxtApellido, vista.jtxtDpi, vista.jtxtIngreseCodigo);
                        regCliente.iniciar();
                        
                        
                    }else{
                        vista.jtxtNombre.setText("");
                        vista.jtxtApellido.setText("");
                        vista.jtxtDpi.setText("");
                        vista.jtxtNit.setText("");
                        vista.jtxtNombre.setEditable(true);
                        vista.jtxtApellido.setEditable(true);
                        vista.jtxtDpi.setEditable(true);
                        vista.jtxtIngreseCodigo.requestFocus();
                        
                    }
                 
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
            calcularTotales(); 
            active=false;
        }else if(!active && tme.getType()==TableModelEvent.DELETE){
            active=true;
            calcularSubTotal(vista.jtableVentas.getModel());
            calcularTotales(); 
            active=false;
        }else if(!active && tme.getType()==TableModelEvent.UPDATE ){
            active=true;
            calcularSubTotal(vista.jtableVentas.getModel());
            calcularTotales(); 
            active=false;
        }
            
        
         
        
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){
            calcularTotales();
        }
           
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){
            calcularTotales();
        }
           
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtImporte.getDocument()){     
            calcularTotales();

        }
    }
    @Override
    public void focusGained(FocusEvent fe) {
        if(fe.getSource()==this.vista.jtxtNit){
            this.vista.jtxtNit.setText("");
        }else if(fe.getSource()==this.vista.jtxtImporte){
            this.vista.jtxtImporte.setText("");
            
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if(fe.getSource()==this.vista.jtxtNit){
            if(this.vista.jtxtNit.getText().equals("")){
                this.vista.jtxtNit.setText("C/F");
                vista.jtxtNombre.setText("");
                vista.jtxtApellido.setText("");
                vista.jtxtDpi.setText("");
                vista.jtxtNombre.setEditable(true);
                vista.jtxtApellido.setEditable(true);
                vista.jtxtDpi.setEditable(true);

            }
        }else if(fe.getSource()==this.vista.jtxtImporte){
            if(this.vista.jtxtImporte.getText().equals("")){
                this.vista.jtxtImporte.setText("0");
            }
        }
    }
    @Override
    public void windowActivated(WindowEvent we) {
        if(!vista.jtxtNit.getText().equals("")){
            Cliente cli = new Cliente();
            cli.setNit(vista.jtxtNit.getText());
            if(consultaCliente.consultar(cli)){
                this.cliente=cli;
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

    @Override
    public void windowOpened(WindowEvent we) {
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
    public void windowDeactivated(WindowEvent we) {
    }

    
    
    
}
