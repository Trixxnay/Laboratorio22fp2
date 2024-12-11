public class Espadachin extends Soldado {
    private double longitudEspada;  // Longitud de la espada del espadachín.

    // Constructor que inicializa los atributos heredados de Soldado y la longitud de la espada.
    public Espadachin(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);  // Llama al constructor de la clase padre (Soldado).
    }

    // Acción especial del espadachín: crea un muro de escudos, aumentando su defensa.
    @Override
    public void accionEspecial() {
        System.out.println(nombre + " crea un muro de escudos, aumentando su defensa en 3 puntos.");
        this.defensa += 3;  // Aumenta la defensa del espadachín en 3 puntos al realizar la acción especial.
    }

    // Getter para la longitud de la espada.
    public double getLongitudEspada() {
        return longitudEspada;
    }

    // Setter para la longitud de la espada (en caso de que se quiera cambiar).
    public void setLongitudEspada(double longitudEspada) {
        this.longitudEspada = longitudEspada;
    }

    // Método adicional opcional para mostrar información relevante de la espada (si lo deseas).
    public void mostrarInfoEspada() {
        System.out.println("La espada de " + nombre + " tiene una longitud de " + longitudEspada + " metros.");
    }
}
