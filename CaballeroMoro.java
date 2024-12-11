public class CaballeroMoro extends Caballero {
    private int numeroFlechas;  // Número de flechas disponibles para el caballero moro.
    private double tamanoFlecha;  // Tamaño de las flechas que el caballero lanza.
    private int nivelEvolucion;  // Nivel de evolución del caballero moro.

    // Constructor que inicializa los atributos del caballero moro.
    public CaballeroMoro(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna, true);  // Llamada al constructor de la clase padre (Caballero).
        this.numeroFlechas = 5;  // El caballero empieza con 5 flechas.
        this.tamanoFlecha = 1.5;  // El tamaño de cada flecha es 1.5 (puedes modificar esto según el juego).
        this.nivelEvolucion = 1;  // El caballero empieza en nivel 1.
    }

    // Método para lanzar una flecha. Si hay flechas disponibles, se lanza una y se decrementa el contador.
    public void lanzarFlecha() {
        if (numeroFlechas > 0) {
            System.out.println(nombre + " lanza una flecha de tamaño " + tamanoFlecha + "!");
            numeroFlechas--;  // Se decrementa el número de flechas disponibles.
        } else {
            System.out.println(nombre + " no tiene más flechas.");
        }
    }

    // Método para realizar una envestida. Aumenta el ataque del caballero.
    public void envestir() {
        System.out.println(nombre + " realiza una envestida poderosa!");
        this.ataque += 5;  // Aumenta el ataque en 5 al realizar la envestida.
    }

    // Método para evolucionar al caballero moro. Mejora las flechas y el tamaño de las mismas con cada evolución.
    public void evolucionar() {
        if (nivelEvolucion < 4) {  // Verifica si el caballero ha alcanzado el nivel máximo de evolución.
            nivelEvolucion++;  // Aumenta el nivel de evolución.
            numeroFlechas += 3;  // Aumenta el número de flechas disponibles.
            tamanoFlecha += 0.5;  // Aumenta el tamaño de la flecha.
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + "!");
        } else {
            System.out.println(nombre + " ya ha alcanzado el nivel máximo de evolución.");
        }
    }
}
