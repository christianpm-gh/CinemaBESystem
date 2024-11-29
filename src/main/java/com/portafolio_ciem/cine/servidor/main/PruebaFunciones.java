package com.portafolio_ciem.cine.servidor.main;

import com.portafolio_ciem.cine.servidor.modelo.servicio.FuncionService;

public class PruebaFunciones {
    public static void main(String[] args) {
        FuncionService service = new FuncionService();

        // Crear funciones
        service.crearFuncion(1, 1, "2024-12-01 18:00:00");
        service.crearFuncion(1, 2, "2024-12-01 21:00:00");

        // Leer funciones
        System.out.println("Funciones disponibles:");
        service.obtenerFunciones();

        // Actualizar una función
        service.actualizarFuncion(1, 3, "2024-12-01 20:00:00");
        System.out.println("Funciones después de la actualización:");
        service.obtenerFunciones();

        // Eliminar una función
        service.eliminarFuncion(2);
        System.out.println("Funciones después de la eliminación:");
        service.obtenerFunciones();

    }
}
