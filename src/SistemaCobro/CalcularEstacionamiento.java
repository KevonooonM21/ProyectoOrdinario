
package SistemaCobro;


import java.time.LocalTime;
import java.time.Duration;



//Esta clase se agrego toda la logica que se ocuapra en todas las clases que heredan

public class CalcularEstacionamiento {

    // Calcular horas de estancia redondeando hacia arriba
    public int calcularHoras(LocalTime entrada, LocalTime salida) {
        Duration duracion = Duration.between(entrada, salida);
        long minutos = duracion.toMinutes();
        // Convertir minutos a horas redondeando hacia arriba
        int horas = (int) Math.ceil(minutos / 60.0);
        return horas;
    }
      
    
    // Calcular total sin descuento
    public double totalSinDescuento(Vehiculo v, int horas) {
        return v.calcularTarifa(horas);
    }

    // Aplicar descuento si existe
    public double aplicarDescuento(double total, Descuento d) {

        if (d == null) {
            return 0;
        }

        return d.aplicarDescuento(total);
    }
    
    // Total final
    public double totalFinal(double total, double descuento) {
        return total - descuento;
    }

    // Validar monto recibido
    public boolean validarMonto(double recibido, double totalFinal) {
        return recibido >= totalFinal;
    }

    // Calcular cambio
    public double calcularCambio(double recibido, double totalFinal) {
        return recibido - totalFinal;
    }
}


