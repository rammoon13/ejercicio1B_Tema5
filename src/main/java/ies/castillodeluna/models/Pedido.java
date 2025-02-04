package ies.castillodeluna.models;

import java.util.Date;

public class Pedido {
    private int id; // ID único del pedido
    private Date fecha; // Fecha en la que se realizó el pedido
    private double importeTotal; // Importe total del pedido
    private int idCliente; // ID del cliente que hizo el pedido

    // Constructor que inicializa los atributos del pedido
    public Pedido(int id, Date fecha, double importeTotal, int idCliente) {
        this.id = id;
        this.fecha = fecha;
        this.importeTotal = importeTotal;
        this.idCliente = idCliente;
    }

    // Métodos getter para obtener los valores de los atributos
    public int getId() { return id; }
    public Date getFecha() { return fecha; }
    public double getImporteTotal() { return importeTotal; }
    public int getIdCliente() { return idCliente; }

    // Método para representar el pedido como una cadena de texto
    @Override
    public String toString() {
        return String.format("Pedido{id=%d, fecha=%s, importeTotal=%.2f, idCliente=%d}", 
                id, fecha, importeTotal, idCliente);
    }
}
