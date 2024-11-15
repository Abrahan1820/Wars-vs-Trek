import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Administrador {
    private List<Queue<Personaje>> colasStarWars = new ArrayList<>();
    private List<Queue<Personaje>> colasStarTrek = new ArrayList<>();
    private Random random = new Random();
    
    // Constructor: Inicializa las 4 colas de prioridad (3 de prioridad + 1 de refuerzo)
    public Administrador() {
        for (int i = 0; i < 4; i++) {
            colasStarWars.add(new LinkedList<>());
            colasStarTrek.add(new LinkedList<>());
        }
    }

    // Método para gestionar el ciclo de batalla y actualización de colas
    public void gestionarSistema(InteligenciaArtificial ia) {
        for (int ronda = 1; ronda <= 10; ronda++) {  // Asumiendo que 10 rondas son necesarias
            System.out.println("\n--- Ronda " + ronda + " ---");

            // Revisión de batallas y selección de personajes
            Personaje personajeSW = seleccionarPersonaje(colasStarWars);
            Personaje personajeST = seleccionarPersonaje(colasStarTrek);
            
            if (personajeSW != null && personajeST != null) {
                System.out.println("Batalla entre: " + personajeSW.getNombre() + " (Star Wars) y " + personajeST.getNombre() + " (Star Trek)");
                ia.procesarBatalla(personajeSW, personajeST);
            } else {
                System.out.println("No hay personajes disponibles para la batalla. Procediendo con las colas de refuerzo.");
            }

            // Reintroducir personajes de refuerzo a las colas de prioridad más baja
            reintegrarPersonajes(colasStarWars);
            reintegrarPersonajes(colasStarTrek);
            
            // Después de cada batalla, se actualizan las colas y los personajes se envían a refuerzo si es necesario
            actualizarColas();

            // Mostrar el estado de las colas después de la ronda
            mostrarEstadoColas();
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
    public void mostrarEstadoColas() {
        System.out.println("\nEstado de las colas de Star Wars:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Prioridad " + (i + 1) + ": " + colasStarWars.get(i));
        }

        System.out.println("\nEstado de las colas de Star Trek:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Prioridad " + (i + 1) + ": " + colasStarTrek.get(i));
        }
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
