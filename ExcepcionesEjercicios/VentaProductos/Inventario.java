package ExcepcionesEjercicios.VentaProductos;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    
    private List<Producto> productos;

    public Inventario(){

        this.productos= new ArrayList<>();

    }


    public void agregarProducto(Producto p){
    
        productos.add(p);
    }

    public void venderPoducto (String nombre,int cantidad){

        for (Producto p : productos) {
            if(p.getNombre().equalsIgnoreCase(nombre)){
            if(cantidad>p.getCantidad()){
                    throw new SinStockException("No hay existencia de: "+nombre);
                }
                p.setCantidad(p.getCantidad()-cantidad);
                System.out.println("Venta exitosa ");
                return;
            }
        }


        throw new IllegalArgumentException("Producto no encontrado ");
    }

    public void mostrarInventario() {
        System.out.println("--- Estado del inventario ---");
        for (Producto p : productos) {
            System.out.println("  " + p.getNombre() + ": " + p.getCantidad() + " unidades");
        }
        System.out.println("-----------------------------");
    }






}
