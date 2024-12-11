import java.util.*;

public class Ejercito {
    private String nombreReino;
    private ArrayList<Soldado> soldados;
    private static int contEjercitos=0;

    public Ejercito(String nombreReino) {
        contEjercitos++;
        this.nombreReino = nombreReino;
        this.soldados = new ArrayList<>();
    }

    public void generarSoldados(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int tipo = random.nextInt(4); 
            Soldado soldado;
    
            switch (tipo) {
                case 0 -> soldado = new Espadachin(
                    "Espadachin " + i + " (" + nombreReino + ")", 
                    random.nextInt(3) + 8, 
                    10, 
                    8,  
                    random.nextInt(10), 
                    random.nextInt(10)
                );
                case 1 -> soldado = new Arquero(
                    "Arquero " + i + " (" + nombreReino + ")",
                    random.nextInt(3) + 3, 
                    7,  
                    3,  
                    random.nextInt(10), 
                    random.nextInt(10), 
                    random.nextInt(10) 
                );
                case 2 -> soldado = new Caballero(
                    "Caballero " + i + " (" + nombreReino + ")",
                    random.nextInt(3) + 10, 
                    13, 
                    7,  
                    random.nextInt(10), 
                    random.nextInt(10), 
                    random.nextBoolean() 
                );
                case 3 -> soldado = new Lancero(
                    "Lancero " + i + " (" + nombreReino + ")",
                    random.nextInt(3) + 5, 
                    5,  
                    10, 
                    random.nextInt(10), 
                    random.nextInt(10), 
                    random.nextDouble() * 2 + 1 
                );
                default -> throw new IllegalArgumentException("Tipo de soldado desconocido.");
            }
    
            soldados.add(soldado);
        }
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public String getNombreReino() {
        return nombreReino;
    }

    public static int getContEjercitos() {
        return contEjercitos;
    }
    
    public void mostrarSoldados() {
        System.out.println("Soldados del Ejército de " + nombreReino + ":");
        for (Soldado soldado : soldados) {
            System.out.println(soldado.getClass().getSimpleName() + ": " + soldado);
        }
    }

    public void generarUnidadesEspeciales(String nombreReino, List<Soldado> soldados) {
        Random random = new Random();
        int fila, columna;
        boolean posicionValida;
    
        do {
            fila = random.nextInt(10);  
            columna = random.nextInt(10);  
    
            posicionValida = true;
            for (Soldado s : soldados) {
                if (s.getFila() == fila && s.getColumna() == columna) {
                    posicionValida = false;
                    break;
                }
            }
        } while (!posicionValida);
    
        Soldado unidadEspecial;
        switch (nombreReino) {
            case "Eldoria" -> unidadEspecial = new GuardiaRealEldoria(
                "Guardia Real (" + nombreReino + ")", 
                15, 8, 12, fila, columna
            );
            case "Ferrathien" -> unidadEspecial = new BerserkerFerrathien(
                "Berserker (" + nombreReino + ")", 
                14, 15, 6, fila, columna
            );
            case "Lysund" -> unidadEspecial = new CorsarioLysund(
                "Corsario (" + nombreReino + ")", 
                12, 10, 8, fila, columna
            );
            case "Kalvora" -> unidadEspecial = new PaladinKalvora(
                "Paladín (" + nombreReino + ")", 
                16, 10, 10, fila, columna
            );
            case "Zarnok" -> unidadEspecial = new NigromanteZarnok(
                "Nigromante (" + nombreReino + ")", 
                12, 9, 7, fila, columna
            );
            default -> throw new IllegalArgumentException("Reino desconocido: " + nombreReino);
        }
    
        soldados.add(unidadEspecial);
    }
}
