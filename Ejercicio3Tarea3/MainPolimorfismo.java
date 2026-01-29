package Ejercicio3Tarea3;

public class MainPolimorfismo {
    static class Coche{
        private String modelo;
        private boolean motor;
        private int ruedas;
        private int cilindros;

        public Coche(String modelo, int cilindros){
            this.modelo = modelo;
            this.cilindros = cilindros;
            this.ruedas = 4;
            this.motor = true;
        }

        public String getModelo() {
            return modelo;
        }

        public int getCilindros() {
            return cilindros;
        }

        public void arrancar(){
            System.out.println("El coche está arrancando.");
        }

        public void acelerar(){
            System.out.println("El coche está acelerando.");
        }

        public void frenar(){
            System.out.println("El coche está frenando.");
        }
    }

    static class CocheDeportivo extends Coche{
        public CocheDeportivo(String modelo, int cilindros) {
            super(modelo, cilindros); // Llama al constructor del padre
        }

        @Override
        public void acelerar() {
            System.out.println("El deportivo acelera de 0 a 100 en 3 segundos! Ruge el motor.");
        }

        @Override
        public void arrancar() {
            System.out.println("El deportivo arranca con un estruendo potente.");
        }

        public void frenar() {
            System.out.println("El deportivo frena rápidamente.");
        }
    }

    static class CocheElectrico extends Coche{
        public CocheElectrico(String modelo, int cilindros){
            super(modelo,cilindros);
        }

        @Override
        public void arrancar(){
            System.out.println("El coche eléctrico arranca, apenas hace ruido.");
        }

        @Override
        public void acelerar(){
            System.out.println("El coche eléctrico acelera a gran velocidad, apenas se escucha el motor.");
        }

        @Override
        public void frenar(){
            System.out.println("El coche eléctrico frena, el freno va bastante suave.");
        }
    }

    static class CocheDiesel extends Coche{
        public CocheDiesel(String modelo, int cilindros){
            super(modelo, cilindros);
        }

        @Override
        public void arrancar(){
            System.out.println("El coche diesel arranca, suena a tractor.");
        }

        @Override
        public void acelerar(){
            System.out.println("El coche diesel acelera, tiene bastante salida.");
        }

        @Override
        public void frenar(){
            System.out.println("El coche diesel frena.");
        }
    }

    public static void main (String[]args){
        Coche[] garaje = new Coche[4];

        garaje[0] = new Coche("Ford Fiesta", 4);
        garaje[1] = new CocheDeportivo("Ferrari", 12);
        garaje[2] = new CocheElectrico("Tesla Model 3", 0);
        garaje[3] = new CocheDiesel("Audi A3 Turbodiesel", 6);

        System.out.println("--- PRUEBA DE POLIMORFISMO ---");
        for (Coche vehiculo : garaje) {
            System.out.println("\nProbando: " + vehiculo.getModelo());

            vehiculo.arrancar();
            vehiculo.acelerar();
            vehiculo.frenar();
        }
    }
}
