package br.unifor.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("carro");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
