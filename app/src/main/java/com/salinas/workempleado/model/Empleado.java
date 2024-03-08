package com.salinas.workempleado.model;

public class Empleado {
    private String nombre;
    private int tipoEmpleado;
    private int horasTrabajadas;
    private double cuotaPorHora;

    public Empleado(String nombre, int tipoEmpleado, int horasTrabajadas, double cuotaPorHora) {
        this.nombre = nombre;
        this.tipoEmpleado = tipoEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.cuotaPorHora = cuotaPorHora;
    }

    public double calcularSueldo() {
        double sueldo = 0.0;

        //Pago por horas extra
        //pago por horas normal y sacar horas normal
        if (horasTrabajadas <= 40) {
            sueldo = horasTrabajadas * cuotaPorHora;
        } else {
            double horasExtras = horasTrabajadas - 40;
            sueldo = 40 * cuotaPorHora;
            switch (tipoEmpleado) {
                case 1:
                    sueldo += (horasExtras) * (cuotaPorHora) * 1.5;
                    break;
                case 2:
                    sueldo += (horasExtras) * (cuotaPorHora) * 2;
                    break;
                case 3:
                    sueldo += (horasExtras) * (cuotaPorHora) * 2.5;
                    break;
                case 4:
                    sueldo += (horasExtras) * (cuotaPorHora) * 3;
                    break;
            }
        }
        return sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getCuotaPorHora() {
        return cuotaPorHora;
    }

}
