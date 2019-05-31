

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

public class Salida extends javax.swing.JFrame {
    ConectarBD Con = new ConectarBD();
    static Connection conect;
    public Salida() {
        initComponents();
        setSize(410,380);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("MOVIMIENTOS DE SALIDA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 12, 222, 22);

        jButton1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jButton1.setText("PRESIONE AQUI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 100, 111, 21);

        btnvolver.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        btnvolver.setText("VOLVER");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver);
        btnvolver.setBounds(160, 260, 75, 21);

        jButton2.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jButton2.setText("PRESIONE AQUI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 160, 111, 21);

        jButton3.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jButton3.setText("PRESIONE AQUI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(140, 220, 111, 21);

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Cantidad de Movimientos de Salida por Bodega.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 70, 270, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setText("Cantidad de Movimientos de Salida por cada Producto en Bodega");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 360, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setText("Precio de los Movimientos de Salida por cada Producto en Bodega ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 190, 370, 15);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 480, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

//sdlkfj
                Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/i.Informar la cantidad total de movimientos de salida por bodega.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("SUMA total de la cantidad (salida)");
            tabla.addCell("nombre de la bodega");

            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Count(Movimientos.Tipomov) AS CuentaDeTipomov, Bodega.Nombre\n" +
"FROM (Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod) INNER JOIN Movimientos ON (Bodega.Codbod = Movimientos.Codbod) AND (Producto.Codprod = Movimientos.Codprod)\n" +
"GROUP BY Movimientos.Tipomov, Bodega.Nombre\n" +
"HAVING (((Movimientos.Tipomov)=\"Salida\"));");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°i.Informar la cantidad total de movimientos de salida por bodega."));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");
            documento.open();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ii. la cantidad total de unidades salida de cada producto por bodega en el día..pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("SUMA total de la cantidad (salida)");
            tabla.addCell("codigo del producto");
            tabla.addCell("nombre de la bodega");
            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Sum(Movimientos.Cantidad) AS SumaDeCantidad, Producto.Codprod, Bodega.Nombre\n" +
"FROM (Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod) INNER JOIN Movimientos ON (Bodega.Codbod = Movimientos.Codbod) AND (Producto.Codprod = Movimientos.Codprod)\n" +
"GROUP BY Movimientos.Tipomov, Producto.Codprod, Bodega.Nombre\n" +
"HAVING (((Movimientos.Tipomov)=\"SALIDA\"));");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°la cantidad total de unidades salida de cada producto por bodega en el día."));
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
            documento.open();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/iii. el monto equivalente a los movimientos de salida de cada producto por bodega .pdf"));// donde y como se llama el PDF
            documento.open();

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Total a pagar ");
            tabla.addCell("Codigo del Producto ");
            tabla.addCell("Nombre de la bodega");
            try {
                conect = Con.Conexion();
                PreparedStatement pst = conect.prepareStatement("SELECT Movimientos.Cantidad, Producto.Precio, [Cantidad]*[Precio] AS [Precio total], Producto.Codprod, Bodega.Nombre\n"
                        + "FROM (Producto INNER JOIN (Bodega INNER JOIN Prodxbod ON Bodega.Codbod = Prodxbod.Codbod) ON Producto.Codprod = Prodxbod.Codprod) INNER JOIN Movimientos ON (Bodega.Codbod = Movimientos.Codbod) AND (Producto.Codprod = Movimientos.Codprod)\n"
                        + "WHERE (((Movimientos.Tipomov)=\"SALIDA\"));");
                ResultSet rs = pst.executeQuery();
                documento.add(new Paragraph("°El monto equivalente a los movimientos de salida de cada producto por bodega "));
                documento.add(new Paragraph(" "));
                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, " El reporte se ha creado en el Desktop");
            documento.open();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
