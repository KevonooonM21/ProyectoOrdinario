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
public class Automovil extends Vehiculo{

    //instancia de atributos
    private int puertas;
    private int pasajeros;

    // Constructor con parametros
    public Automovil(String tipoVehiculo, double tarifaPorHora, int puertas, int pasajeros) {
        super(tipoVehiculo, tarifaPorHora);
        this.puertas = puertas;
        this.pasajeros = pasajeros;
    }
    //Constructor sin parametros
    public Automovil(){
        super("", 0);
        this.puertas = 0;
        this.pasajeros = 0;
    }

    // Getters y Setters
    public int getPuertas() {
        return puertas;
    }
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }   
    public int getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public double calcularTarifa(int horas) {
        return horas * tarifaPorHora;
    }
}