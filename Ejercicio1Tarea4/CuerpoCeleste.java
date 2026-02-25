package Ejercicio1Tarea4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste {ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE}
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo){
        this.nombre=nombre;
        this.periodoOrbital=periodoOrbital;
        this.tipoCuerpo=tipoCuerpo;
        this.satelites= new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    public boolean addSatelite (CuerpoCeleste cuerpo) {
        return this.satelites.add(cuerpo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        CuerpoCeleste cuerpo2 = (CuerpoCeleste) obj;

        return Objects.equals(this.nombre, cuerpo2.nombre) && (this.tipoCuerpo == cuerpo2.tipoCuerpo);
    }

    @Override
    public int hashCode() {
        return (this.nombre.hashCode())+(this.tipoCuerpo.hashCode())+ 38;
    }

    @Override
    public String toString() {
        return "\nNombre: "+this.nombre + "\nTipo: "+this.tipoCuerpo+"\nPeriodo Obrital: "+periodoOrbital;
    }
}
