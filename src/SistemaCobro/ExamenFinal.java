/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SistemaCobro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
/**
 *
 * @author angel
 */
public class ExamenFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear y mostrar la ventana del sistema de cobro de estacionamiento
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaEstacionamiento();
            }
        });
    }
}
//hola xD
