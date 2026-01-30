
package SistemaCobro;

//En este caso de aplica  un 10%  de descuento si el cliente estuvo más de 5 horas.

public class DescuentoPorHoras implements Descuento {

    @Override
    public double aplicarDescuento(double total) {
        return total * 0.10;
    }
    
}
