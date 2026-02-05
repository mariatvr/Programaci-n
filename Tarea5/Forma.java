package Tarea5;

public abstract class Forma {
    protected int numLados;

    public Forma(int numLados){
        this.numLados=numLados;
    }

    public int getNumLados() {
        return numLados;
    }

    public abstract void getArea();

    public abstract void getPerimeter();
}
