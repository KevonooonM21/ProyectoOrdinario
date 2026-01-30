
package SistemaCobro;

//En este caso se aplica un 15% de descuento si el cliente es frecuente.

public class DescuentoFrecuente implements Descuento {
    @Override
    public double aplicarDescuento(double total) {
        return total * 0.15;
    }

    
}
