public class CorsarioLysund extends Soldado {
    public CorsarioLysund(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " lanza un ataque rápido y roba recursos del enemigo.");
        this.ataque += 5;
    }
}
