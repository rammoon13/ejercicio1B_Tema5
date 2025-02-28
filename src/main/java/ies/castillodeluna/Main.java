package ies.castillodeluna;

import ies.castillodeluna.db.HibernateUtil;
import ies.castillodeluna.ui.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Menu menu = new Menu(em);
        menu.mostrarMenu();

        em.close();
        HibernateUtil.shutdown();
    }
}
