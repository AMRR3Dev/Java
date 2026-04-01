package AlumnosEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();

        // Se crean instancias de Estudiante usando el constructor estándar de Java:
        // new Estudiante(nombre, listaDeCalificaciones)
        estudiantes.add(new Estudiante("Juan", List.of(80, 70, 90)));
        estudiantes.add(new Estudiante("Pedro", List.of(70, 70, 70)));
        estudiantes.add(new Estudiante("Martha", List.of(80, 90, 100)));

        // Se obtiene la lista de estudiantes con promedio mayor a 85
        List<Estudiante> estudiantesDestacados = obtenerPromedio(estudiantes);

        // Se imprime el resultado
        for (Estudiante estudiante : estudiantesDestacados) {
            System.out.println("Estudiante destacado: " + estudiante.getNombre() + " "  );
            System.out.println(estudiante.getNombre());
            
        }
    }
}
   