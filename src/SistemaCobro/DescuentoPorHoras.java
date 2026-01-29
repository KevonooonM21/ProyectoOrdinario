
package SistemaCobro;

/**
 *
 * @author webon
 */
public class DescuentoPorHoras implements Descuento {
    private int horasDescuento;
    private double porcentajeDescuento;

    // Constructor con parámetros
    public DescuentoPorHoras(int horasDescuento, double porcentajeDescuento) {  
        this.horasDescuento = horasDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
    }   
    // Constructor sin parámetros
    public DescuentoPorHoras() {
        this.horasDescuento = 0;
        this.porcentajeDescuento = 0;
    }   

    // Getters y Setters
    public int getHorasDescuento() {
        return horasDescuento;
    }       
    public void setHorasDescuento(int horasDescuento) {
        this.horasDescuento = horasDescuento;
    }
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double total) {
        return total - (total * (porcentajeDescuento / 100));
    }

    
    
}
