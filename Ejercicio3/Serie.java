package Ejercicio3;

import java.util.ArrayList;

/**
 * Clase que representa una serie de televisión.
 * Contiene una lista de temporadas y ofrece métodos para buscar episodios
 * por calificación y determinar la temporada con mejor promedio.
 */
public class Serie {

    // ── Atributos ─────────────────────────────────────────────────────────────

    /** Nombre de la serie. */
    private String nombre;

    /** Lista de temporadas que componen la serie. */
    private ArrayList<Temporada> temporadas;

    // ── Constructor ───────────────────────────────────────────────────────────

    /**
     * Construye una serie con su nombre y una lista de temporadas vacía.
     *
     * nombre de la serie
     */
    public Serie(String nombre) {
        this.nombre = nombre;
        this.temporadas = new ArrayList<>();
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** Devuelve el nombre de la serie. */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre de la serie. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Devuelve la lista de temporadas de la serie. */
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    /** Establece la lista de temporadas de la serie. */
    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * Agrega una temporada a la lista de temporadas de la serie.
     * temporada a agregar
     */
    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    // ── Métodos de comportamiento ─────────────────────────────────────────────

    /**
     * Busca y devuelve todos los episodios de todas las temporadas de la serie
     * cuya calificación supera el valor indicado.
     *
     * calificacionMinima valor mínimo de calificación (exclusivo)
     * lista de episodios con calificación superior al valor dado
     */
    public ArrayList<Episodio> buscarEpisodiosPorCalificacion(double calificacionMinima) {
        ArrayList<Episodio> resultado = new ArrayList<>();

        // Se recorre cada temporada de la serie
        for (Temporada temporada : temporadas) {
            // Se recorre cada episodio de la temporada
            for (Episodio ep : temporada.getEpisodios()) {
                // Si la calificación supera el mínimo se agrega al resultado
                if (ep.getCalificacion() > calificacionMinima) {
                    resultado.add(ep);
                }
            }
        }

        return resultado;
    }

    /**
     * Determina la temporada con el mayor promedio de calificación de la serie.
     * Si la serie no tiene temporadas devuelve null.
     *
     * temporada con mejor promedio de calificación, o null si no hay temporadas
     */
    public Temporada temporadaConMejorCalificacion() {
        // Si no hay temporadas no hay ganadora
        if (temporadas == null || temporadas.isEmpty()) {
            return null;
        }

        // Se asume que la primera temporada tiene el mejor promedio
        Temporada mejor = temporadas.get(0);

        // Se compara con el resto de temporadas
        for (Temporada t : temporadas) {
            if (t.obtenerPromedioCalificacion() > mejor.obtenerPromedioCalificacion()) {
                mejor = t; // se actualiza si se encuentra una con mejor promedio
            }
        }

        return mejor;
    }

   
}
