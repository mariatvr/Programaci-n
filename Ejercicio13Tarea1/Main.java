package Ejercicio13Tarea1;

public class Main {
        public static void main(String[] args) {
            // --- PRUEBA 1: Círculo ---
            System.out.println("--- Prueba Círculo ---");
            Circulo circulo = new Circulo(3.75);
            System.out.println("Radio del círculo: " + circulo.getRadio());
            System.out.println("Área del círculo: " + circulo.getArea());

            // --- PRUEBA 2: Cilindro ---
            System.out.println("\n--- Prueba Cilindro ---");
            Cilindro cilindro = new Cilindro(5.55, 7.25);
            System.out.println("Radio del cilindro: " + cilindro.getRadio());
            System.out.println("Altura del cilindro: " + cilindro.getAltura());
            System.out.println("Área de la base (heredada): " + cilindro.getArea());
            System.out.println("Volumen del cilindro: " + cilindro.getVolume());

            // --- PRUEBA 3: Validación de negativos ---
            System.out.println("\n--- Prueba Valores Negativos ---");
            Cilindro cilindroNegativo = new Cilindro(-10, -5);
            System.out.println("Radio (debe ser 0): " + cilindroNegativo.getRadio());
            System.out.println("Altura (debe ser 0): " + cilindroNegativo.getAltura());
        }
    }

