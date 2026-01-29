
package SistemaCobro;

public abstract class Vehiculo implements Descuento {
    protected String tipoVehiculo;
    protected double tarifaPorHora;

    //Constructor vacio 
    public Vehiculo(){
    }
    
    //Constructor con parámetros
    public Vehiculo (String tipoVehiculo, double tarifaporhora){
        this.tipoVehiculo = tipoVehiculo;
        this.tarifaPorHora = tarifaPorHora;
    }

    //Metodos de acceso Stter y Getter
    public void setTipo(String tipoVehiculo){
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipo(){
        return tipoVehiculo;
    }

    public void settTarifaPorHora(double tarifaPorHora){
        this.tarifaPorHora = tarifaPorHora;
    }

    public double getTarifaPorHora(){
        return tarifaPorHora;
    }

    //Implementación del método abstracto de calcularTarifa
    public abstract double calcularTarifa();

}
