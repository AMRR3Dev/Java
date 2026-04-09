package ExcepcionesEjercicios.VentaProductos;

public class Main {
    
    public static void main(String[] args) {
        
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Manzanas", 10));
        inventario.agregarProducto(new Producto("Peras", 15));

        System.out.println("Inventario inicial:");
        inventario.mostrarInventario();

        try {
            System.out.println("Intentando vender 5 manzanas");
            inventario.venderPoducto("Manzanas", 5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            inventario.mostrarInventario();
        }

        try {
            System.out.println("Intentando vender 20 peras");
            inventario.venderPoducto("Peras", 20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            inventario.mostrarInventario();
        }

        try {
            System.out.println("Intentando vender 10 sandias");
            inventario.venderPoducto("sandias", 10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            inventario.mostrarInventario();
        }
    }
}
