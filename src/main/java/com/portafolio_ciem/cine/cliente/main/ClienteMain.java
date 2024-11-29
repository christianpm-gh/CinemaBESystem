package com.portafolio_ciem.cine.cliente.main;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteMain {

    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        try(Socket socket = new Socket (HOST, PUERTO);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectado al servidor en " + HOST + " : " + PUERTO);

            // Ciclo para enviar mensajes al servidor
            String mensaje;
            while (true) {
                System.out.print("Escriba un mensaje para el servidor (o 'salir' para finalizar la conexión)" +
                        "\nSu mensaje : ");
                mensaje = scanner.nextLine();
                // Enviamos el mensaje al servidor
                writer.println(mensaje);
                if ("salir".equalsIgnoreCase(mensaje)) {
                    System.out.println("Cerrando conexion...");
                }
                // Leer respuesta del servidor
                String respuesta = reader.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
