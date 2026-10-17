package com.taller.ciclos;

public class PrimerMultiploComun {

    public static void main(String[] args) {
        for (int numeroActual = 1; numeroActual <= 100; numeroActual++) {
            if (numeroActual % 7 == 0 && numeroActual % 11 == 0) {
                System.out.println("Primer numero divisible por 7 y 11: " + numeroActual);
                break;
            }
        }
    }
}
