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

    public ArrayList<Vuelo> encontrarVueloClave(String clave ,String valor) {
        ArrayList<Vuelo> encontrados = new ArrayList<>();

        for (Vuelo vuelo : this.vuelos) {
            if (clave.equalsIgnoreCase("origen") && vuelo.getOrigen().equalsIgnoreCase(valor)) {
                encontrados.add(vuelo);
            } else if (clave.equalsIgnoreCase("destino") && vuelo.getDestino().equalsIgnoreCase(valor)){
                encontrados.add(vuelo);
            } else if (clave.equalsIgnoreCase("dia") || clave.equalsIgnoreCase("día")){
                if (vuelo.getDia().equalsIgnoreCase(valor))encontrados.add(vuelo);
            } else if (clave.equalsIgnoreCase("clase") && vuelo.getClase().equalsIgnoreCase(valor)){
                encontrados.add(vuelo);
            }
        }
        return encontrados;
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
