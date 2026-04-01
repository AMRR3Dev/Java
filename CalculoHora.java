import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculoHora {
    
public static void main (String [] args ){
Scanner scanner = new Scanner(System.in);
DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

//hora entrada
System.out.print("Ingresa la Hora de entrada (hh:mm:ss): ");
String entrada = scanner.nextLine();
LocalTime horaEntrada = LocalTime.parse(entrada,formato);


//Hora salida
System.out.print("Ingresar hora salida (hh:mm:ss): ");
String Salida = scanner.nextLine();
LocalTime horaSalida = LocalTime.parse(Salida,formato);

scanner.close();

//validar hora de salida no sea menor 

if(horaSalida.isBefore(horaEntrada)){
    System.out.println("Error: la hora de salida no puede ser anterior a  la hora de entrada");
return;
}

Duration duration = Duration.between(horaEntrada, horaSalida);
long horas = duration.toHours();
long minutos = duration.toMinutesPart();
//long minunutos = duration.toMinutes() %60;
long segundos = duration.toMinutesPart();
//long segundos = duration.toSeconds() %60;


System.out.println("Calculo de tiempo");
System.out.print(horas + " horas " + minutos+ " minutos " + segundos + " segundos");

}
}
