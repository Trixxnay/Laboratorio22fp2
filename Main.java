import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mapa mapa = new Mapa(10, 10);

        Menu menu = new Menu();
        menu.iniciarSimulacion();
        
        String conflicto = "Batalla de Valorthia"; // Esto debería provenir del menú, por ahora lo dejamos fijo.
        String[] reinosSeleccionados = new String[2];

        System.out.println("Jugador 1 ha elegido: " + reinosSeleccionados[0]);

        System.out.println("------------------------------------------");

        System.out.println("Jugador 2 ha elegido: " + reinosSeleccionados[1]);

        System.out.println("------------------------------------------");

        Ejercito ejercito1 = new Ejercito(reinosSeleccionados[0]);
        ejercito1.generarSoldados(3);

        Ejercito ejercito2 = new Ejercito(reinosSeleccionados[1]);
        ejercito2.generarSoldados(3);

        ejercito1.mostrarSoldados();
        System.out.println("------------------------------------------");

        ejercito2.mostrarSoldados();
        System.out.println("------------------------------------------");

        for (Soldado soldado : ejercito1.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }

        for (Soldado soldado : ejercito2.getSoldados()) {
            mapa.colocarSoldado(soldado);
        }

        JuegoDeBatalla juego = new JuegoDeBatalla(mapa, ejercito1, ejercito2);
        juego.iniciar();

        scanner.close();
    }
}