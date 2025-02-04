package ies.castillodeluna.models;

import java.util.Date;

/**
 * Clase que representa un pedido realizado por un cliente en el sistema.
 */
public class Pedido {
    private int id; // ID único del pedido
    private Date fecha; // Fecha en la que se realizó el pedido
    private double importeTotal; // Importe total del pedido
    private int idCliente; // ID del cliente que realizó el pedido

    /**
     * Constructor para inicializar un objeto Pedido con sus atributos.
     *
     * @param id            Identificador único del pedido.
     * @param fecha         Fecha en la que se realizó el pedido.
     * @param importeTotal  Importe total del pedido.
     * @param idCliente     Identificador del cliente que realizó el pedido.
     */
    public Pedido(int id, Date fecha, double importeTotal, int idCliente) {
        this.id = id;
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return ID del pedido.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la fecha en la que se realizó el pedido.
     *
     * @return Fecha del pedido.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene el importe total del pedido.
     *
     * @return Importe total del pedido.
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * Obtiene el ID del cliente que realizó el pedido.
     *
     * @return ID del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Representa el objeto Pedido como una cadena de texto.
     *
     * @return Cadena de texto con la información del pedido.
     */
    @Override
    public String toString() {
        return String.format("Pedido{id=%d, fecha=%s, importeTotal=%.2f, idCliente=%d}", 
                id, fecha, importeTotal, idCliente);
    }
}
