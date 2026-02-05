package Tarea5;

public class MainFormas {
    public static void main (String[]args){
        Rectangulo rectan = new Rectangulo(4, 5, 7);
        Triangulo trian = new Triangulo(3, 4, 3);

        rectan.getArea();
        rectan.getPerimeter();

        trian.getArea();
        trian.getPerimeter();
    }
}
