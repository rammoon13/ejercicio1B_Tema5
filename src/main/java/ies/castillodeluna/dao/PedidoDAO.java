package ies.castillodeluna.dao;

import ies.castillodeluna.models.Pedido;
import jakarta.persistence.*;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    /**
     * Constructor que recibe el EntityManager.
     * @param em EntityManager para gestionar la persistencia.
     */
    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Agrega un nuevo pedido a la base de datos.
     *
     * @param pedido Objeto Pedido con los datos a insertar.
     */
    public void agregarPedido(Pedido pedido) {
        em.persist(pedido);
    }

    /**
     * Elimina un pedido de la base de datos usando su ID.
     *
     * @param idPedido ID del pedido a eliminar.
     */
    public void borrarPedido(int idPedido) {
        Pedido pedido = em.find(Pedido.class, idPedido);
        if (pedido != null) {
            em.remove(pedido);
        }
    }

    /**
     * Obtiene una lista de todos los pedidos realizados por un cliente específico.
     *
     * @param idCliente ID del cliente del cual se desean obtener los pedidos.
     * @return Lista de pedidos asociados al cliente.
     */
    public List<Pedido> obtenerPedidosPorCliente(int idCliente) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.id = :idCliente", Pedido.class)
                .setParameter("idCliente", idCliente)
                .getResultList();
    }
}
