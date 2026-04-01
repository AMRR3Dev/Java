package Ejercicio3;

import java.util.ArrayList;

/**
 * Clase principal que demuestra el uso de Episodio, Temporada y Serie.
 * Cubre los cuatro escenarios planteados:
 *   1. Listar series con el promedio de calificación de cada temporada.
 *   2. Buscar episodios con calificación superior a cierta nota.
 *   3. Mostrar el episodio más largo de una serie específica.
 *   4. Mostrar qué temporada de cada serie tiene el mejor promedio.
 */
public class Main {

    public static void main(String[] args) {

        // ── Construcción de datos de prueba ───────────────────────────────────

        // --- Serie 1: "Breaking Bad" ---
        // Temporada 1
        ArrayList<Episodio> epsBB1 = new ArrayList<>();
        epsBB1.add(new Episodio("Piloto",                 58, 9.0));
        epsBB1.add(new Episodio("Cat's in the Bag",       48, 8.7));
        epsBB1.add(new Episodio("And the Bag's in the River", 47, 8.8));
        epsBB1.add(new Episodio("Cancer Man",             47, 8.5));
        epsBB1.add(new Episodio("Gray Matter",            47, 8.6));
        Temporada bb1 = new Temporada(1, epsBB1);

        // Temporada 2
        ArrayList<Episodio> epsBB2 = new ArrayList<>();
        epsBB2.add(new Episodio("Seven Thirty-Seven",     47, 8.8));
        epsBB2.add(new Episodio("Down",                   47, 8.4));
        epsBB2.add(new Episodio("Bit by a Dead Bee",      47, 8.7));
        epsBB2.add(new Episodio("Over",                   47, 8.5));
        epsBB2.add(new Episodio("ABQ",                    47, 9.4));
        Temporada bb2 = new Temporada(2, epsBB2);

        // Se crea la serie y se agregan sus temporadas
        Serie breakingBad = new Serie("Breaking Bad");
        breakingBad.agregarTemporada(bb1);
        breakingBad.agregarTemporada(bb2);

        // --- Serie 2: "Chernobyl" ---
        // Solo tiene una temporada (miniserie)
        ArrayList<Episodio> epsCh1 = new ArrayList<>();
        epsCh1.add(new Episodio("1:23:45",                 62, 9.8));
        epsCh1.add(new Episodio("Please Remain Calm",      55, 9.7));
        epsCh1.add(new Episodio("Open Wide, O Earth",      60, 9.7));
        epsCh1.add(new Episodio("The Happiness of All Mankind", 60, 9.7));
        epsCh1.add(new Episodio("Vichnaya Pamyat",         75, 9.9));
        Temporada ch1 = new Temporada(1, epsCh1);

        Serie chernobyl = new Serie("Chernobyl");
        chernobyl.agregarTemporada(ch1);

        // Arreglo con todas las series para iterar fácilmente
        Serie[] series = { breakingBad, chernobyl };

        // ── 1. Listar series con promedio de calificación por temporada ────────
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println(" 1. PROMEDIO DE CALIFICACION POR TEMPORADA         ");
        System.out.println("═══════════════════════════════════════════════════");

        // Se recorre cada serie y cada una de sus temporadas
        for (Serie s : series) {
            System.out.println("\nSerie: " + s.getNombre());
            for (Temporada t : s.getTemporadas()) {
                // obtenerPromedioCalificacion() calcula el promedio de todos los episodios
                double promedio = t.obtenerPromedioCalificacion();
                System.out.println("Temporada "+ t.getNumeroTemporada()+ " promedio: "+ promedio);
            }
        }

        // ── 2. Episodios con calificación superior a un umbral ────────────────
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println(" 2. EPISODIOS CON CALIFICACION > 9.0               ");
        System.out.println("═══════════════════════════════════════════════════");

        double umbral = 9.0; // valor de corte para la búsqueda

        for (Serie s : series) {
            // buscarEpisodiosPorCalificacion devuelve solo los que superan el umbral
            ArrayList<Episodio> destacados = s.buscarEpisodiosPorCalificacion(umbral);
            System.out.println("\nSerie: " + s.getNombre());
            if (destacados.isEmpty()) {
                System.out.println("  (ningún episodio supera " + umbral + ")");
            } else {
                for (Episodio ep : destacados) {
                    // toString() muestra título, duración y calificación
                    System.out.println("  " + ep.toString());
                }
            }
        }

        // ── 3. Episodio más largo de una serie específica ─────────────────────
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println(" 3. EPISODIO MAS LARGO POR SERIE                   ");
        System.out.println("═══════════════════════════════════════════════════");

        for (Serie s : series) {
            System.out.println("\nSerie: " + s.getNombre());
            Episodio masLargo = null;

            // Se busca el episodio más largo entre todas las temporadas de la serie
            for (Temporada t : s.getTemporadas()) {
                // episodioMasLargo() devuelve el de mayor duración en esa temporada
                Episodio candidato = t.episodioMasLargo();
                if (candidato != null) {
                    if (masLargo == null || candidato.getDuracionMinutos() > masLargo.getDuracionMinutos()) {
                        masLargo = candidato;
                    }
                }
            }

            if (masLargo != null) {
                // mostrarInfo() imprime los detalles formateados del episodio
                masLargo.mostrarInfo();
            } else {
                System.out.println("  (la serie no tiene episodios)");
            }
        }

        // ── 4. Temporada con mejor promedio de calificación por serie ─────────
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println(" 4. TEMPORADA CON MEJOR PROMEDIO POR SERIE         ");
        System.out.println("═══════════════════════════════════════════════════");

        for (Serie s : series) {
            // temporadaConMejorCalificacion() compara promedios y devuelve la ganadora
            Temporada mejor = s.temporadaConMejorCalificacion();
            System.out.println("\nSerie: " + s.getNombre());
            if (mejor != null) {
                System.out.printf("  Mejor temporada: Temporada %d (promedio: %.2f)%n",
                        mejor.getNumeroTemporada(),
                        mejor.obtenerPromedioCalificacion());
            } else {
                System.out.println("  (la serie no tiene temporadas)");
            }
        }

        
    }
}
