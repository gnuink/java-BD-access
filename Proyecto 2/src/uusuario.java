
public class uusuario{
    
    private String login;
    private String Clave;
    private String Tipo;    
    public uusuario() {
        
    }

    public uusuario(String login,String Clave, String Tipo) {
        this.login = login;
        this.Clave= Clave;
        this.Tipo = Tipo;
    }


    public String getlogin() {
        return login;
    }

    public void setlogin (String login) {
        this.login  = login ;
    }
    
    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
