package SistemaCobro;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class VentanaEstacionamiento extends JFrame {

    // Etiquetas para mostrar los resultados
    private JLabel lblHoras, lblTotal, lblDescuento, lblFinal, lblCambio;

    public VentanaEstacionamiento() {

        setTitle("Sistema de Cobro de Estacionamiento");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Titulo principal del sistema
        JLabel titulo = new JLabel("SISTEMA DE COBRO DE ESTACIONAMIENTO", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        // Panel central que contiene todos los componentes
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        add(panelCentral, BorderLayout.CENTER);

        // Seleccion del tipo de vehiculo
        JPanel panelVehiculo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelVehiculo.add(new JLabel("Tipo de vehiculo:"));

        JRadioButton auto = new JRadioButton("Automovil");
        JRadioButton moto = new JRadioButton("Motocicleta");
        JRadioButton camioneta = new JRadioButton("Camioneta");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(auto);
        grupo.add(moto);
        grupo.add(camioneta);

        panelVehiculo.add(auto);
        panelVehiculo.add(moto);
        panelVehiculo.add(camioneta);
        panelCentral.add(panelVehiculo);

        // Captura de hora de entrada y salida
        JPanel panelHoras = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField txtEntrada = new JTextField();
        JTextField txtSalida = new JTextField();

        panelHoras.add(new JLabel("Hora de entrada (HH:mm):"));
        panelHoras.add(txtEntrada);
        panelHoras.add(new JLabel("Hora de salida (HH:mm):"));
        panelHoras.add(txtSalida);

        panelCentral.add(panelHoras);

        // Seleccion de descuentos
        JPanel panelDescuentos = new JPanel(new GridLayout(2, 1));
        panelDescuentos.setBorder(BorderFactory.createTitledBorder("Descuentos"));

        JCheckBox chkHoras = new JCheckBox("Mas de 5 horas (10%)");
        JCheckBox chkFrecuente = new JCheckBox("Cliente frecuente (15%)");

        panelDescuentos.add(chkHoras);
        panelDescuentos.add(chkFrecuente);
        panelCentral.add(panelDescuentos);

        // Panel de pago
        JPanel panelPago = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPago.add(new JLabel("Monto recibido: $"));
        JTextField txtMonto = new JTextField(10);
        panelPago.add(txtMonto);

        JButton btnCalcular = new JButton("CALCULAR");
        JButton btnFinalizar = new JButton("FINALIZAR");

        panelPago.add(btnCalcular);
        panelPago.add(btnFinalizar);
        panelCentral.add(panelPago);

        // Panel donde se muestran los resultados
        JPanel panelResultados = new JPanel(new GridLayout(5, 2));
        panelResultados.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));

        lblHoras = new JLabel("0");
        lblTotal = new JLabel("$0.00");
        lblDescuento = new JLabel("$0.00");
        lblFinal = new JLabel("$0.00");
        lblCambio = new JLabel("$0.00");

        panelResultados.add(new JLabel("Horas de estancia:"));
        panelResultados.add(lblHoras);

        panelResultados.add(new JLabel("Total sin descuento:"));
        panelResultados.add(lblTotal);

        panelResultados.add(new JLabel("Descuento aplicado:"));
        panelResultados.add(lblDescuento);

        panelResultados.add(new JLabel("Total a pagar:"));
        panelResultados.add(lblFinal);

        panelResultados.add(new JLabel("Cambio a devolver:"));
        panelResultados.add(lblCambio);

        panelCentral.add(panelResultados);

        // Logica del boton calcular
        btnCalcular.addActionListener(e -> {

            // Obtener horas de entrada y salida
            LocalTime entrada = LocalTime.parse(txtEntrada.getText());
            LocalTime salida = LocalTime.parse(txtSalida.getText());

            // Calculo de horas de estancia
            CalcularEstacionamiento calc = new CalcularEstacionamiento();
            int horas = calc.calcularHoras(entrada, salida);

            // Determinar el tipo de vehiculo usando polimorfismo
            Vehiculo vehiculo = null;

            if (auto.isSelected()) {
                vehiculo = new Automovil("Auto", 20, 4, 5);
            } else if (moto.isSelected()) {
                vehiculo = new Motocicleta(250, 2, "Moto", 10);
            } else if (camioneta.isSelected()) {
                vehiculo = new Camioneta("Camioneta", 30, false, "Pickup");
            }

            // Validar que se haya seleccionado un vehiculo
            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un tipo de vehiculo",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calcular total sin descuento
            double total = calc.totalSinDescuento(vehiculo, horas);

            // Aplicar descuentos si corresponde
            double descuento = 0;

            if (chkHoras.isSelected() && horas > 5) {
                descuento += new DescuentoPorHoras().aplicarDescuento(total);
            }

            if (chkFrecuente.isSelected()) {
                descuento += new DescuentoFrecuente().aplicarDescuento(total);
            }

            // Calcular total final
            double totalFinal = calc.totalFinal(total, descuento);

            // Obtener monto recibido
            double recibido = Double.parseDouble(txtMonto.getText());

            // Validar monto recibido
            if (!calc.validarMonto(recibido, totalFinal)) {
                JOptionPane.showMessageDialog(this,
                        "Monto insuficiente",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calcular cambio
            double cambio = calc.calcularCambio(recibido, totalFinal);

            // Mostrar resultados en la interfaz
            lblHoras.setText(horas + " horas");
            lblTotal.setText("$" + total);
            lblDescuento.setText("$" + descuento);
            lblFinal.setText("$" + totalFinal);
            lblCambio.setText("$" + cambio);
        });

        // Boton para cerrar el sistema
        btnFinalizar.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
