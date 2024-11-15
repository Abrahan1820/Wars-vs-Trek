import java.util.*;

public class InteligenciaArtificial {
    private Random random = new Random();

    // Método para procesar una ronda de combate
    public void procesarBatalla(Personaje personaje1, Personaje personaje2) {
        // Simular el resultado del combate basado en las probabilidades
        int resultado = determinarResultado();

        switch (resultado) {
            case 1: // Ganador
                // Determinamos al ganador
                Personaje ganador = determinarGanador(personaje1, personaje2);
                System.out.println("El ganador es: " + ganador.getNombre());
                // Borramos al perdedor de la simulación
                eliminarPerdedor(personaje1, personaje2, ganador);
                break;

            case 2: // Empate
                // Colocamos a ambos personajes al final de la cola de nivel 1
                System.out.println("Empate. Ambos personajes van a la cola de nivel 1.");
                personaje1.actualizarContador();  // Incrementamos el contador de ambos personajes
                personaje2.actualizarContador();
                break;

            case 3: // No se puede llevar a cabo el combate
                // Enviamos ambos personajes a la cola de refuerzo
                System.out.println("No se puede llevar a cabo el combate. Ambos personajes van a la cola de refuerzo.");
                enviarAColaRefuerzo(personaje1);
                enviarAColaRefuerzo(personaje2);
                break;
        }
    }

    // Método para determinar el resultado basado en las probabilidades
    private int determinarResultado() {
        int probabilidad = random.nextInt(100) + 1;  // Número entre 1 y 100
        if (probabilidad <= 40) {
            return 1; // Ganador
        } else if (probabilidad <= 67) {
            return 2; // Empate
        } else {
            return 3; // No combate
        }
    }

    // Determinar el ganador entre dos personajes basado en su poder de batalla
    private Personaje determinarGanador(Personaje personaje1, Personaje personaje2) {
        int fuerza1 = personaje1.getFuerza() + (int)(personaje1.getSuerte() * random.nextInt(100));
        int fuerza2 = personaje2.getFuerza() + (int)(personaje2.getSuerte() * random.nextInt(100));

        if (fuerza1 > fuerza2) {
            return personaje1;
        } else {
            return personaje2;
        }
    }

    // Método para eliminar al perdedor del combate
    private void eliminarPerdedor(Personaje personaje1, Personaje personaje2, Personaje ganador) {
        if (ganador.equals(personaje1)) {
            System.out.println("Perdedor: " + personaje2.getNombre());
        } else {
            System.out.println("Perdedor: " + personaje1.getNombre());
        }
    }

    // Método para enviar un personaje a la cola de refuerzo
    private void enviarAColaRefuerzo(Personaje personaje) {
        System.out.println("Enviando a " + personaje.getNombre() + " a la cola de refuerzo.");
        personaje.setContador(0);
    }
}
