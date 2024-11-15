public class Personaje {
    private static int idCounter = 1;
    private int id;
    private String nombre;
    private int prioridad;  // 1: alta, 2: media, 3: baja
    private String saga;  // "Star Trek" o "Star Wars"
    private int fuerza;
    private int velocidad;
    private int agilidad;
    private int inteligencia;
    private double suerte; // Factor multiplicativo de suerte
    private int contador;  // Contador para la inanición
    
    // Constructor de la clase
    public Personaje(String nombre, String saga, int prioridad, int fuerza, int velocidad, int agilidad, int inteligencia) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.saga = saga;
        this.prioridad = prioridad;  // La prioridad se pasa directamente
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.agilidad = agilidad;
        this.inteligencia = inteligencia;
        this.suerte = generarSuerte();  // Suerte aleatoria entre 0.5 y 2
        this.contador = 0;
    }

    // Método para generar el factor de suerte entre 0.5 y 2
    private double generarSuerte() {
        return 0.5 + (1.5 * Math.random());  // Genera suerte entre 0.5 y 2
    }

    // Método para actualizar el contador y mover el personaje a la siguiente prioridad si es necesario
    public void actualizarContador() {
        if (contador >= 8 && prioridad != 1) {
            prioridad = Math.max(1, prioridad - 1);  // Aumenta la prioridad si es necesario
            contador = 0;  // Reinicia el contador
        } else {
            contador++;  // Incrementa el contador si no se cumple la condición
        }
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getPrioridad() { return prioridad; }
    public String getSaga() { return saga; }
    public int getFuerza() { return fuerza; }
    public int getVelocidad() { return velocidad; }
    public int getAgilidad() { return agilidad; }
    public int getInteligencia() { return inteligencia; }
    public double getSuerte() { return suerte; }
    public int getContador() { return contador; }

    public void setContador(int contador) { this.contador = contador; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }

    // Método para representar al personaje como String
    @Override
    public String toString() {
        return nombre + " (" + saga + ") - Prioridad: " + prioridad + ", Fuerza: " + fuerza + ", Velocidad: " + velocidad;
    }
}
