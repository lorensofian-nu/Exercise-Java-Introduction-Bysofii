package org.example;

import java.util.Scanner;

public class NumeroParImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;

        try {
            numero = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Hubo un problema al castear el numero -> " + e.getMessage());
        }

        if(numero % 2 == 0) {
            System.out.println("Es numero par Bot");
        } else {
            System.out.println("Es numero impar Bot");
        }
    }
}