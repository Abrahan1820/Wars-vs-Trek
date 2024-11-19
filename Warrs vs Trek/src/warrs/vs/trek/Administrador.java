import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Administrador {
     static List<Queue<Personaje>> colasStarWars = new ArrayList<>();
    static List<Queue<Personaje>> colasStarTrek = new ArrayList<>();
    private Random random = new Random();
    int velocidadRondas = 1;
    
    // Constructor: Inicializa las 4 colas de prioridad (3 de prioridad + 1 de refuerzo)
    public Administrador() {
        for (int i = 0; i < 4; i++) {
            colasStarWars.add(new LinkedList<>());
            colasStarTrek.add(new LinkedList<>());
        }
    }

   // Método para gestionar el ciclo de batalla y actualización de colas
public void gestionarSistema(InteligenciaArtificial ia) {
    for (int ronda = 1; ronda <= 100; ronda++) {  // Asumiendo que 10 rondas son necesarias
        System.out.println("\n--- Ronda " + ronda + " ---");
        
        try {
                Thread.sleep(velocidadRondas * 500);  // Pausa en milisegundos
        // Revisión de batallas y selección de personajes
        Personaje personajeSW = seleccionarPersonaje(colasStarWars);
        Personaje personajeST = seleccionarPersonaje(colasStarTrek);
        
        if (personajeSW != null && personajeST != null) {
            System.out.println("Batalla entre: " + personajeSW.getNombre() + " (Star Wars) y " + personajeST.getNombre() + " (Star Trek)");
            ia.procesarBatalla(personajeSW, personajeST);
        } else {
            System.out.println("No hay personajes disponibles para la batalla. Procediendo con las colas de refuerzo.");
        }

        // Reintegrar personajes de refuerzo a las colas de prioridad más baja
        reintegrarPersonajes(colasStarWars);
        reintegrarPersonajes(colasStarTrek);
        
        // Después de cada batalla, se actualizan las colas y los personajes se envían a refuerzo si es necesario
        actualizarColas();

        // Mostrar el estado de las colas después de la ronda
        mostrarEstadoColas();
        
        } catch (InterruptedException e) {
                System.err.println("Error en la pausa entre rondas: " + e.getMessage());
            }
    }
}

    // Método para seleccionar un personaje de la cola de prioridad más alta disponible
    private Personaje seleccionarPersonaje(List<Queue<Personaje>> colas) {
        // Recorremos las colas de mayor a menor prioridad (1, 2, 3)
        for (int i = 0; i < 3; i++) {
            if (!colas.get(i).isEmpty()) {
                return colas.get(i).poll();  // Extraemos el primer personaje de la cola
            }
        }
        return null;  // Si no hay personajes disponibles
    }

    // Método para reintroducir personajes de la cola de refuerzo en la cola de prioridad más baja
    private void reintegrarPersonajes(List<Queue<Personaje>> colas) {
        Queue<Personaje> colaRefuerzo = colas.get(3);  // La cola de refuerzo es la de índice 3
        while (!colaRefuerzo.isEmpty()) {
            Personaje personaje = colaRefuerzo.poll();
            System.out.println("Reintegrando a " + personaje.getNombre() + " en la cola de prioridad 3.");
            colas.get(2).add(personaje);  // Reintroducimos al personaje en la cola de la prioridad más baja (índice 2)
        }
    }

    // Método para actualizar las colas después de cada ronda
    private void actualizarColas() {
        // Mover personajes de refuerzo según las reglas
        for (int i = 0; i < 4; i++) {
            Queue<Personaje> cola = (i < 3) ? colasStarWars.get(i) : colasStarTrek.get(i-3);
            if (!cola.isEmpty()) {
                Personaje personaje = cola.peek();
                // Si el personaje ha sido actualizado, moverlo a la siguiente cola de prioridad
                if (personaje.getContador() >= 8 && personaje.getPrioridad() < 3) {
                    personaje.setContador(0);
                    personaje.setPrioridad(personaje.getPrioridad() + 1);  // Pasar a la siguiente prioridad
                }
                // Si no está listo para la batalla, agregarlo al refuerzo
                else if (random.nextInt(100) >= 40) {
                    cola.add(personaje);
                }
            }
        }
    }

    // Método para mostrar el estado de las colas de Star Wars y Star Trek
public String mostrarEstadoColas() {
    StringBuilder resultado = new StringBuilder();
    
    // Mostrar colas de Star Wars
    resultado.append("Estado de las colas Star Wars:\n");
    for (int i = 0; i < colasStarWars.size(); i++) {
        resultado.append("Prioridad ").append(i + 1).append(": ");
        
        // Mostrar elementos de la cola
        Queue<Personaje> cola = colasStarWars.get(i);
        if (cola.isEmpty()) {
            resultado.append("Vacío\n");
        } else {
            for (Personaje personaje : cola) {
                resultado.append(personaje.getNombre()).append(", "); // Asegúrate de tener un método getNombre() en Personaje
            }
            // Eliminar la última coma y espacio
            resultado.setLength(resultado.length() - 2);
            resultado.append("\n");
        }
    }
    
    // Mostrar colas de Star Trek
    resultado.append("Estado de las colas Star Trek:\n");
    for (int i = 0; i < colasStarTrek.size(); i++) {
        resultado.append("Prioridad ").append(i + 1).append(": ");
        
        // Mostrar elementos de la cola
        Queue<Personaje> cola = colasStarTrek.get(i);
        if (cola.isEmpty()) {
            resultado.append("Vacío\n");
        } else {
            for (Personaje personaje : cola) {
                resultado.append(personaje.getNombre()).append(", ");
            }
            // Eliminar la última coma y espacio
            resultado.setLength(resultado.length() - 2);
            resultado.append("\n");
        }
    }
    
    return resultado.toString();
}



    // Método para agregar un nuevo personaje
    public void agregarPersonaje(String saga, String nombre, int prioridad, int fuerza, int velocidad, int agilidad, int inteligencia, double suerte) {
        Personaje nuevoPersonaje = new Personaje(nombre, saga, prioridad, fuerza, velocidad, agilidad, inteligencia);
        
        if (saga.equalsIgnoreCase("Star Wars")) {
            colasStarWars.get(prioridad - 1).add(nuevoPersonaje);
        } else if (saga.equalsIgnoreCase("Star Trek")) {
            colasStarTrek.get(prioridad - 1).add(nuevoPersonaje);
        }
    }
}
