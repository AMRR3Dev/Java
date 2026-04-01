package Ejercicio3;

import java.util.ArrayList;

/**
 * Clase que representa una temporada de una serie de televisión.
 * Contiene una lista de episodios y permite calcular estadísticas
 * como el promedio de calificación y el episodio más largo.
 */
public class Temporada {

    // ── Atributos ─────────────────────────────────────────────────────────────

    /** Número que identifica a la temporada (ej. 1, 2, 3...). */
    private int numeroTemporada;

    /** Lista de episodios que forman parte de esta temporada. */
    private ArrayList<Episodio> episodios;

    // ── Constructor ───────────────────────────────────────────────────────────

    /**
     * Construye una temporada con su número identificador y su lista de episodios.
     *
     * numeroTemporada número de la temporada (ej. 1, 2, 3...)
     * episodios       lista de episodios de la temporada
     */
    public Temporada(int numeroTemporada, ArrayList<Episodio> episodios) {
        this.numeroTemporada = numeroTemporada;
        this.episodios = episodios;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** Devuelve el número de la temporada. */
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    /** Establece el número de la temporada. */
    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    /** Devuelve la lista de episodios de la temporada. */
    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    /** Establece la lista de episodios de la temporada. */
    public void setEpisodios(ArrayList<Episodio> episodios) {
        this.episodios = episodios;
    }

    // ── Métodos de comportamiento ─────────────────────────────────────────────

    /**
     * Calcula el promedio de calificación de todos los episodios de la temporada.
     * Si la temporada no tiene episodios devuelve 0.0.
     *
     * promedio de calificaciones entre 0.0 y 10.0
     */
    public double obtenerPromedioCalificacion() {
        // Si no hay episodios no se puede calcular promedio, se devuelve 0
        if (episodios == null || episodios.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        // Se recorre cada episodio y se acumula su calificación
        for (Episodio ep : episodios) {
            suma += ep.getCalificacion();
        }

        // El promedio es la suma dividida entre el total de episodios
        return suma / episodios.size();
    }

    /**
     * Obtiene el episodio con mayor duración en minutos de la temporada.
     * Si la temporada no tiene episodios devuelve null.
     *
     * episodio más largo, o null si la lista está vacía
     */
    public Episodio episodioMasLargo() {
        // Si no hay episodios no hay episodio más largo
        if (episodios == null || episodios.isEmpty()) {
            return null;
        }

        // Se asume que el primero es el más largo y se va comparando con el resto
        Episodio masLargo = episodios.get(0);
        for (Episodio ep : episodios) {
            if (ep.getDuracionMinutos() > masLargo.getDuracionMinutos()) {
                masLargo = ep; // se actualiza si se encuentra uno más largo
            }
        }

        return masLargo;
    }

   
}
