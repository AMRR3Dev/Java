package EjerciciosArrays;

class Alumno{
    String nombre;
    int edad;
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }



    
}



public class AlumnosArreglos {
    
    public static void main(String[] args) {
        
Alumno[] alumnos ={
    new Alumno("Juan", 20),
    new Alumno("Maria", 22),
    new Alumno("Pedro", 19),
    new Alumno("Ana", 21),
};


for (int i = 0 ; i < alumnos.length; i++){

    System.out.println("Alumnos en el indice "+i+": "+alumnos[i].getNombre() +" con edad: "+ alumnos[i].getEdad());
}

    }



}
