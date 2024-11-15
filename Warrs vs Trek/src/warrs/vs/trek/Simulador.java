import java.util.*;

public class Simulador {
    private Administrador administrador;
    private InteligenciaArtificial ia;
    
    public Simulador() {
        // Inicializamos el Administrador y la IA
        administrador = new Administrador();
        ia = new InteligenciaArtificial();
    }

    public void iniciarSimulacion() {
        // Crear personajes manualmente (puedes ajustarlo como prefieras)
        crearPersonajes();
        
        // Simulación de batallas y actualización de colas por 10 rondas
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Ronda " + (i + 1) + " ---");
            administrador.gestionarSistema(ia);  // El Administrador gestiona las batallas
            mostrarEstadoColas();  // Imprimir el estado de las colas después de la ronda
        }
    }

    // Método para crear personajes manualmente y agregarlos a las colas
    private void crearPersonajes() {
        // Agregar personajes de Star Wars
        administrador.agregarPersonaje("Star Wars", "Han Solo", 2, 75, 85, 70, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Darth Vader", 3, 100, 80, 60, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Luke Skywalker", 1, 95, 90, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Princess Leia", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Yoda", 3, 85, 60, 95, 100, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Obi-Wan Kenobi", 1, 90, 80, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Chewbacca", 2, 85, 90, 70, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "R2-D2", 3, 60, 70, 95, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "C-3PO", 2, 50, 60, 90, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Boba Fett", 3, 80, 90, 70, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Anakin Skywalker", 1, 95, 90, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Lando Calrissian", 2, 80, 75, 70, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Qui-Gon Jinn", 3, 85, 80, 75, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Jango Fett", 2, 90, 85, 70, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Ahsoka Tano", 1, 80, 90, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Rey", 2, 85, 80, 90, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Kylo Ren", 3, 95, 75, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Emperor Palpatine", 1, 100, 70, 60, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Mace Windu", 2, 90, 80, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Darth Maul", 3, 95, 85, 70, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "General Grievous", 2, 90, 70, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Count Dooku", 3, 85, 60, 75, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Padmé Amidala", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Jar Jar Binks", 3, 60, 65, 50, 60, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Mon Mothma", 1, 80, 70, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Wedge Antilles", 2, 80, 75, 85, 90, Math.random() + 0.5);
        
        // Agregar personajes de Star Trek
        administrador.agregarPersonaje("Star Trek", "James T. Kirk", 1, 85, 80, 70, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Spock", 2, 80, 85, 75, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Worf", 3, 90, 70, 80, 60, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Leonard McCoy", 2, 75, 70, 65, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Scotty", 1, 80, 75, 90, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Uhura", 2, 70, 80, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Sulu", 3, 75, 85, 80, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Chekov", 1, 80, 70, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Data", 2, 90, 90, 85, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Geordi La Forge", 3, 85, 80, 90, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Beverly Crusher", 1, 75, 80, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Deanna Troi", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Will Riker", 3, 90, 85, 75, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Jean-Luc Picard", 1, 95, 90, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Q", 2, 100, 75, 60, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Guinan", 3, 70, 80, 85, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Lore", 1, 90, 85, 80, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Borg Queen", 2, 95, 80, 85, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Khan Noonien Singh", 1, 100, 95, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Seven of Nine", 2, 85, 90, 80, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Tasha Yar", 3, 70, 75, 65, 80, Math.random() + 0.5);
    }

    // Método para mostrar el estado de las colas
    private void mostrarEstadoColas() {
        System.out.println("\nEstado de las colas:");
        administrador.mostrarEstadoColas();  // Llamamos al método para mostrar las colas
    }

    public static void main(String[] args) {
        // Crear el simulador y arrancar la simulación
        Simulador simulador = new Simulador();
        simulador.iniciarSimulacion();
    }
}
