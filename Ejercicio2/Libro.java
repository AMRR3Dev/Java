package Ejercicio2;

/**
 * Clase que representa un libro dentro de la biblioteca.
 * Hereda los atributos comunes de MaterialBiblioteca y agrega
 * el numero de paginas como atributo propio del libro.
 */
public class Libro extends MaterialBiblioteca {

    // Atributo especifico de Libro
    private int numeroPaginas; // cantidad de paginas del libro

   
    public Libro(String titulo, String autor, String codigo, int numeroPaginas) {
        // Llama al constructor de la clase padre para inicializar los atributos comunes
        super(titulo, autor, codigo);
        this.numeroPaginas = numeroPaginas;
    }

    /** @return el numero de paginas del libro */
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * Muestra en consola la informacion completa del libro.
     * Sobrescribe el metodo abstracto de MaterialBiblioteca (polimorfismo).
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------");
        System.out.println("  [LIBRO]");
        System.out.println("  Titulo    : " + titulo);
        System.out.println("  Autor     : " + autor);
        System.out.println("  Codigo    : " + codigo);
        System.out.println("  Paginas   : " + numeroPaginas);
        System.out.println("  Estado    : " + (disponible ? "Disponible" : "Prestado"));
        System.out.println("------------------------------------");
    }
}
