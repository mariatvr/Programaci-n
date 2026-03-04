package ProgramaArte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // 1. VARIABLES LOCALES (Las colecciones y el Scanner dentro del main)
        ArrayList<Artista> listaArtistas = new ArrayList<>();

        // ¡OJO AQUÍ! Usamos un Set (HashSet) para que no haya obras repetidas
        Set<Obra> listaObras = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        // --- CARGAMOS LOS DATOS DE EJEMPLO DEL PDF ---
        Artista daVinci = new Artista("Leonardo da Vinci", "italiano");
        Artista picasso = new Artista("Pablo Picasso", "español");
        Artista rodin = new Artista("Auguste Rodin", "francés");
        listaArtistas.add(daVinci);
        listaArtistas.add(picasso);
        listaArtistas.add(rodin);

        listaObras.add(new Obra("Salvator Mundi", "óleo sobre madera", 450.0, 1500, daVinci));
        listaObras.add(new Obra("La Gioconda", "óleo sobre madera", 870.0, 1503, daVinci));
        listaObras.add(new Obra("El pensador", "escultura", 11.0, 1904, rodin));
        listaObras.add(new Obra("El sueño", "óleo sobre lienzo", 155.0, 1932, picasso));
        listaObras.add(new Obra("El Guernica", "óleo sobre lienzo", 2000.0, 1937, picasso));

        // --- BUCLE DEL MENÚ ---
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== MENÚ GALERÍA DE ARTE ===");
            System.out.println("1. Añadir obra");
            System.out.println("2. Añadir artista");
            System.out.println("3. Buscar obra por nombre");
            System.out.println("4. Buscar obras por artista");
            System.out.println("5. Eliminar obra");
            System.out.println("6. Encontrar obra más barata");
            System.out.println("7. Encontrar obra más moderna");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n--- AÑADIR OBRA ---");
                    System.out.print("Nombre de la obra: ");
                    String nombreObra = sc.nextLine();
                    System.out.print("Tipo de obra: ");
                    String tipo = sc.nextLine();
                    System.out.print("Precio aproximado (en millones): ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Año de realización: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre del artista: ");
                    String nombreArt = sc.nextLine();

                    // Buscamos si el artista existe
                    Artista artistaEncontrado = null;
                    for (Artista a : listaArtistas) {
                        if (a.getNombre().equalsIgnoreCase(nombreArt)) {
                            artistaEncontrado = a;
                            break;
                        }
                    }

                    if (artistaEncontrado == null) {
                        System.out.println("Error: El artista '" + nombreArt + "' no existe. Añádelo primero (Opción 2).");
                    } else {
                        // Creamos la obra y dejamos que el Set bloquee los duplicados
                        Obra nuevaObra = new Obra(nombreObra, tipo, precio, anio, artistaEncontrado);
                        if (listaObras.add(nuevaObra)) {
                            System.out.println("Obra añadida con éxito.");
                        } else {
                            System.out.println("Error: esa obra ya está registrada.");
                        }
                    }
                    break;

                case "2":
                    System.out.println("\n--- AÑADIR ARTISTA ---");
                    System.out.print("Nombre artístico: ");
                    String nombreNuevoArt = sc.nextLine();

                    // Comprobamos si ya existe
                    boolean existe = false;
                    for (Artista a : listaArtistas) {
                        if (a.getNombre().equalsIgnoreCase(nombreNuevoArt)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Ese artista ya existe en el sistema.");
                    } else {
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = sc.nextLine();
                        listaArtistas.add(new Artista(nombreNuevoArt, nacionalidad));
                        System.out.println("Artista añadido correctamente.");
                    }
                    break;

                case "3":
                    System.out.print("Nombre de la obra a buscar: ");
                    String nombreBusqueda = sc.nextLine();
                    boolean encontrada = false;
                    for (Obra o : listaObras) {
                        if (o.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                            System.out.println(o.toString());
                            encontrada = true;
                        }
                    }
                    if (!encontrada) System.out.println("Obra no encontrada.");
                    break;

                case "4":
                    System.out.print("Nombre del artista: ");
                    String buscarArt = sc.nextLine();
                    boolean tieneObras = false;
                    for (Obra o : listaObras) {
                        if (o.getArtista().getNombre().equalsIgnoreCase(buscarArt)) {
                            System.out.println(o.toString());
                            tieneObras = true;
                        }
                    }
                    if (!tieneObras) System.out.println("No hay obras registradas de este artista.");
                    break;

                case "5":
                    System.out.print("Nombre de la obra a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    Obra obraABorrar = null;
                    for (Obra o : listaObras) {
                        if (o.getNombre().equalsIgnoreCase(nombreEliminar)) {
                            obraABorrar = o;
                            break;
                        }
                    }

                    if (obraABorrar != null) {
                        listaObras.remove(obraABorrar);
                        System.out.println("Obra eliminada con éxito.");
                    } else {
                        System.out.println("No se encontró esa obra.");
                    }
                    break;

                case "6": // Obra más barata
                    if (listaObras.isEmpty()) {
                        System.out.println("No hay obras registradas.");
                    } else {
                        Obra masBarata = null;
                        for (Obra o : listaObras) {
                            // Si es la primera que miramos (null) o si su precio es menor que la ganadora actual
                            if (masBarata == null || o.getPrecioMillones() < masBarata.getPrecioMillones()) {
                                masBarata = o;
                            }
                        }
                        System.out.println("La obra más barata es:\n" + masBarata.toString());
                    }
                    break;

                case "7": // Obra más moderna
                    if (listaObras.isEmpty()) {
                        System.out.println("No hay obras registradas.");
                    } else {
                        Obra masModerna = null;
                        for (Obra o : listaObras) {
                            // Si es la primera que miramos (null) o si su año es mayor que la ganadora actual
                            if (masModerna == null || o.getAnio() > masModerna.getAnio()) {
                                masModerna = o;
                            }
                        }
                        System.out.println("La obra más moderna es:\n" + masModerna.toString());
                    }
                    break;

                case "8":
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        sc.close();
    }
}
