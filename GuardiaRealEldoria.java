public class GuardiaRealEldoria extends Soldado {
    public GuardiaRealEldoria(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);
    }

    @Override
    public void accionEspecial() {
        System.out.println(nombre + " activa un aura de protección mágica, aumentando la defensa de todos los aliados cercanos.");
        this.defensa += 10;
    }
}
