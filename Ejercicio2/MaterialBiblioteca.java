package Ejercicio2;

/**
 * Clase abstracta que representa un material de biblioteca.
 * Sirve como base para los tipos concretos: Libro y Revista.
 * Aplica encapsulamiento (atributos protegidos con getters) y
 * abstraccion (metodo abstracto mostrarInformacion).
 */
public abstract class MaterialBiblioteca {

    // Atributos comunes a todo material
    protected String titulo;        // titulo del material
    protected String autor;         // nombre del autor o editorial
    protected String codigo;        // codigo unico de identificacion en la biblioteca
    protected boolean disponible = true; // true = disponible para prestamo

    
    public MaterialBiblioteca(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    /**
     * Registra el prestamo del material.
     * Cambia disponible a false si el material estaba disponible;
     * lanza IllegalStateException si ya se encontraba prestado.
     */
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Material \"" + titulo + "\" prestado con exito.");
        } else {
            // Excepcion opcional: material no disponible
            throw new IllegalStateException(
                "El material \"" + titulo + "\" (codigo: " + codigo + ") no esta disponible.");
        }
    }

    /**
     * Registra la devolucion del material.
     * Cambia disponible a true para que pueda prestarse de nuevo.
     */
    public void devolver() {
        disponible = true;
        System.out.println("Material \"" + titulo + "\" devuelto con exito.");
    }

    /**
     * Muestra en consola todos los datos del material.
     * Cada subclase debe proporcionar su propia implementacion
     * para incluir los atributos especificos (polimorfismo).
     */
    public abstract void mostrarInformacion();

    // Getters

    /** el titulo del material */
    public String getTitulo() {
        return titulo;
    }

    /** el autor o editorial del material */
    public String getAutor() {
        return autor;
    }

    /** el codigo unico del material */
    public String getCodigo() {
        return codigo;
    }

    /**  true si el material esta disponible para prestamo */
    public boolean isDisponible() {
        return disponible;
    }
}
