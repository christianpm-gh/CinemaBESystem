package com.portafolio_ciem.cine.servidor.controladores;

import java.io.*;
import java.net.Socket;

public class ClienteHandler implements Runnable {

    private final Socket cliente;

    public ClienteHandler(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (InputStream input = cliente.getInputStream();
             OutputStream output = cliente.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             PrintWriter writer = new PrintWriter(output, true)
        ) {
            writer.println("Conexión exitosa al servidor!");
            String mensaje;
            while((mensaje = reader.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                if ("salir".equalsIgnoreCase(mensaje)) {
                    break;
                }
                writer.println("Mensaje recibido: " + mensaje);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar la conexión con el cliente: " + e.getMessage());
            }
            System.out.println("Conexión cerrada con el cliente");
        }
    }
}
