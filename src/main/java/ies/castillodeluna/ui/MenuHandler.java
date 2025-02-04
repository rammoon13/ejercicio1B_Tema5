package ies.castillodeluna.ui;

import ies.castillodeluna.dao.ClienteDAO;
import ies.castillodeluna.dao.PedidoDAO;
import ies.castillodeluna.dao.ZonaEnvioDAO;
import ies.castillodeluna.models.Cliente;
import ies.castillodeluna.models.Pedido;
import ies.castillodeluna.models.ZonaEnvio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de gestionar las operaciones del menú relacionadas con la base de datos.
 */
public class MenuHandler {
    private final Connection conn;

    /**
     * Constructor que inicializa la conexión con la base de datos.
     *
     * @param conn Conexión a la base de datos.
     */
    public MenuHandler(Connection conn) {
        this.conn = conn;
    }

    /**
     * Muestra todas las zonas de envío registradas en la base de datos.
     *
     * @throws SQLException Si ocurre un error en la consulta.
     */
    public void mostrarZonasEnvio() throws SQLException {
        ZonaEnvioDAO dao = new ZonaEnvioDAO(conn);
        List<ZonaEnvio> zonas = dao.obtenerZonasEnvio();
        zonas.forEach(System.out::println);
    }

    /**
     * Muestra todos los clientes registrados en la base de datos.
     *
     * @throws SQLException Si ocurre un error en la consulta.
     */
    public void mostrarClientes() throws SQLException {
        ClienteDAO dao = new ClienteDAO(conn);
        List<Cliente> clientes = dao.obtenerClientes();
        clientes.forEach(System.out::println);
    }

    /**
     * Muestra los pedidos de un cliente ingresado por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error en la consulta.
     */
    public void mostrarPedidosCliente(Scanner scanner) throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        List<Pedido> pedidos = dao.obtenerPedidosPorCliente(idCliente);
        pedidos.forEach(System.out::println);
    }

    /**
     * Agrega un nuevo cliente con los datos ingresados por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error en la inserción.
     */
    public void agregarCliente(Scanner scanner) throws SQLException {
        ClienteDAO dao = new ClienteDAO(conn);
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("ID de Zona de Envío: ");
        int idZona = scanner.nextInt();
        dao.agregarCliente(new Cliente(0, nombre, email, telefono, idZona)); // Se usa 0 como ID porque se generará en la BD
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Borra un cliente según el ID ingresado por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error en la eliminación.
     */
    public void borrarCliente(Scanner scanner) throws SQLException {
        ClienteDAO dao = new ClienteDAO(conn);
        System.out.print("Ingrese el ID del Cliente a eliminar: ");
        int idCliente = scanner.nextInt();
        dao.borrarCliente(idCliente);
        System.out.println("Cliente eliminado exitosamente.");
    }

    /**
     * Agrega un nuevo pedido con los datos ingresados por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error en la inserción.
     */
    public void agregarPedido(Scanner scanner) throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese el importe total: ");
        double importe = scanner.nextDouble();
        dao.agregarPedido(new Pedido(0, new java.util.Date(), importe, idCliente)); // Se usa 0 como ID porque se generará en la BD
        System.out.println("Pedido agregado exitosamente.");
    }

    /**
     * Borra un pedido según el ID ingresado por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     * @throws SQLException Si ocurre un error en la eliminación.
     */
    public void borrarPedido(Scanner scanner) throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Pedido a eliminar: ");
        int idPedido = scanner.nextInt();
        dao.borrarPedido(idPedido);
        System.out.println("Pedido eliminado exitosamente.");
    }
}
