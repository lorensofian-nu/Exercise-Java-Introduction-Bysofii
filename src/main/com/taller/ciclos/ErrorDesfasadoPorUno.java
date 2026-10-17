package com.taller.ciclos;

public class ErrorDesfasadoPorUno {

    public static void main(String[] args) {
        int totalElementos = 5;
        System.out.println("Mostrando elementos del 1 al " + totalElementos + ":");

        // SOLUCION: usar '<=' en lugar de '<' para incluir el ultimo elemento.
        for (int indice = 1; indice <= totalElementos; indice++) {
            System.out.println("Elemento " + indice);
        }
    }
}
