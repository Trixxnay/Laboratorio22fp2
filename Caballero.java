public class Caballero extends Soldado {
    private boolean montado;  // Atributo para determinar si el caballero está montado

    // Constructor que inicializa el caballero con todos los atributos, incluyendo el estado de la montura
    public Caballero(String nombre, int nivelVida, int ataque, int defensa, int fila, int columna, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, fila, columna);  // Llama al constructor de la clase base
        this.montado = montado;  // Inicializa el estado de la montura
    }

    // Método para alternar el estado de la montura (montado/desmontado)
    public void alternarMontura() {
        this.montado = !montado;  // Cambia el estado de montura
        // Mejora: Se hace más claro el mensaje dependiendo si el caballero está montado o desmontado
        System.out.println(nombre + (montado ? " monta su caballo." : " desmonta de su caballo."));
    }

    // Método para realizar una acción especial dependiendo del estado de la montura
    @Override
    public void accionEspecial() {
        if (montado) {
            // Si está montado, realiza una poderosa envestida
            System.out.println(nombre + " realiza una poderosa envestida.");
            this.ataque += 10;  // Aumenta el ataque de manera significativa al estar montado
        } else {
            // Si no está montado, realiza un ataque doble
            System.out.println(nombre + " realiza un ataque doble.");
            this.ataque += 5;  // Aumenta el ataque de manera moderada al no estar montado
        }
    }

    // Método para obtener el estado de montura, en caso de que se necesite consultar
    public boolean estaMontado() {
        return montado;  // Devuelve el estado de la montura (true si está montado, false si no)
    }
}
