package Ejercicio1Tarea4;

public class Planeta extends CuerpoCeleste{
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste satelite){
        if (satelite.getTipoCuerpo()==TipoCuerpoCeleste.LUNA){
            return super.addSatelite(satelite);
        } else {
            System.out.println("Error: A un planeta solo se le pueden añadir lunas.");
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
