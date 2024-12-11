import java.util.Scanner;

public class Menu {

    public void iniciarSimulacion() {
        Scanner scanner = new Scanner(System.in);

        // Introducción a la historia
        System.out.println("Bienvenido a Velyndria, un continente al borde de la guerra.");
        System.out.println("Tres grandes conflictos definirán el destino de sus reinos. Tú decidirás cuál librar y qué bando liderar.\n");

        // Menú de conflictos
        System.out.println("Selecciona el conflicto en el que deseas participar:");
        System.out.println("1. Batalla de Valorthia (Reino de Eldoria vs. Imperio Ferrathien)");
        System.out.println("2. Batalla del Estrecho de Avenmar (Principado de Lysund vs. Reino de Darion)");
        System.out.println("3. Cruzada de Kalvora (Confederación de Kalvora vs. Reino de Zarnok)");
        System.out.print("Ingresa el número del conflicto que deseas simular: ");

        int conflictoSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Mostrar detalles del conflicto seleccionado
        String conflicto = "";
        String ejercito1 = "";
        String ejercito2 = "";

        switch (conflictoSeleccionado) {
            case 1:
                conflicto = "Batalla de Valorthia";
                ejercito1 = "Reino de Eldoria";
                ejercito2 = "Imperio Ferrathien";
                break;
            case 2:
                conflicto = "Batalla del Estrecho de Avenmar";
                ejercito1 = "Principado de Lysund";
                ejercito2 = "Reino de Darion";
                break;
            case 3:
                conflicto = "Cruzada de Kalvora";
                ejercito1 = "Confederación de Kalvora";
                ejercito2 = "Reino de Zarnok";
                break;
            default:
                System.out.println("Selección inválida. Saliendo del programa.");
                scanner.close();
                return;
        }

        System.out.println("\nHas seleccionado: " + conflicto);

        // Jugador 1 elige un ejército
        System.out.println("\nJugador 1, elige tu ejército:");
        System.out.println("1. " + ejercito1);
        System.out.println("2. " + ejercito2);
        System.out.print("Ingresa el número de tu elección: ");
        int eleccionJugador1 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        String ejercitoJugador1 = eleccionJugador1 == 1 ? ejercito1 : ejercito2;
        String ejercitoJugador2 = eleccionJugador1 == 1 ? ejercito2 : ejercito1;

        System.out.println("\nJugador 1 se une al: " + ejercitoJugador1);
        System.out.println("Jugador 2 se une al: " + ejercitoJugador2);

        // Confirmar inicio del juego
        System.out.println("\n¡La batalla está lista para comenzar! Prepara tus estrategias.");

        // Cierre del programa
        scanner.close();
    }
}
