package Ejercicio5Tarea4;

public class Main {
    public static void main (String[]args){
        Bienes silla = new Bienes("Silla de madera", 35);
        Comida cacahuetes = new Comida("Cacahuetes de chocolate", 2.99, 500);
        Juguete muneca = new Juguete("Muñeca Nancy", 50, 4);
        Libro libro = new Libro ("Invisible", 15.99, "Eloy Moreno");

        System.out.println("\n--- IMPRIMIMOS LOS OBJETOS ---\n");
        // Al imprimir el objeto, Java llama automáticamente al método toString()
        // Nota: En Juguete y Libro, el toString ya llama internamente a calcularImpuesto()
        System.out.println(silla);
        System.out.println(cacahuetes);
        System.out.println(muneca);
        System.out.println(libro);


        System.out.println("\n--- CÁLCULOS DE IMPUESTOS ---\n");
        System.out.println("Impuestos de la muñeca: "+muneca.calculoImpuestos()+" €");
        System.out.println("Impuestos del libro: "+libro.calculoImpuestos()+" €");

        Bienes[] inventario = {silla, cacahuetes, muneca, libro};
        System.out.println("\n--- IMPRIMIENDO DESDE EL ARRAY ---");
        // Recorremos el array
        for (Bienes item : inventario) {
            System.out.println(item);
        }

    }
}
