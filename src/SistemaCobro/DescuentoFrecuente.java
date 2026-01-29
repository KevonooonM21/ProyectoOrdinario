/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCobro;

/**
 *
 * @author webon
 */
public class DescuentoFrecuente implements Descuento {
    private static final double DESCUENTO = 0.10; // 10% de descuento

    public DescuentoFrecuente() {
        // Constructor vacío
    }

    @Override
    public double aplicarDescuento(double total) {
        return total * (1 - DESCUENTO);
    }
    
}
