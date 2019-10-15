/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Vista.ListaInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author criss
 */
public class ControladorListaInventario implements KeyListener, MouseListener,
        ActionListener, DocumentListener, WindowListener {
    private ListaInventario vista;
    private JTable tabla;
    private ConsultasProducto consultasP = new ConsultasProducto();
    
    public ControladorListaInventario(ListaInventario Inventario){
        this.vista=Inventario;
        
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        vista.jlblCerrar.addMouseListener(this);
        vista.jtableListaInventario.addMouseListener(this);
        vista.btnSeleccionar.addActionListener(this);
        vista.jtxtCantidad.getDocument().addDocumentListener(this);
        vista.jtxtPC.getDocument().addDocumentListener(this);
        vista.jtxtPV.getDocument().addDocumentListener(this);
        vista.jtxtCantidad.addKeyListener(this);
        vista.jtxtPC.addKeyListener(this);
        vista.jtxtPV.addKeyListener(this);
        vista.btnSeleccionar.setEnabled(false);
        vista.addWindowListener(this);
        
    }
    public void insertarTabla(JTable tabla){
        this.tabla=tabla;
        
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    

    }
     public void verificadorJtxt(){
        try{
             if(vista.jtxtCantidad.getText().length()>0 && vista.jtxtPC.getText().length()>0
                && vista.jtxtPV.getText().length()>0&&Integer.parseInt(vista.jtxtCantidad.getText())>0
                && Double.parseDouble(vista.jtxtPC.getText())< Double.parseDouble(vista.jtxtPV.getText())){
            vista.btnSeleccionar.setEnabled(true);
            
            }else{
                vista.btnSeleccionar.setEnabled(false);

            }
        }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Error - Ingrese solo datos numericos");

        }
        
    }
    
    public void agregarProducto(){
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
            try{
                for(int i = 0; i<model.getRowCount();i++){
                    if(model.getValueAt(i, 1).toString().equals(modelLista.getValueAt(row, 1))){

                        //si existe solo aumenta la cantidad del producto 
                        String valor = String.valueOf(Integer.valueOf((String)model.getValueAt(i, 6))+
                                Integer.parseInt(vista.jtxtCantidad.getText()));
                        model.setValueAt(valor, i, 6);
                        model.setValueAt(vista.jtxtPC.getText(), i, 7);
                        model.setValueAt(vista.jtxtPV.getText(),i,8);
                        model.setValueAt(String.valueOf(Integer.parseInt(vista.jtxtCantidad.getText())
                            *Double.parseDouble(vista.jtxtPC.getText())), i, 9);
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
                    registro[6] = vista.jtxtCantidad.getText();
                    registro[7] = vista.jtxtPC.getText();
                    registro[8] = String.valueOf(Double.parseDouble(vista.jtxtPV.getText()));
                    registro[9] = String.valueOf(Integer.parseInt(vista.jtxtCantidad.getText())
                        *Double.parseDouble(vista.jtxtPC.getText()));
                    model.addRow(registro);
                }
            }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Error - Ingrese solo datos numericos");

                            }
        
        this.tabla.setModel(model);
        vista.dispose();
        
    }   

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==vista.btnSeleccionar){
            if(vista.jtableListaInventario.getSelectedRow()>=0){
                agregarProducto();
                
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
               
                
        }
            
        
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
         verificadorJtxt();
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultasP.buscar(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
         verificadorJtxt();
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultasP.buscar(vista.jtableListaInventario, vista.jtxtBuscar.getText()); 
        }
        
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
         verificadorJtxt();
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
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtCantidad){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtPC.requestFocus();
                
            }
            
        }else if(ke.getSource()==vista.jtxtPC){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.jtxtPV.requestFocus();
                
            }
            
        }else if (ke.getSource()==vista.jtxtPV){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                vista.getRootPane().setDefaultButton(vista.btnSeleccionar);
                vista.btnSeleccionar.requestFocus();
                
               
            }
            
        }
    }
    
        @Override
    public void windowOpened(WindowEvent e) {
        consultasP.llenarTabla(vista.jtableListaInventario);
    }
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
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
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
