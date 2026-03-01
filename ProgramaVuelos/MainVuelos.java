package ProgramaVuelos;

import Ejercicio1Tarea2.Cancion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MainVuelos {
    private static void imprimirMenu() {
        System.out.println("1 - Imprimir todos los vuelos");
        System.out.println("2 - Buscar un número de vuelo");
        System.out.println("3 - Buscar vuelo por clave");
        System.out.println("4 - Añadir vuelo nuevo");
        System.out.println("5 - Borrar vuelo por número");
        System.out.println("0 - SALIR");
        System.out.println("--------------------------------");
    }

    private static void imprimirVuelos(ArrayList<Vuelo> vuelos) {
        //Si el arraylist está vacio
        if (vuelos.isEmpty()) {
            System.out.println("No existen vuelos.");
            return;
        }

        //Si el arraylist tiene datos
        System.out.println("\nDATOS DE LOS VUELOS:");
        for (Vuelo v : vuelos) {
            System.out.println(v.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aeropuerto Valencia = new Aeropuerto("VALENCIA");

        Valencia.addVuelo("2020-01", "Valencia", "Menorca", "15-08", "turista");
        Valencia.addVuelo("2023-02", "Valencia", "Tenerife", "20-08", "turista");
        Valencia.addVuelo("2023-03", "París", "Valencia", "15-08", "primera");
        Valencia.addVuelo("2023-04", "Atenas", "Valencia", "20-08", "primera");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n================================");
            System.out.println("VUELOS DEL AEROPUERTO DE " + Valencia.getNombre());
            System.out.println("================================");
            imprimirMenu();
            System.out.print("Dame la opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    imprimirVuelos(Valencia.getVuelos());
                    break;
                case 2:
                    System.out.println("\nBUSCAR VUELO POR Nº:");
                    if (Valencia.getVuelos().isEmpty()) {
                        System.out.println("No existen vuelos.");
                    } else {
                        System.out.print("Número de vuelo: ");
                        String numIntroduce = sc.nextLine();
                        Vuelo v = Valencia.encontrarVuelo(numIntroduce);
                        if (v != null) {
                            System.out.println("\nDatos del vuelo:");
                            System.out.println(v.toString());
                        } else {
                            System.out.println("El número de vuelo no existe.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("BUSCAR VUELO POR CLAVE: ");
                    if (Valencia.getVuelos().isEmpty()) {
                        System.out.println("No existen vuelos.");
                    } else {
                        System.out.print("Clave: ");
                        String clave = sc.nextLine();
                        if (!clave.equalsIgnoreCase("origen") && !clave.equalsIgnoreCase("destino") && !clave.equalsIgnoreCase("dia") && !clave.equalsIgnoreCase("clase")) {
                            System.out.println("Lo siento pero la clave no existe");
                        } else {
                            System.out.print("Valor: ");
                            String valor = sc.nextLine();
                            ArrayList<Vuelo> vuelosEncontrados = Valencia.encontrarVueloClave(clave, valor);
                            if (vuelosEncontrados.isEmpty()) {
                                System.out.println("No existen datos para (" + clave + " " + valor + ").");
                            } else {
                                // Imprimimos todos los vuelos que se hayan encontrado
                                for (Vuelo v : vuelosEncontrados) {
                                    System.out.println("Datos del vuelo:");
                                    System.out.println(v.toString());
                                }
                            }
                        }
                    }
                    break;
                case 4:
                   System.out.println("\nAÑADIR NUEVO VUELO: ");
                   System.out.print("Numero: ");
                   String numero = sc.nextLine();
                   System.out.print("Origen: ");
                   String origen = sc.nextLine();
                   System.out.print("Destino: ");
                   String destino = sc.nextLine();
                   System.out.print("Día: ");
                   String dia = sc.nextLine();
                   System.out.print("Clase: ");
                   String clase = sc.nextLine();
                   Valencia.addVuelo(numero, origen, destino, dia, clase);
                   System.out.println("Vuelo añadido a la lista.");
                   break;
                case 5:
                   System.out.println("BORRAR VUELO: ");
                    if (Valencia.getVuelos().isEmpty()) {
                        System.out.println("No existen vuelos.");
                    }else {
                        System.out.print("Número de vuelo: ");
                        String numeroVuel = sc.nextLine();
                        Vuelo f = Valencia.encontrarVuelo(numeroVuel);
                        if (f!=null) {
                            Valencia.borrarVuelo(numeroVuel);
                            System.out.println("Vuelo nº " + numeroVuel + " eliminado.");
                        } else {
                            System.out.println("El número de vuelo no existe.");
                        }
                    }


            }

        }
    }
}
