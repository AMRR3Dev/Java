package Ejercicio2;

import java.util.Scanner;

/**
 * Clase principal del sistema de biblioteca.
 * Crea objetos Libro y Revista, los agrega al catalogo,
 * simula un prestamo y devolucion, y luego presenta un menu
 * interactivo en consola para que el usuario gestione la biblioteca.
 */
public class Main {

    public static void main(String[] args) {

        // Crear instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros y revistas iniciales al catalogo

        System.out.println("\n===    Libros agregados    ===");
        biblioteca.agregarMaterial(new Libro("Cien anos de soledad", "Gabriel Garcia Marquez", "L001", 496));
        biblioteca.agregarMaterial(new Libro("El principito",        "Antoine de Saint-Exupery", "L002", 96));
       
       
        System.out.println("\n===   Revistas Agregadas   ===");
        biblioteca.agregarMaterial(new Revista("National Geographic", "Nat Geo Society", "R001", 245));
        biblioteca.agregarMaterial(new Revista("Scientific American", "Springer Nature",  "R002", 312));


        // Menu interactivo
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        // El menu se repite hasta que el usuario elija la opcion 0 (Salir)
        while (opcion != 0) {
            System.out.println("\n====================================");
            System.out.println("     SISTEMA DE BIBLIOTECA          ");
            System.out.println("====================================");
            System.out.println("  1. Mostrar catalogo");
            System.out.println("  2. Prestar material");
            System.out.println("  3. Devolver material");
            System.out.println("  4. Agregar libro");
            System.out.println("  5. Agregar revista");
            System.out.println("  6. Salir");
            System.out.println("====================================");
            System.out.print("  Selecciona una opcion: ");

            // Leer la opcion del usuario; manejar entrada no numerica
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // consumir el salto de linea restante
            } else {
                System.out.println("Entrada invalida. Ingresa un numero del 0 al 5.");
                scanner.nextLine(); // descartar la entrada incorrecta
                continue;
            }

            // Procesar la opcion seleccionada
            switch (opcion) {

                case 1:
                    // Mostrar todos los materiales (polimorfismo)
                    biblioteca.mostrarCatalogo();
                    break;

                case 2:
                    // Prestar un material por codigo
                    System.out.print("  Ingresa el codigo del material a prestar: ");
                    String codigoPrestar = scanner.nextLine().trim();
                    try {
                        biblioteca.prestarMaterial(codigoPrestar);
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Devolver un material por codigo
                    System.out.print("  Ingresa el codigo del material a devolver: ");
                    String codigoDevolver = scanner.nextLine().trim();
                    try {
                        biblioteca.devolverMaterial(codigoDevolver);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    // Agregar un nuevo libro al catalogo
                    System.out.print("  Titulo       : ");
                    String tituloLibro = scanner.nextLine().trim();
                    System.out.print("  Autor        : ");
                    String autorLibro = scanner.nextLine().trim();
                    System.out.print("  Codigo       : ");
                    String codigoLibro = scanner.nextLine().trim();
                    System.out.print("  Num. paginas : ");
                    int paginas = 0;
                    if (scanner.hasNextInt()) {
                        paginas = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Numero de paginas invalido. Libro no agregado.");
                        scanner.nextLine();
                        break;
                    }
                    biblioteca.agregarMaterial(new Libro(tituloLibro, autorLibro, codigoLibro, paginas));
                    break;

                case 5:
                    // Agregar una nueva revista al catalogo
                    System.out.print("  Titulo       : ");
                    String tituloRevista = scanner.nextLine().trim();
                    System.out.print("  Editorial    : ");
                    String autorRevista = scanner.nextLine().trim();
                    System.out.print("  Codigo       : ");
                    String codigoRevista = scanner.nextLine().trim();
                    System.out.print("  Num. edicion : ");
                    int edicion = 0;
                    if (scanner.hasNextInt()) {
                        edicion = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Numero de edicion invalido. Revista no agregada.");
                        scanner.nextLine();
                        break;
                    }
                    biblioteca.agregarMaterial(new Revista(tituloRevista, autorRevista, codigoRevista, edicion));
                    break;

                    case 6:
                        System.exit(0);
                    break;
             

                default:
                    // Opcion fuera del rango valido
                    System.out.println("Opcion no valida. Elige entre 1 y 6.");
            }
        }

        scanner.close(); // liberar el recurso Scanner al terminar
    }
}
