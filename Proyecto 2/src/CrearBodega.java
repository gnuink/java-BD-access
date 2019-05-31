import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
public class CrearBodega extends javax.swing.JFrame {
    public CrearBodega() {
        initComponents();
        setSize(380,270);
        setLocationRelativeTo(null);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bodID = new javax.swing.JLabel();
        bodNombre = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnvolver = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setText("Ingresar Bodega");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(105, 16, 142, 22);

        bodID.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        bodID.setText("<-Codigo->");
        getContentPane().add(bodID);
        bodID.setBounds(134, 48, 52, 13);

        bodNombre.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        bodNombre.setText("<-Nombre->");
        getContentPane().add(bodNombre);
        bodNombre.setBounds(134, 107, 53, 13);

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
        txtcodigo.setBounds(105, 74, 119, 20);

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtnombre);
        txtnombre.setBounds(105, 127, 119, 20);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(234, 125, 75, 23);

        btnguardar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar);
        btnguardar.setBounds(230, 70, 90, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 550, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtcodigo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un codigo");
            txtcodigo.requestFocus();
            return;
        }
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una nombre");
            txtnombre.requestFocus();
            return;
        }

        boodega datos = new boodega();
        seronoser funcion = new seronoser();
        
        datos.setCodbod(Integer.parseInt(txtcodigo.getText()));
        datos.setNombre(txtnombre.getText());

        if (funcion.CrearBodega(datos)) {
            JOptionPane.showMessageDialog(null, "exito!");

        } else {
            JOptionPane.showMessageDialog(null, "error de ingreso");
        }
    
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        txtcodigo.transferFocus();        
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
           char ty =evt.getKeyChar();
            if ((((ty<'0')||(ty>'9')))&&(ty!=KeyEvent.VK_BACK_SPACE) && (ty!=KeyEvent.VK_ENTER)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

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
            java.util.logging.Logger.getLogger(CrearBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearBodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearBodega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bodID;
    private javax.swing.JLabel bodNombre;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
