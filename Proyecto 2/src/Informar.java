
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Informar extends javax.swing.JFrame {

    ConectarBD Con = new ConectarBD();
    static Connection conect;

    public Informar() {
        initComponents();
        setSize(400, 350);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnstockinicio = new javax.swing.JButton();
        btndepartamentos = new javax.swing.JButton();
        btnresponsables = new javax.swing.JButton();
        btnstockfinal = new javax.swing.JButton();
        btnentrada = new javax.swing.JButton();
        btnsalida = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnstockinicio.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnstockinicio.setText("STOCK AL INICIO DE JORNADA LABORAL");
        btnstockinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstockinicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnstockinicio);
        btnstockinicio.setBounds(83, 11, 233, 30);

        btndepartamentos.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btndepartamentos.setText("PEDIDOS DEPARTAMENTOS");
        btndepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndepartamentosActionPerformed(evt);
            }
        });
        getContentPane().add(btndepartamentos);
        btndepartamentos.setBounds(108, 46, 190, 30);

        btnresponsables.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnresponsables.setText("PEDIDOS RESPONSABLES");
        btnresponsables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresponsablesActionPerformed(evt);
            }
        });
        getContentPane().add(btnresponsables);
        btnresponsables.setBounds(108, 81, 190, 30);

        btnstockfinal.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnstockfinal.setText("STOCK AL FINAL DE JORNADA LABORAL");
        btnstockfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstockfinalActionPerformed(evt);
            }
        });
        getContentPane().add(btnstockfinal);
        btnstockfinal.setBounds(83, 116, 233, 32);

        btnentrada.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnentrada.setText("MOVIMIENTOS DE ENTRADA");
        btnentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentradaActionPerformed(evt);
            }
        });
        getContentPane().add(btnentrada);
        btnentrada.setBounds(108, 153, 190, 30);

        btnsalida.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnsalida.setText("MOVIMIENTOS DE SALIDA");
        btnsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidaActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalida);
        btnsalida.setBounds(108, 188, 190, 30);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnvolver.setText("VOLVER");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(295, 266, 90, 21);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel1.setText("no funciona");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 470, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnresponsablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresponsablesActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/c.Informar los pedidos realizados por un responsable determinado..pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre del Responsable");
            tabla.addCell("Tipo de Movimiento");
            tabla.addCell("Descripcion del Producto");
            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Responsable.Nombre, Movimientos.Tipomov, Producto.Descripcion\n"
                        + "FROM Producto INNER JOIN (Responsable INNER JOIN Movimientos ON Responsable.Codresp = Movimientos.Codresp) ON Producto.Codprod = Movimientos.Codprod\n"
                        + "WHERE (((Movimientos.Tipomov)=\"SALIDA\"));");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°Los pedidos realizados por un "));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_btnresponsablesActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnstockinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstockinicioActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/A.Informar el stock al comenzar el día por producto y por bodega..pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Stock");
            tabla.addCell("Codigo del producto");
            tabla.addCell("Codigo de la  bodega");

            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Prodxbod.Stock, Producto.Codprod, Bodega.Codbod\n"
                        + "FROM Bodega INNER JOIN (Producto INNER JOIN Prodxbod ON Producto.Codprod = Prodxbod.Codprod) ON Bodega.Codbod = Prodxbod.Codbod;");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°a.Informar el stock al comenzar el día por producto y por bodega."));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_btnstockinicioActionPerformed

    private void btndepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndepartamentosActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/b.Informar los pedidos realizados por un departamento en particular..pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre del Departamento");
            tabla.addCell("Tipo de movimiento (salida");
            tabla.addCell("Codigo del producto");
            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Departamento.Nombre, Movimientos.Tipomov, Producto.Codprod\n" +
"FROM Producto INNER JOIN ((Departamento INNER JOIN Responsable ON Departamento.Coddep = Responsable.Coddep) INNER JOIN Movimientos ON Responsable.Codresp = Movimientos.Codresp) ON Producto.Codprod = Movimientos.Codprod\n" +
"WHERE (((Movimientos.Tipomov)=\"SALIDA\"));");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°b.Informar los pedidos realizados por un departamento en particular. "));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_btndepartamentosActionPerformed

    private void btnstockfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstockfinalActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/d.Informar el stock actualizado de cada producto por bodega al final del día.pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo de la bodega");
            tabla.addCell("Stick");
            tabla.addCell("Codigo del producto");
            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Bodega.Codbod, Prodxbod.Stock, Producto.Codprod\n"
                        + "FROM Bodega INNER JOIN (Producto INNER JOIN Prodxbod ON Producto.Codprod = Prodxbod.Codprod) ON Bodega.Codbod = Prodxbod.Codbod;");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°El stock actualizado de cada producto por bodega al final del día "));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_btnstockfinalActionPerformed

    private void btnentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentradaActionPerformed
        Entrdas men = new Entrdas();
        men.setVisible(true);
    }//GEN-LAST:event_btnentradaActionPerformed

    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidaActionPerformed
        Salida men = new Salida();
        men.setVisible(true);
    }//GEN-LAST:event_btnsalidaActionPerformed

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
            java.util.logging.Logger.getLogger(Informar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndepartamentos;
    private javax.swing.JButton btnentrada;
    private javax.swing.JButton btnresponsables;
    private javax.swing.JButton btnsalida;
    private javax.swing.JButton btnstockfinal;
    private javax.swing.JButton btnstockinicio;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
