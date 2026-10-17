package com.taller.ciclos;

import java.util.Scanner;

public class AcumuladorCentinela {

    private static final int TERMINADOR = -99;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        long sumaTotal = 0;
        int totalNumeros = 0;

        System.out.print("Ingrese un entero (" + TERMINADOR + " para terminar): ");
        int valor = entrada.nextInt();

        while (valor != TERMINADOR) {
            sumaTotal += valor;
            totalNumeros++;

            System.out.print("Ingrese un entero (" + TERMINADOR + " para terminar): ");
            valor = entrada.nextInt();
        }

        System.out.println("Suma total: " + sumaTotal);
        System.out.println("Numeros procesados: " + totalNumeros);

        entrada.close();
    }
}
