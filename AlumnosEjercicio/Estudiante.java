package AlumnosEjercicio;

import java.util.List;

/**
 * Clase Estudiante que representa a un estudiante con su nombre y calificaciones.
 */
public class Estudiante {

    private String nombre;

    // Lista de calificaciones con acceso de paquete para uso en la misma clase del paquete
    List<Integer> calificaciones;

    /**
     * Constructor que recibe el nombre y la lista de calificaciones.
     *
     * @param nombre         nombre del estudiante
     * @param calificaciones lista de calificaciones enteras
     */
    public Estudiante(String nombre, List<Integer> calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    /**
     * Retorna el nombre del estudiante.
     *
     * @return nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la lista de calificaciones del estudiante.
     *
     * @return lista de calificaciones
     */
    public List<Integer> getCalificaciones() {
        return calificaciones;
    }
}
