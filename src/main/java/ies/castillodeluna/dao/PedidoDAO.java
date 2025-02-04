package ies.castillodeluna.dao;

import ies.castillodeluna.models.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection conn;

    // Constructor que recibe una conexión y la almacena en el atributo conn
    public PedidoDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para agregar un pedido a la base de datos
    public void agregarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedidos (fecha, importe_total, id_cliente) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(pedido.getFecha().getTime())); // Convierte la fecha a formato SQL
            stmt.setDouble(2, pedido.getImporteTotal()); // Establece el importe total
            stmt.setInt(3, pedido.getIdCliente()); // Establece el ID del cliente
            stmt.executeUpdate(); // Ejecuta la inserción
        }
    }

    // Método para borrar un pedido de la base de datos usando su ID
    public void borrarPedido(int idPedido) throws SQLException {
        String sql = "DELETE FROM Pedidos WHERE id_pedido = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPedido); // Establece el ID del pedido a borrar
            stmt.executeUpdate(); // Ejecuta la eliminación
        }
    }

    // Método para obtener todos los pedidos de un cliente específico
    public List<Pedido> obtenerPedidosPorCliente(int idCliente) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedidos WHERE id_cliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente); // Establece el ID del cliente en la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(new Pedido(
                        rs.getInt("id_pedido"), // Obtiene el ID del pedido
                        rs.getDate("fecha"), // Obtiene la fecha del pedido
                        rs.getDouble("importe_total"), // Obtiene el importe total
                        rs.getInt("id_cliente") // Obtiene el ID del cliente
                    ));
                }
            }
        }
        return pedidos; // Retorna la lista de pedidos del cliente
    }
}
