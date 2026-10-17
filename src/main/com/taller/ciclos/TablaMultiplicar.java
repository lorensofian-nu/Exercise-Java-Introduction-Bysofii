package com.taller.ciclos;

import java.util.Scanner;

public class TablaMultiplicar {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un numero entero N: ");
        int numero = entrada.nextInt();

        System.out.println("---- Tabla de multiplicar del " + numero + " ----");
        for (int multiplicador = 1; multiplicador <= 12; multiplicador++) {
            System.out.printf("%d x %2d = %d%n", numero, multiplicador, numero * multiplicador);
        }

        System.out.println("---- Cuenta regresiva ----");
        for (int contador = numero; contador >= 0; contador--) {
            System.out.println(contador);
        }

        entrada.close();
    }
}
