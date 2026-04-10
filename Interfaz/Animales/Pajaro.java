package Interfaz.Animales;

public class Pajaro extends Animal  implements IVolador{

    @Override
    void hacerSonido() {

        System.out.println("El pajaro canta");
        

    }

    @Override
    public void volar() {

        System.out.println("El pajaro vuela con sus alas");

    }
    


    
}
