package br.unifor.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe Util de Acesso ao Banco de Dados
 * @author Grupo4
 *
 */
public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("carro");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
