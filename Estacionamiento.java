import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Estacionamiento {

    // Regla de negocio 1: Si la hora de entrada es antes de las 14:00, el precio se cobra a la mitad
    public static double precioMitad(double deuda, LocalTime horaEntrada) {
        if (horaEntrada.isBefore(LocalTime.of(14, 0))) {
            deuda = deuda / 2;
            System.out.println("Descuento aplicado: entrada antes de las 2pm. Precio reducido a la mitad.");
        }
        return deuda;
    }

    // Regla de negocio 2: Si el usuario tiene membresía, se aplica un descuento del 20% al precio final
    public static double aplicarDescuentoMembresia(double deuda, Scanner scanner) {
        System.out.print("¿Tiene membresía? (1 = Sí / 2 = No): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            deuda = deuda * 0.80;
            System.out.println("Descuento de membresía aplicado: 20% de descuento.");
        }
        return deuda;
    }

    // Regla de negocio 3: El precio límite del estacionamiento es $200 pesos
    public static double aplicarLimitePrecio(double deuda) {
        if (deuda > 200) {
            System.out.println("El precio ha sido limitado al máximo de $200 pesos.");
            deuda = 200;
        }
        return deuda;
    }

    public static void main(String[] args) {

        // Inicialización del lector de entrada y formato de hora
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Variables del sistema: precio por hora y contadores de pago
        double precioHora = 10;
        int opcion;
        int opcionB;
        int opcionM;
        double totalPagado = 0;

        // Mensaje de bienvenida
        System.out.println("Bienvenido al sistema de cobro de estacionamiento.");
        System.out.println("Favor de ingresar las horas en formato (hh:mm:ss).\n");

        // Hora de entrada
        System.out.print("Ingresar hora de entrada: ");
        String entrada = scanner.nextLine();
        LocalTime horaEntrada = LocalTime.parse(entrada, formato);

        // Hora de salida
        System.out.print("Ingresa la hora de salida: ");
        String salida = scanner.nextLine();
        LocalTime horaSalida = LocalTime.parse(salida, formato);

        // Validar que la hora de salida no sea anterior a la de entrada
        if (horaSalida.isBefore(horaEntrada)) {
            System.out.println("Error: la hora de salida no puede ser anterior a la de entrada.");
            return;
        }

        // Cálculo de la duración total del estacionamiento
        Duration duration = Duration.between(horaEntrada, horaSalida);
        long horas = duration.toHours();
        long minutos = duration.toMinutesPart();
        long segundos = duration.toSecondsPart();

        // Cálculo de la deuda basado en horas completas
        double deuda = precioHora * horas;

        // Mostrar el resumen de tiempo y deuda al usuario
        System.out.println("\nCalculo de Tiempo");
        System.out.print("Tiempo estacionado: " + horas + " hora(s), " + minutos + " minuto(s), " + segundos + " segundo(s)\n");
        System.out.print("Tu deuda inicial es: $" + deuda + "\n");

        // Si la deuda es cero, no se realiza cobro
        if (deuda == 0) {
            System.out.println("No hay cobro por menos de una hora.");
            return;
        }

        // Aplicar reglas de negocio en orden
        deuda = precioMitad(deuda, horaEntrada);
        deuda = aplicarDescuentoMembresia(deuda, scanner);
        deuda = aplicarLimitePrecio(deuda);

        System.out.printf("Tu deuda final a pagar es: " + deuda);

        // Ciclo de pago: se repite hasta que la deuda esté cubierta
        do {
            // Menú principal de método de pago
            System.out.println("\n--- Menu de pago ---");
            System.out.println("1.- Billetes");
            System.out.println("2.- Monedas");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Submenu de billetes disponibles
                    System.out.println("\nBilletes");
                    System.out.println("1.- $20");
                    System.out.println("2.- $50");
                    System.out.println("3.- $100");
                    System.out.println("4.- $200");
                    System.out.print("Seleccione un billete: ");
                    opcionB = scanner.nextInt();

                    // Suma el valor del billete seleccionado al total pagado
                    switch (opcionB) {
                        case 1:
                            totalPagado += 20;
                            System.out.println("Ingresaste un billete de $20.");
                            break;
                        case 2:
                            totalPagado += 50;
                            System.out.println("Ingresaste un billete de $50.");
                            break;
                        case 3:
                            totalPagado += 100;
                            System.out.println("Ingresaste un billete de $100.");
                            break;
                        case 4:
                            totalPagado += 200;
                            System.out.println("Ingresaste un billete de $200.");
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                            break;
                    }
                    break;

                case 2:
                    // Submenu de monedas disponibles
                    System.out.println("\nMonedas");
                    System.out.println("1.- $1");
                    System.out.println("2.- $2");
                    System.out.println("3.- $5");
                    System.out.println("4.- $10");
                    System.out.print("Seleccione una moneda: ");
                    opcionM = scanner.nextInt();

                    // Suma el valor de la moneda seleccionada al total pagado
                    switch (opcionM) {
                        case 1:
                            totalPagado += 1;
                            System.out.println("Ingresaste una moneda de $1.");
                            break;
                        case 2:
                            totalPagado += 2;
                            System.out.println("Ingresaste una moneda de $2.");
                            break;
                        case 3:
                            totalPagado += 5;
                            System.out.println("Ingresaste una moneda de $5.");
                            break;
                        case 4:
                            totalPagado += 10;
                            System.out.println("Ingresaste una moneda de $10.");
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            // Mostrar el estado actual del pago tras cada operación
            System.out.printf("Total pagado: $"+ totalPagado);
            System.out.printf("Deuda restante: $"+ Math.max(0, deuda - totalPagado));

        } while (totalPagado < deuda); // Continuar hasta cubrir la deuda

        // Resumen final del pago
        System.out.println("\nResumen Final");
        System.out.printf("Deuda cubierta. Pago total: $"+ totalPagado+"\n");

        // Cálculo y muestra del cambio si se pagó de más
        double cambio = totalPagado - deuda;
        if (cambio > 0) {
            System.out.printf("Su cambio es: $"+ cambio+"\n15");
        }

        System.out.println("Gracias por usar el estacionamiento. Hasta luego!");

        scanner.close();
    }
}
