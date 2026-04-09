package ExcepcionesEjercicios;

public class EjemploExcepciones {
    public static void main(String[] args) {

        try {
            System.out.println("\nEjemplo de Excepciones ArithmeticException");
            int resultado = 10 / 0;
            System.out.println("Ejecuto con exito: ");
        } catch (ArithmeticException e) {
            System.out.println("Error division entre 0 ");
        }

        try {
            System.out.println("\nEjemplo de Excepciones NullPointerException");
            String texto = null;
            System.out.println(texto.length());
            System.out.println("Con exito ");
        } catch (NullPointerException e) {
            System.out.println("Objeto null " );
        }

        try {
            System.out.println("\nEjemplo de Excepciones ArrayIndexOutOfBounds");
            int[] arr = new int[3];
            int valor = arr[10];
            System.out.println("Exito");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de rango ");
        }

        try {
            System.out.println("\nEjemplo de Excepcion NumberFormatException");
            int numero = Integer.parseInt("1a");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("Formato de numero invalido" );
        }



      /*  try {
            System.out.println("\nthrow");
            ImprimirEdad(-1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());// TODO: handle exception
        } */

            try{
        System.out.println("\nthrow");
            ImprimirEdad(-1);
        } catch (EdadInvalida e) {
            System.err.println(e.getMessage());
        }

        

    }

    public static void ImprimirEdad (int edad) throws EdadInvalida{

   /*     if(edad<0){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        System.out.println(edad);
    } */
    
        if(edad<0){

            throw new EdadInvalida("La edad no puede ser negativa");

        }
        System.out.println(edad);
    
    
    }


}
