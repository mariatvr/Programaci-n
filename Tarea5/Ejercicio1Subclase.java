package Tarea5;

public class Ejercicio1Subclase extends Ejercicio1{
    public Ejercicio1Subclase(){
        super();
    }

    @Override
    public void abstract_method() {
        System.out.println("Este es un método abstracto implementado en una clase no abstracta.");
    }

    public static void main (String[]args){
        Ejercicio1Subclase objeto = new Ejercicio1Subclase();

        objeto.noAbstract_method();
        objeto.abstract_method();
    }
}
