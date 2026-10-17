package com.taller.ciclos;

public class FiltroNumerosPares {

    public static void main(String[] args) {
        System.out.println("Numeros pares del 1 al 50 que no son multiplos de 5:");

        for (int numeroActual = 1; numeroActual <= 50; numeroActual++) {
            if (numeroActual % 2 != 0) {
                continue;
            }
            if (numeroActual % 5 == 0) {
                continue;
            }
            System.out.println(numeroActual);
        }
    }
}
