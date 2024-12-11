public class Lancero extends Soldado {
    private double longitudLanza;  // Longitud de la lanza del lancero.

    // Constructor que inicializa los atributos heredados de Soldado y la longitud de la lanza.
    public Lancero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, double longitudLanza) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);  // Llama al constructor de la clase padre (Soldado).
        this.longitudLanza = longitudLanza;  // Inicializa la longitud de la lanza.
    }

    // Acción especial del lancero: forma un schiltrom, aumentando su defensa.
    @Override
    public void accionEspecial() {
        System.out.println(nombre + " forma un schiltrom, aumentando defensa en 5 puntos.");
        this.defensa += 5;  // Aumenta la defensa del lancero en 5 puntos al realizar la acción especial.
    }

    // Getter para la longitud de la lanza.
    public double getLongitudLanza() {
        return longitudLanza;
    }

    // Método opcional: Setter para cambiar la longitud de la lanza si es necesario.
    public void setLongitudLanza(double longitudLanza) {
        this.longitudLanza = longitudLanza;
    }
}
