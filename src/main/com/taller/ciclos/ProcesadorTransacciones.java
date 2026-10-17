package com.taller.ciclos;

import java.util.Scanner;

public class ProcesadorTransacciones {

    private static final double LIMITE_TRANSFERENCIA = 1_000_000;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean procesando = true;
        double saldoAcumulado = 0;
        String razonDetencion = "";

        while (procesando) {
            System.out.print("Ingrese el monto de la transaccion: ");
            double montoTransaccion = entrada.nextDouble();

            if (montoTransaccion < 0) {
                procesando = false;
                razonDetencion = "Monto negativo ingresado";
            } else {
                saldoAcumulado += montoTransaccion;

                if (saldoAcumulado > LIMITE_TRANSFERENCIA) {
                    procesando = false;
                    razonDetencion = "Limite maximo de $1,000,000 excedido";
                }
            }
        }

        System.out.println("---- Reporte de Caja ----");
        System.out.printf("Saldo acumulado final: $%.2f%n", saldoAcumulado);
        System.out.println("Razon de detencion: " + razonDetencion);

        entrada.close();
    }
}
