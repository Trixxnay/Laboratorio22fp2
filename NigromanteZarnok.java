public class NigromanteZarnok extends Soldado {
    public NigromanteZarnok(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " resucita a un soldado caído como un aliado temporal.");
    }
}