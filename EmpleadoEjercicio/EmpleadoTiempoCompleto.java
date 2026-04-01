package EmpleadoEjercicio;

/**
 * CLASE: EmpleadoTiempoCompleto
 *
 * ¿Qué es la HERENCIA aquí?
 * Esta clase usa "extends Empleado", lo que significa que HEREDA de la clase
 * abstracta Empleado. Esto implica que:
 *   - Obtiene automáticamente los atributos 'nombre' y 'salarioBase' de Empleado.
 *   - Obtiene los métodos getNombre() y getSalarioBase().
 *   - ESTÁ OBLIGADA a implementar el método abstracto calcularSalario().
 *
 * EmpleadoTiempoCompleto representa a un empleado con un salario base fijo
 * más un bono adicional. A diferencia de EmpleadoPorHora, aquí SÍ se usa
 * el salarioBase heredado de Empleado, y se le suma un bono.
 */
public class EmpleadoTiempoCompleto extends Empleado {

    // Atributo propio de esta subclase: monto adicional que se suma al salario base.
    private double bono;

    /**
     * Constructor de EmpleadoTiempoCompleto.
     *
     * ¿Por qué se usa super()?
     * 'super(nombre, salarioBase)' llama al constructor de la clase padre (Empleado).
     * Es obligatorio porque Empleado tiene atributos privados que solo pueden
     * inicializarse a través de su propio constructor.
     * Aquí SÍ se pasa el salarioBase real, porque este tipo de empleado
     * tiene un sueldo fijo mensual al que se le agrega un bono.
     *
     * @param nombre      Nombre del empleado.
     * @param salarioBase Salario base mensual fijo del empleado.
     * @param bono        Monto adicional (bono) que se suma al salario base.
     */
    public EmpleadoTiempoCompleto(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase); // Llama al constructor de Empleado para inicializar nombre y salarioBase
        this.bono = bono;           // Inicializa el bono propio de esta subclase
    }

    /**
     * IMPLEMENTACIÓN del método abstracto calcularSalario().
     *
     * ¿Qué es @Override?
     * La anotación @Override indica que este método SOBREESCRIBE (implementa)
     * el método abstracto definido en la clase padre Empleado.
     *
     * ¿Qué es el POLIMORFISMO aquí?
     * Cuando se llama calcularSalario() sobre una referencia de tipo Empleado
     * que apunta a un objeto EmpleadoTiempoCompleto, Java ejecuta
     * ESTA implementación automáticamente. El código que llama al método
     * no necesita saber si el objeto es EmpleadoPorHora o EmpleadoTiempoCompleto;
     * Java resuelve cuál método ejecutar en tiempo de ejecución (dynamic dispatch).
     *
     * ¿Por qué se usa getSalarioBase() y no salarioBase directamente?
     * Porque el atributo 'salarioBase' es PRIVADO en la clase Empleado.
     * Las subclases no pueden acceder a atributos privados del padre directamente,
     * por eso se usa el getter público getSalarioBase() para obtener su valor.
     *
     * Fórmula: salario = salarioBase + bono
     * Ejemplo: $1000 + $500 = $1500
     *
     * @return El salario calculado como la suma del salario base y el bono.
     */
    @Override
    public double calcularSalario() {
        return getSalarioBase() + bono; // salarioBase se obtiene via getter porque es privado en Empleado
    }

}
