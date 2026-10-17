package com.taller.ciclos;

public class ErrorBucleInfinito {

    public static void main(String[] args) {
        int contador = 1;
        int limite = 10;

        System.out.println("Iniciando procesamiento...");
        while (contador <= limite) {
            System.out.println("Procesando elemento numero: " + contador);
            // SOLUCION: la variable de control no se actualizaba,
            // haciendo que el bucle nunca terminara.
            contador++;
        }
        System.out.println("Procesamiento finalizado correctamente.");
    }
}
