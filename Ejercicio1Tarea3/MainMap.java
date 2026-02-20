package Ejercicio1Tarea3;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MainMap {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public MainMap(){
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación."));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña."));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa."));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto."));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente."));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque."));

        //1 Estoy en montaña
        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);
        //2 Estoy en playa
        ubicaciones.get(2).addExit("N", 5);
        //3 Estoy en edificio
        ubicaciones.get(3).addExit("O", 1);
        //4 Estoy en puente
        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);
        //5 Estoy en bosque
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);
        // Salida quit
        ubicaciones.get(1).addExit("Q", 0);
        ubicaciones.get(2).addExit("Q", 0);
        ubicaciones.get(3).addExit("Q", 0);
        ubicaciones.get(4).addExit("Q", 0);
        ubicaciones.get(5).addExit("Q", 0);
        /*Mejora
        for (Ubicacion ubi : ubicaciones.values()) {
            if (ubi.getId() != 0) { // Omitimos añadir salida Q a la clase de programación (0)
                ubi.addExit("Q", 0);
            }
        }
         */
    }



    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        MainMap mapa = new MainMap();

        int loc = 1;

        while (true) {
            Ubicacion actual = mapa.ubicaciones.get(loc);
            System.out.println(actual.getDescripcion());

            if (loc == 0) {
                break;
            }

            System.out.print("Tus salidas válidas son: ");
            System.out.println(actual.getExits().keySet());

            System.out.println("\nIntroduce tu salida: ");
            String input = sc.nextLine().toUpperCase();
            System.out.println( );

            if (actual.exits.containsKey(input)){
                loc = actual.getExits().get(input);
            } else {
                System.out.println("No es una dirección válida.\n");
            }

        }

        sc.close();
    }
}


