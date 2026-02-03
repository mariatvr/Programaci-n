package Ejercicio5Tarea4;

public class Comida extends Bienes{
    private double calorias;

    public Comida(String descripcion, double precio, double calorias) {
        super(descripcion, precio);
        this.calorias=calorias;
    }

    @Override
    public String toString(){
        return "COMIDA:\nCalorías del alimento: "+calorias+"\nPrecio: "+precio+"\nDescripcion: "+descripcion+"\n";
    }
}
