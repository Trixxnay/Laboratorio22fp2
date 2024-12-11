public class PaladinKalvora extends Soldado {
    public PaladinKalvora(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " invoca la bendición de los dioses, curando a los aliados cercanos.");
        this.nivelVida += 10;
    }
}