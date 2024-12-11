import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JuegoDeBatalla {
    private final Ejercito ejercito1;
    private final Ejercito ejercito2;
    private final Mapa mapa;
    private final Scanner scanner;

    public JuegoDeBatalla(Mapa mapa, Ejercito ejercito1, Ejercito ejercito2) {
        this.mapa = mapa;
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarPosicionesSoldados(Ejercito ejercitoOponente) {
        System.out.println("Posiciones de los soldados del ejército oponente:");
        for (Soldado soldado : ejercitoOponente.getSoldados()) {
            System.out.printf("%s está en la posición (%d, %d)%n",
                              soldado.getNombre(), soldado.getFila(), soldado.getColumna());
        }
    }
    
    public void iniciar() {
        System.out.println("¡Bienvenidos al campo de batalla!");
        boolean juegoActivo = true;
        boolean turnoJugador1 = true;
    
        while (juegoActivo) {
            mapa.mostrarMapa(ejercito1, ejercito2);
            System.out.println("\nTurno del jugador " + (turnoJugador1 ? "1" : "2"));
    
            Ejercito ejercitoActual = turnoJugador1 ? ejercito1 : ejercito2;
            Ejercito ejercitoOponente = turnoJugador1 ? ejercito2 : ejercito1;
    
            if (!ejercitoActual.isEvolucionRealizada()) {
                ejercitoActual.intentarEvolucionar();
            }
    
            System.out.println("\nSoldados disponibles:");
            for (int i = 0; i < ejercitoActual.getSoldados().size(); i++) {
                System.out.println((i + 1) + ". " + ejercitoActual.getSoldados().get(i));
            }
    
            System.out.print("Selecciona el soldado a mover (número): ");
            int seleccion = scanner.nextInt() - 1;
    
            if (seleccion < 0 || seleccion >= ejercitoActual.getSoldados().size()) {
                System.out.println("Selección inválida. Pierdes tu turno.");
                turnoJugador1 = !turnoJugador1;
                continue;
            }
    
            Soldado soldadoSeleccionado = ejercitoActual.getSoldados().get(seleccion);
    
            mostrarPosicionesSoldados(ejercitoOponente);
    
            System.out.print("Ingresa la nueva fila: ");
            int nuevaFila = scanner.nextInt();
            System.out.print("Ingresa la nueva columna: ");
            int nuevaColumna = scanner.nextInt();
    
            if (mapa.esMovimientoValido(soldadoSeleccionado, nuevaFila, nuevaColumna)) {
                Soldado oponente = mapa.obtenerSoldadoEnPosicion(nuevaFila, nuevaColumna);
                if (oponente != null) {
                    System.out.println("¡Batalla entre " + soldadoSeleccionado.getNombre() + " y " + oponente.getNombre() + "!");
                    Soldado ganador = Batalla.enfrentar(soldadoSeleccionado, oponente);
                    if (ganador == soldadoSeleccionado) {
                        mapa.limpiarPosicion(oponente.getFila(), oponente.getColumna());
                        ejercitoOponente.getSoldados().remove(oponente);
                    } else {
                        mapa.limpiarPosicion(soldadoSeleccionado.getFila(), soldadoSeleccionado.getColumna());
                        ejercitoActual.getSoldados().remove(soldadoSeleccionado);
                    }
                } else {
                    mapa.moverSoldado(soldadoSeleccionado, nuevaFila, nuevaColumna);
                }
            } else {
                System.out.println("Movimiento inválido. Pierdes tu turno.");
            }
    
            if (ejercito1.getSoldados().isEmpty()) {
                mostrarResultadoFinal("Jugador 2", ejercito1, ejercito2);
            } else if (ejercito2.getSoldados().isEmpty()) {
                mostrarResultadoFinal("Jugador 1", ejercito1, ejercito2);
            }
        }
        System.out.println("Juego terminado.");
    } 

    private void mostrarResultadoFinal(String ganador, Ejercito ejercito1, Ejercito ejercito2) {
        JFrame frame = new JFrame("Resultado Final de la Batalla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JLabel labelGanador = new JLabel("¡El ganador es: " + ganador + "!", SwingConstants.CENTER);
        labelGanador.setFont(new Font("Arial", Font.BOLD, 20));
        labelGanador.setForeground(Color.BLUE);
        frame.add(labelGanador, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout());

        JPanel panelDetalles = new JPanel();
        panelDetalles.setLayout(new GridLayout(1, 2));

        JTextArea detallesEjercito1 = new JTextArea();
        detallesEjercito1.setText("Ejército de " + ejercito1.getNombreReino() + ":\n");
        for (Soldado soldado : ejercito1.getSoldados()) {
            detallesEjercito1.append(soldado.toString() + "\n");
        }
        detallesEjercito1.setEditable(false);
        panelDetalles.add(new JScrollPane(detallesEjercito1));

        JTextArea detallesEjercito2 = new JTextArea();
        detallesEjercito2.setText("Ejército de " + ejercito2.getNombreReino() + ":\n");
        for (Soldado soldado : ejercito2.getSoldados()) {
            detallesEjercito2.append(soldado.toString() + "\n");
        }
        detallesEjercito2.setEditable(false);
        panelDetalles.add(new JScrollPane(detallesEjercito2));

        panelCentral.add(panelDetalles, BorderLayout.CENTER);

        JPanel panelOpciones = new JPanel(new GridLayout(2, 1));

        JCheckBox verDetalles = new JCheckBox("Mostrar Detalles Complejos");
        verDetalles.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                detallesEjercito1.setBackground(Color.LIGHT_GRAY);
                detallesEjercito2.setBackground(Color.LIGHT_GRAY);
            } else {
                detallesEjercito1.setBackground(Color.WHITE);
                detallesEjercito2.setBackground(Color.WHITE);
            }
        });

        ButtonGroup grupoOpciones = new ButtonGroup();
        JRadioButton opcion1 = new JRadioButton("Opción 1");
        JRadioButton opcion2 = new JRadioButton("Opción 2");
        grupoOpciones.add(opcion1);
        grupoOpciones.add(opcion2);

        JPanel panelRadioButtons = new JPanel(new FlowLayout());
        panelRadioButtons.add(opcion1);
        panelRadioButtons.add(opcion2);

        panelOpciones.add(verDetalles);
        panelOpciones.add(panelRadioButtons);

        panelCentral.add(panelOpciones, BorderLayout.SOUTH);

        frame.add(panelCentral, BorderLayout.CENTER);

        JComboBox<String> opcionesFinales = new JComboBox<>(new String[] { "Guardar Resultado", "Cerrar", "Reiniciar" });
        JButton botonAccion = new JButton("Ejecutar");
        botonAccion.addActionListener(e -> {
            String seleccion = (String) opcionesFinales.getSelectedItem();
            switch (seleccion) {
                case "Guardar Resultado" -> JOptionPane.showMessageDialog(frame, "Resultados guardados.");
                case "Cerrar" -> frame.dispose();
                case "Reiniciar" -> JOptionPane.showMessageDialog(frame, "Reiniciando el juego...");
            }
        });

        JPanel panelInferior = new JPanel(new FlowLayout());
        panelInferior.add(opcionesFinales);
        panelInferior.add(botonAccion);

        frame.add(panelInferior, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
