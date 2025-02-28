package ies.castillodeluna.ui;

import ies.castillodeluna.dao.ClienteDAO;
import ies.castillodeluna.dao.PedidoDAO;
import ies.castillodeluna.dao.ZonaEnvioDAO;
import ies.castillodeluna.models.Cliente;
import ies.castillodeluna.models.Pedido;
import ies.castillodeluna.models.ZonaEnvio;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de gestionar las operaciones del menú relacionadas con la base de datos.
 */
public class MenuHandler {
    private final EntityManager em;

    /**
     * Constructor que inicializa la conexión con la base de datos usando Hibernate.
     *
     * @param em EntityManager para gestionar las entidades.
     */
    public MenuHandler(EntityManager em) {
        this.em = em;
    }

    /**
     * Muestra todas las zonas de envío registradas en la base de datos.
     */
    public void mostrarZonasEnvio() {
        ZonaEnvioDAO dao = new ZonaEnvioDAO(em);
        List<ZonaEnvio> zonas = dao.obtenerZonasEnvio();
        zonas.forEach(System.out::println);
    }

    /**
     * Muestra todos los clientes registrados en la base de datos.
     */
    public void mostrarClientes() {
        ClienteDAO dao = new ClienteDAO(em);
        List<Cliente> clientes = dao.obtenerClientes();
        clientes.forEach(System.out::println);
    }

    /**
     * Muestra los pedidos de un cliente ingresado por el usuario.
     *
     * @param scanner Scanner para leer la entrada del usuario.
     */
    public void mostrarPedidosCliente(Scanner scanner) {
        PedidoDAO dao = new PedidoDAO(em);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        List<Pedido> pedidos = dao.obtenerPedidosPorCliente(idCliente);
        pedidos.forEach(System.out::println);
    }

    /**
     * Agrega un nuevo cliente con los datos ingresados por el usuario.
     */
    public void agregarCliente(Scanner scanner) {
        ClienteDAO dao = new ClienteDAO(em);
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("ID de Zona de Envío: ");
        int idZona = scanner.nextInt();
    
        ZonaEnvio zona = em.find(ZonaEnvio.class, idZona);
        if (zona == null) {
            System.out.println("Error: No existe la zona de envío con ID " + idZona);
            return;
        }
    
        em.getTransaction().begin();
        dao.agregarCliente(new Cliente(nombre, email, telefono, zona));
        em.getTransaction().commit();
    
        System.out.println("Cliente agregado exitosamente.");
    }

    /**
     * Borra un cliente según el ID ingresado por el usuario.
     */
    public void borrarCliente(Scanner scanner) {
        ClienteDAO dao = new ClienteDAO(em);
        System.out.print("Ingrese el ID del Cliente a eliminar: ");
        int idCliente = scanner.nextInt();

        em.getTransaction().begin();
        dao.borrarCliente(idCliente);
        em.getTransaction().commit();

        System.out.println("Cliente eliminado exitosamente.");
    }

    /**
     * Agrega un nuevo pedido con los datos ingresados por el usuario.
     */
    public void agregarPedido(Scanner scanner) {
        PedidoDAO dao = new PedidoDAO(em);
        System.out.print("Ingrese el ID del Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese el importe total: ");
        double importe = scanner.nextDouble();
    
        Cliente cliente = em.find(Cliente.class, idCliente);
        if (cliente == null) {
            System.out.println("Error: No existe un cliente con ID " + idCliente);
            return;
        }
    
        em.getTransaction().begin();
        dao.agregarPedido(new Pedido(new java.util.Date(), importe, cliente));
        em.getTransaction().commit();
    
        System.out.println("Pedido agregado exitosamente.");
    }

    /**
     * Borra un pedido según el ID ingresado por el usuario.
     */
    public void borrarPedido(Scanner scanner) {
        PedidoDAO dao = new PedidoDAO(em);
        System.out.print("Ingrese el ID del Pedido a eliminar: ");
        int idPedido = scanner.nextInt();

        em.getTransaction().begin();
        dao.borrarPedido(idPedido);
        em.getTransaction().commit();

        System.out.println("Pedido eliminado exitosamente.");
    }
}
