public class BerserkerFerrathien extends Soldado {
    public BerserkerFerrathien(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " entra en un frenesí, aumentando su ataque pero reduciendo su defensa.");
        this.ataque += 15;
        this.defensa -= 5;
    }
}
