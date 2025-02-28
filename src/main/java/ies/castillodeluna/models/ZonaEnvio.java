package ies.castillodeluna.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Zonas_Envio")
public class ZonaEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private int id;

    @Column(name = "nombre_zona", nullable = false)
    private String nombre;

    @Column(name = "tarifa_envio", nullable = false)
    private double tarifaEnvio;

    @OneToMany(mappedBy = "zonaEnvio")
    private List<Cliente> clientes;

    public ZonaEnvio() {}

    public ZonaEnvio(String nombre, double tarifaEnvio) {
        this.nombre = nombre;
        this.tarifaEnvio = tarifaEnvio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getTarifaEnvio() { return tarifaEnvio; }

    @Override
    public String toString() {
        return String.format("ZonaEnvio{id=%d, nombre='%s', tarifaEnvio=%.2f}", id, nombre, tarifaEnvio);
    }
}
