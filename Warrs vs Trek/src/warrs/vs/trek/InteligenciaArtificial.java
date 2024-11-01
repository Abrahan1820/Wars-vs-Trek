import java.util.List;
import java.util.Optional;

public class InteligenciaArtificial {
    // Método que selecciona dos personajes para la batalla
    public static Optional<Personaje[]> seleccionarParaBatalla(List<Personaje> personajes) {
        if (personajes.size() < 2) {
            System.out.println("No hay suficientes personajes para una batalla.");
            return Optional.empty();
        }

        // Estrategia: Seleccionar los dos personajes con menor prioridad
        Personaje p1 = null;
        Personaje p2 = null;

        // Encontrar dos personajes con la prioridad más baja posible
        for (Personaje personaje : personajes) {
            if (p1 == null || personaje.getNivelPrioridad() < p1.getNivelPrioridad()) {
                p2 = p1;
                p1 = personaje;
            } else if (p2 == null || personaje.getNivelPrioridad() < p2.getNivelPrioridad()) {
                p2 = personaje;
            }
        }

        return Optional.of(new Personaje[]{p1, p2});
    }
}
