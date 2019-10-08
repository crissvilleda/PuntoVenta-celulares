/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.placeholder.PlaceHolder;

/**
 *
 * @author Orlando
 */
public class EntradaNuevo extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    public EntradaNuevo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void holders(){
      PlaceHolder holder;  
      holder=new PlaceHolder(jtxtCodigo,"Ingrese Codigo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1EntradaNuevo = new javax.swing.JPanel();
        jlblEntradaIcono = new javax.swing.JLabel();
        jlblMinimizar = new javax.swing.JLabel();
        jlblEntrada = new javax.swing.JLabel();
        jlblNombreUsuario = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jPanel2EntradaNuevo = new javax.swing.JPanel();
        jtxtCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlblBuscarIcono = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jlblProveedor = new javax.swing.JLabel();
        jcmbProveedor = new javax.swing.JComboBox<>();
        jlblRecibido1 = new javax.swing.JLabel();
        jlblRecibido2 = new javax.swing.JLabel();
        jlblNoEntrada = new javax.swing.JLabel();
        jtxtNoEntrada = new javax.swing.JTextField();
        jlblFecha = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableNuevaEntrada = new javax.swing.JTable();
        jlblTotal = new javax.swing.JLabel();
        jlblRecibido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1EntradaNuevo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1EntradaNuevo.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanel1EntradaNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblEntradaIcono.setBackground(new java.awt.Color(255, 255, 255));
        jlblEntradaIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconoCarrito.png"))); // NOI18N
        jlblEntradaIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1EntradaNuevo.add(jlblEntradaIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 97));

        jlblMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jlblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizarMouseClicked(evt);
            }
        });
        jPanel1EntradaNuevo.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        jlblEntrada.setBackground(new java.awt.Color(255, 255, 255));
        jlblEntrada.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jlblEntrada.setForeground(new java.awt.Color(238, 112, 85));
        jlblEntrada.setText("Nueva Entrada");
        jPanel1EntradaNuevo.add(jlblEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jlblNombreUsuario.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jlblNombreUsuario.setForeground(new java.awt.Color(105, 105, 105));
        jlblNombreUsuario.setText("Nombre del Usuario");
        jPanel1EntradaNuevo.add(jlblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 65, 340, -1));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAtrasb.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAtras.png"))); // NOI18N
        btnAtras.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAtras.png"))); // NOI18N
        btnAtras.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAtras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1EntradaNuevo.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        getContentPane().add(jPanel1EntradaNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2EntradaNuevo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2EntradaNuevo.setPreferredSize(new java.awt.Dimension(1000, 400));
        jPanel2EntradaNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(153, 153, 153));
        jtxtCodigo.setBorder(null);
        jtxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCodigoActionPerformed(evt);
            }
        });
        jPanel2EntradaNuevo.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 120, 20));

        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel2EntradaNuevo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 160, -1));

        jSeparator2.setPreferredSize(new java.awt.Dimension(1000, 10));
        jPanel2EntradaNuevo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jlblBuscarIcono.setBackground(new java.awt.Color(255, 255, 255));
        jlblBuscarIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Search_32px.png"))); // NOI18N
        jPanel2EntradaNuevo.add(jlblBuscarIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarb.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        btnBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2EntradaNuevo.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 75, 25));

        jlblProveedor.setBackground(new java.awt.Color(255, 255, 255));
        jlblProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblProveedor.setForeground(new java.awt.Color(225, 99, 71));
        jlblProveedor.setText("Proveedor:");
        jPanel2EntradaNuevo.add(jlblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jcmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor" }));
        jPanel2EntradaNuevo.add(jcmbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, -1));

        jlblRecibido1.setBackground(new java.awt.Color(255, 255, 255));
        jlblRecibido1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblRecibido1.setForeground(new java.awt.Color(105, 105, 105));
        jlblRecibido1.setText("Lista de Inventario");
        jPanel2EntradaNuevo.add(jlblRecibido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 46, 130, -1));

        jlblRecibido2.setBackground(new java.awt.Color(255, 255, 255));
        jlblRecibido2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblRecibido2.setForeground(new java.awt.Color(225, 99, 71));
        jlblRecibido2.setText("Recibido por:");
        jPanel2EntradaNuevo.add(jlblRecibido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jlblNoEntrada.setBackground(new java.awt.Color(255, 255, 255));
        jlblNoEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblNoEntrada.setForeground(new java.awt.Color(225, 99, 71));
        jlblNoEntrada.setText("No:");
        jPanel2EntradaNuevo.add(jlblNoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        jtxtNoEntrada.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtNoEntrada.setForeground(new java.awt.Color(153, 153, 153));
        jtxtNoEntrada.setText("id Compra");
        jtxtNoEntrada.setBorder(null);
        jtxtNoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNoEntradaActionPerformed(evt);
            }
        });
        jPanel2EntradaNuevo.add(jtxtNoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 100, 20));

        jlblFecha.setBackground(new java.awt.Color(255, 255, 255));
        jlblFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblFecha.setForeground(new java.awt.Color(225, 99, 71));
        jlblFecha.setText("Fecha:");
        jPanel2EntradaNuevo.add(jlblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        jtxtFecha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtFecha.setForeground(new java.awt.Color(153, 153, 153));
        jtxtFecha.setBorder(null);
        jtxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFechaActionPerformed(evt);
            }
        });
        jPanel2EntradaNuevo.add(jtxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 100, 20));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarb.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        btnAgregar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        btnAgregar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        jPanel2EntradaNuevo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        btnComprar.setBackground(new java.awt.Color(255, 255, 255));
        btnComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaComprarb.png"))); // NOI18N
        btnComprar.setBorder(null);
        btnComprar.setBorderPainted(false);
        btnComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComprar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaComprar.png"))); // NOI18N
        btnComprar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaComprar.png"))); // NOI18N
        btnComprar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaComprar.png"))); // NOI18N
        jPanel2EntradaNuevo.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        btnNuevoProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevoProductob.png"))); // NOI18N
        btnNuevoProducto.setBorder(null);
        btnNuevoProducto.setBorderPainted(false);
        btnNuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevoProducto.png"))); // NOI18N
        btnNuevoProducto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevoProducto.png"))); // NOI18N
        btnNuevoProducto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevoProducto.png"))); // NOI18N
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });
        jPanel2EntradaNuevo.add(btnNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, -1));

        jtableNuevaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Nombre", "Descripcion", "Categoria", "Marca", "Cantidad", "PrecioCompra", "PrecioVenta", "      Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableNuevaEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtableNuevaEntrada.setPreferredSize(new java.awt.Dimension(300, 200));
        jScrollPane1.setViewportView(jtableNuevaEntrada);
        if (jtableNuevaEntrada.getColumnModel().getColumnCount() > 0) {
            jtableNuevaEntrada.getColumnModel().getColumn(0).setMinWidth(30);
            jtableNuevaEntrada.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel2EntradaNuevo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, 900, 230));

        jlblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblTotal.setForeground(new java.awt.Color(102, 102, 102));
        jlblTotal.setText("     Total");
        jPanel2EntradaNuevo.add(jlblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 360, 75, 25));

        jlblRecibido.setText("Nombre Usuario");
        jPanel2EntradaNuevo.add(jlblRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Q.");
        jPanel2EntradaNuevo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 360, -1, 25));

        getContentPane().add(jPanel2EntradaNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizarMouseClicked
         this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jlblMinimizarMouseClicked

    private void jtxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoActionPerformed

    private void jtxtNoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNoEntradaActionPerformed

    private void jtxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFechaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
       Entrada form= new Entrada();
       form.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
       RegistrarProducto form= new RegistrarProducto();
       form.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       ListaInventario form= new ListaInventario();
       form.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(EntradaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnComprar;
    public javax.swing.JButton btnNuevoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1EntradaNuevo;
    public javax.swing.JPanel jPanel2EntradaNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JComboBox<String> jcmbProveedor;
    public javax.swing.JLabel jlblBuscarIcono;
    public javax.swing.JLabel jlblEntrada;
    public javax.swing.JLabel jlblEntradaIcono;
    public javax.swing.JLabel jlblFecha;
    public javax.swing.JLabel jlblMinimizar;
    public javax.swing.JLabel jlblNoEntrada;
    public javax.swing.JLabel jlblNombreUsuario;
    public javax.swing.JLabel jlblProveedor;
    public javax.swing.JLabel jlblRecibido;
    public javax.swing.JLabel jlblRecibido1;
    public javax.swing.JLabel jlblRecibido2;
    public javax.swing.JLabel jlblTotal;
    public javax.swing.JTable jtableNuevaEntrada;
    public javax.swing.JTextField jtxtCodigo;
    public javax.swing.JTextField jtxtFecha;
    public javax.swing.JTextField jtxtNoEntrada;
    // End of variables declaration//GEN-END:variables
}
