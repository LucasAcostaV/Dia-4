import java.util.Scanner;

public class JuegoNim {
    // Declaración de variables estáticas para representar las pilas y jugadores
    private static Pila pilaA;
    private static Pila pilaB;
    private static Pila pilaC;
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static Jugador jugadorActual;

    // Bloque estático para inicializar las variables estáticas
    static {
        // Inicialización de las pilas con sus respectivas cantidades iniciales
        pilaA = new Pila(3);
        pilaB = new Pila(4);
        pilaC = new Pila(5);
        // Creación de los jugadores con sus respectivos nombres
        jugador1 = new Jugador("Jugador1");
        jugador2 = new Jugador("Jugador2");
        // Establecimiento del jugador actual como jugador1 al inicio del juego
        jugadorActual = jugador1;
    }

    // Método estático para iniciar el juego
    public static void jugar() {
        // Creación de un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Bucle principal del juego que se ejecuta mientras no haya terminado el juego
        while (!juegoTerminado()) {
            // Imprime el estado actual del juego mostrando las pilas y sus cantidades
            System.out.println("Estado actual:");
            System.out.println("Pila A: " + pilaA);
            System.out.println("Pila B: " + pilaB);
            System.out.println("Pila C: " + pilaC);

            // Imprime el turno del jugador actual
            System.out.println("Turno de " + jugadorActual.getNombre() + ":");
            System.out.print("Elige una pila (A, B, C): ");
            // Lee la entrada del usuario para seleccionar la pila
            String pilaElegida = scanner.next();
            Pila pilaSeleccionada = null;
            // Asigna la pila seleccionada según la entrada del usuario
            switch (pilaElegida.toUpperCase()) {
                case "A":
                    pilaSeleccionada = pilaA;
                    break;
                case "B":
                    pilaSeleccionada = pilaB;
                    break;
                case "C":
                    pilaSeleccionada = pilaC;
                    break;
                default:
                    // Imprime un mensaje de error si la pila seleccionada no es válida y vuelve al inicio del bucle
                    System.out.println("Pila no válida. Inténtalo de nuevo.");
                    continue;
            }

            // Pide al usuario que elija cuántos contadores quitar de la pila seleccionada
            System.out.print("Elige cuántos contadores quitar (1-" + pilaSeleccionada.getCantidad() + "): ");
            int cantidad = scanner.nextInt();

            // Quita los contadores de la pila seleccionada
            pilaSeleccionada.quitarContadores(cantidad);

            // Cambia al siguiente jugador
            if (jugadorActual == jugador1) {
                jugadorActual = jugador2;
            } else {
                jugadorActual = jugador1;
            }
        }

        // Imprime un mensaje de felicitación al jugador ganador al final del juego
        System.out.println("¡Felicidades, " + jugadorActual.getNombre() + "! ¡Has ganado!");
        // Cierra el objeto Scanner
        scanner.close();
    }

    // Método estático que verifica si el juego ha terminado
    private static boolean juegoTerminado() {
        // El juego ha terminado si todas las pilas están vacías
        return pilaA.estaVacia() && pilaB.estaVacia() && pilaC.estaVacia();
    }

    // Método principal que inicia el juego
    public static void main(String[] args) {
        jugar(); // Llama al método para iniciar el juego
    }
}

