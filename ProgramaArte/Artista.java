package ProgramaArte;

public class Artista {
    protected String nombre;
    protected String nacionalidad;

    public Artista(String nombre, String nacionalidad){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
