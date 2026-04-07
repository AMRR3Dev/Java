package EjerciciosArrays;

public class CadenasArreglo{

public static void main(String[] args) {
    

    String[] nombres =  new String[]{"Ale","Juan","Manuel","Ana"};

    String[] nombre = {"Raul","Maria","Mario","Pedro"};

System.out.println("\nPrimera forma");


    for(String nombres1 : nombres ){
        System.out.println(nombres1);
    }
System.out.println("\nSegunda forma");
    for(String nom : nombre){
        
        System.out.println("Nombres: "+nom);
    }


for  (int i =0; i<nombre.length;i++){

    System.out.println("Nombre en el indice "+i+": "+nombre[i]);


    if ("Maria".equals(nombre[i])){

        System.out.println("Se encontro en el indice "+i+": "+nombre[i]);
    }
   

}





}



}