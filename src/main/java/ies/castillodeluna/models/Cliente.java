package ies.castillodeluna.models;

public class Cliente {
    private int id; // ID único del cliente
    private String nombre; // Nombre del cliente
    private String email; // Correo electrónico del cliente
    private String telefono; // Teléfono del cliente
    private int idZona; // ID de la zona de envío del cliente

    // Constructor que inicializa los datos del cliente
    public Cliente(int id, String nombre, String email, String telefono, int idZona) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.idZona = idZona;
    }

    // Métodos getter para obtener los valores de los atributos
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public int getIdZona() { return idZona; }

    // Método para representar el cliente como una cadena de texto
    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nombre='%s', email='%s', telefono='%s', idZona=%d}", 
                id, nombre, email, telefono, idZona);
    }
}
