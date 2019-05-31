

 
public class reesponsable {
   
private String Codresp;
private String Nombre  ;
private String Cargo  ;
private int Coddep  ;

    public reesponsable() {
    }

    public reesponsable( String Codresp, String Nombre, String Cargo ,  int Coddep) {
        this.Codresp = Codresp;
        this.Nombre = Nombre;
        this.Cargo  = Cargo ;
        this.Coddep = Coddep;
    }

 

    public  String getCodresp() {
        return Codresp;
    }

    public void setCodresp ( String Codresp) {
        this.Codresp = Codresp;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCargo () {
        return Cargo ;
    }

    public void setCargo (String Cargo ) {
        this.Cargo  = Cargo ;
    }

    public  int getCoddep() {
        return Coddep;
    }

    public void setCoddep( int Coddep) {
        this.Coddep = Coddep;
    }

 


    
    
}
