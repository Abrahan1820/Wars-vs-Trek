import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Administrador {
    private List<Personaje> refuerzosStarTrek;      // Cola de refuerzos de Star Trek
    private List<Personaje> refuerzosStarWars;      // Cola de refuerzos de Star Wars
    private List<Personaje> personajesEliminados;   // Personajes eliminados
    private List<Personaje> personajesEnBatalla;    // Personajes que están en la batalla actual
    private List<String> registroBatallas;           // Registro de resultados de las batallas
    private static Random random = new Random();

    private Semaphore semaphore = new Semaphore(1); // Semáforo para controlar el acceso a las colas

    // Constructor
    public Administrador() {
        this.refuerzosStarTrek = new ArrayList<>();
        this.refuerzosStarWars = new ArrayList<>();
        this.personajesEliminados = new ArrayList<>();
        this.personajesEnBatalla = new ArrayList<>();
        this.registroBatallas = new ArrayList<>();
    }

    // Método para registrar un personaje en la cola de refuerzos según la franquicia
    public void registrarPersonaje(Personaje personaje) {
        try {
            semaphore.acquire(); // Adquirir el semáforo antes de modificar las colas
            if (personaje.getSerie().equalsIgnoreCase("Star Trek")) {
                refuerzosStarTrek.add(personaje);
            } else if (personaje.getSerie().equalsIgnoreCase("Star Wars")) {
                refuerzosStarWars.add(personaje);
            }
            System.out.println("Personaje registrado: " + personaje.getNombre() + " (Franquicia: " + personaje.getSerie() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el semáforo
        }
    }

    // Método para iniciar la batalla con personajes de prioridad
    public void iniciarBatallaConIA() {
        try {
            semaphore.acquire(); // Adquirir el semáforo antes de modificar las colas
            mostrarEstadoColas(); // Mostrar estado de personajes antes de la batalla

            // Seleccionar personajes para la batalla
            Personaje p1 = seleccionarPersonajeConPrioridad(refuerzosStarTrek);
            Personaje p2 = seleccionarPersonajeConPrioridad(refuerzosStarWars);

            if (p1 == null || p2 == null) {
                System.out.println("No hay suficientes personajes en las colas de refuerzos.");
                return;
            }

            // Agregar personajes a la lista de batalla
            personajesEnBatalla.add(p1);
            personajesEnBatalla.add(p2);

            // Calcular el puntaje total de habilidades para cada personaje
            p1.calcularSuerte();
            p2.calcularSuerte();
            double puntajeP1 = p1.nivelCombate();
            double puntajeP2 = p2.nivelCombate();

            // Determinar el ganador y actualizar las prioridades
            String resultado;
            if (puntajeP1 > puntajeP2) {
                resultado = "Ganador: " + p1.getNombre() + " (Serie: " + p1.getSerie() + ")";
                actualizarPrioridad(p1, p2);  // p1 gana, p2 pierde
                eliminarPersonaje(p2); // Eliminar al perdedor
            } else if (puntajeP2 > puntajeP1) {
                resultado = "Ganador: " + p2.getNombre() + " (Serie: " + p2.getSerie() + ")";
                actualizarPrioridad(p2, p1);  // p2 gana, p1 pierde
                eliminarPersonaje(p1); // Eliminar al perdedor
            } else {
                resultado = "Empate entre " + p1.getNombre() + " y " + p2.getNombre();
                // No se cambia la prioridad ni se elimina en caso de empate
            }

            // Agregar el resultado al registro de batallas
            registroBatallas.add(resultado);
            System.out.println(resultado);
            mostrarEstadoColas(); // Mostrar el estado después de la batalla

            // Limpiar la lista de personajes en batalla para la próxima ronda
            personajesEnBatalla.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el semáforo
        }
    }

    // Método para seleccionar un personaje de la cola de refuerzos con probabilidad
    private Personaje seleccionarPersonaje(List<Personaje> refuerzos) {
        if (refuerzos.isEmpty()) {
            return null; // No hay personajes disponibles
        }

        // Generar un número aleatorio entre 0 y 100
        int chance = random.nextInt(100);
        Personaje seleccionado = refuerzos.get(0); // Primer personaje en la cola

        if (chance < 40) { // 40% de probabilidad de seleccionar el primero
            refuerzos.remove(0); // Remover el personaje seleccionado de la cola
            return seleccionado;
        } else {
            // Si no se selecciona, mover al final de la cola
            refuerzos.add(refuerzos.remove(0));
            return seleccionarPersonaje(refuerzos); // Repetir selección
        }
    }

    // Método para seleccionar un personaje de la cola de refuerzos según prioridad
    private Personaje seleccionarPersonajeConPrioridad(List<Personaje> refuerzos) {
        for (int prioridad = 1; prioridad <= 3; prioridad++) {
            for (Personaje p : refuerzos) {
                if (p.getNivelPrioridad() == prioridad) {
                    return seleccionarPersonaje(refuerzos); // Llamamos al método de selección
                }
            }
        }
        return null; // Si no se encuentra un personaje adecuado
    }

    // Método para mostrar el estado de todas las colas de personajes
    private void mostrarEstadoColas() {
        System.out.println("Colas de Refuerzos:");

        System.out.println("Cola de Refuerzos Star Trek (Prioridad 1):");
        mostrarColaPorPrioridad(refuerzosStarTrek, 1);
        System.out.println("Cola de Refuerzos Star Trek (Prioridad 2):");
        mostrarColaPorPrioridad(refuerzosStarTrek, 2);
        System.out.println("Cola de Refuerzos Star Trek (Prioridad 3):");
        mostrarColaPorPrioridad(refuerzosStarTrek, 3);

        System.out.println("Cola de Refuerzos Star Wars (Prioridad 1):");
        mostrarColaPorPrioridad(refuerzosStarWars, 1);
        System.out.println("Cola de Refuerzos Star Wars (Prioridad 2):");
        mostrarColaPorPrioridad(refuerzosStarWars, 2);
        System.out.println("Cola de Refuerzos Star Wars (Prioridad 3):");
        mostrarColaPorPrioridad(refuerzosStarWars, 3);

        System.out.println("Personajes eliminados:");
        for (Personaje personaje : personajesEliminados) {
            System.out.println("- " + personaje);
        }
        System.out.println(); // Línea en blanco para mejor legibilidad
    }

    // Método para mostrar personajes por prioridad en la cola
    private void mostrarColaPorPrioridad(List<Personaje> refuerzos, int prioridad) {
        for (Personaje personaje : refuerzos) {
            if (personaje.getNivelPrioridad() == prioridad) {
                System.out.println("- " + personaje);
            }
        }
    }

    // Método para mostrar el registro de batallas
    public void mostrarRegistroBatallas() {
        System.out.println("Registro de Batallas:");
        for (String resultado : registroBatallas) {
            System.out.println("- " + resultado);
        }
        System.out.println(); // Línea en blanco para mejor legibilidad
    }

    // Método para eliminar un personaje y agregarlo a la lista de eliminados
    private void eliminarPersonaje(Personaje personaje) {
        personajesEliminados.add(personaje);
        personajesEnBatalla.remove(personaje); // Asegurarse de que se remueva de la lista de batalla
    }

    // Método para actualizar la prioridad del personaje ganador y perdedor
    private void actualizarPrioridad(Personaje ganador, Personaje perdedor) {
        // Incrementar prioridad del perdedor si no es ya la más baja (Deficiente)
        if (perdedor.getNivelPrioridad() < 3) {
            perdedor.setNivelPrioridad(perdedor.getNivelPrioridad() + 1);
        }

        // Reducir prioridad del ganador si no es ya la más alta (Excepcional)
        if (ganador.getNivelPrioridad() > 1) {
            ganador.setNivelPrioridad(ganador.getNivelPrioridad() - 1);
        }
    }

    // Método para mostrar personajes activos en batalla
    public void mostrarPersonajesEnBatalla() {
        System.out.println("Personajes en Batalla:");
        for (Personaje personaje : personajesEnBatalla) {
            System.out.println("- " + personaje);
        }
        System.out.println(); // Línea en blanco para mejor legibilidad
    }
}
