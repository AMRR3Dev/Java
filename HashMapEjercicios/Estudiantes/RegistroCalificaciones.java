package HashMapEjercicios.Estudiantes;

import java.util.HashMap;

public class RegistroCalificaciones {
    


    private HashMap<String, Integer> calificaciones;
    


    public RegistroCalificaciones(){
        calificaciones=new HashMap<>();
    }
    public void agregarCalificaciones (String nombre, int calificacion){

        calificaciones.put(nombre, calificacion);
    }

    public Integer buscarCalificacion(String nombre){

        if(calificaciones.containsKey(nombre)){
        return calificaciones.get(nombre);

        }else {
            return 0;
        }
    }

    public void mostrarCalificaciones(){

        System.out.println("\nListado de calificaciones: ");

        for (var calificacion : calificaciones.entrySet() ) {
            
            System.out.println(calificacion.getKey()+" "+calificacion.getValue());
        }


    }





}
