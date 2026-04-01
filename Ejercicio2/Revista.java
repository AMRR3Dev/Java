package Ejercicio2;

/**
 * Clase que representa una revista dentro de la biblioteca.
 * Hereda los atributos comunes de MaterialBiblioteca y agrega
 * el numero de edicion como atributo propio de la revista.
 */
public class Revista extends MaterialBiblioteca {

    // Atributo especifico de Revista
    private int numeroEdicion; // numero de edicion o volumen de la revista

  
    public Revista(String titulo, String autor, String codigo, int numeroEdicion) {
        // Llama al constructor de la clase padre para inicializar los atributos comunes
        super(titulo, autor, codigo);
        this.numeroEdicion = numeroEdicion;
    }

    /**  el numero de edicion de la revista */
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    /**
     * Muestra en consola la informacion completa de la revista.
     * Sobrescribe el metodo abstracto de MaterialBiblioteca (polimorfismo).
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------");
        System.out.println("  [REVISTA]");
        System.out.println("  Titulo    : " + titulo);
        System.out.println("  Editorial : " + autor);
        System.out.println("  Codigo    : " + codigo);
        System.out.println("  Edicion   : " + numeroEdicion);
        System.out.println("  Estado    : " + (disponible ? "Disponible" : "Prestado"));
        System.out.println("------------------------------------");
    }
}
