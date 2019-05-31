

public class pproducto {

    private int Codprod;
    private String Descripcion;
    private int Precio;    
    public pproducto() {
        
    }

    public pproducto(int Codprod,String Descripcion, int Precio) {
        this.Codprod = Codprod;
        this.Descripcion= Descripcion;
        this.Precio = Precio;
    }


    public int getCodprod() {
        return Codprod;
    }

    public void setCodprod (int Codprod) {
        this.Codprod  = Codprod ;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    } 
}
