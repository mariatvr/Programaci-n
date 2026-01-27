package Ejercicio1Tarea2;

public class Main {
        public static void main(String[] args) {
            Pared paredNorte = new Pared("Norte");
            Pared paredSur = new Pared("Sur");
            Pared paredEste = new Pared("Este");
            Pared paredOeste = new Pared("Oeste");

            Techo techo = new Techo(300, 1); // 300cm altura, color código 1

            Cama cama = new Cama("Moderna", 2, 50, 2, 1);

            Lampara lampara = new Lampara("Clásica", true, 5);

            // 2. Crear el objeto principal (Composición)
            Habitacion habitacion = new Habitacion("Dormitorio Principal", paredNorte, paredSur, paredEste, paredOeste, techo, cama, lampara);

            // 3. Probar el código
            System.out.println("--- Prueba de hacer la cama ---");
            habitacion.hacerLaCama();

            System.out.println("\n--- Prueba de la lámpara (Apartado g) ---");
            habitacion.getLampara().encender();

            System.out.println("Estilo de lámpara: " + habitacion.getLampara().getEstilo());
        }
    }
