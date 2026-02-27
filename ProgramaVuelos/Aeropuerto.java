package ProgramaVuelos;

import Ejercicio1Tarea2.Cancion;

import java.util.ArrayList;

public class Aeropuerto {
    protected String nombre;
    protected ArrayList<Vuelo> vuelos;

    public Aeropuerto(String nombre){
        this.nombre=nombre;
        this.vuelos= new ArrayList<Vuelo>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public Vuelo encontrarVuelo(String numero) {
        for (Vuelo vuelo : this.vuelos) {
            if (vuelo.getNumVuelo().equals(numero)) {
                return vuelo;
            }
        }
        return null;
    }

    public Vuelo encontrarVueloClave(String clave) {
        for (Vuelo vuelo : this.vuelos) {
            if (vuelo.getOrigen().equals(clave)) {
                return vuelo;
            }
        }
        return null;
    }

    public boolean addVuelo (String numero, String origen, String destino, String dia, String clase){
        boolean agregada=true;

        if(encontrarVuelo(numero)==null){
            vuelos.add(new Vuelo(numero, origen, destino, dia, clase));
        } else{
            agregada=false;
        }
        return agregada;
    }

    public boolean borrarVuelo(String numero) {
        Vuelo v = encontrarVuelo(numero);
        if (v != null) {
            vuelos.remove(v);
            return true;
        }
        return false;
    }
}
