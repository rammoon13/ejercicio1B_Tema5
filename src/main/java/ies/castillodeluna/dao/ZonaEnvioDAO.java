package ies.castillodeluna.dao;

import ies.castillodeluna.models.ZonaEnvio;
import jakarta.persistence.*;
import java.util.List;

public class ZonaEnvioDAO {
    private EntityManager em;

    /**
     * Constructor que recibe el EntityManager.
     * @param em EntityManager para gestionar la persistencia.
     */
    public ZonaEnvioDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Obtiene una lista de todas las zonas de envío registradas en la base de datos.
     *
     * @return Lista de objetos {@link ZonaEnvio} con la información de cada zona de envío.
     */
    public List<ZonaEnvio> obtenerZonasEnvio() {
        return em.createQuery("SELECT z FROM ZonaEnvio z", ZonaEnvio.class).getResultList();
    }
}
