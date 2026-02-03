package Pruebasclase3Febrero;

public interface Impuesto {
    //constantes
    double TASA_DE_IMPUESTO = 0.06;

    //métodos abstractos
    double calcularImpuestoAnual();

    void imprimirImpuesto();
}
