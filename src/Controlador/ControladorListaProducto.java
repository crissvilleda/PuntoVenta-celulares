/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInventario;
import Vista.ListaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorListaProducto implements DocumentListener,MouseListener,
        ActionListener{
    private ListaProducto vista;
    private JTable tabla;
    private ConsultasInventario conInv = new ConsultasInventario();
    
    public ControladorListaProducto(ListaProducto vista) {
        this.vista = vista;
        
        this.vista.jtxtBuscar.getDocument().addDocumentListener(this);
        this.vista.jlblCerrar.addMouseListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnSeleccionar.setVisible(false);
        conInv.llenarTablaInv(this.vista.jtableListaInventario);
    }
    private void agregarProducto(){
        //obtiene modelo de la tabla Lista Inventario de la vista listaInvetario
        DefaultTableModel modelLista = 
                (DefaultTableModel)vista.jtableListaInventario.getModel();
        //obtiene modelo de la tabla Ventas para agregar productos
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        //obtiene la columnna selecinada
        int row = vista.jtableListaInventario.getSelectedRow();
        boolean existe = false;
        //verifica si el producto selecionado en la tabla listaInventario
        //ya esta en la tabla Ventas de la vista Ventas
        try{
            for(int i = 0; i<model.getRowCount();i++){
                if(model.getValueAt(i, 1).toString().equals(modelLista.getValueAt(row, 1))){
                    String valor = String.valueOf(Integer.valueOf((String)model.getValueAt(i, 4))+1);
                    model.setValueAt(valor, i, 4);
                    existe=true;

                }
            }
            if(!existe){
                
                
            }
            
            
        }catch(Exception e){
            
        }
        
    }
    public void insertarTabla(JTable tabla){
        this.tabla=tabla;   
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.vista.btnSeleccionar){
            if(vista.jtableListaInventario.getSelectedRow()>=0){
                agregarProducto();
                
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
            
        }
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
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

   
    
    
}
