package Ejercicio5Tarea4;

public class Libro extends Bienes implements Imponible{
    private String autor;

    public Libro(String descripcion, double precio, String autor) {
        super(descripcion, precio);
        this.autor=autor;
    }

    @Override
    public double calculoImpuestos() {
        return precio*tasaImpuestos;
    }

    @Override
    public String toString(){
        return "LIBRO:\nAutor: "+autor+"\nPrecio: "+precio+"\nDescripcion: "+descripcion+"\n";
    }
}
