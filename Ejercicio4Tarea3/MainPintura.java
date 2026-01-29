package Ejercicio4Tarea3;

import Ejercicio3Tarea3.MainPolimorfismo;

public class MainPintura {
    static class Forma{
        protected String nombre;

        public Forma(String nombre){
            this.nombre=nombre;
        }

        public double area(){
            return 0;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    static class Esfera extends Forma{
        private double radio;

        public Esfera(double radio){
            super("Esfera");
            this.radio = radio;
        }

        @Override
        public double area() {
            return 4 * Math.PI * Math.pow(radio, 2);
        }

        @Override
        public String toString(){
            return nombre;
        }
    }

    static class Rectangulo extends Forma{
        private double longitud;
        private double ancho;

        public Rectangulo(double longitud, double ancho){
            super("Rectángulo");
            this.longitud=longitud;
            this.ancho=ancho;
        }

        @Override
        public double area() {
            return longitud*ancho;
        }

        @Override
        public String toString(){
            return nombre;
        }
    }

    static class Cilindro extends Forma{
        private double radio;
        private double altura;

        public Cilindro(double radio, double altura){
            super("Cilindro");
            this.radio=radio;
            this.altura=altura;
        }

        @Override
        public double area() {
            return Math.PI*Math.pow(radio, 2)*altura;
        }

        @Override
        public String toString(){
            return nombre;
        }
    }

    static class Pintura{
        private double cobertura;

        public Pintura(double cobertura){
            this.cobertura=cobertura;
        }

        public double cantidadPintura(Forma f){
            return f.area()/cobertura;
        }
    }
    public static void main (String[]args){
        Forma[] figuras = new Forma[3];
        Pintura p = new Pintura(250);

        figuras[0] = new Esfera (15);
        figuras[1] = new Rectangulo(20, 35);
        figuras[2] = new Cilindro(10, 30);

        System.out.println("--- CÁLCULO DE PINTURA ---");
        //Aquí se prueba el polimorfismo, al tener override para el area de cada figura,
        // llamamos a la función cantidad pintura recorriendo el array de objetos creados.
        for (Forma formaFig : figuras){
            System.out.println("La cantidad de pintura necesaria para "+ formaFig.nombre+" es "+ p.cantidadPintura(formaFig));
        }
    }
}
