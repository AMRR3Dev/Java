package EjerciciosArrays;

import java.util.ArrayList;
import java.util.List;

public class EjemploArrayList {
    
    public static void main(String[] args) {

        List<String> nombres=new ArrayList<>();
        nombres.add("Juan");
        nombres.add("Alejandro");
        nombres.add("Pedro");
 

 System.out.println("nombres "+ nombres);


 nombres.remove(0);
 System.out.println("Se borro el indice 0");
 System.out.println("nombres: "+nombres);
 

nombres.set(1, "Maria");
System.out.println("Se edito el indice 1");
System.out.println("nombres "+nombres);


    }

    





}
