package Ejercicio1Tarea2;

public class Lampara {
    private String estilo;
    private boolean bateria;
    private int calificacion;

    public Lampara(String estilo, boolean bateria, int calificacion){
        this.estilo=estilo;
        this.bateria=bateria;
        this.calificacion=calificacion;
    }

    public String getEstilo() {
        return estilo;
    }

    public boolean hayBateria() {
        return bateria;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void encender(){
        System.out.println("La lámpara se ha encendido.");
    }


}
