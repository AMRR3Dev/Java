import java.util.Scanner;

public class PagoDeuda {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double deuda = 100;
        double totalPagado = 0;
        int opcion;
        double pago;

        //solicitar monto de la deuda
        System.out.print("Tu deuda es: "+ deuda);

        //Ciclo do-while para el menu

        do{
            System.out.println("\nMenu de pago");
            System.out.println("1.- Pagar con billete");
            System.out.println("2.- Pagar con monedas");
            System.out.println("Seleccione una opcion");
         opcion = scanner.nextInt();


            switch (opcion) {

            case 1: 
             System.out.print("Ingrese el monto del billete: ");
            pago = scanner.nextDouble();
            totalPagado += pago;
            break;


            case 2: 
            System.out.print("Ingrese el monto de la moneda: ");
            pago = scanner.nextDouble();
            totalPagado += pago;
            break;
            
            default:
                System.out.print("Opción inválida\n");
            }

            System.out.print("Total pagado: $"+totalPagado+"\n");
            System.out.print("Deuda restante: $" + (deuda - totalPagado) + "\n");

        }while (totalPagado < deuda);

        System.out.println("Deuda cubierta");
        System.out.println("Pago total: $"+totalPagado);

        scanner.close();
    }

}
