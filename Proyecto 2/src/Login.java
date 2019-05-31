
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    ConectarBD Con = new ConectarBD();
    static Connection conect;
    static Statement st;
    ResultSet rs;
    String query;
    public static String tipo_acc ;  
void entrar (){
    this.entrarUsuario(user.getText(),password.getText());
        switch (tipo_acc) {
            case "Administrador":
                {
                    Menu n = new Menu();
                    n.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null,"Bienvenido Administrador","java",2);
                    Menu.btnCrearUsuario.setEnabled(true);
                    Menu.btnVentasReponer.setEnabled(true);
                    Menu.btnIngreso.setEnabled(true);
                    Menu.btnInformar.setEnabled(true);
                    Menu.btnsalir.setEnabled(true);
                    break;
                }
            case "Jefe Bodega":
                {
                    Menu n = new Menu();
                    n.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null,"Bienvenido Jefe de Bodega","java",2);
                    Menu.btnCrearUsuario.setEnabled(false);
                    Menu.btnVentasReponer.setEnabled(true);
                    Menu.btnIngreso.setEnabled(true);
                    Menu.btnInformar.setEnabled(true);
                    Menu.btnsalir.setEnabled(true);
                    break;
                }
            default:
                {
                    Menu n = new Menu();
                    n.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null,"Bienvenido Operador","java",2);
                    Menu.btnCrearUsuario.setEnabled(false);
                    Menu.btnVentasReponer.setEnabled(true);
                    Menu.btnIngreso.setEnabled(false);
                    Menu.btnInformar.setEnabled(true);
                    Menu.btnsalir.setEnabled(true);
                    break;
                }
        }

}
    public Login() {
        initComponents();
        setSize(500,390);
        setLocationRelativeTo(null);
    }
void entrarUsuario(String Login , String Clave){

    query = "Select * From Cuentas where Login='"+Login+"'";
    
    try{
        conect = Con.Conexion();
        st=conect.createStatement(); 
        rs=st.executeQuery(query);
    
        String pass ="" , nom = "", tipo = "";
        
        if(rs.next()){
            nom= rs.getString("Login");
            pass= rs.getString("Clave");
            tipo= rs.getString("tipo");
        }
        if(Clave.equals(pass)){
            tipo_acc = tipo ;
            
        }else{
            JOptionPane.showMessageDialog(null,"Los Datos no son Correctos","java",1);
            user.setText("");
            password.setText("");
        }   
        
        
    }catch (SQLException | HeadlessException e){
    
}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 150, 70, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 210, 90, 17);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user);
        user.setBounds(150, 170, 180, 30);

        btnIngresar.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(40, 290, 120, 25);

        btnSalir.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(350, 290, 90, 25);
        getContentPane().add(password);
        password.setBounds(150, 230, 180, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-490, -160, 1010, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed

    }//GEN-LAST:event_userActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
       entrar();        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
