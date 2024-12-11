public class EspadachinReal extends Espadachin {
    private int numeroCuchillos;  // Número de cuchillos disponibles.
    private double tamanoCuchillos;  // Tamaño de los cuchillos.
    private int nivelEvolucion;  // Nivel de evolución del espadachín real.

    // Constructor que inicializa los atributos del EspadachinReal.
    public EspadachinReal(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);  // Llama al constructor de la clase base Espadachin.
        this.numeroCuchillos = 5;  // Se asignan valores predeterminados a los cuchillos y tamaño.
        this.tamanoCuchillos = 1.0;  
        this.nivelEvolucion = 1;  // El espadachín comienza en el nivel 1.
    }

    // Método para lanzar un cuchillo.
    public void lanzarCuchillo() {
        if (numeroCuchillos > 0) {
            System.out.println(nombre + " lanza un cuchillo de tamaño " + tamanoCuchillos + "!");
            numeroCuchillos--;  // Se reduce la cantidad de cuchillos al lanzarlos.
        } else {
            System.out.println(nombre + " no tiene más cuchillos.");
        }
    }

    // Método para evolucionar al espadachín real.
    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;  // Aumenta el nivel de evolución.
            numeroCuchillos += 2;  // Aumenta la cantidad de cuchillos.
            tamanoCuchillos += 0.5;  // Aumenta el tamaño de los cuchillos.
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + "!");
        } else {
            System.out.println(nombre + " ya ha alcanzado el nivel máximo de evolución.");
        }
    }

    // Método para mostrar la información sobre los cuchillos (opcional).
    public void mostrarInfoCuchillos() {
        System.out.println(nombre + " tiene " + numeroCuchillos + " cuchillos de tamaño " + tamanoCuchillos + " cada uno.");
    }
}
