package com.taller.ciclos;

import java.util.Scanner;

public class ControlInventario {

    private static final int CAPACIDAD_ALMACEN = 500;

    private static int unidadesAlmacenadas = 0;
    private static int productosRegistrados = 0;
    private static double valorInventario = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcionMenu;

        do {
            System.out.println();
            System.out.println("---- Control de Inventario ----");
            System.out.println("1. Registrar lote de productos");
            System.out.println("2. Ver estado del almacen");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionMenu = entrada.nextInt();

            switch (opcionMenu) {
                case 1 -> registrarLote(entrada);
                case 2 -> mostrarEstadoAlmacen();
                case 3 -> System.out.println("Saliendo del sistema. Hasta luego!");
                default -> System.out.println("Opcion invalida. Intentelo de nuevo.");
            }
        } while (opcionMenu != 3);

        entrada.close();
    }

    private static void registrarLote(Scanner entrada) {
        System.out.print("Cantidad de productos en el lote: ");
        int tamanoLote = entrada.nextInt();

        for (int i = 1; i <= tamanoLote; i++) {
            System.out.print("Producto " + i + " descontinuado? (S/N): ");
            String respuesta = entrada.next().trim().toLowerCase();

            if (respuesta.startsWith("s")) {
                System.out.println("Producto " + i + " esta descontinuado. Omitido.");
                continue;
            }

            System.out.print("Precio del producto " + i + ": ");
            double precio = entrada.nextDouble();
            while (precio <= 0) {
                System.out.print("El precio debe ser mayor que cero. Intentelo de nuevo: ");
                precio = entrada.nextDouble();
            }

            System.out.print("Cantidad en stock del producto " + i + ": ");
            int stock = entrada.nextInt();
            while (stock <= 0) {
                System.out.print("El stock debe ser mayor que cero. Intentelo de nuevo: ");
                stock = entrada.nextInt();
            }

            if (unidadesAlmacenadas + stock > CAPACIDAD_ALMACEN) {
                System.out.println("ALERTA: capacidad maxima de " + CAPACIDAD_ALMACEN
                        + " unidades excedida. Cancelando el resto del lote.");
                break;
            }

            unidadesAlmacenadas += stock;
            valorInventario += precio * stock;
            productosRegistrados++;
            System.out.println("Producto " + i + " registrado.");
        }
    }

    private static void mostrarEstadoAlmacen() {
        System.out.println("---- Estado del Almacen ----");
        System.out.println("Productos registrados: " + productosRegistrados);
        System.out.println("Unidades totales: " + unidadesAlmacenadas + " / " + CAPACIDAD_ALMACEN);
        System.out.printf("Valor del inventario: $%.2f%n", valorInventario);
    }
}
