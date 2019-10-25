/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasDetalleEntrada;
import Modelo.ConsultasEntrada;
import Modelo.ConsultasInventario;
import Modelo.ConsultasProducto;
import Modelo.ConsultasProveedor;
import Modelo.DetalleEntrada;
import Modelo.Entrada;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vista.CantPrecioEnt;
import Vista.ListaInventario;
import Vista.VEntrada;
import Vista.RegistroEntrada;
import Vista.RegistroProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import javax.swing.JFrame;
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
        TableModelListener,MouseListener{
    private RegistroEntrada vista;
    private Usuario modelo;
    private VEntrada vistaEntrada = new VEntrada();
    private RegistroProducto vistaRegistro = new RegistroProducto();
    private ConsultasEntrada consultaE = new ConsultasEntrada();
    private ConsultasProveedor consultaP = new ConsultasProveedor();
    private ControladorRegistroProducto controladorRP = 
                    new ControladorRegistroProducto(vistaRegistro);
    
   
    
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
        vista.btnBuscar.addActionListener(this);
        vista.jtableNuevaEntrada.getModel().addTableModelListener(this);
        vista.btnComprar.addActionListener(this);
        vista.btnElimdeCarr.addActionListener(this);
        vista.btnElimdeCarr.setEnabled(false);
        vista.btnComprar.setEnabled(false);
        vista.jtableNuevaEntrada.addMouseListener(this);
        siguienteId(vista.jlblNoEntrada);
        //carga lista de proveedores
        vista.jcmbProveedor.addItem("");
        consultaP.listaProveedores(vista.jcmbProveedor);
        vista.jtxtCodigo.requestFocus();
    }
    public void agregarProducto(){
        Producto  producto = new Producto();
        DefaultTableModel model = (DefaultTableModel)vista.jtableNuevaEntrada.getModel();
        ConsultasProducto consultaP = new ConsultasProducto();

        
        boolean existe = false;
        String regProducto [] = new String[6];
        regProducto[1]= vista.jtxtCodigo.getText();
        if(consultaP.consultar(regProducto)){
            for(int i = 0; i<model.getRowCount();i++){
                if(model.getValueAt(i, 1).toString().equals(producto.getCodigo())){
                    String valor = String.valueOf(Integer.valueOf((String)model.getValueAt(i, 6))+1);
                    model.setValueAt(valor, i, 6);
                    existe=true;
                }
            }
            if(!existe){
                try{
                    CantPrecioEnt panel = new CantPrecioEnt();
                    ControladorCantPrecioEnt control = new ControladorCantPrecioEnt(panel);
                    control.inciar();
                    control.insertarProducto(vista.jtableNuevaEntrada, regProducto);
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al agregar producto");
                }
                
                
            }
            
            vista.jtableNuevaEntrada.setModel(model);
            vista.jtxtCodigo.setText("");
            vista.jtxtCodigo.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null,"Este producto no esta registrado");
        }
        
    }
    public void siguienteId(JLabel id){
        Entrada entrada = new Entrada();
        if(consultaE.siguenteIdEntrada(entrada)){
            id.setText(String.valueOf(entrada.getIdEntrada()));
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
    
    public void realizarCompra(){
       //***********Obejtos de la compra **************
        Entrada entrada = new Entrada();
        Proveedor proveedor = new Proveedor();
        Inventario inventario = new Inventario();
        ConsultasInventario consultasInv = new ConsultasInventario();
        DetalleEntrada detalleEntrada = new DetalleEntrada();
        ConsultasDetalleEntrada consultasDetEntrada = new ConsultasDetalleEntrada();
        try{
            //***********Datos de compra **************
            //obtenemos el id del proveedor, deacuedo al seleccionado en el jcombox
            proveedor.setNombre(vista.jcmbProveedor.getModel().getSelectedItem().toString());
            if(consultaP.getId(proveedor)){
                //agregamos el id del proveedor a nuestra clase entrada
                entrada.setIdProveedor(proveedor.getIdProveedor());
            }
            //agregamos informacion necesaria a la clase entrada
            entrada.setIdEntrada(Integer.parseInt(vista.jlblNoEntrada.getText()));
            entrada.setIdUsuario(modelo.getIdUsuario());
            //registro el momento de la compra(fecha y hora)
            long now = System.currentTimeMillis();
            Timestamp sqlTimestamp = new Timestamp(now);
            entrada.setFechaCompra(sqlTimestamp);
            entrada.setTotal(Double.parseDouble(vista.jlblTotal.getText()));
            //registramos la venta
            consultaE.registrar(entrada);


            //Obtenemos el modelo de la tabla para recorrerla y guardar los datos de cada una
            DefaultTableModel model = (DefaultTableModel)vista.jtableNuevaEntrada.getModel();
            for(int i=0; i<model.getRowCount(); i++){

                //***********Datos detalle venta *********
                detalleEntrada.setIdCompra(entrada.getIdEntrada());
                detalleEntrada.setIdProducto(Integer.parseInt((String)model.getValueAt(i, 0)));
                detalleEntrada.setnActiculo(Integer.parseInt((String)model.getValueAt(i, 6)));
                detalleEntrada.setPrecioCompra(Double.parseDouble((String)model.getValueAt(i, 7)));
                detalleEntrada.setSubtotal(Double.parseDouble((String)model.getValueAt(i, 9)));
                //registro del detalle venta
                consultasDetEntrada.registrar(detalleEntrada);

                //***********Datos Inventario*************
                inventario.setIdProducto(Integer.parseInt((String)model.getValueAt(i, 0)));
                inventario.setnArticulo(Integer.parseInt((String)model.getValueAt(i, 6)));
                inventario.setPrecioCompra(Double.parseDouble((String)model.getValueAt(i, 7)));
                inventario.setPrecioVenta(Double.parseDouble((String)model.getValueAt(i, 8)));
                //registro del inventario
                consultasInv.registrar(inventario);
            }
            JOptionPane.showMessageDialog(null,"Registro de Entrada Exitoso");
            //limpio tabla
            while(model.getRowCount()>0){
                model.removeRow(0);

            }


            vista.jtableNuevaEntrada.setModel(model);
            vista.jlblTotal.setText("0000.00");
            siguienteId(vista.jlblNoEntrada);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al Guardar la Compra\n"+e);
        }       

    }
    
    
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevoProducto){
            controladorRP.iniciar();
            
        }else if(ae.getSource()==vista.btnAtras){
            
            if(Double.parseDouble(this.vista.jlblTotal.getText())>0){
                int op = JOptionPane.showConfirmDialog(null,"Hay productos en la lista"
                        + " ¿Desea salir?\nperdera la informacion ya ingresada",
                        "Alerta",JOptionPane.YES_NO_OPTION);
                if(op==0){
                    ControladorEntrada controladorE = new ControladorEntrada(vistaEntrada,modelo);
                    controladorE.iniciar();
                    vista.dispose();
                    
                }

            }else{
                ControladorEntrada controladorE = new ControladorEntrada(vistaEntrada,modelo);
                controladorE.iniciar();
                vista.dispose();

            }
            
            
            
            
        }else if(ae.getSource()==vista.btnAgregar){
            agregarProducto();
        }else if(ae.getSource()==vista.btnElimdeCarr){
            DefaultTableModel model = (DefaultTableModel)vista.jtableNuevaEntrada.getModel();
            int result=JOptionPane.showConfirmDialog(null, "Desea quitar este producto de "
                    + "la lista","Alerta",JOptionPane.YES_NO_OPTION);
            if (result==0){
                model.removeRow(vista.jtableNuevaEntrada.getSelectedRow());
                vista.jtableNuevaEntrada.setModel(model);
            }
            vista.jtableNuevaEntrada.clearSelection();
            vista.btnElimdeCarr.setEnabled(false);

        }else if(ae.getSource()==vista.btnBuscar){
            ListaInventario vistaLista = new ListaInventario();
            ControladorListaInventario controladorInv = 
                new ControladorListaInventario(vistaLista);
            controladorInv.insertarTabla(vista.jtableNuevaEntrada);
            controladorInv.iniciar();
            
        }else if(ae.getSource()==vista.btnComprar){
            if(vista.jcmbProveedor.getModel().getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null,"Selecione un proveedor para continuar");
            }else{
                realizarCompra();
                vista.jcmbProveedor.setSelectedIndex(0);
            }
            
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
            if(Double.parseDouble(vista.jlblTotal.getText())>0){
                vista.btnComprar.setEnabled(true);
                
            }else{
                vista.btnComprar.setEnabled(false);
            }
        }else if(!active &&tme.getType()==TableModelEvent.INSERT){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
            if(Double.parseDouble(vista.jlblTotal.getText())>0){
                vista.btnComprar.setEnabled(true);
                
            }else{
                vista.btnComprar.setEnabled(false);
            }
        }else if(!active &&tme.getType()==TableModelEvent.DELETE){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
            if(Double.parseDouble(vista.jlblTotal.getText())>0){
                vista.btnComprar.setEnabled(true);
                
            }else{
                vista.btnComprar.setEnabled(false);
            }
        }
        
        
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtCodigo){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                if(!vista.jtxtCodigo.getText().equals("")){
                    agregarProducto();
                }
            }
        }
        
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jtableNuevaEntrada){
            if(me.getClickCount()==1){
                vista.btnElimdeCarr.setEnabled(true);
            }
        
    }
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

    
}
