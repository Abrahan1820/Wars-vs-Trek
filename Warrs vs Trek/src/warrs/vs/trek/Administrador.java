import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

public class Administrador {
     static List<Queue<Personaje>> colasStarWars = new ArrayList<>();
    static List<Queue<Personaje>> colasStarTrek = new ArrayList<>();
    private Random random = new Random();
    static int velocidadRondas = 1;
    int contador = 0; // Inicializa el contador
    

    
    // Constructor: Inicializa las 4 colas de prioridad (3 de prioridad + 1 de refuerzo)
    public Administrador() {
        for (int i = 0; i < 4; i++) {
            colasStarWars.add(new LinkedList<>());
            colasStarTrek.add(new LinkedList<>());
        }
    }

 public void gestionarSistema(InteligenciaArtificial ia, JTextArea textArea) {
    for (int ronda = 1; ronda <= 100; ronda++) {  // Asumiendo que 100 rondas son necesarias
        // Mostrar ronda actual en el JTextArea
        textArea.append("Ronda " + ronda + " ---\n");

        try {
            Thread.sleep(velocidadRondas * 1000);  // Pausa en milisegundos

            // Revisión de batallas y selección de personajes
            Personaje personajeSW = seleccionarPersonaje(colasStarWars);
            Personaje personajeST = seleccionarPersonaje(colasStarTrek);
            
            
            
            if (personajeSW != null && personajeST != null) {
                // Mostrar que se están enfrentando estos personajes
                textArea.append("Batalla entre: " + personajeSW.getNombre() + " (Star Wars) y " + personajeST.getNombre() + " (Star Trek)\n");
                // Pasamos el JTextArea al procesarBatalla para que lo llene con los resultados
                String resultado = ia.procesarBatalla(personajeSW, personajeST);
                textArea.append(resultado + "\n");  // Mostrar el resultado de la batalla
            } else {
                textArea.append("No hay personajes disponibles para la batalla. Procediendo con las colas de refuerzo.\n");
            }
            
            
            eliminarDuplicados(colasStarWars);
            eliminarDuplicados(colasStarTrek);

            // Reintegrar personajes de refuerzo a las colas de prioridad más baja
            
            contador++;
            if (contador > 4) {
                contador = 0;
                reintegrarPersonajes(colasStarWars);
                reintegrarPersonajes(colasStarTrek);
                
                eliminarDuplicados(colasStarWars);
                eliminarDuplicados(colasStarTrek);
            }
            incrementarCounter();
            // Actualizar las colas después de cada ronda
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
        
        // Obtener la prioridad del personaje
        int prioridad = personaje.getPrioridad();  
        
        if (prioridad >= 0 && prioridad <= 2) {
            System.out.println("Reintegrando a " + personaje.getNombre() + " en la cola de prioridad " + prioridad + ".");
            colas.get(prioridad).add(personaje);  // Reintroducir al personaje en la cola correspondiente
        } else {
            System.out.println("Error: La prioridad de " + personaje.getNombre() + " es inválida.");
        }
    }
}



    // Método para actualizar las colas después de cada ronda
   private void actualizarColas() {
    // Mover personajes de refuerzo según las reglas
    for (int i = 0; i < 3; i++) {
        Queue<Personaje> colaStarWars = colasStarWars.get(i);  // Cola en Star Wars
        Queue<Personaje> colaStarTrek = colasStarTrek.get(i);  // Cola en Star Trek

        // Verificar y mover personajes en cada cola
        if (!colaStarWars.isEmpty()) {
            Personaje personaje = colaStarWars.peek();
            if (personaje.getContador() >= 8) {
                // Mover personaje a la siguiente cola de prioridad
                if (i < 2) {  // Si no está en la cola de más alta prioridad
                    
                    colaStarWars.poll();  // Eliminar el personaje de la cola actual
                    colasStarWars.get(i - 1).add(personaje);  // Moverlo a la siguiente cola
                    personaje.setContador(0);  // Reiniciar el contador
                }
            } else if (random.nextInt(100) >= 40) {
                // Si no está listo para la batalla, ponerlo de nuevo en la cola
                colaStarWars.add(personaje);
                personaje.setContador(0);  // Reiniciar el contador
            }
        }

        if (!colaStarTrek.isEmpty()) {
            Personaje personaje = colaStarTrek.peek();
            if (personaje.getContador() >= 8) {
                // Mover personaje a la siguiente cola de prioridad
                if (i < 2) {  // Si no está en la cola de más alta prioridad
                    colaStarTrek.poll();  // Eliminar el personaje de la cola actual
                    colasStarTrek.get(i - 1).add(personaje);  // Moverlo a la siguiente cola
                    personaje.setContador(0);  // Reiniciar el contador
                }
            } else if (random.nextInt(100) >= 40) {
                // Si no está listo para la batalla, ponerlo de nuevo en la cola
                colaStarTrek.add(personaje);
                personaje.setContador(0);  // Reiniciar el contador
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

    if (cola == null || cola.isEmpty()) {
        resultado.append("La cola está vacía.\n");
    } else {
        // Crear una copia de la cola para iterar de forma segura
        List<Personaje> copiaCola = new ArrayList<>(cola);

        for (Personaje personaje : copiaCola) {
            if (personaje != null) { // Validar que el personaje no sea nulo
                resultado.append("ID: ").append(personaje.getId())
                        .append(" | Nombre: ").append(personaje.getNombre())
                        .append("\n");
            } else {
                resultado.append("Un elemento nulo fue encontrado en la cola.\n");
            }
        }
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

// Método para eliminar duplicados
    public void eliminarDuplicados(List<Queue<Personaje>> colas) {
        Set<Personaje> personajesVistos = new HashSet<>();
        for (Queue<Personaje> cola : colas) {
            Queue<Personaje> colaTemporal = new LinkedList<>();
            for (Personaje personaje : cola) {
                if (personajesVistos.add(personaje)) {
                    colaTemporal.add(personaje);
                } else {
                    
                }
            }
            cola.clear();
            cola.addAll(colaTemporal);
        }
    }
    
    public void incrementarCounter() {
    // Recorrer las colas de Star Wars
    for (int i = 0; i < 3; i++) {
        Queue<Personaje> colaStarWars = colasStarWars.get(i);
        for (Personaje personaje : colaStarWars) {
            // Incrementar el idCounter de cada personaje
            personaje.incrementarIdCounter();
        }
    }
    
    // Recorrer las colas de Star Trek
    for (int i = 0; i < 3; i++) {
        Queue<Personaje> colaStarTrek = colasStarTrek.get(i);
        for (Personaje personaje : colaStarTrek) {
            // Incrementar el idCounter de cada personaje
            personaje.incrementarIdCounter();
        }
    }
}



}