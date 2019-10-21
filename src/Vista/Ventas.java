/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Orlando
 */
public class Ventas extends javax.swing.JFrame {

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Fecha del Sistema
        Date sistFecha = new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd-MMM-YYYY");
        jlblFechaSistema.setText(formato.format(sistFecha));
        
        //Hora del Sistema;
        Timer tiempo = new Timer(100,new Ventas.jlblHora());
        tiempo.start();
        
    }

    class jlblHora implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Date sistHora = new Date();
            String pmAm="hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy=Calendar.getInstance();
            jlblHoraSistema.setText(String.format(format.format(sistHora),hoy));
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlblDatosCliente = new javax.swing.JLabel();
        jlblNombre = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jlblApellido = new javax.swing.JLabel();
        jtxtDpi = new javax.swing.JTextField();
        jlblDpi = new javax.swing.JLabel();
        jtxtNit = new javax.swing.JTextField();
        jlblNit = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableVentas = new javax.swing.JTable();
        jpanel3 = new javax.swing.JPanel();
        jlblIngreseCodigo = new javax.swing.JLabel();
        jtxtIngreseCodigo = new javax.swing.JTextField();
        jlblCantidad = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        btnEliminarCarrito = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        btnAgregarCarrito = new javax.swing.JButton();
        jpanel4 = new javax.swing.JPanel();
        jlblMinimizar = new javax.swing.JLabel();
        jlblNoVenta = new javax.swing.JLabel();
        jlblDetalleVenta = new javax.swing.JLabel();
        jlblIdVenta = new javax.swing.JLabel();
        jlblAtendio = new javax.swing.JLabel();
        jlblNombreUsuario = new javax.swing.JLabel();
        jlblHora = new javax.swing.JLabel();
        jlblHoraSistema = new javax.swing.JLabel();
        jlblCantArts = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jlblArtsVendidos = new javax.swing.JLabel();
        jlblFechaSistema = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        jpanel5 = new javax.swing.JPanel();
        jlblIconoTotal = new javax.swing.JLabel();
        jlblTotal = new javax.swing.JLabel();
        jtxtImporte = new javax.swing.JTextField();
        jlblImporte = new javax.swing.JLabel();
        jlblTotalVenta = new javax.swing.JLabel();
        jlblQ = new javax.swing.JLabel();
        btnRealizar = new javax.swing.JButton();
        jlblCambio = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jlblCambioVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanel1.setBackground(new java.awt.Color(255, 255, 255));
        jpanel1.setPreferredSize(new java.awt.Dimension(1000, 400));
        jpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 112, 85));
        jLabel5.setText("Ventas");
        jpanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconoVentas.png"))); // NOI18N
        jpanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jlblDatosCliente.setBackground(new java.awt.Color(255, 255, 255));
        jlblDatosCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblDatosCliente.setForeground(new java.awt.Color(225, 99, 71));
        jlblDatosCliente.setText("Datos del cliente:");
        jpanel1.add(jlblDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jlblNombre.setBackground(new java.awt.Color(255, 255, 255));
        jlblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNombre.setForeground(new java.awt.Color(225, 99, 71));
        jlblNombre.setText("Nombre:");
        jpanel1.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jtxtNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(153, 153, 153));
        jtxtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jpanel1.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 260, 20));

        jtxtApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtApellido.setForeground(new java.awt.Color(153, 153, 153));
        jtxtApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });
        jpanel1.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 260, 20));

        jlblApellido.setBackground(new java.awt.Color(255, 255, 255));
        jlblApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblApellido.setForeground(new java.awt.Color(225, 99, 71));
        jlblApellido.setText("Apellido:");
        jpanel1.add(jlblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jtxtDpi.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtDpi.setForeground(new java.awt.Color(153, 153, 153));
        jtxtDpi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtDpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDpiActionPerformed(evt);
            }
        });
        jpanel1.add(jtxtDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 120, 20));

        jlblDpi.setBackground(new java.awt.Color(255, 255, 255));
        jlblDpi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblDpi.setForeground(new java.awt.Color(225, 99, 71));
        jlblDpi.setText("DPI:");
        jpanel1.add(jlblDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        jtxtNit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtNit.setForeground(new java.awt.Color(153, 153, 153));
        jtxtNit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNitActionPerformed(evt);
            }
        });
        jpanel1.add(jtxtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 120, 20));

        jlblNit.setBackground(new java.awt.Color(255, 255, 255));
        jlblNit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNit.setForeground(new java.awt.Color(225, 99, 71));
        jlblNit.setText("Nit:");
        jpanel1.add(jlblNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));
        jpanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 950, -1));

        getContentPane().add(jpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 225));

        jpanel2.setBackground(new java.awt.Color(255, 255, 255));
        jpanel2.setPreferredSize(new java.awt.Dimension(1000, 400));
        jpanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Nombre", "Descripcion", "Cantidad", "PrecioCompra", "Precio ", "PrecioTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtableVentas.setPreferredSize(new java.awt.Dimension(300, 270));
        jScrollPane1.setViewportView(jtableVentas);
        if (jtableVentas.getColumnModel().getColumnCount() > 0) {
            jtableVentas.getColumnModel().getColumn(0).setMinWidth(0);
            jtableVentas.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtableVentas.getColumnModel().getColumn(0).setMaxWidth(0);
            jtableVentas.getColumnModel().getColumn(1).setMinWidth(0);
            jtableVentas.getColumnModel().getColumn(1).setPreferredWidth(0);
            jtableVentas.getColumnModel().getColumn(1).setMaxWidth(0);
            jtableVentas.getColumnModel().getColumn(4).setMinWidth(70);
            jtableVentas.getColumnModel().getColumn(4).setMaxWidth(80);
            jtableVentas.getColumnModel().getColumn(5).setMinWidth(0);
            jtableVentas.getColumnModel().getColumn(5).setPreferredWidth(0);
            jtableVentas.getColumnModel().getColumn(5).setMaxWidth(0);
            jtableVentas.getColumnModel().getColumn(6).setMinWidth(80);
            jtableVentas.getColumnModel().getColumn(6).setMaxWidth(90);
            jtableVentas.getColumnModel().getColumn(7).setMinWidth(80);
            jtableVentas.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        jpanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 850, 300));

        getContentPane().add(jpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 950, 300));

        jpanel3.setBackground(new java.awt.Color(255, 255, 255));
        jpanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblIngreseCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jlblIngreseCodigo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblIngreseCodigo.setForeground(new java.awt.Color(103, 103, 103));
        jlblIngreseCodigo.setText("Ingrese o escanee codigo");
        jpanel3.add(jlblIngreseCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jtxtIngreseCodigo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jtxtIngreseCodigo.setForeground(new java.awt.Color(153, 153, 153));
        jtxtIngreseCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtIngreseCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIngreseCodigoActionPerformed(evt);
            }
        });
        jpanel3.add(jtxtIngreseCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 200, 30));

        jlblCantidad.setBackground(new java.awt.Color(255, 255, 255));
        jlblCantidad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblCantidad.setForeground(new java.awt.Color(103, 103, 103));
        jlblCantidad.setText("Cantidad");
        jpanel3.add(jlblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jtxtCantidad.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jtxtCantidad.setForeground(new java.awt.Color(153, 153, 153));
        jtxtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCantidadActionPerformed(evt);
            }
        });
        jpanel3.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 40, 80, 30));

        btnEliminarCarrito.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaEliminarCarritob.png"))); // NOI18N
        btnEliminarCarrito.setBorder(null);
        btnEliminarCarrito.setBorderPainted(false);
        btnEliminarCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCarrito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaEliminarCarrito.png"))); // NOI18N
        btnEliminarCarrito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaEliminarCarrito.png"))); // NOI18N
        btnEliminarCarrito.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaEliminarCarrito.png"))); // NOI18N
        btnEliminarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCarritoActionPerformed(evt);
            }
        });
        jpanel3.add(btnEliminarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 85, 35));

        btnBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarProductob.png"))); // NOI18N
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.setBorderPainted(false);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarProducto.png"))); // NOI18N
        btnBuscarProducto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarProducto.png"))); // NOI18N
        btnBuscarProducto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarProducto.png"))); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jpanel3.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 30, 85, 35));

        btnAgregarCarrito.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarCarritob.png"))); // NOI18N
        btnAgregarCarrito.setBorder(null);
        btnAgregarCarrito.setBorderPainted(false);
        btnAgregarCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCarrito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarCarrito.png"))); // NOI18N
        btnAgregarCarrito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarCarrito.png"))); // NOI18N
        btnAgregarCarrito.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarCarrito.png"))); // NOI18N
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });
        jpanel3.add(btnAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 85, 35));

        getContentPane().add(jpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 525, 950, 150));

        jpanel4.setBackground(new java.awt.Color(255, 255, 255));
        jpanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jlblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizarMouseClicked(evt);
            }
        });
        jpanel4.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        jlblNoVenta.setBackground(new java.awt.Color(255, 255, 255));
        jlblNoVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNoVenta.setForeground(new java.awt.Color(225, 99, 71));
        jlblNoVenta.setText("N° Venta");
        jpanel4.add(jlblNoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jlblDetalleVenta.setBackground(new java.awt.Color(255, 255, 255));
        jlblDetalleVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblDetalleVenta.setForeground(new java.awt.Color(225, 99, 71));
        jlblDetalleVenta.setText("Detalles de la Venta");
        jpanel4.add(jlblDetalleVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jlblIdVenta.setForeground(new java.awt.Color(103, 103, 103));
        jlblIdVenta.setText("idVenta");
        jpanel4.add(jlblIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 130, 20));

        jlblAtendio.setBackground(new java.awt.Color(255, 255, 255));
        jlblAtendio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblAtendio.setForeground(new java.awt.Color(225, 99, 71));
        jlblAtendio.setText("Lo Atendio:");
        jpanel4.add(jlblAtendio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jlblNombreUsuario.setForeground(new java.awt.Color(103, 103, 103));
        jlblNombreUsuario.setText("Nombre Usuario");
        jpanel4.add(jlblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 130, 20));

        jlblHora.setBackground(new java.awt.Color(255, 255, 255));
        jlblHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblHora.setForeground(new java.awt.Color(225, 99, 71));
        jlblHora.setText("Hora:");
        jpanel4.add(jlblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jlblHoraSistema.setForeground(new java.awt.Color(103, 103, 103));
        jlblHoraSistema.setText("Hora Sistema");
        jpanel4.add(jlblHoraSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 130, 20));

        jlblCantArts.setBackground(new java.awt.Color(255, 255, 255));
        jlblCantArts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCantArts.setForeground(new java.awt.Color(225, 99, 71));
        jlblCantArts.setText("Cant. Arts.");
        jpanel4.add(jlblCantArts, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jlblFecha.setBackground(new java.awt.Color(255, 255, 255));
        jlblFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblFecha.setForeground(new java.awt.Color(225, 99, 71));
        jlblFecha.setText("Fecha:");
        jpanel4.add(jlblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 202, -1, -1));

        jlblArtsVendidos.setForeground(new java.awt.Color(103, 103, 103));
        jlblArtsVendidos.setText("Cantidad de Articulos");
        jpanel4.add(jlblArtsVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 130, 20));

        jlblFechaSistema.setForeground(new java.awt.Color(103, 103, 103));
        jlblFechaSistema.setText("Fecha Sistema");
        jpanel4.add(jlblFechaSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 130, 20));

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cerrarSesion.png"))); // NOI18N
        lblSalir.setText("Cerrar Session");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpanel4.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 120, 30));

        getContentPane().add(jpanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 250, 275));

        jpanel5.setBackground(new java.awt.Color(255, 255, 255));
        jpanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblIconoTotal.setBackground(new java.awt.Color(255, 255, 255));
        jlblIconoTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconoImporte.png"))); // NOI18N
        jpanel5.add(jlblIconoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, 100));

        jlblTotal.setBackground(new java.awt.Color(255, 255, 255));
        jlblTotal.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlblTotal.setForeground(new java.awt.Color(103, 103, 103));
        jlblTotal.setText("Total");
        jpanel5.add(jlblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 120, 30));

        jtxtImporte.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jtxtImporte.setForeground(new java.awt.Color(153, 153, 153));
        jtxtImporte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtImporteActionPerformed(evt);
            }
        });
        jpanel5.add(jtxtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 230, 160, 30));

        jlblImporte.setBackground(new java.awt.Color(255, 255, 255));
        jlblImporte.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblImporte.setForeground(new java.awt.Color(153, 153, 153));
        jlblImporte.setText("Importe");
        jpanel5.add(jlblImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 210, -1, -1));

        jlblTotalVenta.setBackground(new java.awt.Color(255, 255, 255));
        jlblTotalVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblTotalVenta.setForeground(new java.awt.Color(153, 153, 153));
        jlblTotalVenta.setText("Total Venta");
        jpanel5.add(jlblTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 150, -1, -1));

        jlblQ.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlblQ.setForeground(new java.awt.Color(103, 103, 103));
        jlblQ.setText("Q.");
        jpanel5.add(jlblQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 170, 30, 30));

        btnRealizar.setBackground(new java.awt.Color(255, 255, 255));
        btnRealizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaRealizarb.png"))); // NOI18N
        btnRealizar.setBorder(null);
        btnRealizar.setBorderPainted(false);
        btnRealizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaRealizar.png"))); // NOI18N
        btnRealizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaRealizar.png"))); // NOI18N
        btnRealizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaRealizar.png"))); // NOI18N
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });
        jpanel5.add(btnRealizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 267, 85, 35));

        jlblCambio.setBackground(new java.awt.Color(255, 255, 255));
        jlblCambio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblCambio.setForeground(new java.awt.Color(153, 153, 153));
        jlblCambio.setText("Cambio");
        jpanel5.add(jlblCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(103, 103, 103));
        jLabel24.setText("Q.");
        jpanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 30, 30));

        jlblCambioVenta.setBackground(new java.awt.Color(255, 255, 255));
        jlblCambioVenta.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlblCambioVenta.setForeground(new java.awt.Color(103, 103, 103));
        jlblCambioVenta.setText("Cambio");
        jpanel5.add(jlblCambioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 120, 30));

        getContentPane().add(jpanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 275, 250, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jtxtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDpiActionPerformed

    private void jtxtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNitActionPerformed

    private void jtxtIngreseCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIngreseCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIngreseCodigoActionPerformed

    private void jtxtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCantidadActionPerformed

    private void btnEliminarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCarritoActionPerformed

    }//GEN-LAST:event_btnEliminarCarritoActionPerformed

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
     


        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void jlblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizarMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jlblMinimizarMouseClicked

    private void jtxtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtImporteActionPerformed

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarCarrito;
    public javax.swing.JButton btnBuscarProducto;
    public javax.swing.JButton btnEliminarCarrito;
    public javax.swing.JButton btnRealizar;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel jlblApellido;
    public javax.swing.JLabel jlblArtsVendidos;
    private javax.swing.JLabel jlblAtendio;
    private javax.swing.JLabel jlblCambio;
    public javax.swing.JLabel jlblCambioVenta;
    private javax.swing.JLabel jlblCantArts;
    public javax.swing.JLabel jlblCantidad;
    public javax.swing.JLabel jlblDatosCliente;
    private javax.swing.JLabel jlblDetalleVenta;
    public javax.swing.JLabel jlblDpi;
    private javax.swing.JLabel jlblFecha;
    public javax.swing.JLabel jlblFechaSistema;
    private javax.swing.JLabel jlblHora;
    public javax.swing.JLabel jlblHoraSistema;
    public javax.swing.JLabel jlblIconoTotal;
    public javax.swing.JLabel jlblIdVenta;
    public javax.swing.JLabel jlblImporte;
    public javax.swing.JLabel jlblIngreseCodigo;
    public javax.swing.JLabel jlblMinimizar;
    public javax.swing.JLabel jlblNit;
    private javax.swing.JLabel jlblNoVenta;
    public javax.swing.JLabel jlblNombre;
    public javax.swing.JLabel jlblNombreUsuario;
    public javax.swing.JLabel jlblQ;
    public javax.swing.JLabel jlblTotal;
    private javax.swing.JLabel jlblTotalVenta;
    public javax.swing.JPanel jpanel1;
    protected javax.swing.JPanel jpanel2;
    public javax.swing.JPanel jpanel3;
    public javax.swing.JPanel jpanel4;
    public javax.swing.JPanel jpanel5;
    public javax.swing.JTable jtableVentas;
    public javax.swing.JTextField jtxtApellido;
    public javax.swing.JTextField jtxtCantidad;
    public javax.swing.JTextField jtxtDpi;
    public javax.swing.JTextField jtxtImporte;
    public javax.swing.JTextField jtxtIngreseCodigo;
    public javax.swing.JTextField jtxtNit;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JLabel lblSalir;
    // End of variables declaration//GEN-END:variables
}
