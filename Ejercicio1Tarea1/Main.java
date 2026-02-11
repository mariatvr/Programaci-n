package Ejercicio1Tarea1;

import java.util.Scanner;

public class Main {

    private static void imprimirMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar nuevo contacto");
        System.out.println("3 - Actualizar contacto existente");
        System.out.println("4 - Eliminar contacto");
        System.out.println("5 - Buscar contacto por nombre");
        System.out.println("6 - Volver a imprimir opciones");
    }


    public static void main (String[]args){
        boolean continuar = true;
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil telefono = new TelefonoMovil("600123456");

        imprimirMenu();

        while (continuar) {
            System.out.println("\nElige una opción: (6 para mostrar las opciones): ");
            // Validación simple para evitar errores si meten letras
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del salto de línea
            } else {
                System.out.println("Error: Por favor, introduce un número.");
                scanner.nextLine(); // Limpiar entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    continuar = false;
                    break;
                case 1:
                    telefono.printContacts();
                    break;
                case 2:
                    System.out.println("Introduce el nombre del nuevo contacto:");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduce el número de teléfono:");
                    String numero = scanner.nextLine();

                    // Usamos el metodo factor y estático de la clase Contacto
                    Contacto nuevoContacto = Contacto.createContact(nombre, numero);

                    telefono.addNewContact(nuevoContacto);
                    break;
                case 3:
                    System.out.println("Introduce el nombre del contacto actual a actualizar:");
                    String nombreActual = scanner.nextLine();

                    // Primero verificamos si existe usando queryContact
                    Contacto contactoExistente = telefono.queryContact(nombreActual);

                    if (contactoExistente == null) {
                        System.out.println("Error: No se encontró el contacto " + nombreActual);
                    }

                    if (contactoExistente != null) {
                    System.out.println("Introduce el NUEVO nombre:");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Introduce el NUEVO número de teléfono:");
                    String nuevoNumero = scanner.nextLine();

                    Contacto nuevoContacto1 = Contacto.createContact(nuevoNombre, nuevoNumero);

                    telefono.updateContact(contactoExistente, nuevoContacto1);
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre del contacto a eliminar:");
                    String nombre2 = scanner.nextLine();

                    // Necesitamos obtener el objeto Contacto primero para pasarlo a removeContact
                    Contacto contactoExistente1 = telefono.queryContact(nombre2);

                    if (contactoExistente1 == null) {
                        System.out.println("Error: No se encontró el contacto.");
                    }

                    if (contactoExistente1 != null) {
                        telefono.removeContact(contactoExistente1);
                    }

                    break;
                case 5:
                    System.out.println("Introduce el nombre del contacto a buscar:");
                    String nombre3 = scanner.nextLine();

                    Contacto contacto = telefono.queryContact(nombre3);

                    if (contacto == null) {
                        System.out.println("El contacto no existe en la agenda.");
                    } else {
                        System.out.println("Contacto encontrado: " + contacto.getName() +
                                " -> Teléfono: " + contacto.getPhoneNumber());
                    }
                    break;
                case 6:
                    imprimirMenu();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }
}
