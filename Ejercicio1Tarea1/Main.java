package Ejercicio1Tarea1;

import java.util.Scanner;

public class Main {

    // Scanner estático para usarlo en todos los métodos
    private static Scanner scanner = new Scanner(System.in);
    // Instancia estática del teléfono para gestionarla desde el main
    private static TelefonoMovil telefono = new TelefonoMovil("600123456");

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

    // Opción 2: Agregar contacto
    private static void agregarContacto() {
        System.out.println("Introduce el nombre del nuevo contacto:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el número de teléfono:");
        String numero = scanner.nextLine();

        // Usamos el metodo factor y estático de la clase Contacto
        Contacto nuevoContacto = Contacto.createContact(nombre, numero);

        telefono.addNewContact(nuevoContacto);
    }

    // Opción 3: Actualizar contacto
    private static void actualizarContacto() {
        System.out.println("Introduce el nombre del contacto actual a actualizar:");
        String nombreActual = scanner.nextLine();

        // Primero verificamos si existe usando queryContact
        Contacto contactoExistente = telefono.queryContact(nombreActual);

        if (contactoExistente == null) {
            System.out.println("Error: No se encontró el contacto " + nombreActual);
            return;
        }

        System.out.println("Introduce el NUEVO nombre:");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Introduce el NUEVO número de teléfono:");
        String nuevoNumero = scanner.nextLine();

        Contacto nuevoContacto = Contacto.createContact(nuevoNombre, nuevoNumero);

        if (telefono.updateContact(contactoExistente, nuevoContacto)) {
            System.out.println("Contacto actualizado correctamente.");
        } else {
            System.out.println("Error al actualizar el contacto.");
        }
    }

    // Opción 4: Eliminar contacto
    private static void eliminarContacto() {
        System.out.println("Introduce el nombre del contacto a eliminar:");
        String nombre = scanner.nextLine();

        // Necesitamos obtener el objeto Contacto primero para pasarlo a removeContact
        Contacto contactoExistente = telefono.queryContact(nombre);

        if (contactoExistente == null) {
            System.out.println("Error: No se encontró el contacto.");
            return;
        }

        if (telefono.removeContact(contactoExistente)) {
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("Error al eliminar el contacto.");
        }
    }

    // Opción 5: Buscar contacto
    private static void buscarContacto() {
        System.out.println("Introduce el nombre del contacto a buscar:");
        String nombre = scanner.nextLine();

        Contacto contacto = telefono.queryContact(nombre);

        if (contacto == null) {
            System.out.println("El contacto no existe en la agenda.");
        } else {
            System.out.println("Contacto encontrado: " + contacto.getName() +
                    " -> Teléfono: " + contacto.getPhoneNumber());
        }
    }


    public static void main (String[]args){
        boolean continuar = true;
        int opcion = 0;

        imprimirMenu();

        while (continuar) {
            System.out.println("\nElige una opción: (6 para mostrar las opciones)");
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
                    agregarContacto();
                    break;
                case 3:
                    actualizarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 5:
                    buscarContacto();
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
