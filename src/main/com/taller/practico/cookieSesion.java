package org.example;

public class cookieSesion {
    public static void main(String[] args) {
        boolean cookieSesionActiva = true;
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";

        System.out.println("El estado de la conexión poer ranger es: " + estadoConexion);
    }
}
