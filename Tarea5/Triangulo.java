package Tarea5;

public class Triangulo extends Forma{
    private double ancho;
    private double alto;

    public Triangulo(int numLados, double ancho, double alto){
        super(numLados);
        this.ancho=ancho;
        this.alto=alto;
    }


    @Override
    public void getArea() {
        System.out.println("Área del triángulo: "+ancho*alto/2);
    }

    @Override
    public void getPerimeter() {
        System.out.println("Perímetro del triángulo: "+ancho*3);
    }
}
