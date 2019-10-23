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
import javax.swing.JTextField;
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
    private ConsultasInventario conInv = new ConsultasInventario();
    private JTextField codigo;
    private JTextField cantidad;
    
    public ControladorListaProducto(ListaProducto vista) {
        this.vista = vista;
        
        this.vista.jtxtBuscar.getDocument().addDocumentListener(this);
        this.vista.jlblCerrar.addMouseListener(this);
        this.vista.btnSeleccionar.addActionListener(this);
        this.vista.btnSeleccionar.setEnabled(false);
        this.vista.jtableListaInventario.addMouseListener(this);
        conInv.llenarTablaInv(this.vista.jtableListaInventario);
    }
    private void agregarProducto(){
        //obtiene modelo de la tabla Lista Inventario de la vista listaInvetario
        DefaultTableModel modelLista = 
                (DefaultTableModel)vista.jtableListaInventario.getModel();
        //obtiene la columnna selecinada
        int row = vista.jtableListaInventario.getSelectedRow();
        this.codigo.setText(modelLista.getValueAt(row, 1).toString());
        this.cantidad.requestFocus();
        this.vista.dispose();

    }
    public void setTextField(JTextField codigo, JTextField cantidad){
        this.codigo=codigo;
        this.cantidad=cantidad;
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.vista.btnSeleccionar){
            agregarProducto();
        }
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText());
            this.vista.btnSeleccionar.setEnabled(false);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText());
            this.vista.btnSeleccionar.setEnabled(false);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            conInv.buscarProductoInv(vista.jtableListaInventario, vista.jtxtBuscar.getText());
            this.vista.btnSeleccionar.setEnabled(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jtableListaInventario){
            this.vista.btnSeleccionar.setEnabled(true);
        }
        
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
