package ies.castillodeluna.dao;

import ies.castillodeluna.models.Cliente;
import jakarta.persistence.*;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void agregarCliente(Cliente cliente) {
        em.persist(cliente);
    }

    public void borrarCliente(int idCliente) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, idCliente);
        if (cliente != null) {
            em.remove(cliente);
        }
        em.getTransaction().commit();
    }

    public List<Cliente> obtenerClientes() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
