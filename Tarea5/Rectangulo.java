package Tarea5;

public class Rectangulo extends Forma implements Redimensionable, Comparable<Rectangulo>{
    private double ancho;
    private double alto;

    public Rectangulo(double alto, double ancho){
        super(4);
        this.ancho=ancho;
        this.alto=alto;
    }


    @Override
    public double getArea() {
        return ancho*alto;
    }

    @Override
    public double getPerimeter() {
        return (ancho*2)+(alto*2);
    }

    @Override
    public void redimensionar(int x) {
        this.ancho=x;
        this.alto=x;
        System.out.println("Alto del rectángulo redimensionado: "+ancho);
        System.out.println("Ancho del rectángulo redimensionado: "+alto);
    }


    @Override
    public int compareTo(Rectangulo c) {
        int resultado=0;
        if (this.getArea()<c.getArea()) {   resultado = -1;      }
        else if (this.getArea() > c.getArea()){    resultado = 1;      }
        else { return 0;}

        return resultado;
    }

    @Override
    public String toString() {
        return "Altura del rectángulo: "+this.alto+"\nAnchura del rectángulo: "+this.ancho;
    }
}
