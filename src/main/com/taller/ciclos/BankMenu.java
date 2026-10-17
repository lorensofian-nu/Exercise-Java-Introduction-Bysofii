package com.taller.ciclos;

import java.util.Scanner;

public class BankMenu {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double saldoCuenta = 500_000;
        int opcionSeleccionada;

        do {
            System.out.println();
            System.out.println("---- Menu Bancario ----");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar deposito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionSeleccionada = entrada.nextInt();

            switch (opcionSeleccionada) {
                case 1 -> System.out.printf("Saldo actual: $%.2f%n", saldoCuenta);
                case 2 -> {
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = entrada.nextDouble();
                    if (montoDeposito > 0) {
                        saldoCuenta += montoDeposito;
                        System.out.printf("Deposito realizado. Nuevo saldo: $%.2f%n", saldoCuenta);
                    } else {
                        System.out.println("El monto debe ser mayor que cero.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = entrada.nextDouble();
                    if (montoRetiro <= 0) {
                        System.out.println("El monto debe ser mayor que cero.");
                    } else if (montoRetiro > saldoCuenta) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        saldoCuenta -= montoRetiro;
                        System.out.printf("Retiro realizado. Nuevo saldo: $%.2f%n", saldoCuenta);
                    }
                }
                case 4 -> System.out.println("Saliendo del sistema. Hasta luego!");
                default -> System.out.println("Opcion invalida. Intentelo de nuevo.");
            }
        } while (opcionSeleccionada != 4);

        entrada.close();
    }
}
