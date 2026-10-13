package org.example;

import java.util.Scanner;

public class tipoJornada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        String jornadaTradicional = "";

        switch (dia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                jornadaTradicional = "Jornada Laboral";
                break;
            case 6:
            case 7:
                jornadaTradicional = "Fin de semana";
                break;
            default:
                jornadaTradicional = "Inválido";
                break;
        }

        System.out.println(jornadaTradicional);
        sc.close();
    }
}