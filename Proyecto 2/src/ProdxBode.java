
public class ProdxBode {
    private String Codprodxbod;
    private int Codprod;
    private int Codbod;
    private int Stock;    
    public ProdxBode() {
        
    }

    public ProdxBode(String Codprodxbod ,int Codprod,int Codbod, int Stock) {
        this.Codprodxbod = Codprodxbod;
        this.Codprod = Codprod;
        this.Codbod= Codbod;
        this.Stock = Stock;
    }


    public String getCodprodxbod() {
        return Codprodxbod;
    }

    public void setCodprodxbod (String Codprodxbod) {
        this.Codprodxbod  = Codprodxbod ;
    }
    public int getCodprod() {
        return Codprod;
    }

    public void setCodprod (int Codprod) {
        this.Codprod  = Codprod ;
    }
    
    public int getCodbod() {
        return Codbod;
    }

    public void setCodbod(int Codbod) {
        this.Codbod = Codbod;
    }
    
    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }  
}
