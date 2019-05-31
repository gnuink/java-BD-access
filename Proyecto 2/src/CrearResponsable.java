import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class CrearResponsable extends javax.swing.JFrame {
    ConectarBD Con = new ConectarBD();
    static Connection conect;
    public static String query;
    public CrearResponsable() {
        initComponents();
        consultar();
        txtCod.setVisible(false);
        setSize(550, 300);
        setLocationRelativeTo(null);
                num();
    }
    public void consultar() {
        conect = Con.Conexion();
        String Bodega = "SELECT  Nombre FROM Departamento ORDER BY Nombre ASC";

        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);
            comdepart.addItem("Seleccione una opción");

            while (rs.next()) {
                comdepart.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    void num() {
        conect = Con.Conexion();
        String c = "";
        String Num = "SELECT MAX(Codresp) AS Codresp FROM Responsable";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Num);
            if (rs.next()) {
                c = rs.getString("Codresp");
            }
            if (c == null) {
                txtCod.setText("0001");
            } else {
                char r3 = c.charAt(2);
                char r2s = c.charAt(3);

                String juntar = "" + r3 + r2s;

                int var = Integer.parseInt(juntar);
                numero gen = new numero();
                gen.generar(var);

                txtCod.setText(gen.serie());

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        Nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Departamento = new javax.swing.JLabel();
        IResponsable = new javax.swing.JLabel();
        comdepart = new javax.swing.JComboBox<String>();
        txtdep = new javax.swing.JTextField();
        txtcar = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        Cargo = new javax.swing.JLabel();
        btnguar = new javax.swing.JButton();
        txtvolver = new javax.swing.JButton();
        Departamento1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        Nombre.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        Nombre.setText("<-Nombre");
        getContentPane().add(Nombre);
        Nombre.setBounds(190, 72, 44, 13);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 122, 0, 0);

        Departamento.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        Departamento.setText("Departamento->");
        getContentPane().add(Departamento);
        Departamento.setBounds(255, 72, 89, 13);

        IResponsable.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        IResponsable.setText("Responsable");
        getContentPane().add(IResponsable);
        IResponsable.setBounds(104, 11, 106, 22);

        comdepart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comdepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comdepartActionPerformed(evt);
            }
        });
        getContentPane().add(comdepart);
        comdepart.setBounds(354, 68, 105, 20);
        getContentPane().add(txtdep);
        txtdep.setBounds(357, 124, 35, 20);
        getContentPane().add(txtcar);
        txtcar.setBounds(14, 124, 158, 20);
        getContentPane().add(txtnombre);
        txtnombre.setBounds(16, 68, 158, 20);

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        getContentPane().add(txtCod);
        txtCod.setBounds(130, 70, 30, 10);

        Cargo.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        Cargo.setText("<-Cargo");
        getContentPane().add(Cargo);
        Cargo.setBounds(204, 128, 37, 13);

        btnguar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnguar.setText("Guardar");
        btnguar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguar);
        btnguar.setBounds(405, 122, 85, 23);

        txtvolver.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        txtvolver.setText("Salir");
        txtvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvolverActionPerformed(evt);
            }
        });
        getContentPane().add(txtvolver);
        txtvolver.setBounds(405, 151, 85, 23);

        Departamento1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        Departamento1.setText("ID departamento->");
        getContentPane().add(Departamento1);
        Departamento1.setBounds(268, 128, 85, 13);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-80, 0, 950, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvolverActionPerformed
        dispose();
    }//GEN-LAST:event_txtvolverActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed

    }//GEN-LAST:event_txtCodActionPerformed

    private void comdepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comdepartActionPerformed
        conect = Con.Conexion();
        query = "SELECT  Coddep FROM Departamento Where Nombre = '" + this.comdepart.getSelectedItem() + "'";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                this.txtdep.setText(String.valueOf(rs.getInt("Coddep")));
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_comdepartActionPerformed

    private void btnguarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguarActionPerformed

        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar la nombre");
            txtnombre.requestFocus();
            return;
        }
        if (txtcar.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una cargo");
            txtcar.requestFocus();
            return;
        }

        reesponsable datos = new reesponsable();

        seronoser funcion = new seronoser();

        datos.setCodresp(txtCod.getText());
        datos.setNombre(txtnombre.getText());
        datos.setCargo(txtcar.getText());
        datos.setCoddep(Integer.parseInt(txtdep.getText()));

        if (funcion.CrearResponsable(datos)) {
            JOptionPane.showMessageDialog(null, "ingreso realizado!");
        } else {
            JOptionPane.showMessageDialog(null, "eror en el ingreso");
        }
    }//GEN-LAST:event_btnguarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearResponsable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearResponsable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cargo;
    private javax.swing.JLabel Departamento;
    private javax.swing.JLabel Departamento1;
    private javax.swing.JLabel IResponsable;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnguar;
    private javax.swing.JComboBox<String> comdepart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtcar;
    private javax.swing.JTextField txtdep;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JButton txtvolver;
    // End of variables declaration//GEN-END:variables
}
