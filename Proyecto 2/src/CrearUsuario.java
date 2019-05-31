import javax.swing.JOptionPane;
public class CrearUsuario extends javax.swing.JFrame {
    public CrearUsuario() {
        initComponents();
        setSize(500, 250);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userUsuario = new javax.swing.JLabel();
        userClave = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        btnguardarr = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        userAcceso = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Usuario");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Usuarios");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 180, 29);

        userUsuario.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        userUsuario.setText("USER:");
        getContentPane().add(userUsuario);
        userUsuario.setBounds(65, 68, 31, 13);

        userClave.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        userClave.setText("PASSWORD:");
        getContentPane().add(userClave);
        userClave.setBounds(48, 127, 62, 13);

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser);
        txtuser.setBounds(10, 89, 144, 20);
        getContentPane().add(txtpass);
        txtpass.setBounds(10, 150, 144, 20);

        btnguardarr.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnguardarr.setText("Guardar");
        btnguardarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarrActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardarr);
        btnguardarr.setBounds(330, 100, 90, 23);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(330, 130, 90, 23);

        userAcceso.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        userAcceso.setText("TIPO:");
        getContentPane().add(userAcceso);
        userAcceso.setBounds(207, 93, 26, 13);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Jefe Bodega","Operador"}));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        getContentPane().add(comboTipo);
        comboTipo.setBounds(157, 123, 144, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 550, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarrActionPerformed
        if (txtuser.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar user");
            txtuser.requestFocus();
            return;
        }
        if (txtpass.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una password");
            txtuser.requestFocus();
            return;
        }
        uusuario datos = new uusuario();
        seronoser funcion = new seronoser();
        int login = funcion.verificarLogin();
        if (login == 1) {
            JOptionPane.showMessageDialog(null, "Este user : " + txtuser.getText() + " ya esta ocupado por otro user.");
            txtuser.setText("");
            txtuser.requestFocus();
            return;
        }
        datos.setlogin(txtuser.getText());
        datos.setClave(txtpass.getText());
        int Tipo = comboTipo.getSelectedIndex();
        datos.setTipo((String) comboTipo.getItemAt(Tipo));
        if (funcion.CrearUsuario(datos)) {
            JOptionPane.showMessageDialog(null, "ingresado!!");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnguardarrActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        txtuser.transferFocus();
    }//GEN-LAST:event_txtuserActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        comboTipo.transferFocus();
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
    dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardarr;
    private javax.swing.JButton btnvolver;
    public javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField txtpass;
    public static javax.swing.JTextField txtuser;
    private javax.swing.JLabel userAcceso;
    private javax.swing.JLabel userClave;
    private javax.swing.JLabel userUsuario;
    // End of variables declaration//GEN-END:variables
}
