

public class movimientoss {
    private String Numeromov;
    private int Codprod;
    private int Codbod;    
    private String Tipomov;
    private int Cantidad;  
    private String Fecha;
    private String Hora; 
    private String Codresp;
    public movimientoss() {
        
    }

    public movimientoss(String Numeromov ,int Codprod, int Codbod ,String Tipomov ,  int Cantidad , String Fecha , String Hora , String Codresp) {
        this.Numeromov = Numeromov;
        this.Codprod= Codprod;
        this.Codbod = Codbod;
        this.Codprod = Codprod;
        this.Tipomov= Tipomov;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
        this.Hora= Hora;
        this.Codresp= Codresp;
    }


    public String getNumeromov() {
        return Numeromov;
    }

    public void setNumeromov (String Numeromov) {
        this.Numeromov  = Numeromov ;
    }
    
    public int getCodprod() {
        return Codprod;
    }

    public void setCodprod(int Codprod) {
        this.Codprod = Codprod;
    }
    public int getCodbod() {
        return Codbod;
    }

    public void setCodbod(int Codbod) {
        this.Codbod = Codbod;
    }
    public String getTipomov() {
        return Tipomov;
    }

    public void setTipomov (String Tipomov) {
        this.Tipomov  = Tipomov ;
    }
    
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    public String getFecha() {
        return Fecha;
    }

    public void setFecha (String Fecha) {
        this.Fecha  = Fecha ;
    }
    
    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    public String getCodresp() {
        return Codresp;
    }

    public void setCodresp (String Codresp) {
        this.Codresp  = Codresp ;
    }
    
}
