package Estacionamiento;

public class Estacionamiento{


private double precioBase;
private int horaEntrada;
private boolean tieneMembresia;

public Estacionamiento() {
this.precioBase=500;
this.horaEntrada=9;
this.tieneMembresia=true;
}



public Estacionamiento(double precioBase, int horaEntrada, boolean tieneMembresia) {
    this.precioBase = precioBase;
    this.horaEntrada = horaEntrada;
    this.tieneMembresia = tieneMembresia;
}



public double getPrecioBase() {
    return precioBase;
}

public void setPrecioBase(double precioBase) {
    this.precioBase = precioBase;
}

public int getHoraEntrada() {
    return horaEntrada;
}

public void setHoraEntrada(int horaEntrada) {
    this.horaEntrada = horaEntrada;
}

public boolean isTieneMembresia() {
    return tieneMembresia;
}

public void setTieneMembresia(boolean tieneMembresia) {
    this.tieneMembresia = tieneMembresia;
}


private double aplicarDescuentoHorario(double precio){

if (horaEntrada < 14){

    precio=precio/2;
}
return precio;
}



private double aplicarDescuentoMembrecia(double precio){

    if (tieneMembresia){
        precio=precio*0.8;

    }
return precio;
}

private double aplicarPrecioMaximo(double precio){

    if(precio>200){
        precio=200;

    }
return precio;
}


public double calcularPrecioFinal(){
    double precioFinal=precioBase;

    precioFinal=aplicarDescuentoHorario(precioFinal);
    precioFinal=aplicarDescuentoMembrecia(precioFinal);
    precioFinal=aplicarPrecioMaximo(precioFinal);
    return precioFinal;
}



}