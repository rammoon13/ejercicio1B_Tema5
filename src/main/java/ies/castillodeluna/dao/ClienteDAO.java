package ies.castillodeluna.dao;

import ies.castillodeluna.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones relacionadas con los clientes en la base de datos.
 */
public class ClienteDAO {
    private Connection conn;

    /**
     * Constructor que recibe una conexión y la almacena en el atributo conn.
     *
     * @param conn Conexión a la base de datos.
     */
    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente Objeto Cliente con los datos a insertar.
     * @throws SQLException Si ocurre un error durante la operación.
     */
    public void agregarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (nombre, email, telefono, id_zona) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());  // Establece el nombre
            stmt.setString(2, cliente.getEmail());   // Establece el email
            stmt.setString(3, cliente.getTelefono()); // Establece el teléfono
            stmt.setInt(4, cliente.getIdZona());     // Establece la zona
            stmt.executeUpdate(); // Ejecuta la consulta para insertar el cliente
        }
    }

    /**
     * Elimina un cliente de la base de datos según su ID.
     *
     * @param idCliente ID del cliente a eliminar.
     * @throws SQLException Si ocurre un error durante la operación.
     */
    public void borrarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);  // Establece el ID del cliente
            stmt.executeUpdate(); // Ejecuta la consulta para eliminar el cliente
        }
    }

    /**
     * Obtiene una lista con todos los clientes registrados en la base de datos.
     *
     * @return Lista de clientes.
     * @throws SQLException Si ocurre un error durante la operación.
     */
    public List<Cliente> obtenerClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) { // Recorre los resultados de la consulta
                clientes.add(new Cliente(
                    rs.getInt("id_cliente"),  // Obtiene el ID
                    rs.getString("nombre"),   // Obtiene el nombre
                    rs.getString("email"),    // Obtiene el email
                    rs.getString("telefono"), // Obtiene el teléfono
                    rs.getInt("id_zona")      // Obtiene la zona
                ));
            }
        }
        return clientes; // Devuelve la lista de clientes
    }
}
