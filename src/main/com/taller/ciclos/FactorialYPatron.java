package com.taller.ciclos;

import java.util.Scanner;

public class FactorialYPatron {

    private static final int MAXIMO_FACTORIAL = 20;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un numero entero positivo N: ");
        int numero = entrada.nextInt();

        if (numero < 1) {
            System.out.println("N debe ser un entero positivo.");
            entrada.close();
            return;
        }

        if (numero <= MAXIMO_FACTORIAL) {
            long resultado = 1;
            for (int i = 2; i <= numero; i++) {
                resultado *= i;
            }
            System.out.println(numero + "! = " + resultado);
        } else {
            System.out.println("N es muy grande: " + numero + "! excede el limite de long (max N = "
                    + MAXIMO_FACTORIAL + ").");
        }

        System.out.println("---- Patron triangular ----");
        for (int fila = 1; fila <= numero; fila++) {
            for (int columna = 1; columna <= fila; columna++) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }

        entrada.close();
    }
}
