/**
 * Clase DatabaseConfig
 *
 * Proporciona la configuración y gestión de conexiones a la base de datos utilizada
 * en la aplicación de compra de boletos de cine. Esta clase utiliza la arquitectura JDBC
 * para conectar con una base de datos MySQL.
 *
 * <p>Esta clase es estática, lo que significa que no es necesario instanciarla
 * para utilizar sus métodos. Se utiliza principalmente para obtener una instancia
 * de conexión a la base de datos a través del método {@link #getConnection()}.</p>
 *
 * <p><b>Uso típico:</b></p>
 * <pre>
 *     Connection conexion = DatabaseConfig.getConnection();
 * </pre>
 *
 * <p>Se recomienda cerrar manualmente las conexiones después de su uso para evitar
 * problemas de consumo de recursos o conexiones abiertas.</p>
 *
 * <p>Para cambiar los parámetros de conexión, actualice las constantes:
 * {@code URL}, {@code USER} y {@code PASSWORD}.</p>
 *
 * @author Christian Michelle Pérez Morga
 * @version 1.0
 */
package com.portafolio_ciem.cine.servidor.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    /**
     * URL de la base de datos.
     * Define la ubicación del servidor MySQL y la base de datos que se desea utilizar.
     * Cambie este valor si la base de datos se aloja en un servidor remoto o si el nombre de la base cambia.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/cine_db";

    /**
     * Nombre de usuario para la conexión a la base de datos.
     * Este usuario debe tener los permisos necesarios para realizar las operaciones requeridas
     * por la aplicación.
     */
    private static final String USER = "cine_user";

    /**
     * Contraseña del usuario para la conexión a la base de datos.
     * Asegúrese de mantener esta información segura y no incluirla directamente
     * en el código fuente en entornos de producción.
     */
    private static final String PASSWORD = "cine_password";

    /**
     * Obtiene una conexión a la base de datos utilizando los parámetros configurados.
     *
     * <p>Este método utiliza {@link DriverManager#getConnection(String, String, String)}
     * para establecer una conexión con la base de datos.</p>
     *
     * @return Una instancia de {@link Connection} que representa la conexión establecida con la base de datos.
     * @throws SQLException Si ocurre algún error al intentar conectarse a la base de datos, como credenciales inválidas,
     *                      URL incorrecta o problemas de red.
     *
     * <p><b>Ejemplo de uso:</b></p>
     * <pre>
     *     try (Connection conexion = DatabaseConfig.getConnection()) {
     *         // Código para ejecutar consultas
     *     } catch (SQLException e) {
     *         e.printStackTrace();
     *     }
     * </pre>
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

