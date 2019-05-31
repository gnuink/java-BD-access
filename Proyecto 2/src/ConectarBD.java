
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConectarBD {
    static Connection conect;
    static String bd = "jdbc:ucanaccess://C:\\Users\\camil\\Documents\\NetBeansProjects\\Proyecto 2\\Proye.accdb";
    static String drv = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    public Connection Conexion(){
        try {
            Class.forName(drv) ;
        } catch(java.lang.ClassNotFoundException e) {
          JOptionPane.showMessageDialog(null,"SQLException: " + e);
            System.err.println(e.getMessage()) ;   
        }
        try {
            conect = DriverManager.getConnection(bd, "java", "sun");
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return conect;
    }
    void ConectarPostgres() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    ResultSet consultar(String select_Codbod__Nombre_FROM_Bodega) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

