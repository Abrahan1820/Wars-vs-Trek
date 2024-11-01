import java.util.List;
import java.util.Optional;

public class InteligenciaArtificial {

    // Método que selecciona dos personajes para la batalla
    public static Optional<Personaje[]> seleccionarParaBatalla(List<Personaje> personajes) {
        if (personajes.size() < 2) {
            System.out.println("No hay suficientes personajes para una batalla.");
            return Optional.empty();
        }

        // Estrategia: Seleccionar los dos personajes con menor prioridad (prioridad 1 es la más alta)
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

        if (p1 != null && p2 != null) {
            return Optional.of(new Personaje[] { p1, p2 });
        }

        return Optional.empty();
    }

    // Otra estrategia: Selección de personajes de acuerdo a un criterio de serie
    public static Optional<Personaje[]> seleccionarPorSerie(List<Personaje> personajes, String serie) {
        Personaje p1 = null;
        Personaje p2 = null;

        // Buscar dos personajes de la misma serie
        for (Personaje personaje : personajes) {
            if (personaje.getSerie().equals(serie)) {
                if (p1 == null) {
                    p1 = personaje;
                } else if (p2 == null) {
                    p2 = personaje;
                    break;
                }
            }
        }

        if (p1 != null && p2 != null) {
            return Optional.of(new Personaje[] { p1, p2 });
        }

        return Optional.empty();
    }

    // Estrategia avanzada: seleccionar personajes basándose en el nivel de combate
    public static Optional<Personaje[]> seleccionarPorNivelCombate(List<Personaje> personajes) {
        personajes.sort((p1, p2) -> Double.compare(p2.nivelCombate(), p1.nivelCombate()));

        if (personajes.size() >= 2) {
            return Optional.of(new Personaje[] { personajes.get(0), personajes.get(1) });
        }
        return Optional.empty();
    }
}
