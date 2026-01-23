package Ejercicio10Tarea1;

public class A {
    protected String atributoHeredable1;
    protected String atributoHeredable2;
    private String atributoNoHeredable;

    public void metodoHeredable1() {
        System.out.println("Método 1 de la clase Ejercicio10Tarea1.A (Original)");
    }

    public void metodoHeredable2() {
        System.out.println("Método 2 de la clase Ejercicio10Tarea1.A");
    }

    private void metodoNoHeredable() { // private: No se hereda
        System.out.println("Este método es exclusivo de Ejercicio10Tarea1.A");
    }

}
