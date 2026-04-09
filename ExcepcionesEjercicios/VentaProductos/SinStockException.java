package ExcepcionesEjercicios.VentaProductos;

public class SinStockException extends RuntimeException {

    public SinStockException(String mensaje) {
        super(mensaje);
    }
}
