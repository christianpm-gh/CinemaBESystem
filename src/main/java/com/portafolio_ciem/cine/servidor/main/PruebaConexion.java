package com.portafolio_ciem.cine.servidor.main;

import com.portafolio_ciem.cine.servidor.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Conexión cerrada");
        }
    }
}
