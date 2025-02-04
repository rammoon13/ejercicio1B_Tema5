package ies.castillodeluna.dao;

import ies.castillodeluna.models.ZonaEnvio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones relacionadas con las zonas de envío en la base de datos.
 */
public class ZonaEnvioDAO {
    private Connection conn;

    /**
     * Constructor que inicializa la conexión con la base de datos.
     *
     * @param conn Conexión a la base de datos.
     */
    public ZonaEnvioDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Obtiene una lista de todas las zonas de envío registradas en la base de datos.
     *
     * @return Lista de objetos {@link ZonaEnvio} con la información de cada zona de envío.
     * @throws SQLException Si ocurre un error en la operación.
     */
    public List<ZonaEnvio> obtenerZonasEnvio() throws SQLException {
        List<ZonaEnvio> zonas = new ArrayList<>();
        String sql = "SELECT * FROM Zonas_Envio"; // Consulta para obtener todas las zonas de envío
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) { // Recorre los resultados de la consulta
                zonas.add(new ZonaEnvio(
                    rs.getInt("id_zona"), // Obtiene el ID de la zona
                    rs.getString("nombre_zona"), // Obtiene el nombre de la zona
                    rs.getDouble("tarifa_envio") // Obtiene la tarifa de envío
                ));
            }
        }
        return zonas; // Retorna la lista de zonas de envío
    }
}
