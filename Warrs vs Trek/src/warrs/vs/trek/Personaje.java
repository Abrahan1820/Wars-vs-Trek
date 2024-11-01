import java.util.Random;

public class Personaje {
    private static int idCounter = 1;
    private int id;
    private String nombre;
    private String serie; // Nueva propiedad para diferenciar series de personajes
    private int fuerza;
    private int velocidad;
    private int inteligencia;
    private int agilidad;
    private double suerte;
    private int prioridad;

    // Constructor del personaje
    public Personaje(String nombre, String serie, int fuerza, int velocidad, int inteligencia, int agilidad, int prioridad) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.serie = serie;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.agilidad = agilidad;
        this.suerte = calcularSuerte();
        this.prioridad = prioridad;
    }

    // Método para generar la suerte de manera aleatoria entre 0.5 y 2
    public double calcularSuerte() {
        Random rand = new Random();
        return 0.5 + (1.5 * rand.nextDouble()); // Esto da un número entre 0.5 y 2
    }

    // Método para calcular el nivel de combate del personaje en la batalla actual
    public double nivelCombate() {
        return (fuerza + velocidad + inteligencia + agilidad) * this.suerte;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSerie() {
        return serie;
    }

    public double getSuerte() {
        return suerte;
    }

    public void nuevaSuerte() {
        this.suerte = calcularSuerte();
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setNivelPrioridad(int nuevaPrioridad) {
        this.prioridad = nuevaPrioridad;
    }

    public void resetearContadorRondas() {
        // Implementar la lógica para resetear rondas, si es necesario.
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", serie='" + serie + '\'' +
                ", fuerza=" + fuerza +
                ", velocidad=" + velocidad +
                ", inteligencia=" + inteligencia +
                ", agilidad=" + agilidad +
                ", suerte=" + suerte +
                ", nivelCombate=" + nivelCombate() +
                '}';
    }
}
