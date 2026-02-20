package Ejercicio1Tarea3;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    protected int id;
    protected String descripcion;
    protected Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
        exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion);
    }
}
