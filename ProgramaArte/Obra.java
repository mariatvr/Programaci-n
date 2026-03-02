package ProgramaArte;

public class Obra {
    private String nombre;
    private String tipo;
    private double precioMillones; // Usamos millones como sugiere el enunciado
    private int anio;
    private Artista artista; // Relación: Esta obra tiene un artista asociado

    public Obra(String nombre, String tipo, double precioMillones, int anio, Artista artista) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioMillones = precioMillones;
        this.anio = anio;
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioMillones() {
        return precioMillones;
    }

    public int getAnio() {
        return anio;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return nombre + " (" + anio + ") - " + tipo + " | Precio: " + precioMillones + "M€ | Artista: " + artista.getNombre();
    }
}
