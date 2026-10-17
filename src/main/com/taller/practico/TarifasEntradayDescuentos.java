package org.example;

import java.util.Scanner;

public class TarifasEntradayDescuentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioBase = 100.0;
        double precioFinal = 0;

        System.out.println("ingrese su tipo de entrada power ranger:");
        String tipoEntrada=sc.nextLine().trim().toUpperCase();

        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase * 1.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase * 0.60;
        } else if (tipoEntrada.equals("GENERAL")) {
            precioFinal = precioBase;
        } else {
            precioFinal = precioBase;
        }

        //System.out.println("Tipo de entrada: " + tipoEntrada + " Monto final: " + precioFinal);
        System.out.printf("%nTipo de entrada power rangica: %s%nMonto final: %.2f", tipoEntrada, precioFinal);
        sc.close();
    }
}
