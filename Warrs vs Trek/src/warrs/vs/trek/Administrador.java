import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Administrador {
     static List<Queue<Personaje>> colasStarWars = new ArrayList<>();
    static List<Queue<Personaje>> colasStarTrek = new ArrayList<>();
    private Random random = new Random();
    static int velocidadRondas = 1;
    
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
                Thread.sleep(velocidadRondas * 1000);  // Pausa en milisegundos
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
        int contador = 0; // Inicializa el contador

        // Dentro de tu bucle:
        contador++;
        if (contador > 4) {
            reintegrarPersonajes(colasStarWars);
            reintegrarPersonajes(colasStarTrek);
        }
        
        // Después de cada batalla, se actualizan las colas y los personajes se envían a refuerzo si es necesario
        actualizarColas();


        
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

// Métodos para Star Wars
    public String mostrarEstadoColaStarWars(int prioridad) {
    return mostrarEstadoColaEspecifica(colasStarWars, prioridad, "Star Wars");
}

// Métodos para Star Trek
public String mostrarEstadoColaStarTrek(int prioridad) {
    return mostrarEstadoColaEspecifica(colasStarTrek, prioridad, "Star Trek");
}

// Método auxiliar genérico para obtener el estado de una cola específica
private String mostrarEstadoColaEspecifica(List<Queue<Personaje>> colas, int prioridad, String universo) {
    StringBuilder resultado = new StringBuilder();

    // Validar que la prioridad exista
    if (prioridad < 0 || prioridad >= colas.size()) {
        resultado.append("Prioridad no válida\n");
        return resultado.toString();
    }

    // Obtener la cola correspondiente
    Queue<Personaje> cola = colas.get(prioridad);
    if (cola.isEmpty()) {
        resultado.append("Vacío\n");
    } else {
        for (Personaje personaje : cola) {
            resultado.append(personaje.getId()).append(' ').append(personaje.getNombre()).append("\n");
        }
        // Eliminar la última coma y espacio
        resultado.setLength(resultado.length() - 2);
        resultado.append("\n");
    }

    return resultado.toString();
}


    // Método para agregar un nuevo personaje
public void agregarPersonaje(String saga, String nombre, int prioridad, int fuerza, int velocidad, int agilidad, int inteligencia, double suerte) {
    Personaje nuevoPersonaje = new Personaje(nombre, saga, prioridad, fuerza, velocidad, agilidad, inteligencia);
    
    if (saga.equalsIgnoreCase("Star Wars")) {
        // Verificamos si el personaje ya está en la cola de prioridad
        Queue<Personaje> cola = colasStarWars.get(prioridad - 1);
        if (!esDuplicado(cola, nuevoPersonaje)) {
            System.out.println("se supone que el personaje no es repetido");
            cola.add(nuevoPersonaje);  // Solo lo agregamos si no está duplicado
        }
    } else if (saga.equalsIgnoreCase("Star Trek")) {
        // Verificamos si el personaje ya está en la cola de prioridad
        Queue<Personaje> cola = colasStarTrek.get(prioridad - 1);
        if (!esDuplicado(cola, nuevoPersonaje)) {
            cola.add(nuevoPersonaje);  // Solo lo agregamos si no está duplicado
        }
    }
}

// Método para verificar si un personaje ya está en la cola (por ID o nombre)
private boolean esDuplicado(Queue<Personaje> cola, Personaje nuevoPersonaje) {
    for (Personaje p : cola) {
        if (p.getId() == nuevoPersonaje.getId()) {
            return true;  // El personaje ya existe en la cola
        }
    }
    return false;  // El personaje no existe, por lo que se puede agregar
}

}
