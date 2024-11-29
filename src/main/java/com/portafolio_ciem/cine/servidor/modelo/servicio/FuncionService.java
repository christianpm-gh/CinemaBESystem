package com.portafolio_ciem.cine.servidor.modelo.servicio;

import com.portafolio_ciem.cine.servidor.modelo.repositorio.FuncionRepository;

import java.sql.SQLException;
import java.util.List;

public class FuncionService {
    private final FuncionRepository repository;

    public FuncionService() {
        this.repository = new FuncionRepository();
    }

    public void crearFuncion(int peliculaId, int sala, String horario){
        try{
            repository.crearFuncion(peliculaId, sala, horario);
            System.out.println("Función creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la función: " + e.getMessage());
        }
    }

    public void obtenerFunciones() {
        try{
            List<String> funciones = repository.obtenerFunciones();
            funciones.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error al obtener las funciones" + e.getMessage());
        }
    }

    public void actualizarFuncion(int id, int sala, String horario) {
        try{
            repository.actualizarFuncion(id, sala, horario);
            System.out.println("Función actualizada exitosamente.");
        }catch (SQLException e) {
            System.out.println("Error al actualizar la función: " + e.getMessage());
        }
    }

    public void eliminarFuncion(int id) {
        try{
            repository.eliminarFuncion(id);
            System.out.println("Función eliminada exitosamente.");
        }catch (SQLException e) {
            System.out.println("Error al eliminar la función: " + e.getMessage());
        }
    }
}
