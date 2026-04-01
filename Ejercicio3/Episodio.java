package Ejercicio3;

/**
 * Clase que representa un episodio de una serie de televisión.
 * Cada episodio tiene un título, una duración en minutos y una calificación
 * en escala del 0 al 10.
 */
public class Episodio {

    // ── Atributos ─────────────────────────────────────────────────────────────

    private String titulo;
    private int duracionMinutos;
    private double calificacion;

    // ── Constructor ───────────────────────────────────────────────────────────

    /**
     * Construye un nuevo episodio con los datos proporcionados.
     * Se aplica validación: duracionMinutos debe ser > 0 y
     * calificacion debe estar entre 0.0 y 10.0.
     *
     * título del episodio
     * duración en minutos (> 0)
     * calificación entre 0.0 y 10.0
     */
    public Episodio(String titulo, int duracionMinutos, double calificacion) {
        this.titulo = titulo;
        setDuracionMinutos(duracionMinutos); // usa el setter para validar
        setCalificacion(calificacion);       // usa el setter para validar
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    /** Devuelve el título del episodio. */
    public String getTitulo() {
        return titulo;
    }

    /** Establece el título del episodio. */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /** Devuelve la duración del episodio en minutos. */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * Establece la duración del episodio en minutos.
     * Si el valor es menor o igual a 0 se lanza una excepción.
     * Duración en minutos (debe ser > 0)*
     */
    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0. Valor recibido: " + duracionMinutos);
        }
        this.duracionMinutos = duracionMinutos;
    }

    /** Devuelve la calificación del episodio. */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación del episodio.
     * El valor debe estar comprendido entre 0.0 y 10.0 (inclusive).
     * Si el valor está fuera de ese rango se lanza una excepción.
     *
     * calificacion calificación entre 0.0 y 10.0
     */
    public void setCalificacion(double calificacion) {
        if (calificacion < 0.0 || calificacion > 10.0) {
            throw new IllegalArgumentException(
                "La calificación debe estar entre 0.0 y 10.0. Valor recibido: " + calificacion);
        }
        this.calificacion = calificacion;
    }

    // ── Métodos de comportamiento ─────────────────────────────────────────────

    /**
     * Muestra en consola la información detallada del episodio:
     * título, duración y calificación.
     */
    public void mostrarInfo() {
        System.out.println("─────────────────────────────");
        System.out.println("Título       : " + titulo);
        System.out.println("Duración     : " + duracionMinutos + " min");
        System.out.println("Calificación : " + calificacion + " / 10");
        System.out.println("─────────────────────────────");
    }

    /**
     * Devuelve una representación en cadena del episodio con sus tres campos.
     *
     * Cadena con formato "Episodio{titulo='...', duracionMinutos=..., calificacion=...}"
     */
    @Override
    public String toString() {
        return "Episodio: titulo='" + titulo + "', duracionMinutos= " + duracionMinutos
                + ", calificacion= " + calificacion + "";
    }

   
    }

