package Tarea5;

public class Rectangulo extends Forma{
    private double ancho;
    private double alto;

    public Rectangulo(int numLados, double ancho, double alto){
        super(numLados);
        this.ancho=ancho;
        this.alto=alto;
    }


    @Override
    public void getArea() {
        System.out.println("Área del rectángulo: "+ancho*alto);
    }

    @Override
    public void getPerimeter() {
        System.out.println("Área del rectángulo: "+ancho*2+alto*2);
    }
}
