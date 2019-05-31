
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Movimiento extends javax.swing.JFrame implements Runnable {

    String hora, minuto, segundo;
    public static String stck, codprod;
    Thread hilo;
    static Connection conect;
    public static String Producto;
    public static String Bodega;
    ConectarBD Con = new ConectarBD();

    public Movimiento() {
        initComponents();
        setSize(600,550);
        setLocationRelativeTo(null);
        txtfech.setText(fecha());
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);

        txtsalida.setVisible(false);
        txtentra.setVisible(false);
        txthor.setVisible(false);
        codi.setVisible(false);
        txtm.setVisible(false);
        pre.setVisible(false);
        sat.setVisible(false);
        txtcod.setVisible(false);
        txtfech.setVisible(false);

        des.setVisible(false);
        sto.setVisible(false);
                consultar_Bodega();
        mostrardatos("");
        numeros();
        consultar_Resp();
        limpiar();
    }

    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }

    public void hora() {
        Calendar c = new GregorianCalendar();
        Date hor = new Date();
        c.setTime(hor);
        hora = c.get(Calendar.HOUR_OF_DAY) > 9 ? "" + c.get(Calendar.HOUR_OF_DAY) : "O" + c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE) > 9 ? "" + c.get(Calendar.MINUTE) : "O" + c.get(Calendar.MINUTE);
        segundo = c.get(Calendar.SECOND) > 9 ? "" + c.get(Calendar.SECOND) : "O" + c.get(Calendar.SECOND);
    }

    public void run() {
        Thread current = Thread.currentThread();
        while (current == hilo) {
            hora();
            txthor.setText(hora + ":" + minuto + ":" + segundo);
        }
    }

    public void consultar_Bodega() {
        conect = Con.Conexion();
        Bodega = "SELECT  Nombre FROM Bodega ORDER BY Nombre ASC";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);
            combopro.addItem("Seleccione una opción");
            while (rs.next()) {
                combopro.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultar_Resp() {
        conect = Con.Conexion();
        Bodega = "SELECT  Nombre FROM Responsable ORDER BY Nombre ASC";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);
            combres.addItem("Seleccione una opción");
            while (rs.next()) {
                combres.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void numeros() {
        conect = Con.Conexion();
        int j;
        String c = "";
        String Num = "SELECT MAX(Numeromov) AS Numeromov FROM Movimientos";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Num);
            if (rs.next()) {
                c = rs.getString("Numeromov");
            }
            if (c == null) {
                txtm.setText("0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                String juntar = "" + r1 + r2;
                int var = Integer.parseInt(juntar);
                numero gen = new numero();
                gen.generar(var);
                txtm.setText(gen.serie());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void mostrardatos(String nombre) {
        conect = Con.Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("BODEGA");
        tbproducto.setModel(modelo);
        String sql = "";
        if (nombre.equals(nombre)) {
            sql = "SELECT Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre\n"
                    + "FROM Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod\n"
                    + "WHERE Bodega.Nombre='" + nombre + "'ORDER BY Producto.Codprod, Producto.Descripcion, Prodxbod.Stock, Producto.Precio, Bodega.Nombre";
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
            tbproducto.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcod = new javax.swing.JTextField();
        txtm = new javax.swing.JTextField();
        txtfech = new javax.swing.JTextField();
        txthor = new javax.swing.JTextField();
        txtentra = new javax.swing.JTextField();
        txtsalida = new javax.swing.JTextField();
        combopro = new javax.swing.JComboBox<>();
        txtcan = new javax.swing.JTextField();
        btnvolver = new javax.swing.JButton();
        tbdato = new javax.swing.JScrollPane();
        tbproducto = new javax.swing.JTable();
        brnbuscar = new javax.swing.JButton();
        btnvender = new javax.swing.JButton();
        btnstock = new javax.swing.JButton();
        jLabelRes = new javax.swing.JLabel();
        txtrespo = new javax.swing.JTextField();
        jLabelPrecio = new javax.swing.JLabel();
        txttol = new javax.swing.JTextField();
        codi = new javax.swing.JTextField();
        des = new javax.swing.JTextField();
        sto = new javax.swing.JTextField();
        pre = new javax.swing.JTextField();
        sat = new javax.swing.JTextField();
        jCant2 = new javax.swing.JLabel();
        combres = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCant1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });

        txtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmActionPerformed(evt);
            }
        });

        txtfech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechActionPerformed(evt);
            }
        });

        txthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthorActionPerformed(evt);
            }
        });

        txtentra.setText("ENTRADA");

        txtsalida.setText("SALIDA");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        combopro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        combopro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproItemStateChanged(evt);
            }
        });
        combopro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboproActionPerformed(evt);
            }
        });
        getContentPane().add(combopro);
        combopro.setBounds(10, 80, 128, 20);

        txtcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcanActionPerformed(evt);
            }
        });
        txtcan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcanKeyTyped(evt);
            }
        });
        getContentPane().add(txtcan);
        txtcan.setBounds(50, 340, 128, 20);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnvolver.setText("VOLVER");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(440, 440, 110, 21);

        tbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        tbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproductoMouseClicked(evt);
            }
        });
        tbdato.setViewportView(tbproducto);

        getContentPane().add(tbdato);
        tbdato.setBounds(0, 110, 582, 160);

        brnbuscar.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        brnbuscar.setText("BUSCAR BODEGA");
        brnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(brnbuscar);
        brnbuscar.setBounds(140, 80, 150, 20);

        btnvender.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnvender.setText("VENDER");
        btnvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnvender);
        btnvender.setBounds(200, 300, 150, 21);

        btnstock.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnstock.setText("INGRESAR STOCK");
        btnstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstockActionPerformed(evt);
            }
        });
        getContentPane().add(btnstock);
        btnstock.setBounds(200, 330, 150, 21);

        jLabelRes.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabelRes.setText("<-Responsable->");
        getContentPane().add(jLabelRes);
        jLabelRes.setBounds(60, 360, 110, 15);
        getContentPane().add(txtrespo);
        txtrespo.setBounds(200, 380, 110, 20);

        jLabelPrecio.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabelPrecio.setText("<-Total->");
        getContentPane().add(jLabelPrecio);
        jLabelPrecio.setBounds(80, 410, 60, 15);
        getContentPane().add(txttol);
        txttol.setBounds(50, 430, 128, 20);
        getContentPane().add(codi);
        codi.setBounds(600, 125, 30, 20);
        getContentPane().add(des);
        des.setBounds(600, 120, 30, 20);
        getContentPane().add(sto);
        sto.setBounds(600, 120, 30, 20);
        getContentPane().add(pre);
        pre.setBounds(600, 120, 30, 20);
        getContentPane().add(sat);
        sat.setBounds(600, 120, 30, 20);

        jCant2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jCant2.setText("<-Cantidad->");
        getContentPane().add(jCant2);
        jCant2.setBounds(70, 320, 90, 15);

        combres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        combres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combresActionPerformed(evt);
            }
        });
        getContentPane().add(combres);
        combres.setBounds(50, 380, 130, 28);

        jLabel2.setFont(new java.awt.Font("Arial", 2, 36)); // NOI18N
        jLabel2.setText("MOVIMIENTOS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 0, 270, 70);

        jCant1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jCant1.setText("<-Codigo Responsable->");
        getContentPane().add(jCant1);
        jCant1.setBounds(190, 360, 140, 15);

        jButton1.setText("HELP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 300, 73, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Para saber la cantidad total presione la casilla del producto ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 280, 360, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboproItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproItemStateChanged


    }//GEN-LAST:event_comboproItemStateChanged

    private void comboproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboproActionPerformed
        conect = Con.Conexion();
        Bodega = "SELECT  Codbod FROM Bodega Where Nombre = '" + this.combopro.getSelectedItem() + "'";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);

            while (rs.next()) {
                this.txtcod.setText(String.valueOf(rs.getInt("Codbod")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_comboproActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void brnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnbuscarActionPerformed
        mostrardatos((String) this.combopro.getSelectedItem());
    }//GEN-LAST:event_brnbuscarActionPerformed

    private void btnvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenderActionPerformed

        if (txtcan.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Stock");
            txtcan.requestFocus();
            return;
        }
        if (txtrespo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Responsable");
            txtrespo.requestFocus();
            return;
        }
        int cantidad, stock;
        cantidad = Integer.parseInt(txtcan.getText());
        stock = Integer.parseInt(sto.getText());
        if (cantidad > stock) {
            JOptionPane.showMessageDialog(null, "NO HAY SUFICIENTE STOCK");
        } else {
            movimientoss mov = new movimientoss();
            seronoser fuction = new seronoser();
            mov.setNumeromov(txtm.getText());
            mov.setCodprod(Integer.parseInt(codi.getText()));
            mov.setCodbod(Integer.parseInt(txtcod.getText()));
            mov.setTipomov(txtsalida.getText());
            mov.setCantidad(Integer.parseInt(txtcan.getText()));
            mov.setFecha(txtfech.getText());
            mov.setHora(txthor.getText());
            mov.setCodresp(txtrespo.getText());
            conect = Con.Conexion();
            boolean guardar = true;
            stck = txtcan.getText();
            codprod = codi.getText();
            if (guardar) {
                seronoser fun = new seronoser();
                boolean resultSalida = fun.actualizarVender(stck, codprod);
                if (resultSalida) {

                } else {
                    txtcan.requestFocus();
                }
            }
            if (fuction.CrearMovimiento(mov)) {
                JOptionPane.showMessageDialog(null, "El producto fue ingresado al sistema!!");
                limpiar();
                mostrardatos("");
                numeros();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar Datos");
            }
        }
    }//GEN-LAST:event_btnvenderActionPerformed
    void limpiar() {
        txtcan.setText("");
    }
    private void btnstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstockActionPerformed

        if (txtcan.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingresar un Stock");
            txtcan.requestFocus();
            return;
        }
        if (txtrespo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingresar un Responsable");
            txtrespo.requestFocus();
            return;
        }
        movimientoss mov = new movimientoss();
        seronoser fuction = new seronoser();
        mov.setNumeromov(txtm.getText());
        mov.setCodprod(Integer.parseInt(codi.getText()));
        mov.setCodbod(Integer.parseInt(txtcod.getText()));
        mov.setTipomov(txtentra.getText());
        mov.setCantidad(Integer.parseInt(txtcan.getText()));
        mov.setFecha(txtfech.getText());
        mov.setHora(txthor.getText());
        mov.setCodresp(txtrespo.getText());
        conect = Con.Conexion();
        boolean guardar = true;
        stck = txtcan.getText();
        codprod = codi.getText();
        if (guardar) {
            seronoser fun = new seronoser();
            boolean resultSalida = fun.actualizarReponer(stck, codprod);
            if (resultSalida) {
            } else {
                txtcan.requestFocus();
            }
        }
        if (fuction.CrearMovimiento(mov)) {
            JOptionPane.showMessageDialog(null, "El producto fue ingresado al sistema!!");
            limpiar();
            mostrardatos("");
            numeros();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar Datos");
        }
    }//GEN-LAST:event_btnstockActionPerformed

    private void txtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmActionPerformed
        txtm.transferFocus();
    }//GEN-LAST:event_txtmActionPerformed

    private void tbproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductoMouseClicked
        int i;
        i = this.tbproducto.getSelectedRow();
        codi.setText(tbproducto.getValueAt(i, 0).toString());
        des.setText(tbproducto.getValueAt(i, 1).toString());
        sto.setText(tbproducto.getValueAt(i, 2).toString());
        pre.setText(tbproducto.getValueAt(i, 3).toString());
        sat.setText(tbproducto.getValueAt(i, 4).toString());
    }//GEN-LAST:event_tbproductoMouseClicked

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        conect = Con.Conexion();
        String Resp = "SELECT  Codresp FROM Responsable Where Nombre = '" + this.combres.getSelectedItem() + "'";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Resp);
            while (rs.next()) {
                this.txtrespo.setText(String.valueOf(rs.getInt("Coddep")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtcodActionPerformed

    private void txtcanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcanKeyReleased
        double precio, total;
        int cantidad;
        precio = Double.parseDouble(pre.getText());
        cantidad = Integer.parseInt(txtcan.getText());
        total = precio * cantidad;
        txttol.setText(total + "");
    }//GEN-LAST:event_txtcanKeyReleased

    private void combresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combresActionPerformed
        conect = Con.Conexion();
        Bodega = "SELECT Codresp FROM Responsable Where Nombre = '" + this.combres.getSelectedItem() + "'";
        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Bodega);

            while (rs.next()) {
                this.txtrespo.setText(String.valueOf(rs.getString("Codresp")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_combresActionPerformed

    private void txtcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcanActionPerformed

    }//GEN-LAST:event_txtcanActionPerformed

    private void txtcanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcanKeyTyped
        char ty = evt.getKeyChar();
        if ((((ty < '0') || (ty > '9'))) && (ty != KeyEvent.VK_BACK_SPACE) && (ty != KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtcanKeyTyped

    private void txtfechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechActionPerformed

    private void txthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthorActionPerformed

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
            java.util.logging.Logger.getLogger(Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnbuscar;
    private javax.swing.JButton btnstock;
    private javax.swing.JButton btnvender;
    private javax.swing.JButton btnvolver;
    private javax.swing.JTextField codi;
    private javax.swing.JComboBox<String> combopro;
    private javax.swing.JComboBox<String> combres;
    private javax.swing.JTextField des;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCant1;
    private javax.swing.JLabel jCant2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelRes;
    private javax.swing.JTextField pre;
    private javax.swing.JTextField sat;
    private javax.swing.JTextField sto;
    private javax.swing.JScrollPane tbdato;
    private javax.swing.JTable tbproducto;
    private javax.swing.JTextField txtcan;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtentra;
    private javax.swing.JTextField txtfech;
    private javax.swing.JTextField txthor;
    private javax.swing.JTextField txtm;
    private javax.swing.JTextField txtrespo;
    private javax.swing.JTextField txtsalida;
    private javax.swing.JTextField txttol;
    // End of variables declaration//GEN-END:variables

}
