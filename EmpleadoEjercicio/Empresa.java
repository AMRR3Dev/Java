package EmpleadoEjercicio;

import java.util.ArrayList;
import java.util.List;

/**
 * CLASE: Empresa
 *
 * Esta clase representa una empresa que gestiona una colección de empleados.
 * Puede contener cualquier tipo de empleado (EmpleadoPorHora, EmpleadoTiempoCompleto, etc.)
 * gracias al POLIMORFISMO: la lista almacena referencias de tipo Empleado (la clase padre),
 * pero en tiempo de ejecución cada objeto es del tipo concreto que fue creado.
 *
 * ¿Qué es una List y ArrayList?
 * List es una interfaz de Java que representa una colección ordenada de elementos.
 * ArrayList es una implementación de List que usa un arreglo dinámico internamente,
 * permitiendo agregar elementos sin un tamaño fijo predefinido.
 */
public class Empresa {

    // Lista que almacena todos los empleados de la empresa.
    // Se declara como List<Empleado> (tipo padre) para aprovechar el polimorfismo:
    // puede contener objetos de cualquier subclase de Empleado.
    private List<Empleado> listaEmpleados;

    /**
     * Constructor de Empresa.
     * Inicializa la lista de empleados como un ArrayList vacío,
     * listo para recibir empleados mediante el método agregarEmpleado().
     */
    public Empresa() {
        listaEmpleados = new ArrayList<>(); // Se crea la lista vacía al instanciar la empresa
    }

    /**
     * Método: agregarEmpleado()
     * Agrega un empleado a la lista de la empresa.
     *
     * ¿Por qué el parámetro es de tipo Empleado (clase abstracta)?
     * Gracias al POLIMORFISMO, este método acepta cualquier objeto que sea
     * instancia de una subclase de Empleado (EmpleadoPorHora, EmpleadoTiempoCompleto, etc.).
     * No es necesario crear un método diferente para cada tipo de empleado.
     *
     * @param empleado El empleado (de cualquier subclase) a agregar a la empresa.
     */
    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado); // Se añade el empleado al final de la lista
    }

    /**
     * Método: mostratCatalogoEmpleados()
     * Recorre la lista de empleados y muestra el nombre y salario calculado de cada uno.
     *
     * ¿Cómo funciona el POLIMORFISMO aquí?
     * Al llamar empleado.calcularSalario() dentro del ciclo for-each, Java
     * determina en TIEMPO DE EJECUCIÓN qué implementación de calcularSalario()
     * usar según el tipo real del objeto:
     *   - Si el objeto es EmpleadoPorHora   → ejecuta horasTrabajadas * pagoPorHora
     *   - Si el objeto es EmpleadoTiempoCompleto → ejecuta getSalarioBase() + bono
     * Esto se llama "dynamic dispatch" o despacho dinámico.
     *
     * El ciclo for-each (for(Empleado empleado : listaEmpleados)) recorre
     * cada elemento de la lista, asignándolo temporalmente a la variable 'empleado'.
     */
    public void mostratCatalogoEmpleados() {

        System.out.println("Catalogo Empleados");

        // Se recorre la lista de empleados uno por uno
        for (Empleado empleado : listaEmpleados) {

            // Se imprime el nombre del empleado (obtenido via getter heredado)
            // y el salario calculado (usando la implementación correspondiente al tipo real)
            System.out.println("Nombre: " + empleado.getNombre() +
                               " Salario: " + empleado.calcularSalario());
        }
    }

}
