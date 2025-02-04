package ies.castillodeluna.models;

/**
 * Clase que representa a un cliente en el sistema.
 */
public class Cliente {
    private int id; // ID único del cliente
    private String nombre; // Nombre del cliente
    private String email; // Correo electrónico del cliente
    private String telefono; // Teléfono del cliente
    private int idZona; // ID de la zona de envío del cliente

    /**
     * Constructor para inicializar un objeto Cliente con sus atributos.
     *
     * @param id        Identificador único del cliente.
     * @param nombre    Nombre del cliente.
     * @param email     Correo electrónico del cliente.
     * @param telefono  Teléfono del cliente.
     * @param idZona    ID de la zona de envío del cliente.
     */
    public Cliente(int id, String nombre, String email, String telefono, int idZona) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.idZona = idZona;
    }

    /**
     * Obtiene el ID del cliente.
     *
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return Correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el ID de la zona de envío del cliente.
     *
     * @return ID de la zona de envío del cliente.
     */
    public int getIdZona() {
        return idZona;
    }

    /**
     * Representa el objeto Cliente como una cadena de texto.
     *
     * @return Cadena de texto con la información del cliente.
     */
    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', email='%s', telefono='%s', idZona=%d}", 
                id, nombre, email, telefono, idZona);
    }
}
