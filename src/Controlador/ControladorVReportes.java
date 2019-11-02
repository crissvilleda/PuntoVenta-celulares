/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Pool;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.VReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Orlando
 */

public class ControladorVReportes extends Pool implements MouseListener, WindowListener, ActionListener{
    private VReportes vista;
    private Usuario modelo;
    private Administrador vistAdmin= new Administrador();
    private ConsultasUsuario conUsuarios= new ConsultasUsuario();
    //Constructor
    public ControladorVReportes(VReportes vista, Usuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.jlblInicio.addMouseListener(this);
        
        vista.btnImprimirUs.addActionListener(this);
        vista.btnImprimirPr.addActionListener(this);
        vista.btnImprimirIn.addActionListener(this);
        vista.btnImprimirCa.addActionListener(this);
        vista.btnImprimirMa.addActionListener(this);
        vista.btnImprimirPro.addActionListener(this);
        vista.btnImprimirVe.addActionListener(this);
        vista.jcmbUsuario.addItem("");
        conUsuarios.listUsu(vista.jcmbUsuario);
        vista.addWindowListener(this);
    }


    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
     @Override
    public void windowOpened(WindowEvent e) {
        vista.jlblUsuario.setText(modelo.getNombreUsuario());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblInicio){
           ControladorAdministrador controAdmin =new ControladorAdministrador(vistAdmin,modelo);
           controAdmin.iniciar();
           vista.dispose();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnImprimirUs){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RpUsuario.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }   
        }
        
        else if(e.getSource()==vista.btnImprimirPr){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RpProveedorLandscape.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }    
        }
        else if(e.getSource()==vista.btnImprimirIn){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RprInventario.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }    
        }
        else if(e.getSource()==vista.btnImprimirCa){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RpCategorias.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }    
        }
        else if(e.getSource()==vista.btnImprimirMa){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RpMarcas.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }    
        }
        else if(e.getSource()==vista.btnImprimirPro){
            Connection cn=(Connection)getConnection();
            String jasperReport=Paths.get("").toAbsolutePath().toString()+"/src/Reportes/RpProductos.jasper";
            
            try {
                JasperPrint print=JasperFillManager.fillReport(jasperReport,null,cn);
                JasperViewer view = new JasperViewer(print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null,"Error: "+ ex);
                System.err.print(ex);
            }finally{
                if(cn!=null){
                    try{
                        cn.close();
                    }catch(SQLException ex){
                        System.err.println(ex);
                    }
                
                }
            }    
        }else if(e.getSource()==vista.btnImprimirVe){
            if(!vista.jcmbUsuario.getModel().getSelectedItem().toString().equals("")){
                Connection cn = (Connection)getConnection();
                String jasperReport =Paths.get("").toAbsolutePath().toString()+"/src"
                        + "/Reportes/RprVentas.jasper";
                try{

                    String usuario = vista.jcmbUsuario.getItemAt(vista.jcmbUsuario.getSelectedIndex());
                                            
                    java.sql.Date fechaI = new java.sql.Date(vista.dcFI.getDate().getTime());
                    java.sql.Date fechaF = new java.sql.Date(vista.dcFF.getDate().getTime());   
                    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");

                    Map<String,Object> params = new HashMap<>();
                    params.put("usuario",usuario);
                    params.put("fechaInicial",df.format(fechaI));
                    params.put("fechaFinal", df.format(fechaF));

                    JasperPrint print =JasperFillManager.fillReport(jasperReport,params, cn);
                    JasperViewer view = new JasperViewer(print,false);
                    view.setVisible(true);

                }catch(JRException ex){
                    JOptionPane.showMessageDialog(null,"Error: "+ ex);
                    System.err.println(ex);
                }catch(NullPointerException exs){
                    JOptionPane.showMessageDialog(null,"Seleccione el rango de fecha");
                    System.err.println(exs);
                }catch(Exception exe){
                    JOptionPane.showMessageDialog(null,"Error: "+ exe);
                    System.err.println(exe);
                    
                    
                }finally{
                    if(cn!=null){
                        try{
                            cn.close();
                        }catch(SQLException ex){
                            System.err.println(ex);
                        }

                    }
                } 
            
        }else{
                JOptionPane.showMessageDialog(null,"Selecione un usuario porfavor");
                
            }
        }
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
