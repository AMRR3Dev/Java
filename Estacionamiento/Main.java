 package Estacionamiento;

public class Main {

   public static void main(String[] args) {
    
Estacionamiento estacionamiento = new Estacionamiento(160, 14, false);

//estacionamiento.setHoraEntrada(15);
//estacionamiento.setPrecioBase(200);

double precioFinal=estacionamiento.calcularPrecioFinal();

System.out.println("Precio final a pagar: $"+ precioFinal);

   } 

}