package HashMapEjercicios.Estudiantes;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        

        RegistroCalificaciones registro = new RegistroCalificaciones();


        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos estudiantes deseas registrar: ");
        int cantidad = sc.nextInt();

        


        for (int i = 1; i <= cantidad; i++ ) {
            
            sc.nextLine();
            
            System.out.print("\nNombre del estudiante "+ i +": ");
            String nombre = sc.nextLine();

            System.out.print("Calificacion: ");
            int calificacion = sc.nextInt();
            registro.agregarCalificaciones(nombre, calificacion);
        }

            sc.nextLine();


        System.out.println("Ingresa el nombre del estudiante para consultar su calificacion: ");
        String nombreBusqueda=sc.nextLine();



        Integer resultado = registro.buscarCalificacion(nombreBusqueda);

        if(resultado==0){

             System.out.print("Estudiante no encontrado");

        }else {
        System.out.println("La calificacion de: "+ nombreBusqueda+ " es: "+resultado);

        }




       registro.mostrarCalificaciones();





    }


}
