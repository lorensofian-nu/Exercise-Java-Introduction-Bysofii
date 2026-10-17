package org.example;

import java.util.Scanner;

public class ClasificacionEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa edad: ");
        int edadUsuario= sc.nextInt();

        if(edadUsuario < 12){
            System.out.println("Eres infante Bot");
        }else if(edadUsuario <= 17){
            System.out.println("Eres un adolescente Bot");
        }else if(edadUsuario <= 64 ){
            System.out.println("Eres Adulto bot");
        }else {
            System.out.println("Eres un adulto fosil bot");
        }


    }
}
