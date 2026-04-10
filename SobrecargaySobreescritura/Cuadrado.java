public class Cuadrado extends Figura {
    
    @Override
    public double area(){
        return 2*2;
    }

    public double area(double lado){
        return lado*lado;
    }

     public double area(int lado){
        return lado*lado;
    }

    public double area(int lado, int lado2){
        return lado*lado;
    }
}
