
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IngresarProductos extends javax.swing.JFrame {
    ConectarBD Con = new ConectarBD();
    static Connection conect;
    public static String Bodega;
    public static int bodid;
        public IngresarProductos() {
        initComponents();
        setSize(510, 550);
        setLocationRelativeTo(null);
        txtcods.setVisible(false);
        txtres.setVisible(false);
        txtids.setVisible(false);
        consultar_Bodega();
        numeros();
        mostrardatos("");

    }
    void mostrardatos(String nombre) {
        conect = Con.Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("BODEGA");
        tbEliminar.setModel(modelo);
        String sql = "";
        if (nombre.equals("")) {
            sql = "SELECT Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre\n"
                    + "FROM Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod\n"
                    + " ORDER BY Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre";
        } else {
            sql = "SELECT Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre\n"
                    + "FROM Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod\n"
                    + "WHERE Producto.Descripcion='" + nombre + "' ORDER BY Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre";
        }

        String[] datos = new String[5];
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            tbEliminar.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
    }

    public void consultar_Bodega() {
        conect = Con.Conexion();
        Bodega = "SELECT  Nombre FROM Bodega ORDER BY Nombre ASC";

        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);
            combBodega.addItem("Seleccione una opción");

            while (rs.next()) {
                combBodega.addItem(rs.getString("Nombre"));

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }

    }

    void numeros() {
        conect = Con.Conexion();
        int j;

        String c = "";
        String Num = "SELECT MAX(Codprodxbod) AS Codprodxbod FROM Prodxbod";

        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Num);
            if (rs.next()) {
                c = rs.getString("Codprodxbod");
            }
            if (c == null) {
                txtcods.setText("0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);

                String juntar = "" + r1 + r2;

                int var = Integer.parseInt(juntar);
                numero gen = new numero();
                gen.generar(var);

                txtcods.setText(gen.serie());

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIngProduct = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jNombre = new javax.swing.JLabel();
        jStock = new javax.swing.JLabel();
        jPrecio = new javax.swing.JLabel();
        jBodega = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnvolver = new javax.swing.JButton();
        btnIngreso = new javax.swing.JButton();
        combBodega = new javax.swing.JComboBox<>();
        txtids = new javax.swing.JTextField();
        txtres = new javax.swing.JTextField();
        txtcods = new javax.swing.JTextField();
        tbdato = new javax.swing.JScrollPane();
        tbEliminar = new javax.swing.JTable();
        txtBuscarB = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnelimi = new javax.swing.JButton();
        btntodo = new javax.swing.JButton();
        jPrecio1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jIngProduct.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jIngProduct.setText("Producto");
        jIngProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jIngProductMousePressed(evt);
            }
        });
        getContentPane().add(jIngProduct);
        jIngProduct.setBounds(138, 14, 180, 22);

        jID.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jID.setText("Codigo->");
        getContentPane().add(jID);
        jID.setBounds(20, 50, 50, 13);

        jNombre.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jNombre.setText("Nombre->");
        getContentPane().add(jNombre);
        jNombre.setBounds(210, 50, 80, 13);

        jStock.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jStock.setText("Stock->");
        getContentPane().add(jStock);
        jStock.setBounds(20, 80, 50, 13);

        jPrecio.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jPrecio.setText("Ingrese el nombre Bodega->");
        getContentPane().add(jPrecio);
        jPrecio.setBounds(20, 170, 170, 13);

        jBodega.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jBodega.setText("Bodega->");
        getContentPane().add(jBodega);
        jBodega.setBounds(220, 80, 60, 13);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(80, 50, 115, 19);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(290, 50, 115, 19);

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        getContentPane().add(txtStock);
        txtStock.setBounds(80, 80, 115, 19);

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(80, 110, 110, 19);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(300, 440, 80, 25);

        btnIngreso.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnIngreso.setText("Ingresar");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngreso);
        btnIngreso.setBounds(10, 140, 370, 25);

        combBodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        combBodega.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combBodegaItemStateChanged(evt);
            }
        });
        combBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combBodegaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combBodegaMousePressed(evt);
            }
        });
        combBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combBodegaActionPerformed(evt);
            }
        });
        getContentPane().add(combBodega);
        combBodega.setBounds(290, 80, 115, 24);

        txtids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidsActionPerformed(evt);
            }
        });
        getContentPane().add(txtids);
        txtids.setBounds(160, 110, 32, 19);

        txtres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtresActionPerformed(evt);
            }
        });
        getContentPane().add(txtres);
        txtres.setBounds(310, 50, 32, 19);

        txtcods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodsActionPerformed(evt);
            }
        });
        getContentPane().add(txtcods);
        txtcods.setBounds(180, 50, 10, 20);

        tbEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbdato.setViewportView(tbEliminar);

        getContentPane().add(tbdato);
        tbdato.setBounds(10, 230, 390, 192);
        getContentPane().add(txtBuscarB);
        txtBuscarB.setBounds(200, 170, 116, 19);

        btnbuscar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar);
        btnbuscar.setBounds(320, 170, 80, 25);

        btnelimi.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnelimi.setText("Eliminar");
        btnelimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimiActionPerformed(evt);
            }
        });
        getContentPane().add(btnelimi);
        btnelimi.setBounds(10, 440, 90, 25);

        btntodo.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btntodo.setText("Mostrar Todo");
        btntodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntodoActionPerformed(evt);
            }
        });
        getContentPane().add(btntodo);
        btntodo.setBounds(10, 200, 370, 25);

        jPrecio1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jPrecio1.setText("Precio->");
        getContentPane().add(jPrecio1);
        jPrecio1.setBounds(20, 110, 50, 13);

        jButton1.setText("HELP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 440, 90, 25);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel1.setText("Ver antes de eliminar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 420, 110, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-80, 0, 780, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed

        if (txtCodigo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una ID");
            txtCodigo.requestFocus();
            return;
        }

        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar la descripcion");
            txtNombre.requestFocus();
            return;
        }

        if (txtStock.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Stock");
            txtStock.requestFocus();
            return;
        }

        if (txtPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una Precio");
            txtPrecio.requestFocus();
            return;
        }

        pproducto prod = new pproducto();
        ProdxBode datos = new ProdxBode();

        seronoser funcion = new seronoser();

        prod.setCodprod(Integer.parseInt(txtCodigo.getText()));
        prod.setDescripcion(txtNombre.getText());
        prod.setPrecio(Integer.parseInt(txtPrecio.getText()));

        datos.setCodprodxbod(txtcods.getText());
        datos.setCodprod(Integer.parseInt(txtCodigo.getText()));
        datos.setCodbod(Integer.parseInt(txtids.getText()));
        datos.setStock(Integer.parseInt(txtStock.getText()));

        if (funcion.CrearProducto(prod, datos)) {
            JOptionPane.showMessageDialog(null, "ingreso correctro!!");
            mostrardatos("");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }

    }//GEN-LAST:event_btnIngresoActionPerformed

    private void combBodegaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combBodegaItemStateChanged

    }//GEN-LAST:event_combBodegaItemStateChanged

    private void combBodegaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combBodegaMousePressed

    }//GEN-LAST:event_combBodegaMousePressed

    private void jIngProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIngProductMousePressed

    }//GEN-LAST:event_jIngProductMousePressed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        txtCodigo.transferFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        txtStock.transferFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void combBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combBodegaActionPerformed
        conect = Con.Conexion();
        Bodega = "SELECT  Codbod FROM Bodega Where Nombre = '" + this.combBodega.getSelectedItem() + "'";

        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);

            while (rs.next()) {
                this.txtids.setText(String.valueOf(rs.getInt("Codbod")));

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_combBodegaActionPerformed

    private void combBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combBodegaMouseClicked

    }//GEN-LAST:event_combBodegaMouseClicked

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        String id = txtCodigo.getText();
        txtres.setText(id);

    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtcodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodsActionPerformed
        txtcods.transferFocus();
    }//GEN-LAST:event_txtcodsActionPerformed

    private void txtidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidsActionPerformed
        txtids.transferFocus();
    }//GEN-LAST:event_txtidsActionPerformed

    private void txtresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtresActionPerformed
        txtres.transferFocus();
    }//GEN-LAST:event_txtresActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mostrardatos(txtBuscarB.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnelimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimiActionPerformed
        conect = Con.Conexion();
        int fila = tbEliminar.getSelectedRow();
        String cod;
        cod = "";
        cod = tbEliminar.getValueAt(fila, 0).toString();

        try {
            PreparedStatement pst = conect.prepareStatement("DELETE FROM Producto WHERE  Codprod='" + cod + "'");
            pst.executeUpdate();
            mostrardatos("");
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_btnelimiActionPerformed

    private void btntodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntodoActionPerformed
        mostrardatos("");
    }//GEN-LAST:event_btntodoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char ty = evt.getKeyChar();
        if ((((ty < '0') || (ty > '9'))) && (ty != KeyEvent.VK_BACK_SPACE) && (ty != KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        help help=new help();
        help.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnelimi;
    private javax.swing.JButton btntodo;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> combBodega;
    private javax.swing.JLabel jBodega;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jIngProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jNombre;
    private javax.swing.JLabel jPrecio;
    private javax.swing.JLabel jPrecio1;
    private javax.swing.JLabel jStock;
    private javax.swing.JTable tbEliminar;
    private javax.swing.JScrollPane tbdato;
    private javax.swing.JTextField txtBuscarB;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtcods;
    private javax.swing.JTextField txtids;
    private javax.swing.JTextField txtres;
    // End of variables declaration//GEN-END:variables
}
