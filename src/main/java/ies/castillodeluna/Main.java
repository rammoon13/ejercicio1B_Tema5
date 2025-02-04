package ies.castillodeluna;

import java.sql.Connection;
import java.sql.SQLException;

import ies.castillodeluna.ui.Menu;
import ies.castillodeluna.db.DatabaseManager;

/**
 * Clase principal que inicia la aplicación y gestiona la conexión con la base de datos.
 */
public class Main {

    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // Intenta establecer la conexión con la base de datos
        try (Connection conn = DatabaseManager.getConnection()) {
            // Crea una instancia del menú y lo muestra
            Menu menu = new Menu(conn);
            menu.mostrarMenu();
        } catch (SQLException e) {
            // Captura y muestra cualquier error de conexión
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        } finally {
            // Cierra la conexión cuando el programa termina
            DatabaseManager.closeConnection();
        }
    }
}
