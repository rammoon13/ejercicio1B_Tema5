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

public class Menu {
    private Connection conn; // Conexión a la base de datos
    private Scanner scanner; // Scanner para leer la entrada del usuario

    // Constructor que recibe la conexión y crea el scanner
    public Menu(Connection conn) {
        this.conn = conn;
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú y gestionar las opciones
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Pedidos ---");
            System.out.println("1. Ver Zonas de Envío");
            System.out.println("2. Ver Clientes");
            System.out.println("3. Ver Pedidos de un Cliente");
            System.out.println("4. Agregar Cliente");
            System.out.println("5. Borrar Cliente");
            System.out.println("6. Agregar Pedido");
            System.out.println("7. Borrar Pedido");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            try {
                switch (opcion) {
                    case 1 -> mostrarZonasEnvio();
                    case 2 -> mostrarClientes();
                    case 3 -> mostrarPedidosCliente();
                    case 4 -> agregarCliente();
                    case 5 -> borrarCliente();
                    case 6 -> agregarPedido();
                    case 7 -> borrarPedido();
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (SQLException e) {
                System.err.println("Error en la base de datos: " + e.getMessage());
            }
        } while (opcion != 8);
    }

    // Método para mostrar todas las zonas de envío
    private void mostrarZonasEnvio() throws SQLException {
        ZonaEnvioDAO dao = new ZonaEnvioDAO(conn);
        List<ZonaEnvio> zonas = dao.obtenerZonasEnvio();
        zonas.forEach(System.out::println);
    }

    // Método para mostrar todos los clientes registrados
    private void mostrarClientes() throws SQLException {
        ClienteDAO dao = new ClienteDAO(conn);
        List<Cliente> clientes = dao.obtenerClientes();
        clientes.forEach(System.out::println);
    }

    // Método para mostrar los pedidos de un cliente según su ID
    private void mostrarPedidosCliente() throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        List<Pedido> pedidos = dao.obtenerPedidosPorCliente(idCliente);
        pedidos.forEach(System.out::println);
    }

    // Método para agregar un nuevo cliente
    private void agregarCliente() throws SQLException {
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

    // Método para eliminar un cliente según su ID
    private void borrarCliente() throws SQLException {
        ClienteDAO dao = new ClienteDAO(conn);
        System.out.print("Ingrese el ID del Cliente a eliminar: ");
        int idCliente = scanner.nextInt();
        dao.borrarCliente(idCliente);
        System.out.println("Cliente eliminado exitosamente.");
    }

    // Método para agregar un nuevo pedido
    private void agregarPedido() throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese el importe total: ");
        double importe = scanner.nextDouble();
        dao.agregarPedido(new Pedido(0, new java.util.Date(), importe, idCliente)); // Se usa 0 como ID porque se generará en la BD
        System.out.println("Pedido agregado exitosamente.");
    }

    // Método para eliminar un pedido según su ID
    private void borrarPedido() throws SQLException {
        PedidoDAO dao = new PedidoDAO(conn);
        System.out.print("Ingrese el ID del Pedido a eliminar: ");
        int idPedido = scanner.nextInt();
        dao.borrarPedido(idPedido);
        System.out.println("Pedido eliminado exitosamente.");
    }
}
