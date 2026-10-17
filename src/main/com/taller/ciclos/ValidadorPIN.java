package com.taller.ciclos;

import java.util.Scanner;

public class ValidadorPIN {

    private static final int PIN_MINIMO = 1000;
    private static final int PIN_MAXIMO = 9999;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int codPin;
        boolean esValido;

        do {
            System.out.print("Ingrese su PIN de 4 digitos: ");
            codPin = entrada.nextInt();
            esValido = codPin >= PIN_MINIMO && codPin <= PIN_MAXIMO;

            if (!esValido) {
                System.out.println("Error: La clave debe tener exactamente 4 digitos");
            }
        } while (!esValido);

        System.out.println("PIN aceptado.");

        entrada.close();
    }
}
