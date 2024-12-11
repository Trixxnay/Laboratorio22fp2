import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ElegirReino extends JFrame {
    private ArrayList<JButton> botones = new ArrayList<>();
    private int index;
    private JLabel labelReinoSeleccionado;
    private JPanel JPanel1;
    private JButton siguienteButton; // El botón de "Siguiente"
    private static int creados=0;

    public ElegirReino() {
        creados++;
        setSize(400, 300);
        setLayout(new BorderLayout()); // Usamos BorderLayout para organización
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la ventana correctamente
        newJugador();
        setVisible(true);
    }

    private void newJugador() {
        // Crear el panel que contendrá las etiquetas de los reinos
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Para alinear los reinos verticalmente

        // Crear las etiquetas de los reinos con números
        for (int i = 0; i < Reino.REINOS_VALIDOS.length; i++) {
            JLabel label = new JLabel((i + 1) + ". " + Reino.REINOS_VALIDOS[i]); // Agregar el número junto al nombre del reino
            label.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinear las etiquetas al centro
            centerPanel.add(label);
        }

        // Crear un contenedor adicional para centrar el centerPanel
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Este panel usará FlowLayout centrado
        wrapperPanel.add(centerPanel);

        // Agregar el wrapperPanel al centro del BorderLayout
        add(wrapperPanel, BorderLayout.CENTER); // Centrar el panel dentro del centro

        JPanel1 = new JPanel();
        JPanel1.setLayout(new GridLayout(2, 3)); // Panel para los botones (2 filas y 3 columnas)

        // Crear los botones para seleccionar los reinos
        for (int i = 1; i <= Reino.REINOS_VALIDOS.length; i++) {
            JButton boton = new JButton(Integer.toString(i));
            botones.add(boton);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el texto del botón que se ha presionado
                    String botonTexto = ((JButton) e.getSource()).getText();

                    // Convertir el texto del botón a un índice (el botón contiene el número de 1 a N)
                    index = Integer.parseInt(botonTexto) - 1; // Restamos 1 para acceder al índice correcto

                    // Actualizar el JLabel con el reino seleccionado
                    labelReinoSeleccionado.setText("El jugador " + creados + " eligió: " + Reino.REINOS_VALIDOS[index]);

                    // Desactivar todos los botones después de elegir un reino
                    for (JButton btn : botones) {
                        btn.setEnabled(false); // Desactivar el botón
                    }

                    // Eliminar los botones del panel
                    removeBotones(); // Llamamos al método para eliminar los botones visualmente

                    // Mostrar el botón "Siguiente" solo después de seleccionar un reino
                    if (siguienteButton == null) {
                        siguienteButton = new JButton("Siguiente");
                        siguienteButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Cerrar la ventana al hacer clic en el botón "Siguiente"
                                dispose();
                            }
                        });
                        add(siguienteButton, BorderLayout.SOUTH); // Colocar el botón "Siguiente"
                        revalidate(); // Actualizar la interfaz
                    }
                }
            });
            JPanel1.add(boton);
        }
        add(JPanel1, BorderLayout.SOUTH); // Agregar el panel con botones de reinos

        // Crear una etiqueta para mostrar el reino seleccionado
        labelReinoSeleccionado = new JLabel("");
        labelReinoSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelReinoSeleccionado, BorderLayout.NORTH);
    }

    // Método para eliminar los botones visualmente
    private void removeBotones() {
        JPanel1.removeAll(); // Elimina todos los componentes (botones) del JPanel
        JPanel1.revalidate(); // Fuerza a que el panel se actualice visualmente
        JPanel1.repaint(); // Vuelve a pintar el panel para que los botones desaparezcan
    }

    public String getReinoElegido() {
        return Reino.REINOS_VALIDOS[index]; // Obtener el reino seleccionado
    }
}
