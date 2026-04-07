package EjerciciosArrays;


import java.util.Scanner;

class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}

public class InventarioBasico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto[] productos = new Producto[]{
            new Producto("Manzana", 10),
            new Producto("Pan", 20),
            new Producto("Leche", 15),
            new Producto("Huevos", 30),
            new Producto("Queso", 25),
            new Producto("Arroz", 50),
            new Producto("Frijoles", 40),
            new Producto("Azúcar", 35),
            new Producto("Café", 20),
            new Producto("Té", 10),
            new Producto("Sal", 15)
        };
        int opcion;

    
        do {
            System.out.println("\n\nInventario Básico");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Buscar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            switch(opcion){
                case 1:
                    //Mostrar Productos
                    System.out.println("Productos en el inventario:");
                    for (int i = 0; i < productos.length; i++) {
                        System.out.println( "\t" + productos[i].getNombre() + " - Cantidad: " + productos[i].getCantidad() );
                    }
                break;
                case 2:
                    //Buscar Producto
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String productoBuscado = sc.nextLine();
                    boolean encontrado = false;

                    productoBuscado = productoBuscado != null ? productoBuscado.trim() : null;
                    for (Producto producto : productos) {
                        if (productoBuscado != null && productoBuscado.equalsIgnoreCase(producto.getNombre())) {
                            System.out.println("####Producto encontrado: " + producto.getNombre() + " - Cantidad: " + producto.getCantidad());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("###Producto no encontrado en el inventario.");
                    }
                    break;

            }
        }while( opcion !=5);
    }
}
