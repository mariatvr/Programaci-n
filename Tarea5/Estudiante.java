package Tarea5;

public class Estudiante implements Comparable<Estudiante>{
    String nombre;
    int edad;
    int altura;

    public Estudiante(String nombre, int altura, int edad){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
    }

    @Override
    public int compareTo(Estudiante o) {
        int resultado=0;
        if (this.altura<o.altura) {   resultado = 1;      }
        else if (this.altura>o.altura) {    resultado = -1;      }
        else {
            if (this.edad<o.edad) {  resultado = 1;    }
            else if (this.edad>o.edad) {   resultado = -1;   }
        }
        return resultado;
    }
}
