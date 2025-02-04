package ies.castillodeluna.dao;

import ies.castillodeluna.models.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar las operaciones relacionadas con los pedidos en la base de datos.
 */
public class PedidoDAO {
    private Connection conn;

    /**
     * Constructor que inicializa la conexión con la base de datos.
     *
     * @param conn Conexión a la base de datos.
     */
    public PedidoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Agrega un nuevo pedido a la base de datos.
     *
     * @param pedido Objeto Pedido con los datos a insertar.
     * @throws SQLException Si ocurre un error en la operación.
     */
    public void agregarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedidos (fecha, importe_total, id_cliente) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(pedido.getFecha().getTime())); // Convierte la fecha a formato SQL
            stmt.setDouble(2, pedido.getImporteTotal()); // Establece el importe total
            stmt.setInt(3, pedido.getIdCliente()); // Establece el ID del cliente
            stmt.executeUpdate(); // Ejecuta la consulta para insertar el pedido
        }
    }

    /**
     * Elimina un pedido de la base de datos usando su ID.
     *
     * @param idPedido ID del pedido a eliminar.
     * @throws SQLException Si ocurre un error en la operación.
     */
    public void borrarPedido(int idPedido) throws SQLException {
        String sql = "DELETE FROM Pedidos WHERE id_pedido = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPedido); // Establece el ID del pedido
            stmt.executeUpdate(); // Ejecuta la consulta para eliminar el pedido
        }
    }

    /**
     * Obtiene una lista de todos los pedidos realizados por un cliente específico.
     *
     * @param idCliente ID del cliente del cual se desean obtener los pedidos.
     * @return Lista de pedidos asociados al cliente.
     * @throws SQLException Si ocurre un error en la operación.
     */
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
