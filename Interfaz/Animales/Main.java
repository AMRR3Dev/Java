package Interfaz.Animales;

public class Main {
  
    public static void main(String[] args) {
        
        Avion avion = new Avion();

        Pajaro pajaro = new Pajaro();
        Animal a1 = new Perro();
            
        a1.hacerSonido();
        a1.respira();

            pajaro.hacerSonido();
            pajaro.volar();


                  avion.volar();



        }




    }




