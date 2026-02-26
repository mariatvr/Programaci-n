package Ejercicio1Tarea4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainCuerposCelestes {
    public static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main (String[]args){
        CuerpoCeleste Mercurio = new CuerpoCeleste("Mercurio", 88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        planetas.add(Mercurio);
        sistemaSolar.put("Mercurio", Mercurio);

        //Planetas creados
        CuerpoCeleste Venus = new CuerpoCeleste("Venus", 225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Tierra = new CuerpoCeleste("La Tierra", 365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Marte = new CuerpoCeleste("Marte", 687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Jupiter = new CuerpoCeleste("Jupiter", 4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Saturno = new CuerpoCeleste("Saturno", 10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Urano = new CuerpoCeleste("Urano", 30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Neptuno = new CuerpoCeleste("Neptuno", 165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste Pluton = new CuerpoCeleste("Pluton", 248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        planetas.add(Venus);
        planetas.add(Tierra);
        planetas.add(Marte);
        planetas.add(Jupiter);
        planetas.add(Saturno);
        planetas.add(Urano);
        planetas.add(Neptuno);
        planetas.add(Pluton);
        sistemaSolar.put("Venus", Venus);
        sistemaSolar.put("Tierra", Tierra);
        sistemaSolar.put("Marte", Marte);
        sistemaSolar.put("Jupiter", Jupiter);
        sistemaSolar.put("Saturno", Saturno);
        sistemaSolar.put("Urano", Urano);
        sistemaSolar.put("Neptuno", Neptuno);
        sistemaSolar.put("Pluton", Pluton);

        //Objeto tipo luna
        CuerpoCeleste Luna = new CuerpoCeleste("Luna", 27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Luna", Luna);
        Tierra.addSatelite(Luna);

        //Creación de otras dos lunas
        CuerpoCeleste Deimos = new CuerpoCeleste("Deimos", 1.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Phobos = new CuerpoCeleste("Phobos", 0.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Deimos", Deimos);
        sistemaSolar.put("Phobos", Phobos);
        Marte.addSatelite(Deimos);
        Marte.addSatelite(Phobos);

        //Creación de cuatro lunas más
        CuerpoCeleste Io = new CuerpoCeleste("Io", 1.8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Europa = new CuerpoCeleste("Europa", 3.5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Ganymede = new CuerpoCeleste("Ganymede", 7.1, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste Callisto = new CuerpoCeleste("Callisto", 16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Io", Io);
        sistemaSolar.put("Europa", Europa);
        sistemaSolar.put("Ganymede", Ganymede);
        sistemaSolar.put("Callisto", Callisto);
        Jupiter.addSatelite(Io);
        Jupiter.addSatelite(Europa);
        Jupiter.addSatelite(Ganymede);
        Jupiter.addSatelite(Callisto);

        //Impresión del set con foreach
        System.out.println("\nNombre de los planetas que tenemos en el set: ");
        for(CuerpoCeleste cuerpoCeleste : planetas) {
            System.out.println(cuerpoCeleste.getNombre());
        }

        //Obtener las lunas de Marte
        System.out.println("\nLunas que tiene Marte: ");
        CuerpoCeleste marteEncontrado = null;

        for (CuerpoCeleste cuerpo : sistemaSolar.values()) {
            if (cuerpo.getNombre().equals("Marte")) {
                marteEncontrado = cuerpo;
                break;
            }
        }

        if (marteEncontrado != null) {
            for (CuerpoCeleste luna : marteEncontrado.getSatelites()) {
                System.out.println(luna.getNombre());
            }
        }

        //Unión de todas las lunas
        Set<CuerpoCeleste> lunas = new HashSet<>();

        for(CuerpoCeleste planeta: planetas) {
            lunas.addAll(planeta.getSatelites());
        }

        System.out.println("\nLunas que hay en el sistema solar: ");
        for(CuerpoCeleste cuerpoCeleste: lunas){
            System.out.println(cuerpoCeleste.getNombre());
        }

        //Creación del planeta plutón e imprimir de nuevo los planetas usando toString
        CuerpoCeleste Pluton2 = new CuerpoCeleste("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        planetas.add(Pluton2);

        System.out.println("\nPlanetas actuales:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta);
        }
        //No se agrega al conjunto el planeta porque nuestra función equals controla que no tenga el mismo nombre y el mismo tipo de clase

        CuerpoCeleste Pluton3 = new CuerpoCeleste("Pluton", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        planetas.add(Pluton3);
        //Aqui al crearlo como planeta enano, es otro tipo de clase y por lo tanto si que lo agrega
        System.out.println("\nPlanetas actuales:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta);
        }

        //Diferencia e intersección
        //removeAll() → diferencia
        //retainAll() → intersección

        Set<CuerpoCeleste> lunasMarte = new HashSet<>(Marte.getSatelites());

        Set<CuerpoCeleste> diferencia = new HashSet<>(lunas);
        diferencia.removeAll(lunasMarte);

        Set<CuerpoCeleste> interseccion = new HashSet<>(lunas);
        interseccion.retainAll(lunasMarte);

        System.out.println("\nDiferencia lunas y lunas Marte");
        for (CuerpoCeleste luna : diferencia){
            System.out.println(luna);
        }

        System.out.println("\nIntersección lunas y lunas Marte");
        for (CuerpoCeleste luna : interseccion){
            System.out.println(luna);
        }

    }
}
