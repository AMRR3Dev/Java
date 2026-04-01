package AlumnosEjercicio;

import java.util.ArrayList;
import java.util.List;

public class PromedioEstudiante {
    
 /**
     * Filtra los estudiantes cuyo promedio de calificaciones supera 85.
     *
     * @param estudientes lista completa de estudiantes
     * @return lista de estudiantes destacados
     */
     List<Estudiante> obtenerPromedio(List<Estudiante> estudientes) {

        List<Estudiante> resultado = new ArrayList<>();

        for (Estudiante estudiante : estudientes) {

            int suma = 0;

            for (int calificacion : estudiante.calificaciones) {
                suma += calificacion;
            }

            // Cast a double para evitar división entera y obtener el promedio correcto
            double promedio = (double) suma / estudiante.calificaciones.size();

            if (promedio > 85) {
                resultado.add(estudiante);
            }
        }

        return resultado;
    }
}


    

