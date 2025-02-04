package ies.castillodeluna.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Clase que representa el menú de gestión de pedidos.
 */
public class Menu {
    private final MenuHandler menuHandler; // Manejador del menú
    private final Scanner scanner; // Scanner para leer la entrada del usuario

    /**
     * Constructor que inicializa el menú con la conexión a la base de datos.
     *
     * @param conn Conexión a la base de datos.
     */
    public Menu(Connection conn) {
        this.menuHandler = new MenuHandler(conn);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú y gestiona las opciones seleccionadas por el usuario.
     */
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
                    case 1 -> menuHandler.mostrarZonasEnvio();
                    case 2 -> menuHandler.mostrarClientes();
                    case 3 -> menuHandler.mostrarPedidosCliente(scanner);
                    case 4 -> menuHandler.agregarCliente(scanner);
                    case 5 -> menuHandler.borrarCliente(scanner);
                    case 6 -> menuHandler.agregarPedido(scanner);
                    case 7 -> menuHandler.borrarPedido(scanner);
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (SQLException e) {
                System.err.println("Error en la base de datos: " + e.getMessage());
            }
        } while (opcion != 8);
    }
}
