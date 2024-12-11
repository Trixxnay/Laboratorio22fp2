public class CaballeroFranco extends Caballero {
    private int numeroLanzas;  // Número de lanzas disponibles
    private double tamanoLanza;  // Tamaño de cada lanza
    private int nivelEvolucion;  // Nivel de evolución del caballero

    // Constructor que inicializa el caballero franco con parámetros específicos
    public CaballeroFranco(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna, true);  // Llama al constructor de la clase base Caballero
        this.numeroLanzas = 3;  // El caballero comienza con 3 lanzas
        this.tamanoLanza = 2.0;  // El tamaño inicial de la lanza
        this.nivelEvolucion = 1;  // Comienza en el primer nivel de evolución
    }

    // Método para lanzar una lanza si el caballero tiene lanzas disponibles
    public void lanzarLanza() {
        if (numeroLanzas > 0) {
            System.out.println(nombre + " lanza una lanza de tamaño " + tamanoLanza + "!");
            numeroLanzas--;  // Disminuye el número de lanzas disponibles
        } else {
            System.out.println(nombre + " no tiene más lanzas.");  // Mensaje si no tiene lanzas
        }
    }

    // Método para evolucionar al caballero, mejorando sus atributos
    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;  // Aumenta el nivel de evolución
            numeroLanzas += 1;  // Aumenta el número de lanzas disponibles
            tamanoLanza += 0.5;  // Aumenta el tamaño de la lanza
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + "!");
        } else {
            System.out.println(nombre + " ya ha alcanzado el nivel máximo de evolución.");  // Mensaje si ya está en el nivel máximo
        }
    }

    // Mejora: Método para obtener el número actual de lanzas
    public int getNumeroLanzas() {
        return numeroLanzas;
    }

    // Mejora: Método para obtener el tamaño actual de las lanzas
    public double getTamanoLanza() {
        return tamanoLanza;
    }

    // Mejora: Método para obtener el nivel de evolución
    public int getNivelEvolucion() {
        return nivelEvolucion;
    }
}
