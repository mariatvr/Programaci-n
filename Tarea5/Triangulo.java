package Tarea5;

public class Triangulo extends Forma{
    private double ancho;
    private double alto;

    public Triangulo(double alto, double ancho){
        super(3);
        this.ancho=ancho;
        this.alto=alto;
    }


    @Override
    public double getArea() {
        return ancho*alto/2;
    }

    @Override
    public double getPerimeter() {
        return ancho*3;
    }
}
