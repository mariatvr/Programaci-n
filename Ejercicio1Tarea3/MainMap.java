package Ejercicio1Tarea3;

import java.util.HashMap;
import java.util.Map;

public class MainMap {
    private Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public MainMap(){
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));
    }



    public static void main (String[]args){


    }
}
