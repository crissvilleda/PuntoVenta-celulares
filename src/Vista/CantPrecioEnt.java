/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author criss
 */
public class CantPrecioEnt extends javax.swing.JFrame {

    /**
     * Creates new form CantPrecioEnt
     */
    public CantPrecioEnt() {
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

        jPanel1 = new javax.swing.JPanel();
        jtxtCantidad = new javax.swing.JTextField();
        jtxtPC = new javax.swing.JTextField();
        jtxtPV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblMensaje1 = new javax.swing.JLabel();
        jlblMensaje = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jlblCerrar2 = new javax.swing.JLabel();

        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 103, 103)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtCantidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtCantidad.setForeground(new java.awt.Color(153, 153, 153));
        jtxtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, 20));

        jtxtPC.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtPC.setForeground(new java.awt.Color(153, 153, 153));
        jtxtPC.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPCActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 20));

        jtxtPV.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtxtPV.setForeground(new java.awt.Color(153, 153, 153));
        jtxtPV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtxtPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPVActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtPV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(225, 99, 71));
        jLabel7.setText("Precio de Venta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(225, 99, 71));
        jLabel6.setText("Precio de Compra:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(225, 99, 71));
        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jlblMensaje1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jlblMensaje1.setForeground(new java.awt.Color(103, 103, 103));
        jlblMensaje1.setText("*Todos los campos son");
        jPanel1.add(jlblMensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jlblMensaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jlblMensaje.setForeground(new java.awt.Color(103, 103, 103));
        jlblMensaje.setText("obligatorios");
        jPanel1.add(jlblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregarb.png"))); // NOI18N
        btnSeleccionar.setBorder(null);
        btnSeleccionar.setBorderPainted(false);
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        btnSeleccionar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        btnSeleccionar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CajaAgregar.png"))); // NOI18N
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 85, 25));

        jlblCerrar2.setBackground(new java.awt.Color(255, 255, 255));
        jlblCerrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Multiply_32px.png"))); // NOI18N
        jlblCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblCerrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCerrar2MouseClicked(evt);
            }
        });
        jPanel1.add(jlblCerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCantidadActionPerformed

    private void jtxtPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPCActionPerformed

    private void jtxtPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPVActionPerformed

    private void jlblCerrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCerrar2MouseClicked

    }//GEN-LAST:event_jlblCerrar2MouseClicked

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
            java.util.logging.Logger.getLogger(CantPrecioEnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CantPrecioEnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CantPrecioEnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CantPrecioEnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CantPrecioEnt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jlblCerrar2;
    private javax.swing.JLabel jlblMensaje;
    private javax.swing.JLabel jlblMensaje1;
    public javax.swing.JTextField jtxtCantidad;
    public javax.swing.JTextField jtxtPC;
    public javax.swing.JTextField jtxtPV;
    // End of variables declaration//GEN-END:variables
}
