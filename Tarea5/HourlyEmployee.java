package Tarea5;

public class HourlyEmployee extends Employee{
    private double tarifaPago;
    private double horasTrabajadas;

    public HourlyEmployee(){
        super();
    }

    @Override
    public void calculateWeeklyPay() {
        System.out.println(tarifaPago*horasTrabajadas);
    }
}
