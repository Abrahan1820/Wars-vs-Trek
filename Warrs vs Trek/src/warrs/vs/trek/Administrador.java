import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Administrador {
    private List<Personaje> refuerzosStarTrek;
    private List<Personaje> refuerzosStarWars;
    private List<Personaje> personajesEliminados;
    private List<Personaje> personajesEnBatalla;
    private List<String> registroBatallas;
    private static Random random = new Random();
    private Semaphore semaphore = new Semaphore(1);

    // Constructor
    public Administrador() {
        this.refuerzosStarTrek = new ArrayList<>();
        this.refuerzosStarWars = new ArrayList<>();
        this.personajesEliminados = new ArrayList<>();
        this.personajesEnBatalla = new ArrayList<>();
        this.registroBatallas = new ArrayList<>();
    }

    // Método para registrar un personaje en la cola de refuerzos
    public void registrarPersonaje(Personaje personaje) {
        try {
            semaphore.acquire();
            if (personaje.getSerie().equalsIgnoreCase("Star Trek")) {
                refuerzosStarTrek.add(personaje);
            } else if (personaje.getSerie().equalsIgnoreCase("Star Wars")) {
                refuerzosStarWars.add(personaje);
            }
            System.out.println("Personaje registrado: " + personaje.getNombre() + " (Franquicia: " + personaje.getSerie() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    // Método para iniciar la batalla con personajes de prioridad
    public void iniciarBatallaConIA() {
        try {
            semaphore.acquire();
            mostrarEstadoColas();

            Personaje p1 = seleccionarPersonajeConPrioridad(refuerzosStarTrek);
            Personaje p2 = seleccionarPersonajeConPrioridad(refuerzosStarWars);

            if (p1 == null || p2 == null) {
                System.out.println("No hay suficientes personajes en las colas de refuerzos.");
                return;
            }

            personajesEnBatalla.add(p1);
            personajesEnBatalla.add(p2);

            // Realizar el combate según probabilidades
            String resultado = determinarResultadoBatalla(p1, p2);

            registroBatallas.add(resultado);
            System.out.println(resultado);
            mostrarEstadoColas();
            personajesEnBatalla.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    // Método para determinar el resultado de la batalla
    private String determinarResultadoBatalla(Personaje p1, Personaje p2) {
        int chance = random.nextInt(100);

        if (chance < 40) { // 40% de ganar
            return "Ganador: " + p1.getNombre() + " (Serie: " + p1.getSerie() + ")";
        } else if (chance < 67) { // 27% de empate
            return "Empate entre " + p1.getNombre() + " y " + p2.getNombre();
        } else { // 33% de que no se lleva a cabo el combate
            return "El combate entre " + p1.getNombre() + " y " + p2.getNombre() + " no se llevó a cabo.";
        }
    }

    // Método para seleccionar un personaje de la cola de refuerzos según prioridad
    private Personaje seleccionarPersonajeConPrioridad(List<Personaje> refuerzos) {
    Personaje seleccionado = null;
    int menorPrioridad = Integer.MAX_VALUE;

    // Busca el personaje con menor prioridad
    for (Personaje p : refuerzos) {
        if (p.getNivelPrioridad() < menorPrioridad) {
            menorPrioridad = p.getNivelPrioridad();
            seleccionado = p;
        }
    }

    // Si encontramos un personaje, lo eliminamos de la lista de refuerzos
    if (seleccionado != null) {
        refuerzos.remove(seleccionado);
    }

    return seleccionado;
}

    // Método para mostrar el estado de todas las colas de personajes
    private void mostrarEstadoColas() {
        System.out.println("Colas de Refuerzos:");

        System.out.println("Cola de Refuerzos Star Trek:");
        for (Personaje personaje : refuerzosStarTrek) {
            System.out.println("- " + personaje);
        }

        System.out.println("Cola de Refuerzos Star Wars:");
        for (Personaje personaje : refuerzosStarWars) {
            System.out.println("- " + personaje);
        }

        System.out.println("Personajes eliminados:");
        for (Personaje personaje : personajesEliminados) {
            System.out.println("- " + personaje);
        }
        System.out.println(); // Línea en blanco para mejor legibilidad
    }
    
   // Método para mostrar los personajes que están en batalla
public void mostrarPersonajesEnBatalla() {
    System.out.println("Personajes en Batalla:");
    for (Personaje p : personajesEnBatalla) {
        System.out.println("- " + p);
    }
    System.out.println(); // Línea en blanco para mejor legibilidad
}

// Método para mostrar el registro de batallas
public void mostrarRegistroBatallas() {
    System.out.println("Registro de Batallas:");
    for (String registro : registroBatallas) {
        System.out.println("- " + registro);
    }
    System.out.println(); // Línea en blanco para mejor legibilidad
}
}
