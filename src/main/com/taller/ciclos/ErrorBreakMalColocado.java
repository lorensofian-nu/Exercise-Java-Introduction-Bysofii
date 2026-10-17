package com.taller.ciclos;

public class ErrorBreakMalColocado {

    public static void main(String[] args) {
        for (int numero = 1; numero <= 10; numero++) {
            if (numero % 2 != 0) {
                System.out.println("Numero impar detectado: " + numero);
                // SOLUCION: 'break' terminaba todo el bucle en el primer impar.
                // 'continue' solo salta la iteracion actual.
                continue;
            }
            System.out.println("Numero par procesado: " + numero);
        }
    }
}
