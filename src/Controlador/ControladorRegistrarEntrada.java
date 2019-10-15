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
        TableModelListener{
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
        siguienteId(vista.jlblNoEntrada);
        //carga lista de proveedores
        consultaP.listaProveedores(vista.jcmbProveedor);
        
    }
    public void agregarProducto(){
        Producto  producto = new Producto();
        DefaultTableModel model = (DefaultTableModel)vista.jtableNuevaEntrada.getModel();
        ConsultasProducto consultaP = new ConsultasProducto();
        String registro [] = new String [10];
        
        boolean existe = false;
        producto.setCodigo(vista.jtxtCodigo.getText());
        
        if(consultaP.consultar(producto)){
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
                    control.insertarProducto(vista.jtableNuevaEntrada, producto);
                    
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
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==vista.btnNuevoProducto){
            controladorRP.iniciar();
            
        }else if(ae.getSource()==vista.btnAtras){
            ControladorEntrada controladorE = new ControladorEntrada(vistaEntrada,modelo);
            controladorE.iniciar();
            vista.dispose();
            
        }else if(ae.getSource()==vista.btnAgregar){
            agregarProducto();
        }else if(ae.getSource()==vista.btnBuscar){
            ListaInventario vistaLista = new ListaInventario();
            ControladorListaInventario controladorInv = 
                new ControladorListaInventario(vistaLista);
            controladorInv.insertarTabla(vista.jtableNuevaEntrada);
            controladorInv.iniciar();
            
        }else if(ae.getSource()==vista.btnComprar){
            
            //***********Obejtos de la venta **************
            Entrada entrada = new Entrada();
            Proveedor proveedor = new Proveedor();
            Inventario inventario = new Inventario();
            ConsultasInventario consultasInv = new ConsultasInventario();
            DetalleEntrada detalleEntrada = new DetalleEntrada();
            ConsultasDetalleEntrada consultasDetEntrada = new ConsultasDetalleEntrada();
            try{
                //***********Datos de venta **************
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
                    inventario.setFechaLote(sqlTimestamp);
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
    }
    
    @Override
    public void tableChanged(TableModelEvent tme) {
        if(!active && tme.getType()==TableModelEvent.UPDATE){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
        }else if(!active &&tme.getType()==TableModelEvent.INSERT){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
            
        }else if(!active &&tme.getType()==TableModelEvent.DELETE){
            active=true;
            TableModel model = vista.jtableNuevaEntrada.getModel();
            vista.jtableNuevaEntrada.setModel(calcularSubTotal(model));
            calcularTotal(vista.jlblTotal);
            active = false;
        }
        
        
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getSource()==vista.jtxtCodigo){
            if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                agregarProducto();
            }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
}
