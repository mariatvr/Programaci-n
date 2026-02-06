package Tarea5;

public class MainFormas {
    public static void main (String[]args){
        //Trozo de main del ejercicio 4
        Rectangulo rectan = new Rectangulo(4, 5, 7);
        Triangulo trian = new Triangulo(3, 4, 3);

        rectan.getArea();
        rectan.getPerimeter();

        trian.getArea();
        trian.getPerimeter();


        //Trozo de main del ejercicio 5
        System.out.println("\n--- EJERCICIO 5 ---");
        Rectangulo ejer5 = new Rectangulo(4, 2, 3);
        ejer5.getArea();
        ejer5.getPerimeter();

        System.out.println("\nRedimensionamos el rectángulo: ");
        ejer5.redimensionar(2);
        ejer5.getArea();
        ejer5.getPerimeter();
    }
}
