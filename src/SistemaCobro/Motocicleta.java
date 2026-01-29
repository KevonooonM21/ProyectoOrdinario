
package SistemaCobro;


// Se hereda de la clase abstracta Vehiculo
public class Motocicleta extends Vehiculo {
    
    //Instancia de atributos
    private int cilindrada; // CC de la motocicleta
    private int ruedas;

    //Constructor con parametros
    public Motocicleta(int cilindrada, int ruedas, String tipoVehiculo, double tarifaPorHora) {
        super(tipoVehiculo, tarifaPorHora);
        this.cilindrada = cilindrada;
        this.ruedas = ruedas;
    }
    // constructor sin parametros
    public Motocicleta(){
        super("", 0);
        this.cilindrada = 0;
        this.ruedas = 0;
    }

    // Getters y Setters
    public int getCilindrada() {
        return cilindrada;
    }   
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public int getRuedas() {
        return ruedas;
    }
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public double calcularTarifa() {   
        return getTarifaPorHora();
    }
}
