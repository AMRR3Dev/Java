package EmpleadoEjercicio;

/**
 * CLASE ABSTRACTA: Empleado
 *
 * ¿Qué es una clase abstracta?
 * Una clase abstracta es una clase que NO puede ser instanciada directamente,
 * es decir, no puedes hacer: new Empleado(...).
 * Sirve como PLANTILLA BASE para que otras clases hereden de ella.
 * Define atributos y comportamientos comunes a todos los tipos de empleados.
 *
 * ¿Qué es la HERENCIA?
 * La herencia es un mecanismo de la Programación Orientada a Objetos (POO)
 * que permite que una clase (subclase/hija) herede los atributos y métodos
 * de otra clase (superclase/padre). Así se reutiliza código y se establece
 * una relación "es un" (EmpleadoPorHora ES UN Empleado).
 *
 * En este paquete:
 *   - EmpleadoPorHora   extends Empleado  → hereda nombre y salarioBase
 *   - EmpleadoTiempoCompleto extends Empleado → hereda nombre y salarioBase
 */
public abstract class Empleado {

    // Atributo privado: solo accesible dentro de esta clase.
    // Almacena el nombre del empleado.
    private String nombre;

    // Atributo privado: almacena el salario base del empleado.
    // Las subclases no acceden directamente a él; usan getSalarioBase().
    private double salarioBase;

    /**
     * Constructor de la clase Empleado.
     * Las subclases DEBEN llamar a este constructor usando super(nombre, salarioBase)
     * para inicializar los atributos heredados, ya que son privados y no accesibles
     * directamente desde las subclases.
     *
     * @param nombre      Nombre del empleado.
     * @param salarioBase Salario base del empleado (puede ser 0 si no aplica).
     */
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;           // Se guarda el nombre recibido en el atributo de instancia
        this.salarioBase = salarioBase; // Se guarda el salario base recibido
    }

    /**
     * Getter: getNombre()
     * Devuelve el nombre del empleado.
     * Es necesario porque el atributo 'nombre' es privado (encapsulamiento).
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter: getSalarioBase()
     * Devuelve el salario base del empleado.
     * Las subclases usan este método para acceder al salarioBase,
     * ya que el atributo es privado en esta clase.
     *
     * @return El salario base del empleado.
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * MÉTODO ABSTRACTO: calcularSalario()
     *
     * ¿Por qué es abstracto?
     * Porque cada tipo de empleado calcula su salario de forma diferente:
     *   - EmpleadoPorHora:        salario = horasTrabajadas * pagoPorHora
     *   - EmpleadoTiempoCompleto: salario = salarioBase + bono
     *
     * Al declararlo abstracto, se OBLIGA a que cada subclase lo implemente
     * con su propia lógica. Esta clase define el "qué" (debe existir un cálculo
     * de salario), pero no el "cómo" (cada subclase define su implementación).
     *
     * @return El salario calculado según el tipo de empleado.
     */
    public abstract double calcularSalario();

}
