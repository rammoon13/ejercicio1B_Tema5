package ies.castillodeluna.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase para gestionar la conexión con Hibernate.
 */
public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pedidosPU");

    /**
     * Retorna la instancia del EntityManagerFactory.
     *
     * @return EntityManagerFactory.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    /**
     * Cierra el EntityManagerFactory cuando la aplicación termina.
     */
    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
