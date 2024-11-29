package com.portafolio_ciem.cine.servidor.modelo.repositorio;

import com.portafolio_ciem.cine.servidor.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionRepository {

    public void crearFuncion(int peliculaId, int sala, String horario) throws SQLException {
        String query =  "insert into funciones (pelicula_id, sala, horario)" +
                        "values (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, peliculaId);
            stmt.setInt(2, sala);
            stmt.setString(3, horario);
            stmt.executeUpdate();
        }
    }

    public List<String> obtenerFunciones() throws SQLException {
        String query =  "select f.id, p.nombre, f.sala, f.horario " +
                        "from funciones f inner join peliculas p on f.pelicula_id=p.id";
        List<String> funciones = new ArrayList<>();
        try( Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                funciones.add("id: " + rs.getInt("id") +
                        ", película: " + rs.getString("nombre") +
                        ", sala: " + rs.getInt("sala") +
                        ", horario: " + rs.getString("horario"));
            }
        }
        return funciones;
    }

    public void actualizarFuncion(int id, int sala, String horario) throws SQLException {
        String query = "update funciones set sala = ?, horario = ? where id = ?";
        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, sala);
            stmt.setString(2, horario);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void eliminarFuncion(int id) throws SQLException {
        String query = "delete from funciones where id = ?";
        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
