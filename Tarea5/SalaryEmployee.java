package Tarea5;

public class SalaryEmployee extends Employee{
    private double salarioSemanal;

    public SalaryEmployee(){
        super();
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public void calculateWeeklyPay() {
        System.out.println(salarioSemanal);
    }
}
