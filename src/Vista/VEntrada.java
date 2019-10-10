/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Orlando
 */
public class VEntrada extends javax.swing.JFrame {

    /**
     * Creates new form Usuario
     */
    public VEntrada() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1Entrada = new javax.swing.JPanel();
        jlblEntradaIcono = new javax.swing.JLabel();
        jlblInicio = new javax.swing.JLabel();
        jlblMinimizar = new javax.swing.JLabel();
        jlblEntrada = new javax.swing.JLabel();
        jlblNombreUsuario = new javax.swing.JLabel();
        jPanel2Entrada = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableEntrada = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jtxtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlblBuscarIcono = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1Entrada.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1Entrada.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanel1Entrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblEntradaIcono.setBackground(new java.awt.Color(255, 255, 255));
        jlblEntradaIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconoCarrito.png"))); // NOI18N
        jlblEntradaIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1Entrada.add(jlblEntradaIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 100));

        jlblInicio.setBackground(new java.awt.Color(255, 255, 255));
        jlblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Inicio.png"))); // NOI18N
        jlblInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblInicioMouseClicked(evt);
            }
        });
        jPanel1Entrada.add(jlblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 30, 30));

        jlblMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        jlblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jlblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizarMouseClicked(evt);
            }
        });
        jPanel1Entrada.add(jlblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        jlblEntrada.setBackground(new java.awt.Color(255, 255, 255));
        jlblEntrada.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jlblEntrada.setForeground(new java.awt.Color(238, 112, 85));
        jlblEntrada.setText("Entrada");
        jPanel1Entrada.add(jlblEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jlblNombreUsuario.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jlblNombreUsuario.setForeground(new java.awt.Color(105, 105, 105));
        jlblNombreUsuario.setText("Nombre del Usuario");
        jPanel1Entrada.add(jlblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 65, 340, -1));

        getContentPane().add(jPanel1Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2Entrada.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2Entrada.setPreferredSize(new java.awt.Dimension(1000, 400));
        jPanel2Entrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtableEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Recibido por", "Proveedor", "Fecha", "Cantidad", "PrecioCompra", "Imprimir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtableEntrada.setPreferredSize(new java.awt.Dimension(300, 200));
        jScrollPane1.setViewportView(jtableEntrada);
        if (jtableEntrada.getColumnModel().getColumnCount() > 0) {
            jtableEntrada.getColumnModel().getColumn(0).setMinWidth(30);
            jtableEntrada.getColumnModel().getColumn(0).setMaxWidth(40);
            jtableEntrada.getColumnModel().getColumn(1).setMinWidth(170);
            jtableEntrada.getColumnModel().getColumn(1).setMaxWidth(180);
            jtableEntrada.getColumnModel().getColumn(2).setMinWidth(160);
            jtableEntrada.getColumnModel().getColumn(2).setMaxWidth(170);
            jtableEntrada.getColumnModel().getColumn(3).setMinWidth(50);
            jtableEntrada.getColumnModel().getColumn(3).setMaxWidth(60);
            jtableEntrada.getColumnModel().getColumn(4).setMinWidth(50);
            jtableEntrada.getColumnModel().getColumn(4).setMaxWidth(60);
            jtableEntrada.getColumnModel().getColumn(5).setMinWidth(90);
            jtableEntrada.getColumnModel().getColumn(5).setMaxWidth(100);
            jtableEntrada.getColumnModel().getColumn(6).setMinWidth(50);
            jtableEntrada.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        jPanel2Entrada.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 670, 230));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevob.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevo.png"))); // NOI18N
        btnNuevo.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevo.png"))); // NOI18N
        btnNuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaNuevo.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2Entrada.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, -1));

        jtxtBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jtxtBuscar.setBorder(null);
        jtxtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBuscarActionPerformed(evt);
            }
        });
        jPanel2Entrada.add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 200, 20));

        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel2Entrada.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 240, -1));

        jSeparator2.setPreferredSize(new java.awt.Dimension(1000, 10));
        jPanel2Entrada.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jlblBuscarIcono.setBackground(new java.awt.Color(255, 255, 255));
        jlblBuscarIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Search_32px.png"))); // NOI18N
        jPanel2Entrada.add(jlblBuscarIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscarb.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        btnBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaBuscar.png"))); // NOI18N
        jPanel2Entrada.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 75, 25));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Buscar por Responsable o Fecha");
        jPanel2Entrada.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 54, 220, -1));

        getContentPane().add(jPanel2Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizarMouseClicked
         this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jlblMinimizarMouseClicked

    private void jlblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblInicioMouseClicked

    }//GEN-LAST:event_jlblInicioMouseClicked

    private void jtxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

    }//GEN-LAST:event_btnNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(VEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1Entrada;
    public javax.swing.JPanel jPanel2Entrada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlblBuscarIcono;
    public javax.swing.JLabel jlblEntrada;
    public javax.swing.JLabel jlblEntradaIcono;
    public javax.swing.JLabel jlblInicio;
    public javax.swing.JLabel jlblMinimizar;
    public javax.swing.JLabel jlblNombreUsuario;
    public javax.swing.JTable jtableEntrada;
    public javax.swing.JTextField jtxtBuscar;
    // End of variables declaration//GEN-END:variables
}
