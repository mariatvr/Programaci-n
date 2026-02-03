package Pruebasclase3Febrero;

public class TelefonoMovil implements Impuesto{
    private int minumero;
    private boolean estaSonando;

    public TelefonoMovil(int minumero){
        this.minumero=minumero;
    }

    @Override
    public double calcularImpuestoAnual() {
        return TASA_DE_IMPUESTO * 12;
    }

    @Override
    public void imprimirImpuesto() {
        System.out.println("El impuesto anual del teléfono es " + calcularImpuestoAnual());
    }


        public static void main(String[] args) {
            //Variable  creada de tipo móvil
            TelefonoMovil iphone5=new TelefonoMovil(555456789);
            iphone5.imprimirImpuesto();

            //Variable de tipo Impuesto que contiene objeto Movil. Usa el polimorfismo
            Impuesto impuestoMovil = new TelefonoMovil(123456789);
            impuestoMovil.imprimirImpuesto();
    }
}
