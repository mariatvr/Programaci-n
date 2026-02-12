package Ejercicio1Tarea2;

import Ejercicio1Tarea1.Contacto;

import java.util.ArrayList;

public class Cancion {
    protected String titulo;
    protected double duracion;

    public Cancion(String titulo, double duracion){
        this.titulo=titulo;
        this.duracion=duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString(){
        return "Título: "+ this.titulo+" -- Duración: "+this.duracion;
    }
}
