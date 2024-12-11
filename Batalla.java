import java.util.*;

public class Batalla {

    // Método que simula la batalla entre dos soldados y devuelve el ganador.
    public static Soldado enfrentar(Soldado soldado1, Soldado soldado2) {
        int sumaVida = soldado1.getNivelVida() + soldado2.getNivelVida();

        Random random = new Random();
        double resultado = random.nextDouble() * sumaVida;  // Mejora: cálculo más sencillo y claro

        // Si el resultado es menor que la vida del primer soldado, él gana
        if (resultado < soldado1.getNivelVida()) {
            soldado1.nivelVida += 1;  // Mejora: aumento de vida sin usar set
            System.out.println(soldado1.getNombre() + " gana la batalla contra " + soldado2.getNombre());
            return soldado1;
        } else {
            soldado2.nivelVida += 1;  // Mejora: aumento de vida sin usar set
            System.out.println(soldado2.getNombre() + " gana la batalla contra " + soldado1.getNombre());
            return soldado2;
        }
    }

    // Método para verificar las reglas de batalla entre diferentes tipos de soldados
    public static boolean verificarReglasBatalla(Soldado soldado1, Soldado soldado2) {
        // Verifica las reglas especiales según el tipo de cada soldado y ajusta su vida
        if (soldado1 instanceof Caballero && soldado2 instanceof Arquero) {
            soldado1.nivelVida += 1; // Mejora: se aplica directamente la ventaja sin set
        } else if (soldado1 instanceof Caballero && soldado2 instanceof Lancero) {
            soldado2.nivelVida += 1; // Mejora: se aplica directamente la ventaja sin set
        } else if (soldado1 instanceof Arquero && soldado2 instanceof Lancero) {
            soldado1.nivelVida += 1; // Mejora: se aplica directamente la ventaja sin set
        } else if (soldado1 instanceof Caballero && soldado2 instanceof Espadachin) {
            soldado1.nivelVida += 1; // Mejora: se aplica directamente la ventaja sin set
        } else if (soldado1 instanceof Espadachin && soldado2 instanceof Lancero) {
            soldado1.nivelVida += 1; // Mejora: se aplica directamente la ventaja sin set
        } else {
            // Mejora: El mensaje se mantiene, pero con menos texto
            System.out.println("No se aplican reglas especiales de batalla.");
        }
        return true;
    }
}
