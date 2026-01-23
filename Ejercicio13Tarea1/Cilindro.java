package Ejercicio13Tarea1;

public class Cilindro extends Circulo{
    protected double altura;

    public Cilindro(double radio, double altura) {
        super(radio);
        if (altura<0){
            this.altura=0;
        } else {
            this.altura = altura;
        }
    }

    public double getAltura() {
        return altura;
    }

    public double getVolume(){
        return altura*getArea();
    }
}
