public class Simulador {

    public static void main(String[] args) {
        // Crear instancia de Administrador
        Administrador administrador = new Administrador();

        // Registrar algunos personajes con diferentes atributos
        administrador.registrarPersonaje(new Personaje("Thor","Star Trek", 85, 70, 60, 75, 2));
        administrador.registrarPersonaje(new Personaje("Loki","Star Wars", 60, 80, 90, 60, 2));
        administrador.registrarPersonaje(new Personaje("Hulk", "Star Trek", 95, 50, 40, 85, 1));
        administrador.registrarPersonaje(new Personaje("Iron Man","Star Wars", 65, 75, 85, 70, 1));
        administrador.registrarPersonaje(new Personaje("Black Widow", "Star Trek", 55, 90, 70, 85, 3));
        administrador.registrarPersonaje(new Personaje("Var Vader", "Star Wars", 99, 99, 99, 89, 3));

        // Mostrar los personajes registrados
        System.out.println("=== Lista de Personajes Registrados ===");
        administrador.mostrarPersonajesEnBatalla();

        // Ejecutar varias batallas
        System.out.println("\n=== Inicio de Batallas ===");
        for (int i = 0; i < 10; i++) { // Realizar 10 batallas de prueba
            System.out.println("\n--- Batalla " + (i + 1) + " ---");
            administrador.iniciarBatallaConIA();
        }

        // Mostrar el registro de batallas al final de las simulaciones
        System.out.println("\n=== Registro Final de Batallas ===");
        administrador.mostrarRegistroBatallas();

        // Mostrar el estado final de los personajes
        System.out.println("\n=== Estado Final de los Personajes ===");
        administrador.mostrarPersonajesEnBatalla();
    }
}
