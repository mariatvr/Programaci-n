package Ejercicio3Tarea2;

import java.util.Scanner;

public class Impresora {
    private int nivelToner;
    private int numPagImpresas;
    private boolean dobleCara;

    public Impresora(int nivelToner, int numeroPaginasImpresas, boolean dobleCara){
        if (nivelToner > -1 && nivelToner <= 100) {
            this.nivelToner = nivelToner;
        } else {
            this.nivelToner = -1;
        }
        this.numPagImpresas=numeroPaginasImpresas;
        this.dobleCara=dobleCara;
    }

    public int metoToner(int masToner){
        if(masToner>100 || masToner<0){
            return -1;
        }

        if(this.nivelToner + masToner > 100){
            return -1;
        }
        this.nivelToner += masToner;
        return this.nivelToner;
    }

    public int imprimePag(int numPag){
        int paginasImprimir = numPag;
        System.out.println("Se imprimen las páginas.");
        if (this.dobleCara) {
            paginasImprimir = (numPag / 2) + (numPag % 2);
            System.out.println("Imprimiendo en modo doble cara.");
        } else{
            System.out.println("Se imprime a una cara.");
        }
        // Actualizamos el contador total de la impresora
        this.numPagImpresas += paginasImprimir;

        // Devolvemos las páginas que realmente se han impreso (hojas físicas)
        return paginasImprimir;
    }

    public int getNumPagImpresas() {
        return numPagImpresas;
    }
}
