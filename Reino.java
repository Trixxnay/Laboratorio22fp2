import java.util.*;

public class Reino {
    private String nombre;
    private String descripcion;

    public Reino(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Reino[] inicializarReinos() {
        return new Reino[] {
            new Reino("Eldoria", "Un reino tradicionalista conocido por sus magos de batalla y campos fértiles."),
            new Reino("Ferrathien", "Un imperio expansionista con un ejército poderoso y disciplinado."),
            new Reino("Lysund", "Un principado marítimo con flotas mercantes y hábiles navegantes."),
            new Reino("Darion", "Un reino militar que busca dominar el comercio marítimo."),
            new Reino("Kalvora", "Una confederación unida por la fe en los Cinco Dioses Eternos."),
            new Reino("Zarnok", "Un reino teocrático que sigue el oscuro culto de la Llama Oscura.")
        };
    }

    public static void mostrarReinos(Reino[] reinos) {
        for (int i = 0; i < reinos.length; i++) {
            System.out.println((i + 1) + ". " + reinos[i].getNombre() + " - " + reinos[i].getDescripcion());
        }
    }

    public static Reino seleccionarReino(Scanner scanner, Reino[] reinos, Set<String> reinosYaSeleccionados, int jugador) {
        Reino reinoSeleccionado = null;
        boolean seleccionValida = false;

        while (!seleccionValida) {
            System.out.println("Jugador " + jugador + ", selecciona tu reino:");
            mostrarReinos(reinos);
            System.out.print("Ingresa el número de tu reino: ");
            int seleccion = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpiar el buffer

            if (seleccion >= 0 && seleccion < reinos.length) {
                reinoSeleccionado = reinos[seleccion];
                if (!reinosYaSeleccionados.contains(reinoSeleccionado.getNombre())) {
                    reinosYaSeleccionados.add(reinoSeleccionado.getNombre());
                    seleccionValida = true;
                    System.out.println("Jugador " + jugador + " ha elegido: " + reinoSeleccionado.getNombre());
                } else {
                    System.out.println("Ese reino ya ha sido elegido. Elige otro.");
                }
            } else {
                System.out.println("Selección inválida. Intenta nuevamente.");
            }
        }
        return reinoSeleccionado;
    }
}
