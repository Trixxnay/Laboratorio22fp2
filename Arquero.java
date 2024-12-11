public class Arquero extends Soldado {
    private int flechasDisponibles;

    // Constructor que inicializa todos los atributos del arquero, incluyendo el número de flechas.
    public Arquero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, int flechasDisponibles) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
        this.flechasDisponibles = flechasDisponibles;
    }

    @Override
    public void accionEspecial() {
        // Verifica si el arquero tiene flechas disponibles antes de realizar la acción especial
        if (flechasDisponibles > 0) {
            System.out.println(nombre + " dispara una flecha, aumentando su ataque temporalmente.");
            this.ataque += 5;  // Aumenta el ataque del arquero temporalmente al disparar una flecha.
            flechasDisponibles--;  // Reduce el número de flechas disponibles en uno.
            System.out.println("Flechas restantes: " + flechasDisponibles);  // Imprime el número de flechas restantes después de disparar.
        } else {
            System.out.println(nombre + " no tiene flechas disponibles.");
        }
    }

    // Método adicional para recuperar flechas. Permite al arquero recuperar una cantidad específica de flechas.
    // Este cambio se añadió para darle al arquero la posibilidad de reponer sus flechas durante el juego.
    public void recuperarFlechas(int cantidad) {
        flechasDisponibles += cantidad;  // Aumenta las flechas disponibles en la cantidad indicada.
        System.out.println(nombre + " ha recuperado " + cantidad + " flechas. Flechas disponibles: " + flechasDisponibles);
    }

    // Método para obtener la cantidad actual de flechas disponibles. Se añadió para poder consultar el número de flechas en cualquier momento.
    public int obtenerFlechasDisponibles() {
        return flechasDisponibles;  // Retorna la cantidad de flechas disponibles.
    }
}
