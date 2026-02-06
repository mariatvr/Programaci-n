package Tarea5;

import java.util.Arrays;

public class MainEstudiante {
    public static void main (String[]args){
        Estudiante[] estudiantes = new Estudiante[5];

        estudiantes [0]= new Estudiante("Patri", 170, 12);
        estudiantes [1]= new Estudiante("Manuel", 173, 43);
        estudiantes [2] = new Estudiante("Javier", 189, 72);
        estudiantes [3]= new Estudiante("Alicia", 168, 52);
        estudiantes [4]= new Estudiante("Alberto", 189, 35);

        System.out.println("Estudiantes sin ordenar:");
        for (int i=0; i< estudiantes.length; i++){
            System.out.println(estudiantes[i].nombre+" - "+estudiantes[i].altura+" - "+estudiantes[i].edad);
        }

        Arrays.sort(estudiantes);
        System.out.println("\nEstudiantes ordenados de mayor a menor:");
        for (int i=0; i< estudiantes.length; i++){
            System.out.println(estudiantes[i].nombre+" - "+estudiantes[i].altura+" - "+estudiantes[i].edad);
        }
    }
}
