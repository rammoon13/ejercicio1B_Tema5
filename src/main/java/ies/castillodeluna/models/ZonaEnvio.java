package ies.castillodeluna.models;

public class ZonaEnvio {
    private int id; // ID único de la zona de envío
    private String nombre; // Nombre de la zona de envío
    private double tarifaEnvio; // Tarifa asociada a la zona de envío

    // Constructor que inicializa los atributos de la zona de envío
    public ZonaEnvio(int id, String nombre, double tarifaEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.tarifaEnvio = tarifaEnvio;
    }

    // Métodos getter para obtener los valores de los atributos
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getTarifaEnvio() { return tarifaEnvio; }

    // Método para representar la zona de envío como una cadena de texto
    @Override
    public String toString() {
        return String.format("ZonaEnvio{id=%d, nombre='%s', tarifaEnvio=%.2f}", id, nombre, tarifaEnvio);
    }
}
