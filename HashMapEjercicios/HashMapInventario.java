package HashMapEjercicios;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapInventario {
public static void main(String[] args) {

HashMap <String, Integer> inventario = new HashMap<>();
    

inventario.put("SKU001", 10);
inventario.put("SKU002", 5);
inventario.put("SKU003", 20);


System.out.println(inventario);

System.out.println("\nSe actualizan datos");

String skuVentas="SKU002";
int stockActual=inventario.get(skuVentas);
inventario.put(skuVentas, stockActual-1);

System.out.println(inventario);

System.out.println("\nSi existen ");

if(inventario.containsKey(skuVentas)){
    System.out.println(inventario.get(skuVentas));

}

System.out.println("\nIterar lo que haya ");

for (var producto : inventario.entrySet()){

    System.out.println("SKU "+producto.getKey() + " stock "+ producto.getValue());
}


//pasar de un hashmap a un treemap

TreeMap<String, Integer> inventarioTreeMap = new TreeMap<>(inventario);

System.out.println(inventarioTreeMap);






}


}