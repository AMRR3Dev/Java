package EmpleadoEjercicio;

/**
 * CLASE: EmpleadoPorHora
 *
 * ¿Qué es la HERENCIA aquí?
 * Esta clase usa "extends Empleado", lo que significa que HEREDA de la clase
 * abstracta Empleado. Esto implica que:
 *   - Obtiene automáticamente los atributos 'nombre' y 'salarioBase' de Empleado.
 *   - Obtiene los métodos getNombre() y getSalarioBase().
 *   - ESTÁ OBLIGADA a implementar el método abstracto calcularSalario().
 *
 * EmpleadoPorHora representa a un empleado que cobra según las horas que trabaja,
 * por lo que NO tiene un salario base fijo (se pasa 0 al super()).
 */
public class EmpleadoPorHora extends Empleado {

    // Atributo propio de esta subclase: cantidad de horas trabajadas en el período.
    private int horasTrabajadas;

    // Atributo propio de esta subclase: cuánto se paga por cada hora trabajada.
    private double pagoPorHora;

    /**
     * Constructor de EmpleadoPorHora.
     *
     * ¿Por qué se usa super()?
     * 'super(nombre, 0)' llama al constructor de la clase padre (Empleado).
     * Es obligatorio porque Empleado tiene atributos privados (nombre, salarioBase)
     * que no pueden ser asignados directamente desde esta subclase.
     * Se pasa 0 como salarioBase porque un empleado por hora no tiene salario base fijo;
     * su pago se calcula multiplicando horas trabajadas por pago por hora.
     *
     * @param nombre          Nombre del empleado.
     * @param horasTrabajadas Cantidad de horas que trabajó en el período.
     * @param pagoPorHora     Valor monetario que se paga por cada hora trabajada.
     */
    public EmpleadoPorHora(String nombre, int horasTrabajadas, double pagoPorHora) {
        super(nombre, 0); // Llama al constructor de Empleado; salarioBase = 0 porque no aplica
        this.horasTrabajadas = horasTrabajadas; // Inicializa las horas trabajadas
        this.pagoPorHora = pagoPorHora;          // Inicializa el pago por hora
    }

    /**
     * IMPLEMENTACIÓN del método abstracto calcularSalario().
     *
     * ¿Qué es @Override?
     * La anotación @Override indica que este método SOBREESCRIBE (implementa)
     * el método abstracto definido en la clase padre Empleado.
     * Si el nombre del método no coincide exactamente con el del padre, el compilador
     * lanza un error, lo que ayuda a detectar errores tipográficos.
     *
     * ¿Qué es el POLIMORFISMO aquí?
     * Gracias al polimorfismo, cuando se llama calcularSalario() sobre una referencia
     * de tipo Empleado que apunta a un objeto EmpleadoPorHora, Java ejecuta
     * ESTA implementación automáticamente, sin necesidad de saber el tipo concreto.
     *
     * Fórmula: salario = horasTrabajadas * pagoPorHora
     * Ejemplo: 4 horas * $100/hora = $400
     *
     * @return El salario calculado como horas trabajadas multiplicadas por el pago por hora.
     */
    @Override
    public double calcularSalario() {
        return horasTrabajadas * pagoPorHora;
    }

}
