package ProgramaVuelos;

public class Vuelo {
    protected String numVuelo;
    protected String origen;
    protected String destino;
    protected String dia;
    protected String clase;

    public Vuelo(String numVuelo, String origen, String destino, String dia, String clase){
        this.numVuelo=numVuelo;
        this.origen=origen;
        this.destino=destino;
        this.dia=dia;
        this.clase=clase;
    }

    public String getNumVuelo() { return numVuelo; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getDia() { return dia; }
    public String getClase() { return clase; }

    @Override
    public String toString(){
        return "Número: "+ this.numVuelo+" -- Origen: "+this.origen+" -- Destino: "+this.destino+" -- Día: "+this.dia+" -- Clase: "+this.clase;
    }
}
