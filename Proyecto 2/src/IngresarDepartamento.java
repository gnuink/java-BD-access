
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
public class IngresarDepartamento extends javax.swing.JFrame {

    public IngresarDepartamento() {
        initComponents();
        setSize(300, 300);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnvolver = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel1.setText("Ingresar Departamento");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 20, 214, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel2.setText("<-Codigo->");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 70, 60, 10);

        jLabel3.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel3.setText("<-Nombre->");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 120, 53, 13);

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigo);
        txtcodigo.setBounds(70, 90, 107, 20);
        getContentPane().add(txtnombre);
        txtnombre.setBounds(70, 140, 107, 20);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(130, 190, 80, 21);

        btnguardar.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar);
        btnguardar.setBounds(20, 190, 100, 21);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel4.setText("jLabel2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-80, 0, 800, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtcodigo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un ID");
            txtcodigo.requestFocus();
            return;
        }

        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una Direccion");
            txtnombre.requestFocus();
            return;
        }

        deepartamento datos = new deepartamento();
        seronoser funcion = new seronoser();

        datos.setCoddep(Integer.parseInt(txtcodigo.getText()));
        datos.setNombre(txtnombre.getText());

        if (funcion.CrearDepartamento(datos)) {
            JOptionPane.showMessageDialog(null, " exito!");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed

    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char ty = evt.getKeyChar();
        if ((((ty < '0') || (ty > '9'))) && (ty != KeyEvent.VK_BACK_SPACE) && (ty != KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

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
            java.util.logging.Logger.getLogger(IngresarDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarDepartamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
