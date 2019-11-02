/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasInventario;
import Modelo.Pool;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.VInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author criss
 */
public class ControladorInventario extends Pool implements MouseListener, DocumentListener,ActionListener{
    private VInventario vista ;
    private Usuario modelo;
    private ConsultasInventario consultaInv = new ConsultasInventario();
    private Administrador vistaAdmin = new Administrador();
    
    public ControladorInventario(VInventario v, Usuario m){
        this.vista = v;
        this.modelo = m;
        vista.jlblInicio.addMouseListener(this);
        vista.jtxtBuscar.getDocument().addDocumentListener(this);
        consultaInv.tablaInventario(vista.jtableInventario);
        vista.jlblUsuario.setText(modelo.getNombreUsuario());
        vista.btnImprimirListado.addActionListener(this);
      
        
        
        
       
        
    }

    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vista.jlblInicio){
            ControladorAdministrador controladorA =
                    new ControladorAdministrador(vistaAdmin,modelo);
            controladorA.iniciar();
            vista.dispose();
        }
        
    }
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.buscar(vista.jtableInventario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.buscar(vista.jtableInventario, vista.jtxtBuscar.getText());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if(de.getDocument()==vista.jtxtBuscar.getDocument()){
            consultaInv.buscar(vista.jtableInventario, vista.jtxtBuscar.getText());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnImprimirListado){
            Connection cn = (Connection)getConnection();
            String jasperReport =Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RprInventario.jasper";
            
            try {
                
                JasperPrint print = JasperFillManager.fillReport(jasperReport,null, cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                System.err.println(ex);
            }
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
