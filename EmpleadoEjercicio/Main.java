package EmpleadoEjercicio;

/**
 * CLASE: Main
 *
 * Es el punto de entrada del programa. Contiene el método main() que Java
 * ejecuta automáticamente al iniciar la aplicación.
 *
 * Este programa demuestra tres conceptos clave de la POO:
 *   1. HERENCIA:     EmpleadoPorHora y EmpleadoTiempoCompleto heredan de Empleado.
 *   2. POLIMORFISMO: Las variables empleado1 y empleado2 son de tipo Empleado (padre),
 *                    pero apuntan a objetos de subclases concretas.
 *   3. ABSTRACCIÓN:  Se trabaja con la interfaz común (calcularSalario, getNombre)
 *                    sin importar el tipo concreto de empleado.
 */
public class Main {

    /**
     * Método main: punto de entrada del programa.
     * Java lo ejecuta primero cuando se corre la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se usan en este programa).
     */
    public static void main(String[] args) {

        // Se crea una instancia de Empresa, que internamente tendrá una lista de empleados.
        Empresa empresa = new Empresa();

        // POLIMORFISMO EN ACCIÓN:
        // Las variables empleado1 y empleado2 se declaran de tipo Empleado (clase abstracta/padre).
        // Sin embargo, los objetos reales creados son de subclases concretas.
        // Esto es válido porque EmpleadoPorHora y EmpleadoTiempoCompleto "son" Empleados (herencia).
        // Java sabe en tiempo de ejecución qué tipo real tiene cada objeto.

        // Se crea un EmpleadoPorHora: Juan trabaja 4 horas a $100 por hora → salario = $400
        Empleado empleado1 = new EmpleadoPorHora("Juan", 4, 100);

        // Se crea un EmpleadoTiempoCompleto: Roberto tiene salario base $1000 + bono $500 → salario = $1500
        Empleado empleado2 = new EmpleadoTiempoCompleto("Roberto", 1000, 500);

        // Se agregan ambos empleados a la empresa.
        // El método agregarEmpleado() recibe tipo Empleado, por lo que acepta cualquier subclase.
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);

        // Se muestra el catálogo de empleados con sus salarios calculados.
        // Internamente, para cada empleado se llama calcularSalario():
        //   - Para empleado1 (EmpleadoPorHora):        4 * 100 = 400.0
        //   - Para empleado2 (EmpleadoTiempoCompleto): 1000 + 500 = 1500.0
        // Gracias al polimorfismo, el mismo método calcularSalario() produce
        // resultados diferentes según el tipo real de cada objeto.
        empresa.mostratCatalogoEmpleados();
    }

}
