/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Modelo.Usuario;
import Vista.Entrada;
import Vista.RegistroEntrada;
import Vista.RegistroProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author criss
 */
public class ControladorRegistrarEntrada implements ActionListener, KeyListener,
        TableModelListener{
    private RegistroEntrada vista;
    private Usuario modelo;
    private Entrada vistaEntrada = new Entrada();
    private RegistroProducto vistaRegistro = new RegistroProducto();
    //registra si el jtable esta activo
    boolean active = false;
    
    public ControladorRegistrarEntrada(RegistroEntrada vista, Usuario modelo){
        this.vista= vista;
        this.modelo= modelo;
        
        vista.jtxtCodigo.addKeyListener(this);
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        vista.jlblRecibido.setText(modelo.getNombreUsuario());
        vista.btnNuevoProducto.addActionListener(this);
        vista.btnAtras.addActionListener(this);
        vista.btnAgregar.addActionListener(this);
        vista.jtableNuevaEntrada.getModel().addTableModelListener(this);
        
    }
    public void agregarProducto(){
        Producto  producto = new Producto();
        DefaultTableModel model = (DefaultTableModel)vista.jtableNuevaEntrada.getModel();
        ConsultasProducto consultaP = new ConsultasProducto();
        String registro [] = new String [10];
        
        producto.setCodigo(vista.jtxtCodigo.getText());
        if(consultaP.consultar(producto)){
            registro[0]=String.valueOf(producto.getIdProducto());
            registro[1]=producto.getCodigo();
            registro[2]=producto.getNombre();
            registro[3]=producto.getDescripcion();
            registro[4]=String.valueOf(producto.getIdCategoria());
            registro[5]=String.valueOf(producto.getIdMarca());
            registro[6]="1";
            registro[7]="0";
            registro[8]="0";
            registro[9]="0";
            model.addRow(registro);
            vista.jtableNuevaEntrada.setModel(model);
            vista.jtxtCodigo.setText("");
            vista.jtxtCodigo.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null,"Este producto no esta registrado");
        }
        
    }
    
    public void calcularTotal(JLabel total){
        TableModel model = (TableModel)vista.jtableNuevaEntrada.getModel();
        String valor ="0";
        for(int x=0; x<model.getRowCount();x++){
    
            try{
                double v = Double.valueOf((String)model.getValueAt(x, 9));
                valor = String.valueOf(v + Double.valueOf(valor));
                
            }catch(Exception e){}
        }
        total.setText(valor);
        
    }
    
    public static TableModel calcularSubTotal(TableModel datos){
        for (int x =0; x<datos.getRowCount();x++){
            String valor = null;
            try{
                valor = String.valueOf(Integer.valueOf((String)datos.getValueAt(x, 6)) * 
                        Double.valueOf((String)datos.getValueAt(x, 7)));
            }catch(Exception e){}
            datos.setValueAt(valor, x, 9);
        
        }
        return datos;
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
            
        }else if(ae.getSource()==vista.btnAgregar){
            agregarProducto();
        }
    }
    
    @Override
    public void tableChanged(TableModelEvent tme) {
        if(!active && tme.getType()==TableModelEvent.UPDATE){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
        }
        
        
        
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
}
