package Ejercicio1Tarea2;

import Ejercicio1Tarea1.Contacto;

import java.util.ArrayList;
import java.util.ListIterator;

public class Album {
    protected String nombre;
    protected String artista;
    protected ArrayList<Cancion> canciones;

    public Album(String nombre, String artista){
        this.nombre=nombre;
        this.artista=artista;
        this.canciones= new ArrayList<Cancion>();
    }

    private Cancion findSong(String titulo) {
        for (Cancion cancion : this.canciones) {
            if (cancion.getTitulo().equals(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong (String titulo, double duracion){
        boolean agregada=true;

        if(findSong(titulo)==null){
            canciones.add(new Cancion(titulo, duracion));
        } else{
            agregada=false;
        }
        return agregada;
    }

    public boolean addToPlayList (int numPista, ListIterator<Cancion> playList){
        int posicion = numPista -1;
        if (posicion>=0 && posicion<canciones.size()){
            playList.add(this.canciones.get(posicion));
            return true;
        }
        return false;
    }
}
