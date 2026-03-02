package ProgramaArte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Nuestras dos listas principales
    private static ArrayList<Artista> listaArtistas = new ArrayList<>();
    private static ArrayList<Obra> listaObras = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Método auxiliar para buscar si un artista ya existe
    private static Artista buscarArtistaPorNombre(String nombre) {
        for (Artista a : listaArtistas) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // --- 1. CARGAMOS LOS DATOS DE EJEMPLO DEL PDF ---
        // Artistas
        Artista daVinci = new Artista("Leonardo da Vinci", "italiano");
        Artista picasso = new Artista("Pablo Picasso", "español");
        Artista rodin = new Artista("Auguste Rodin", "francés");
        listaArtistas.add(daVinci);
        listaArtistas.add(picasso);
        listaArtistas.add(rodin);

        // Obras (Precios en millones)
        listaObras.add(new Obra("Salvator Mundi", "óleo sobre madera", 450.0, 1500, daVinci));
        listaObras.add(new Obra("La Gioconda", "óleo sobre madera", 870.0, 1503, daVinci));
        listaObras.add(new Obra("El pensador", "escultura", 11.0, 1904, rodin));
        listaObras.add(new Obra("El sueño", "óleo sobre lienzo", 155.0, 1932, picasso));
        listaObras.add(new Obra("El Guernica", "óleo sobre lienzo", 2000.0, 1937, picasso));

        // --- 2. BUCLE DEL MENÚ ---
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
                    añadirObra();
                    break;
                case "2":
                    añadirArtista();
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
                    String nombreArt = sc.nextLine();
                    boolean tieneObras = false;
                    for (Obra o : listaObras) {
                        if (o.getArtista().getNombre().equalsIgnoreCase(nombreArt)) {
                            System.out.println(o.toString());
                            tieneObras = true;
                        }
                    }
                    if (!tieneObras) System.out.println("No hay obras de este artista.");
                    break;
                case "5":
                    System.out.print("Nombre de la obra a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    Obra obraABorrar = null;
                    for (Obra o : listaObras) {
                        if (o.getNombre().equalsIgnoreCase(nombreEliminar)) {
                            obraABorrar = o;
                            break; // Rompemos el bucle al encontrarla
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
                        Obra masBarata = listaObras.get(0); // Suponemos que la primera es la más barata
                        for (Obra o : listaObras) {
                            if (o.getPrecioMillones() < masBarata.getPrecioMillones()) {
                                masBarata = o; // Si encontramos una más barata, actualizamos
                            }
                        }
                        System.out.println("La obra más barata es:\n" + masBarata.toString());
                    }
                    break;
                case "7": // Obra más moderna (La del año mayor)
                    if (listaObras.isEmpty()) {
                        System.out.println("No hay obras registradas.");
                    } else {
                        Obra masModerna = listaObras.get(0);
                        for (Obra o : listaObras) {
                            if (o.getAnio() > masModerna.getAnio()) {
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
            }
        }
    }

    // --- MÉTODOS PARA AÑADIR (Mantienen el switch limpio) ---

    private static void añadirArtista() {
        System.out.print("Nombre artístico: ");
        String nombre = sc.nextLine();

        if (buscarArtistaPorNombre(nombre) != null) {
            System.out.println("Ese artista ya existe en el sistema.");
            return;
        }

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();
        listaArtistas.add(new Artista(nombre, nacionalidad));
        System.out.println("Artista añadido correctamente.");
    }

    private static void añadirObra() {
        System.out.print("Nombre de la obra: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo de obra (ej. óleo sobre madera): ");
        String tipo = sc.nextLine();
        System.out.print("Precio aproximado (en millones): ");
        double precio = Double.parseDouble(sc.nextLine()); // Leemos como texto y convertimos a número
        System.out.print("Año de realización: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre del artista: ");
        String nombreArtista = sc.nextLine();

        // Buscamos si el artista existe
        Artista artistaEncontrado = buscarArtistaPorNombre(nombreArtista);

        if (artistaEncontrado == null) {
            System.out.println("El artista '" + nombreArtista + "' no existe. Por favor, añádelo primero (Opción 2).");
        } else {
            listaObras.add(new Obra(nombre, tipo, precio, anio, artistaEncontrado));
            System.out.println("Obra añadida con éxito.");
        }
    }
}
