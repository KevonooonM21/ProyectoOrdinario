/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCobro;

/**
 *
 * @author angel
 */
// Se hereda de la clase abstracta Vehiculo
public class Camioneta extends Vehiculo {
    private boolean carga; // Si es de carga o no
    private String modelo;

    public Camioneta(String tipoVehiculo, double tarifaPorHora, boolean carga, String modelo) {
        super(tipoVehiculo, tarifaPorHora);
        this.carga = carga;
        this.modelo = modelo;
    }

        // Constructor sin parametros
    public Camioneta(){
        super("", 0);
        this.carga = false;
        this.modelo = "";
        // Este no lleva nada, vacio
    }

    // Getters y Setters
    public boolean isCarga() {
        return carga;
    }       
    public void setCarga(boolean carga) {
        this.carga = carga;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public double aplicarDescuento(double total) {
        return total - (total * 0.15); // Aplicar descuento del 15%
    }   

}
