package HashMapEjercicios;


import java.util.TreeMap;

public class TreeMapProductos{

    public static void main(String[] args) {
        
        TreeMap<Integer, String> productos = new TreeMap<>();

        productos.put(7, "Laptop");
        productos.put(5, "Monitor");
        productos.put(6, "Mouse");

        System.out.println(productos);


        System.out.println("\nDevuelve el primer registro ");
        System.out.println(productos.firstKey());

        System.out.println("\nDevuelve el ultimo registro ");
        System.out.println(productos.lastKey());
        
        System.out.println("\nMayor ");
        System.out.println(productos.higherKey(5));
        
        System.out.println("\nMenor ");
        System.out.println(productos.lowerKey(7));


        System.out.println("Orden descendente: "+ productos.descendingMap());


    }


}