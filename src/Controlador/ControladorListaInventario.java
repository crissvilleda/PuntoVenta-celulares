/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Usuario;
import Vista.ListaInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorListaInventario implements MouseListener,ActionListener, DocumentListener {
    private ListaInventario vista;
    private JTable tabla;
    private ConsultasProducto consultasP = new ConsultasProducto();
    
    public ControladorListaInventario(ListaInventario Inventario){
        this.vista=Inventario;
        
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.jlblCerrar.addMouseListener(this);
        vista.jtableListaInventario.addMouseListener(this);
        vista.btnSeleccionar.addActionListener(this);
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
        
        if(ae.getSource()==vista.btnSeleccionar){
            //obtiene modelo de la tabla Lista Inventario de la vista listaInvetario
            DefaultTableModel modelLista = 
                    (DefaultTableModel)vista.jtableListaInventario.getModel();
            //obtiene modelo de la tabla NuevaEntrada de la vista RegistroEntrada
            DefaultTableModel model = (DefaultTableModel)tabla.getModel();
            //obtiene la columnna selecinada
            int row = vista.jtableListaInventario.getSelectedRow();
            boolean existe = false;
            //verifica si el producto selecionado en la tabla listaInventario
            //ya esta en la tabla NuevaEntrada de la vista RegistroEndrada
            for(int i = 0; i<model.getRowCount();i++){
                if(model.getValueAt(i, 1).toString().equals(modelLista.getValueAt(row, 1))){
                    //si existe solo aumenta la cantidad del producto 
                    String valor = String.valueOf(Integer.valueOf((String)model.getValueAt(i, 6))+1);
                    model.setValueAt(valor, i, 6);
                    existe=true;
                }
            }
            if(!existe){
                //si no existe agrega un nuevo registro en la tabla NuevaEntrada
                String registro [] = new String [10];
                registro[0] = (String)modelLista.getValueAt(row,0);
                registro[1] = (String)modelLista.getValueAt(row,1);
                registro[2] = (String)modelLista.getValueAt(row,2);
                registro[3] = (String)modelLista.getValueAt(row,3);
                registro[4] = (String)modelLista.getValueAt(row,4);
                registro[5] = (String)modelLista.getValueAt(row,5);
                registro[6] = "1";
                registro[7] = "0";
                registro[8] = "0";
                registro[9] = "0";
                model.addRow(registro);
                
            }
            
        }
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultasP.buscar(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultasP.buscar(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
        
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultasP.buscar(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblCerrar){
            vista.dispose();
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
