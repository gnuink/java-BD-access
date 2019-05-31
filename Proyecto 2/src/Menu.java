public class Menu extends javax.swing.JFrame {
    public Menu() {
        initComponents();
        setSize(290,410);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrearUsuario = new javax.swing.JButton();
        btnIngreso = new javax.swing.JButton();
        btnInformar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnVentasReponer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnCrearUsuario.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnCrearUsuario.setText("CREAR USUARIO");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearUsuario);
        btnCrearUsuario.setBounds(50, 53, 173, 50);

        btnIngreso.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnIngreso.setText("INGRESO DE DATOS");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngreso);
        btnIngreso.setBounds(50, 114, 173, 50);

        btnInformar.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnInformar.setText("INFORMAR DATOS");
        btnInformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInformar);
        btnInformar.setBounds(50, 243, 173, 50);

        btnsalir.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir);
        btnsalir.setBounds(90, 310, 102, 25);

        btnVentasReponer.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnVentasReponer.setText("VENTAS / REPONER STOCK ");
        btnVentasReponer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasReponerActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentasReponer);
        btnVentasReponer.setBounds(20, 180, 230, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(69, 12, 142, 35);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 550, 460);
        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        CrearUsuario men = new CrearUsuario();
        men.setVisible(true);
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        Ingresos men = new Ingresos();
        men.setVisible(true);
    }//GEN-LAST:event_btnIngresoActionPerformed

    private void btnInformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformarActionPerformed
        Informar men = new Informar();
        men.setVisible(true);
    }//GEN-LAST:event_btnInformarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnVentasReponerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasReponerActionPerformed
        Movimiento men = new Movimiento();
        men.setVisible(true);
    }//GEN-LAST:event_btnVentasReponerActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuBar Menu;
    public static javax.swing.JButton btnCrearUsuario;
    public static javax.swing.JButton btnInformar;
    public static javax.swing.JButton btnIngreso;
    public static javax.swing.JButton btnVentasReponer;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
