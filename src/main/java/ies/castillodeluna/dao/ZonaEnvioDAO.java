package ies.castillodeluna.dao;

import ies.castillodeluna.models.ZonaEnvio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZonaEnvioDAO {
    private Connection conn;

    // Constructor que recibe la conexión a la base de datos y la almacena en el atributo conn
    public ZonaEnvioDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para obtener todas las zonas de envío de la base de datos
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
