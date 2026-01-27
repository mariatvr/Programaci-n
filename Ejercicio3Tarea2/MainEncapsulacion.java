package Ejercicio3Tarea2;

public class MainEncapsulacion {
        public static void main(String[] args) {
            System.out.println("\n---PRIMERA PRUEBA: 2 CARAS---\n");
            // 1. Crear impresora con 50% de tóner y capacidad de doble cara
            Impresora impresora = new Impresora(50, 0, true);

            // 2. Probar ver las páginas iniciales
            System.out.println("Páginas iniciales: " + impresora.getNumPagImpresas());

            // 3. Probar impresión (Doble cara activada)
            // Enviamos 4 páginas. Al ser doble cara, debería imprimir 2 hojas físicas.
            int hojasImpresas = impresora.imprimePag(4);
            System.out.println("Hojas impresas en esta orden: " + hojasImpresas);
            System.out.println("Total histórico impresora: " + impresora.getNumPagImpresas());

            // 4. Probar impresión impar (Doble cara activada)
            // Enviamos 5 páginas. Debería imprimir 3 hojas (2 llenas, 1 por una cara).
            hojasImpresas = impresora.imprimePag(5);
            System.out.println("Hojas impresas en esta orden: " + hojasImpresas);
            System.out.println("Total histórico impresora: " + impresora.getNumPagImpresas());

            // 5. Probar rellenar tóner
            System.out.println("Nivel de tóner tras recarga válida: " + impresora.metoToner(20)); // Debería dar 70
            System.out.println("Intento de recarga inválida (rebosa): " + impresora.metoToner(50)); // Debería dar -1

            System.out.println("\n---SEGUNDA PRUEBA: 1 CARA---\n");

            // IMPRESORA QUE IMPRIME A UNA CARA
            // 1. Crear impresora con 50% de tóner y capacidad de una cara
            Impresora impresora1cara = new Impresora(50, 0, false);

            // 2. Probar ver las páginas iniciales
            System.out.println("Páginas iniciales: " + impresora1cara.getNumPagImpresas());

            // 3. Probar impresión (Doble cara activada)
            // Enviamos 4 páginas. Al ser doble cara, debería imprimir 2 hojas físicas.
            int hojasImpresas2 = impresora1cara.imprimePag(4);
            System.out.println("Hojas impresas en esta orden: " + hojasImpresas2);
            System.out.println("Total histórico impresora: " + impresora1cara.getNumPagImpresas());

            // 4. Probar impresión impar (Doble cara activada)
            // Enviamos 5 páginas. Debería imprimir 3 hojas (2 llenas, 1 por una cara).
            hojasImpresas2 = impresora1cara.imprimePag(5);
            System.out.println("Hojas impresas en esta orden: " + hojasImpresas2);
            System.out.println("Total histórico impresora: " + impresora1cara.getNumPagImpresas());

            // 5. Probar rellenar tóner
            System.out.println("Nivel de tóner tras recarga válida: " + impresora1cara.metoToner(20)); // Debería dar 70
            System.out.println("Intento de recarga inválida (rebosa): " + impresora1cara.metoToner(50)); // Debería dar -1
        }
}
