/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.CortedeCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Orlando
 */
public class ControladorCorteCaja implements MouseListener, WindowListener,DocumentListener,ActionListener{

    private CortedeCaja vista;
    private Usuario modelo;
    private Administrador vistaAdmin= new Administrador();
    private ConsultasUsuario consultaU= new ConsultasUsuario();
    
    public ControladorCorteCaja(CortedeCaja vista, Usuario modelo){
    this.vista=vista;
    this.modelo=modelo;
    
    vista.btnGenerar.addActionListener(this);
    
    vista.jtxtFF.getDocument().addDocumentListener(this);
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
    
    vista.jlblInicio.addMouseListener(this);
    vista.jtxtB100.addMouseListener(this);
    vista.jtxtB50.addMouseListener(this);
    vista.jtxtB20.addMouseListener(this);
    vista.jtxtB10.addMouseListener(this);
    vista.jtxtB5.addMouseListener(this);
    vista.jtxtB1.addMouseListener(this);
    vista.jtxtM1.addMouseListener(this);
    vista.jtxtM050.addMouseListener(this);
    vista.jtxtM025.addMouseListener(this);
    vista.jtxtM010.addMouseListener(this);
    vista.jtxtM005.addMouseListener(this);
    
    //Carga la lista de usuarios
    vista.jcmbUsuario.addItem("");
    consultaU.listaUsuarios(vista.jcmbUsuario);
    
    vista.addWindowListener(this);
    
    
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    //Desactiva todos los campos del Panel 2
    public void desactivarP2(){
        vista.jlblTotCaj.setEnabled(false);
        vista.jlblQ.setEnabled(false);
        vista.jlblTotal.setEnabled(false);
        vista.jlblEI.setEnabled(false);
        vista.jlblTV.setEnabled(false);
        vista.jtxtB100.setEditable(false);
        vista.jtxtB50.setEditable(false);
        vista.jtxtB20.setEditable(false);
        vista.jtxtB10.setEditable(false);
        vista.jtxtB5.setEditable(false);
        vista.jtxtB1.setEditable(false);
        vista.jtxtM1.setEditable(false);
        vista.jtxtM050.setEditable(false);
        vista.jtxtM025.setEditable(false);
        vista.jtxtM010.setEditable(false);
        vista.jtxtM005.setEditable(false);
        vista.jtxtEI.setEditable(false);
        vista.jtxtTV.setEditable(false);
        vista.btnGuarCort.setEnabled(false);
        vista.btnGenerar.setEnabled(false);
        }
    //Activa todos los campos del Panel 2
    public void activarP2(){
        vista.jlblTotCaj.setEnabled(true);
        vista.jlblQ.setEnabled(true);
        vista.jlblTotal.setEnabled(true);
        vista.jlblEI.setEnabled(true);
        vista.jlblTV.setEnabled(true);
        vista.jtxtB100.setEditable(true);
        vista.jtxtB50.setEditable(true);
        vista.jtxtB20.setEditable(true);
        vista.jtxtB10.setEditable(true);
        vista.jtxtB5.setEditable(true);
        vista.jtxtB1.setEditable(true);
        vista.jtxtM1.setEditable(true);
        vista.jtxtM050.setEditable(true);
        vista.jtxtM025.setEditable(true);
        vista.jtxtM010.setEditable(true);
        vista.jtxtM005.setEditable(true);
        vista.jtxtEI.setEditable(true);
        vista.jtxtTV.setEditable(true);
        vista.btnGenerar.setEnabled(true);
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
        }
    
    //Verifica los campos antes de activar el boton Generar
    public void verificarJtxtpG(){
        if(vista.jtxtNU.getText().length()>4 && vista.jtxtFI.getText().length()>=10 && vista.jtxtFF.getText().length()>=10){
            vista.btnGenerar.setEnabled(true);
            }
        else{
            vista.btnGenerar.setEnabled(false);
        }
    }
    //Calcular Efectivo Total en caja
    public void calcTotCaj(JLabel total){
        try{
        Double valor;
        valor=(((Double.parseDouble(vista.jtxtB100.getText()))*100)+((Double.parseDouble(vista.jtxtB50.getText()))*50)
             +((Double.parseDouble(vista.jtxtB20.getText()))*20)+((Double.parseDouble(vista.jtxtB10.getText()))*10)
             +((Double.parseDouble(vista.jtxtB5.getText()))*5)+(Double.parseDouble(vista.jtxtB1.getText()))
             +(Double.parseDouble(vista.jtxtM1.getText()))+((Double.parseDouble(vista.jtxtM050.getText()))*0.50)
             +((Double.parseDouble(vista.jtxtM025.getText()))*0.25)+((Double.parseDouble(vista.jtxtM010.getText()))*0.10)
             +((Double.parseDouble(vista.jtxtM005.getText()))*0.05));
        total.setText(String.valueOf(valor));
        }catch(NumberFormatException e){}
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        desactivarP2();
        vista.jlblNombreUsuario.setText(modelo.getNombreUsuario());
        
    }
     @Override
    public void insertUpdate(DocumentEvent e) {
        if(e.getDocument()==vista.jtxtFF.getDocument()){
            verificarJtxtpG();
        }else if(e.getDocument()==vista.jtxtB100.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB50.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB20.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB10.getDocument()){
            calcTotCaj(vista.jlblTotal);
        } else if(e.getDocument()==vista.jtxtB5.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM050.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM025.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM010.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM005.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }
        
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(e.getDocument()==vista.jtxtFF.getDocument()){
            verificarJtxtpG();
        }else if(e.getDocument()==vista.jtxtB100.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB50.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB20.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB10.getDocument()){
            calcTotCaj(vista.jlblTotal);
        } else if(e.getDocument()==vista.jtxtB5.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM050.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM025.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM010.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM005.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if(e.getDocument()==vista.jtxtFF.getDocument()){
            verificarJtxtpG();
        }else if(e.getDocument()==vista.jtxtB100.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB50.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB20.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB10.getDocument()){
            calcTotCaj(vista.jlblTotal);
        } else if(e.getDocument()==vista.jtxtB5.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtB1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM1.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM050.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM025.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM010.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }else if(e.getDocument()==vista.jtxtM005.getDocument()){
            calcTotCaj(vista.jlblTotal);
        }
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnGenerar){
            activarP2();
            vista.jtxtB100.requestFocus();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.jlblInicio){
            ControladorAdministrador controAdmin= new ControladorAdministrador(vistaAdmin,modelo);
            controAdmin.iniciar();
            vista.dispose();
        }
        else if(e.getSource()==vista.jtxtB100){
            vista.jtxtB100.setText("");
        }
        else if(e.getSource()==vista.jtxtB50){
            vista.jtxtB50.setText("");
        }
        else if(e.getSource()==vista.jtxtB20){
            vista.jtxtB20.setText("");
        }
        else if(e.getSource()==vista.jtxtB10){
            vista.jtxtB10.setText("");
        }
        else if(e.getSource()==vista.jtxtB5){
            vista.jtxtB5.setText("");
        }
        else if(e.getSource()==vista.jtxtB1){
            vista.jtxtB1.setText("");
        }
        else if(e.getSource()==vista.jtxtM1){
            vista.jtxtM1.setText("");
        }
        else if(e.getSource()==vista.jtxtM050){
            vista.jtxtM050.setText("");
        }
        else if(e.getSource()==vista.jtxtM025){
            vista.jtxtM025.setText("");
        }
        else if(e.getSource()==vista.jtxtM010){
            vista.jtxtM010.setText("");
        }
        else if(e.getSource()==vista.jtxtM005){
            vista.jtxtM005.setText("");
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
