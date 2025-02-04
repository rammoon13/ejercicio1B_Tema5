package ies.castillodeluna.dao;

import ies.castillodeluna.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

    // Constructor que recibe una conexión y la guarda en el atributo conn
    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    // Metodo para agregar un cliente a la BD
    public void agregarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (nombre, email, telefono, id_zona) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());  // Mete el nombre
            stmt.setString(2, cliente.getEmail());   // Mete el email
            stmt.setString(3, cliente.getTelefono()); // Mete el tlf
            stmt.setInt(4, cliente.getIdZona());     // Mete la zona
            stmt.executeUpdate(); // Ejecuta la query para insertar el cliente
        }
    }

    // Metodo para borrar un cliente usando su ID
    public void borrarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);  // Pone el ID en la query
            stmt.executeUpdate(); // Ejecuta la query para borrar el cliente
        }
    }

    // Metodo para obtener la lista de todos los clientes en la BD
    public List<Cliente> obtenerClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) { // Mientras haya filas en el resultado...
                clientes.add(new Cliente(
                    rs.getInt("id_cliente"),  // Saca el ID
                    rs.getString("nombre"),   // Saca el nombre
                    rs.getString("email"),    // Saca el email
                    rs.getString("telefono"), // Saca el tlf
                    rs.getInt("id_zona")      // Saca la zona
                ));
            }
        }
        return clientes; // Devuelve la lista de clientes
    }
}
