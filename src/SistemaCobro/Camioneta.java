/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCobro;

// Se hereda de la clase abstracta Vehiculo
public class Camioneta extends Vehiculo {

    //instancia de atributos
    private boolean cargaPesada; // Si es de carga o no
    private String modelo;


    //Para la herencia
    public Camioneta(){
        super("", 0);
    }

    public Camioneta(String tipoVehiculo, double tarifaPorHora, boolean cargaPesada, String modelo) {
        super(tipoVehiculo, tarifaPorHora);
        this.cargaPesada = cargaPesada;
        this.modelo = modelo;
    }


    // Getters y Setters
    public void setCargaPesada(boolean cargaPesada) {
        this.cargaPesada = cargaPesada;
    }
    public boolean getCargaPesada() {
        return cargaPesada;
    } 

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo() {
        return modelo;
    }

    @Override
    public double calcularTarifa(int horas) {   
        return horas * tarifaPorHora;
    }


}
