/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasCorteCaja;
import Modelo.ConsultasUsuario;
import Modelo.CorteCaja;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.CortedeCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Orlando
 */
public class ControladorCorteCaja implements MouseListener, WindowListener,
        DocumentListener,ActionListener,FocusListener{

    private CortedeCaja vista;
    private Usuario modelo;
    private Administrador vistaAdmin= new Administrador();
    private ConsultasUsuario consultaU= new ConsultasUsuario();
    private ConsultasCorteCaja conCorte = new ConsultasCorteCaja();
    
    public ControladorCorteCaja(CortedeCaja vista, Usuario modelo){
    this.vista=vista;
    this.modelo=modelo;
    
    vista.btnGenerar.addActionListener(this);
    vista.btnGuarCort.addActionListener(this);
    
    vista.jtxtB100.getDocument().addDocumentListener(this);
    vista.jtxtB50.getDocument().addDocumentListener(this);
    vista.jtxtB20.getDocument().addDocumentListener(this);
    vista.jtxtB10.getDocument().addDocumentListener(this);
    vista.jtxtB5.getDocument().addDocumentListener(this);
    vista.jtxtB1.getDocument().addDocumentListener(this);
    vista.jtxtM1.getDocument().addDocumentListener(this);
    vista.jtxtM050.getDocument().addDocumentListener(this);
    vista.jtxtM025.getDocument().addDocumentListener(this);
    vista.jtxtM010.getDocument().addDocumentListener(this);
    vista.jtxtM005.getDocument().addDocumentListener(this);
    vista.jtxtEI.getDocument().addDocumentListener(this);
    
    vista.jlblInicio.addMouseListener(this);
    vista.jtxtB100.addFocusListener(this);
    vista.jtxtB50.addFocusListener(this);
    vista.jtxtB20.addFocusListener(this);
    vista.jtxtB10.addFocusListener(this);
    vista.jtxtB5.addFocusListener(this);
    vista.jtxtB1.addFocusListener(this);
    vista.jtxtM1.addFocusListener(this);
    vista.jtxtM050.addFocusListener(this);
    vista.jtxtM025.addFocusListener(this);
    vista.jtxtM010.addFocusListener(this);
    vista.jtxtM005.addFocusListener(this);
    vista.jtxtEI.addFocusListener(this);
    
    vista.jtxtB100.setText("0");
    vista.jtxtB50.setText("0");
    vista.jtxtB20.setText("0");
    vista.jtxtB10.setText("0");
    vista.jtxtB5.setText("0");
    vista.jtxtB1.setText("0");
    vista.jtxtM1.setText("0");
    vista.jtxtM050.setText("0");
    vista.jtxtM025.setText("0");
    vista.jtxtM010.setText("0");
    vista.jtxtM005.setText("0");
    
    vista.addWindowListener(this);
 
    //Carga la lista de Usuarios
    vista.jcmbUsuario.addItem("");
    consultaU.listUsu(vista.jcmbUsuario);
    
    
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
  
    
    //Calcular Efectivo Total en caja
    public void realizarOperaciones(){
        try{
            Double saldoInicial=Double.parseDouble(this.vista.jtxtEI.getText());
            Double totalVenta = Double.parseDouble(this.vista.jtxtTV.getText());
            Double subtotal;
            Double totalCaja;
            Double diferencia;

            subtotal=(((Double.parseDouble(vista.jtxtB100.getText()))*100)+((Double.parseDouble(vista.jtxtB50.getText()))*50)
                 +((Double.parseDouble(vista.jtxtB20.getText()))*20)+((Double.parseDouble(vista.jtxtB10.getText()))*10)
                 +((Double.parseDouble(vista.jtxtB5.getText()))*5)+(Double.parseDouble(vista.jtxtB1.getText()))
                 +(Double.parseDouble(vista.jtxtM1.getText()))+((Double.parseDouble(vista.jtxtM050.getText()))*0.50)
                 +((Double.parseDouble(vista.jtxtM025.getText()))*0.25)+((Double.parseDouble(vista.jtxtM010.getText()))*0.10)
                 +((Double.parseDouble(vista.jtxtM005.getText()))*0.05));
            totalCaja = totalVenta+saldoInicial;
            diferencia = subtotal-totalCaja;
            if(subtotal>=totalCaja){
                this.vista.btnGuarCort.setEnabled(true);
                
            }else{
                this.vista.btnGuarCort.setEnabled(false);
            }
            this.vista.jlblsubTotal.setText(String.valueOf(subtotal));
            this.vista.jtxtTotalCaja.setText(String.valueOf(totalCaja));
            this.vista.jtxtDiferencia.setText(String.valueOf(diferencia));
        
        
        }catch(NumberFormatException e){}
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        vista.jPanel2CortCaj.setVisible(false);
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        
    }
     @Override
    public void insertUpdate(DocumentEvent e) {
        realizarOperaciones();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        realizarOperaciones();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        realizarOperaciones();
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnGenerar){
            if(vista.jcmbUsuario.getModel().getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null,"Selecione un Usuario para continuar");
            }else{
                try{
                   

                    java.sql.Date fechaI = new java.sql.Date(vista.dcFI.getDate().getTime());
                    java.sql.Date fechaF = new java.sql.Date(vista.dcFF.getDate().getTime());
                    
                    DateFormat df = new SimpleDateFormat("YYYY-MM-dd");

                    String usuario = vista.jcmbUsuario.getItemAt(
                            vista.jcmbUsuario.getSelectedIndex());
                    String total = null;
                    
                    if(conCorte.getTotalVenta(usuario,df.format(fechaI),df.format(fechaF),vista.jtxtTV)){
                        vista.jPanel2CortCaj.setVisible(true);
                        vista.jtxtEI.requestFocus();
                        
                       
                    }else{
                        vista.jPanel2CortCaj.setVisible(false);
                        JOptionPane.showMessageDialog(null,"No hay informacion de corte"
                                + "\ncon los datos ingresados, intente con otros datos");
                        
                      
                    }
                  
                    
                    
                }catch(NullPointerException ex){
                    vista.jPanel2CortCaj.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Seleccione el rango de fecha");
                    
                    
                    
                }
            
            }
        }else if(e.getSource()==this.vista.btnGuarCort){
            try{
                int añoI = vista.dcFI.getCalendar().get(Calendar.YEAR);
                    int mesI = vista.dcFI.getCalendar().get(Calendar.MONTH)+1;
                    int diaI = vista.dcFI.getCalendar().get(Calendar.DAY_OF_MONTH);
                    int añoF = vista.dcFF.getCalendar().get(Calendar.YEAR);
                    int mesF = vista.dcFF.getCalendar().get(Calendar.MONTH)+1;
                    int diaF = vista.dcFF.getCalendar().get(Calendar.DAY_OF_MONTH);

                    String fechaI =(añoI+"-"+mesI+"-"+diaI);
                    String fechaF =(añoF+"-"+mesF+"-"+diaF);

                    String usuario = vista.jcmbUsuario.getItemAt(
                            vista.jcmbUsuario.getSelectedIndex());
                    
                    CorteCaja caja = new CorteCaja();
                    long now = System.currentTimeMillis();
                    Double saldoInicial = Double.parseDouble(vista.jtxtEI.getText());
                    Double totalCaja = Double.parseDouble(vista.jtxtTotalCaja.getText());
                    Double totalVenta = Double.parseDouble(vista.jtxtTV.getText());
                    Double sobrante = Double.parseDouble(vista.jtxtDiferencia.getText());
                    Timestamp sqlTimestamp = new Timestamp(now);
                    
                    caja.setFechaCorte(sqlTimestamp);
                    caja.setSaldoInicial(saldoInicial);
                    caja.setTotalCorte(totalCaja);
                    caja.setTotalVenta(totalVenta);
                    caja.setSobrante(sobrante);
                
                
                if(conCorte.registrar(caja, usuario, fechaI, fechaF)){
                    vista.jtxtB100.setText("0");
                    vista.jtxtB50.setText("0");
                    vista.jtxtB20.setText("0");
                    vista.jtxtB10.setText("0");
                    vista.jtxtB5.setText("0");
                    vista.jtxtB1.setText("0");
                    vista.jtxtM1.setText("0");
                    vista.jtxtM050.setText("0");
                    vista.jtxtM025.setText("0");
                    vista.jtxtM010.setText("0");
                    vista.jtxtM005.setText("0");
                    vista.jtxtEI.setText("0");
                    vista.btnGuarCort.setEnabled(false);
                    vista.jPanel2CortCaj.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Corte guardado exitosamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "Eror al guardar el corte");
                }
                
            }catch(Exception ex){}
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblInicio){
            ControladorAdministrador controAdmin= new ControladorAdministrador(vistaAdmin,modelo);
            controAdmin.iniciar();
            vista.dispose();
        }
        
    }
    @Override
    public void focusGained(FocusEvent fe) {
        if(fe.getSource()==vista.jtxtB100){
            vista.jtxtB100.setText("");
        }
        else if(fe.getSource()==vista.jtxtB50){
            vista.jtxtB50.setText("");
        }
        else if(fe.getSource()==vista.jtxtB20){
            vista.jtxtB20.setText("");
        }
        else if(fe.getSource()==vista.jtxtB10){
            vista.jtxtB10.setText("");
        }
        else if(fe.getSource()==vista.jtxtB5){
            vista.jtxtB5.setText("");
        }
        else if(fe.getSource()==vista.jtxtB1){
            vista.jtxtB1.setText("");
        }
        else if(fe.getSource()==vista.jtxtM1){
            vista.jtxtM1.setText("");
        }
        else if(fe.getSource()==vista.jtxtM050){
            vista.jtxtM050.setText("");
        }
        else if(fe.getSource()==vista.jtxtM025){
            vista.jtxtM025.setText("");
        }
        else if(fe.getSource()==vista.jtxtM010){
            vista.jtxtM010.setText("");
        }
        else if(fe.getSource()==vista.jtxtM005){
            vista.jtxtM005.setText("");
        }else if(fe.getSource()==vista.jtxtEI){
            vista.jtxtEI.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if(fe.getSource()==vista.jtxtB100){
            if(vista.jtxtB100.getText().equals("")){
                vista.jtxtB100.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtB50){
            if(vista.jtxtB50.getText().equals("")){
                vista.jtxtB50.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtB20){
            if(vista.jtxtB20.getText().equals("")){
                vista.jtxtB20.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtB10){
            if(vista.jtxtB10.getText().equals("")){
                vista.jtxtB10.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtB5){
            if(vista.jtxtB5.getText().equals("")){
                vista.jtxtB5.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtB1){
            if(vista.jtxtB1.getText().equals("")){
                vista.jtxtB1.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtM1){
            if(vista.jtxtM1.getText().equals("")){
                vista.jtxtM1.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtM050){
            if(vista.jtxtM050.getText().equals("")){
                vista.jtxtM050.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtM025){
            if(vista.jtxtM025.getText().equals("")){
                vista.jtxtM025.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtM010){
            if(vista.jtxtM010.getText().equals("")){
                vista.jtxtM010.setText("0");  
            }
        }
        else if(fe.getSource()==vista.jtxtM005){
            if(vista.jtxtM005.getText().equals("")){
                vista.jtxtM005.setText("0");  
            }
        }else if(fe.getSource()==vista.jtxtEI){
            if(vista.jtxtEI.getText().equals("")){
                vista.jtxtEI.setText("0");  
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
