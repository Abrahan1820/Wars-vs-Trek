import java.util.Random;

public class InteligenciaArtificial {
    static int victoriasStarWars = 0;
    static int victoriasStarTrek = 0;
    private Random random = new Random();

    public String procesarBatalla(Personaje personaje1, Personaje personaje2) {
    // Simular el resultado del combate basado en las probabilidades
    int resultado = determinarResultado();

    StringBuilder resultadoBatalla = new StringBuilder();

    switch (resultado) {
        case 1: // Ganador
            // Determinamos al ganador
            Personaje ganador = determinarGanador(personaje1, personaje2);
            resultadoBatalla.append("El ganador es: ").append(ganador.getNombre()).append("\n");
            // Borramos al perdedor de la simulación
            eliminarPerdedor(personaje1, personaje2, ganador);
            
             if (ganador.getSaga().equalsIgnoreCase("Star Wars")) {
            victoriasStarWars++;
            } else if (ganador.getSaga().equalsIgnoreCase("Star Trek")) {
            victoriasStarTrek++;
            }
            break;

        case 2: // Empate
            // Colocamos a ambos personajes al final de la cola de refuerzo
            resultadoBatalla.append("Empate. Ambos personajes van a la cola de refuerzo.\n");
            enviarAColaRefuerzo(personaje1);
            enviarAColaRefuerzo(personaje2);
            break;

        case 3: // No se puede llevar a cabo el combate
            // Enviamos ambos personajes a la cola de refuerzo
            resultadoBatalla.append("No se puede llevar a cabo el combate. Ambos personajes van a la cola de refuerzo.\n");
            enviarAColaRefuerzo(personaje1);
            enviarAColaRefuerzo(personaje2);
            break;
    }

    // Devolver el resultado como String
    return resultadoBatalla.toString();
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
    // Determinar el ganador entre los dos personajes
private Personaje determinarGanador(Personaje personaje1, Personaje personaje2) {
    int fuerza1 = (personaje1.getFuerza() + personaje1.getVelocidad() + personaje1.getAgilidad() + personaje1.getInteligencia()) * (int)personaje1.getSuerte();
    int fuerza2 = (personaje2.getFuerza() + personaje2.getVelocidad() + personaje2.getAgilidad() + personaje2.getInteligencia()) * (int)personaje2.getSuerte();

    Personaje ganador;
    if (fuerza1 > fuerza2) {
        ganador = personaje1;
    } else {
        ganador = personaje2;
    }

    // Registrar la victoria en el Administrador
    String sagaGanadora = ganador.getSaga();  // Se asume que los personajes tienen un método getSaga()


    return ganador;
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
        // Aquí no se reinicia el contador, solo se maneja la cola de refuerzo
        if (personaje.getSaga().equalsIgnoreCase("Star Wars")) {
            Administrador.colasStarWars.get(3).add(personaje);
        } else if (personaje.getSaga().equalsIgnoreCase("Star Trek")) {
            Administrador.colasStarTrek.get(3).add(personaje);
        }
    }
}