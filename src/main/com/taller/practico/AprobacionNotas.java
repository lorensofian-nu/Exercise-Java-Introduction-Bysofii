package org.example;

import java.util.Scanner;

public class AprobacionNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese su calificacion power ranger");
        double calificacionFinal = sc.nextDouble();
        System.out.println("ingrese su porcentaje de asistencia power ranger");
        int porcentajeAsistencia = sc.nextInt();
        System.out.println("¿Power Ranger Entrego el proyecto final? (true/false): ");
        boolean entregoProyectoFinal = sc.nextBoolean();
        sc.close();
        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            System.out.println("haz aprobado power ranger");
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            System.out.println(" power ranger Pendiente para Examen Extraordinario.");
        } else {
            System.out.println("power ranger reprobasteee");
        }

    }
}
