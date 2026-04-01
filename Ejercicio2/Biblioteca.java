package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona el catalogo de materiales de una biblioteca.
 * Permite agregar materiales, mostrar el catalogo completo y
 * realizar prestamos y devoluciones buscando por codigo.
 * Aplica polimorfismo al recorrer la lista de MaterialBiblioteca.
 */
public class Biblioteca {

    // Lista polimorfica: puede almacenar objetos Libro y Revista
    private List<MaterialBiblioteca> materiales;

    /**
     * Inicializa la biblioteca con una lista vacia de materiales.
     */
    public Biblioteca() {
        this.materiales = new ArrayList<>();
    }

    /**
     * Agrega un material (Libro o Revista) al catalogo de la biblioteca.
     *
     *  material el objeto MaterialBiblioteca a registrar
     */
    public void agregarMaterial(MaterialBiblioteca material) {
        materiales.add(material);
        System.out.println("Material \""+  material.getTitulo() + "\" agregado al catalogo. Con codigo: "  + material.getCodigo());
    }

    /**
     * Muestra en consola todos los materiales registrados en la biblioteca.
     * Usa polimorfismo: llama a mostrarInformacion() de cada subclase
     * (Libro o Revista) sin necesidad de conocer el tipo concreto.
     */
    public void mostrarCatalogo() {
        if (materiales.isEmpty()) {
            System.out.println("El catalogo esta vacio.");
            return;
        }
        System.out.println("\n====================================");
        System.out.println("    CATALOGO DE LA BIBLIOTECA       ");
        System.out.println("====================================");
        // Polimorfismo: el metodo correcto (Libro o Revista) se invoca en tiempo de ejecucion
        for (MaterialBiblioteca material : materiales) {
            material.mostrarInformacion();
        }
        System.out.println("Total de materiales: " + materiales.size());
        System.out.println("====================================\n");
    }

    /**
     * Busca un material por su codigo y registra su prestamo.
     * Lanza IllegalArgumentException si el codigo no existe en el catalogo.
     * Lanza IllegalStateException (proveniente de prestar()) si ya esta prestado.
     *
     *  codigo codigo unico del material a prestar
     */
    public void prestarMaterial(String codigo) {
        MaterialBiblioteca material = buscarPorCodigo(codigo);
        if (material == null) {
            throw new IllegalArgumentException(
                "No se encontro ningun material con codigo: " + codigo);
        }
        // prestar() lanzara IllegalStateException si el material no esta disponible
        material.prestar();
    }

    /**
     * Busca un material por su codigo y registra su devolucion.
     * Lanza IllegalArgumentException si el codigo no existe en el catalogo.
     *
     *   codigo unico del material a devolver
     */
    public void devolverMaterial(String codigo) {
        MaterialBiblioteca material = buscarPorCodigo(codigo);
        if (material == null) {
            throw new IllegalArgumentException(
                "No se encontro ningun material con codigo: " + codigo);
        }
        material.devolver();
    }

    /**
     * Recorre la lista de materiales y devuelve el que coincida con el codigo dado.
     *
     * codigo a buscar
     * el MaterialBiblioteca encontrado, o null si no existe
     */
    private MaterialBiblioteca buscarPorCodigo(String codigo) {
        for (MaterialBiblioteca material : materiales) {
            if (material.getCodigo().equalsIgnoreCase(codigo)) {
                return material;
            }
        }
        return null; // no encontrado
    }
}
