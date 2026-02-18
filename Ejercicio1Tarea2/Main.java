package Ejercicio1Tarea2;

import Ejercicio1Tarea1.Contacto;
import Ejercicio1Tarea1.TelefonoMovil;

import java.util.*;

public class Main {
    private static void imprimirMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción en la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú");
        System.out.println("6 - Eliminar canción de la playlist");
    }

    private static void imprimirLista(LinkedList<Cancion> playList) {
        Iterator<Cancion> iterator = playList.iterator();
        System.out.println("================================");
        int i = 1;
        while (iterator.hasNext()) {
            System.out.println(i + ": " + iterator.next());
            i++;
        }
        System.out.println("================================");
    }

    private static void play(LinkedList<Cancion> playList){
        boolean continuar = true;
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        // Creamos el iterador especial para moverse adelante y atrás
        ListIterator<Cancion> listIterator = playList.listIterator();

        if (playList.isEmpty()) {
            System.out.println("No hay canciones en la playlist");
            return;
        } else {
            System.out.println("\nReproduciendo: " + listIterator.next());
            imprimirMenu();
        }

        boolean haciaAdelante = true;
        while (continuar) {
            //Control de que se introduzca un número y no otros caracteres
            try {
                System.out.println("\nElige una opción: (5 para mostrar el menú): ");
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, introduce un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo de la lista de reproducción...");
                    continuar = false;
                    break;
                case 1:
                    if (!haciaAdelante){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        haciaAdelante=true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Reproduciendo siguiente: " + listIterator.next());
                    } else {
                        System.out.println("Has llegado al final de la lista.");
                        haciaAdelante = false; // Para que no intente avanzar más
                    }
                    break;
                case 2:
                    if (haciaAdelante) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        haciaAdelante = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Reproduciendo anterior: " + listIterator.previous());
                    } else {
                        System.out.println("Estás al principio de la lista.");
                        haciaAdelante = true;
                    }

                    break;
                case 3:
                    if (haciaAdelante) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Repitiendo: " + listIterator.previous());
                            haciaAdelante = false;
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("Repitiendo: " + listIterator.next());
                            }
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Repitiendo: " + listIterator.next());
                            haciaAdelante = true;
                        } else {
                            if(listIterator.hasPrevious()){
                                System.out.println("Repitiendo: " + listIterator.previous());
                            }
                        }
                    }
                    break;
                case 4:
                    imprimirLista(playList);
                    break;
                case 5:
                    imprimirMenu();
                    break;
                case 6:
                    listIterator.remove();
                    if(listIterator.hasNext()){
                        System.out.println("Reproduciendo ahora: " + listIterator.next());
                    } else {
                        System.out.println("Reproduciendo ahora: " + listIterator.previous());
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }

    public static void main (String[]args){

        ArrayList<Album> albumes = new ArrayList<Album>();

        Album albumBb = new Album("Nadie sabe lo que va a pasar mañana", "Bad Bunny");
        albumBb.addSong("Mercedes Carota", 3.22);
        albumBb.addSong("Teléfono Nuevo", 5.54);
        albumBb.addSong("Seda", 3.10);
        albumes.add(albumBb);

        Album albumRa = new Album("Cosa nuestra", "Rauw Alejandro");
        albumRa.addSong("Espresso Martini", 3.11);
        albumRa.addSong("Ni me conozco", 3.49);
        albumRa.addSong("Tú con él", 4.49);
        albumes.add(albumRa);

        LinkedList<Cancion> miPlayList = new LinkedList<Cancion>();
        albumes.get(0).addToPlayList("Mercedes Carota", miPlayList);
        albumes.get(0).addToPlayList("Seda", miPlayList);
        albumes.get(1).addToPlayList(2, miPlayList);
        albumes.get(1).addToPlayList(3, miPlayList);

        play(miPlayList);
    }
}
