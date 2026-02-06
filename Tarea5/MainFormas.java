package Tarea5;

import java.util.Arrays;

public class MainFormas {
    public static void main (String[]args){
        /*
        //MAIN DEL EJERCICIO 4
        Rectangulo rectan = new Rectangulo(7, 5);
        Triangulo trian = new Triangulo(4, 3);

        System.out.println("Área del rectángulo: "+rectan.getArea());
        System.out.println("Perímetro del rectángulo: "+rectan.getPerimeter());

        System.out.println("Área del triángulo: "+trian.getArea());
        System.out.println("Perímetro del triángulo: "+trian.getPerimeter());


        //MAIN DE EJERCICIO 5
        System.out.println("\n--- EJERCICIO 5 ---");
        Rectangulo ejer5 = new Rectangulo(4,2);
        System.out.println("Área del rectángulo: "+ejer5.getArea());
        System.out.println("Perímetro del rectángulo: "+ejer5.getPerimeter());

        System.out.println("\nRedimensionamos el rectángulo: ");
        ejer5.redimensionar(2);
        System.out.println("Área del rectángulo redimensionado: "+ejer5.getArea());
        System.out.println("Perímetro del rectángulo redimensionado: "+ejer5.getPerimeter());

         */

        //MAIN DEL EJERCICIO 6
        Rectangulo[] rectan10 = new Rectangulo[10];

        rectan10 [0]= new Rectangulo(6,2);
        rectan10 [1]= new Rectangulo(5,3);
        rectan10 [2] = new Rectangulo(7,5);
        rectan10 [3]= new Rectangulo(8,10);
        rectan10 [4]= new Rectangulo(7,4);
        rectan10 [5]= new Rectangulo(10,6);
        rectan10 [6]= new Rectangulo(25,17);
        rectan10 [7]= new Rectangulo(12,6);
        rectan10 [8]= new Rectangulo(8,4);
        rectan10 [9]= new Rectangulo(11,7);

        Arrays.sort(rectan10);
        System.out.println("-- RECTÁNGULOS DE MENOR A MAYOR EN FUNCIÓN DE SU ÁREA --\n");
        for (int i=0; i<rectan10.length; i++){
            System.out.println("Rectángulo "+(i+1)+"\n"+rectan10[i].toString()+"\n");
        }
    }
}
