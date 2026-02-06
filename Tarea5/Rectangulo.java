package Tarea5;

public class Rectangulo extends Forma implements Redimensionable{
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
        System.out.println("Área del rectángulo: "+((ancho*2)+(alto*2)));
    }

    @Override
    public void redimensionar(int x) {
        this.ancho=x;
        this.alto=x;
        System.out.println("Alto del rectángulo redimensionado: "+ancho);
        System.out.println("Ancho del rectángulo redimensionado: "+alto);
    }
}
