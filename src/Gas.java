
import java.io.Serializable;

public class Gas implements Serializable{
    
    private double disel;
    private double magna;
    private double premiun;
    
    //Los datos mandados se almacenan aqui
    public Gas(double disel, double magna, double premiun) {
        this.disel = disel;
        this.magna = magna;
        this.premiun = premiun;
    }

    public double getDisel() {
        return disel;
    }

    public void setDisel(double disel) {
        this.disel = disel;
    }

    public double getMagna() {
        return magna;
    }

    public void setMagna(double magna) {
        this.magna = magna;
    }

    public double getPremiun() {
        return premiun;
    }

    public void setPremiun(double premiun) {
        this.premiun = premiun;
    }
    
}
    


   