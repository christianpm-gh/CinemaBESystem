package com.portafolio_ciem.cine.servidor.main;

import com.portafolio_ciem.cine.servidor.controladores.ClienteHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {

    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        System.out.println("Servidor iniciado en el puerto " + PUERTO);
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            while (true) {
                // Esperar conexiones de clientes
                Socket cliente = servidor.accept();

                // Crear un Thread para manejar la conexión con el cliente
                new Thread(new ClienteHandler(cliente)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
