package Tarea5;

public abstract class Ejercicio1 {
    public Ejercicio1(){
        System.out.println("Este es un constructor de clase abstracta.");
    }

    public abstract void abstract_method();

    public void noAbstract_method(){
        System.out.println("Este es un método normal de clase abstracta.");
    }
}
