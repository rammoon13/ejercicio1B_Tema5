package ies.castillodeluna.models;

/**
 * Clase que representa una zona de envío dentro del sistema.
 */
public class ZonaEnvio {
    private int id; // ID único de la zona de envío
    private String nombre; // Nombre de la zona de envío
    private double tarifaEnvio; // Tarifa asociada a la zona de envío

    /**
     * Constructor para inicializar una zona de envío con sus atributos.
     *
     * @param id          Identificador único de la zona de envío.
     * @param nombre      Nombre de la zona de envío.
     * @param tarifaEnvio Tarifa de envío asociada a la zona.
     */
    public ZonaEnvio(int id, String nombre, double tarifaEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.tarifaEnvio = tarifaEnvio;
    }

    /**
     * Obtiene el ID de la zona de envío.
     *
     * @return ID de la zona de envío.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre de la zona de envío.
     *
     * @return Nombre de la zona de envío.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la tarifa de envío de la zona.
     *
     * @return Tarifa de envío de la zona.
     */
    public double getTarifaEnvio() {
        return tarifaEnvio;
    }

    /**
     * Representa la zona de envío como una cadena de texto.
     *
     * @return Cadena de texto con la información de la zona de envío.
     */
    @Override
    public String toString() {
        return String.format("ZonaEnvio{id=%d, nombre='%s', tarifaEnvio=%.2f}", id, nombre, tarifaEnvio);
    }
}
