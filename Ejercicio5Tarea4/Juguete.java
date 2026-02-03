package Ejercicio5Tarea4;

public class Juguete extends Bienes implements Imponible{
    private int edadMin;

    public Juguete(String descripcion, double precio, int edadMin) {
        super(descripcion, precio);
        this.edadMin=edadMin;
    }

    @Override
    public double calculoImpuestos() {
        return precio*tasaImpuestos;
    }

    @Override
    public String toString(){
        return "JUGUETE:\nEdad mínima: "+edadMin+"\nPrecio: "+precio+"\nDescripcion: "+descripcion+"\n";
    }
}
