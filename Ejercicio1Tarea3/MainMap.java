package Ejercicio1Tarea3;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MainMap {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public MainMap(){
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        //Estoy en montaña
        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);
        //Estoy en playa
        ubicaciones.get(2).addExit("N", 5);
        //Estoy en edificio
        ubicaciones.get(3).addExit("O", 1);
        //Estoy en puente
        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);
        //Estoy en bosque
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("0", 2);
        // Salida quit
        ubicaciones.get(1).addExit("Q", 0);
        ubicaciones.get(2).addExit("Q", 0);
        ubicaciones.get(3).addExit("Q", 0);
        ubicaciones.get(4).addExit("Q", 0);
        ubicaciones.get(5).addExit("Q", 0);
    }



    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        Ubicacion ubi = new Ubicacion(1, "ejemplo");
        String salidaValida = "[NSEOQnseoq]";
        String salidaIntroducida;
        boolean continuar = true;



        while (continuar) {
            boolean valido = false;
            do {
                try {
                    System.out.println("\nEscribe la letra a la que quieres salir: ");
                    salidaIntroducida = sc.nextLine();

                    if (salidaIntroducida.matches(salidaValida)) {
                        valido = true;
                    } else if (salidaIntroducida.equalsIgnoreCase("Q")) {
                        break;
                    }else {
                        System.out.println("No puede ir en esa dirección.");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Error: Por favor, introduce una letra.");
                }
            } while (!valido);


            continuar=false;
        }


    }
}

