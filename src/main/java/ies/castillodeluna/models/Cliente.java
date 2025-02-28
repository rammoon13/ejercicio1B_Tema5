package ies.castillodeluna.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaEnvio zonaEnvio;

    /**
     * Constructor vacío requerido por Hibernate.
     */
    public Cliente() {}

    /**
     * Constructor sin ID, ya que Hibernate lo generará automáticamente.
     */
    public Cliente(String nombre, String email, String telefono, ZonaEnvio zonaEnvio) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.zonaEnvio = zonaEnvio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public ZonaEnvio getZonaEnvio() { return zonaEnvio; }

    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', email='%s', telefono='%s', zonaEnvio=%s}",
                id, nombre, email, telefono, zonaEnvio.getNombre());
    }
}
