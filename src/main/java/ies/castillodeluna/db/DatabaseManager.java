package ies.castillodeluna.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

/**
 * Clase para gestionar la conexión a la base de datos SQLite.
 * Se encarga de establecer y cerrar la conexión, además de ejecutar un script inicial si es necesario.
 */
public class DatabaseManager {
    // URL de la base de datos SQLite
    private static final String DB_URL = "jdbc:sqlite:pedidos.db";

    // Conexión única a la base de datos
    private static Connection connection;

    /**
     * Constructor privado para evitar instancias de esta clase.
     */
    private DatabaseManager() {}

    /**
     * Obtiene la conexión a la base de datos.
     * Si la conexión no existe o está cerrada, se crea una nueva.
     *
     * @return Conexión a la base de datos.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
            ejecutarScriptInicial(); // Ejecuta el script SQL inicial si es necesario
        }
        return connection;
    }

    /**
     * Ejecuta un script SQL inicial al conectar con la base de datos.
     * Este script se encuentra en el archivo "pedidos.sql".
     */
    private static void ejecutarScriptInicial() {
        try (InputStream is = DatabaseManager.class.getResourceAsStream("/pedidos.sql");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            // Lee el archivo SQL y lo convierte en una sola cadena
            String sql = reader.lines().collect(Collectors.joining("\n"));

            // Ejecuta el script SQL
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sql);
            }
        } catch (Exception e) {
            System.err.println("Error al ejecutar el script SQL: " + e.getMessage());
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     * Si la conexión ya está cerrada, no realiza ninguna acción.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
