
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class seronoser {    
    ConectarBD Con = new ConectarBD();
    
    static Connection conect;
    private String Cuenta;
    private String Producto;
    public static String Bodega;
    private String ProdxBod;

    
     public boolean CrearUsuario(uusuario datos ){
        conect = Con.Conexion();
        
        Cuenta = "insert into Cuentas (Login,Clave,Tipo)"
                + " values (?,?,?)";
        try {
             
            PreparedStatement pst3 = conect.prepareStatement(Cuenta);
            
            pst3.setString(1, datos.getlogin());
            pst3.setString(2, datos.getClave());
            pst3.setString(3, datos.getTipo());


            int N3 = pst3.executeUpdate();

            if (N3 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
    public int verificarLogin() {
        String login = CrearUsuario.txtuser.getText();
        Cuenta = "SELECT COUNT(Login) AS Login FROM Cuentas WHERE Login = " + login;

        try {
            conect = Con.Conexion(); 
            int loginResultante = 0;
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Cuenta);
            while (rs.next()) {
                loginResultante = rs.getInt("login");
            }

            return loginResultante;

        } catch (Exception e) {
            return 0;
        }

    }
    
    public boolean CrearBodega(boodega datos ){
        conect = Con.Conexion();
        
        Cuenta = "insert into Bodega (Codbod,Nombre)"
                + " values (?,?)";
        try {
             
            PreparedStatement pst3 = conect.prepareStatement(Cuenta);
            
            pst3.setInt(1, datos.getCodbod());
            pst3.setString(2, datos.getNombre());


            int N3 = pst3.executeUpdate();

            if (N3 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
     public boolean CrearProducto(pproducto prod , ProdxBode datos ){
        conect = Con.Conexion();
        
        Producto = "insert into Producto (Codprod , Descripcion , Precio)"
                + " values (?,?,?)";
        
        ProdxBod = "insert into Prodxbod ( Codprodxbod , Codbod, Codprod , Stock)"
                + " values (?,?,?,?)" ;
        try {
            PreparedStatement pst1 = conect.prepareStatement(Producto); 
            PreparedStatement pst2 = conect.prepareStatement(ProdxBod);
            
            pst1.setInt(1, prod.getCodprod());
            pst1.setString(2, prod.getDescripcion());
            pst1.setInt(3, prod.getPrecio());
            
            pst2.setString(1, datos.getCodprodxbod());
            pst2.setInt(2, datos.getCodbod());
            pst2.setInt(3, datos.getCodprod());
            pst2.setInt(4, datos.getStock());


            int N1 = pst1.executeUpdate();
            int N2 = pst2.executeUpdate();
       

            if ( N1 != 0 ||N2 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
      public boolean CrearMovimiento(movimientoss mov ){
        conect = Con.Conexion();
        
        Producto = "insert into Movimientos ( Numeromov , Codprod , Codbod , Tipomov , Cantidad , Fecha , Hora , Codresp)"
                + " values (?,?,?,?,?,?,?,?)";
        
 
        try {
            PreparedStatement pst1 = conect.prepareStatement(Producto); 

            
            pst1.setString(1, mov.getNumeromov());
            pst1.setInt(2, mov.getCodprod());
            pst1.setInt(3, mov.getCodbod());
            pst1.setString(4, mov.getTipomov());
            pst1.setInt(5, mov.getCantidad());
            pst1.setString(6, mov.getFecha());
            pst1.setString(7, mov.getHora());
            pst1.setString(8, mov.getCodresp());
            

            int N1 = pst1.executeUpdate();

       

            if ( N1 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
      public boolean CrearDepartamento(deepartamento datos ){
        conect = Con.Conexion();
        
        Cuenta = "insert into Departamento (Coddep,Nombre)"
                + " values (?,?)";
        try {
             
            PreparedStatement pst3 = conect.prepareStatement(Cuenta);
            
            pst3.setInt(1, datos.getCoddep());
            pst3.setString(2, datos.getNombre());


            int N3 = pst3.executeUpdate();

            if (N3 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
      public boolean CrearResponsable(reesponsable datos ){
        conect = Con.Conexion();
        
        Cuenta = "insert into Responsable (Codresp , Nombre , Cargo , Coddep)"
                + " values (?,?,?,?)";
        try {
             
            PreparedStatement pst3 = conect.prepareStatement(Cuenta);
            
            pst3.setString(1, datos.getCodresp());
            pst3.setString(2, datos.getNombre());
            pst3.setString(3, datos.getCargo());
             pst3.setInt(4, datos.getCoddep());
            


            int N3 = pst3.executeUpdate();

            if (N3 != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
      public boolean actualizarVender( String stck, String codprod){
        conect = Con.Conexion();
        boolean salida = true;
        try {
            String update = "Update Prodxbod set Stock = Stock - ? where Codprod = ?";
            PreparedStatement pst1 = conect.prepareStatement(update);  
            pst1.setString(1, stck);
            pst1.setString(2, codprod);
   
            int resultado = pst1.executeUpdate();
               
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error);
            salida=false;
        } 
        return salida;
    }
      public boolean actualizarReponer( String stck, String codprod){
        conect = Con.Conexion();
        boolean salida = true;
        try {
            String update = "Update Prodxbod set Stock = Stock + ? where Codprod = ?";
            PreparedStatement pst1 = conect.prepareStatement(update);  
            pst1.setString(1, stck);
            pst1.setString(2, codprod);
   
            int resultado = pst1.executeUpdate();
            
  
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error);
            salida=false;
        } 
        return salida;
    }
     
}

    


