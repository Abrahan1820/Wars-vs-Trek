import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Administrador {
    private List<Personaje> personajes;
    private List<String> registroBatallas;
    private static Random random = new Random();

    // Constructor
    public Administrador() {
        this.personajes = new ArrayList<>();
        this.registroBatallas = new ArrayList<>();
    }

    public void registrarPersonaje(Personaje personaje) {
        personajes.add(personaje);
        System.out.println("Personaje registrado: " + personaje.getNombre());
    }

    // Método para iniciar la batalla usando la inteligencia artificial
    public void iniciarBatallaConIA() {
        Optional<Personaje[]> seleccionados = InteligenciaArtificial.seleccionarParaBatalla(personajes);

        if (seleccionados.isEmpty()) {
            System.out.println("No hay suficientes personajes seleccionados para la batalla.");
            return;
        }

        Personaje p1 = seleccionados.get()[0];
        Personaje p2 = seleccionados.get()[1];

        // Preparación para la batalla: actualizar la suerte de cada personaje
        p1.nuevaSuerte();
        p2.nuevaSuerte();

        // Calcular el nivel de combate de ambos personajes
        double puntajeP1 = p1.nivelCombate();
        double puntajeP2 = p2.nivelCombate();

        String resultado;
        if (puntajeP1 > puntajeP2) {
            resultado = "Ganador: " + p1.getNombre() + " (Serie: " + p1.getSerie() + ")";
            actualizarPrioridad(p1, p2);
            eliminarPersonaje(p2);
            reubicarGanador(p1);
        } else if (puntajeP2 > puntajeP1) {
            resultado = "Ganador: " + p2.getNombre() + " (Serie: " + p2.getSerie() + ")";
            actualizarPrioridad(p2, p1);
            eliminarPersonaje(p1);
            reubicarGanador(p2);
        } else {
            resultado = "Empate entre " + p1.getNombre() + " y " + p2.getNombre();
        }

        registroBatallas.add(resultado);
        System.out.println(resultado);
    }

    // Método para actualizar la prioridad de los personajes después de una batalla
    private void actualizarPrioridad(Personaje ganador, Personaje perdedor) {
        // Incrementa la prioridad del perdedor (sin exceder el valor máximo)
        if (perdedor.getPrioridad() < 3) {  // Suponiendo que 3 es el nivel de prioridad más bajo
            perdedor.setNivelPrioridad(perdedor.getPrioridad() + 1);
        }

        // Disminuye la prioridad del ganador (sin bajar del valor mínimo)
        if (ganador.getPrioridad() > 1) {  // Suponiendo que 1 es el nivel de prioridad más alto
            ganador.setNivelPrioridad(ganador.getPrioridad() - 1);
        }

        // Reiniciar contadores de rondas para ambos personajes después de la batalla
        ganador.resetearContadorRondas();
        perdedor.resetearContadorRondas();
    }

    // Método para eliminar un personaje del sistema
    private void eliminarPersonaje(Personaje perdedor) {
        personajes.remove(perdedor);
        System.out.println("Personaje eliminado: " + perdedor.getNombre());
    }

    // Método para reubicar al ganador al final de la lista de prioridad más alta
    private void reubicarGanador(Personaje ganador) {
        personajes.remove(ganador);
        ganador.setNivelPrioridad(1);  // Asignar prioridad más alta
        personajes.add(ganador);  // Reubicar al final de la lista
        System.out.println("Ganador reubicado con prioridad alta: " + ganador.getNombre());
    }

    // Método para mostrar el registro de batallas
    public void mostrarRegistroBatallas() {
        System.out.println("Registro de Batallas:");
        for (String resultado : registroBatallas) {
            System.out.println(resultado);
        }
    }

    // Método para mostrar los personajes registrados
    public void mostrarPersonajes() {
        System.out.println("Lista de Personajes Registrados:");
        for (Personaje personaje : personajes) {
            System.out.println(personaje);
        }
    }
}
