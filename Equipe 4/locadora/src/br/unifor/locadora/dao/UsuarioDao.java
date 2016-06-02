package br.unifor.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.locadora.modelo.Usuario;

/**
 * Classe DAO de Usu�rio
 * @author Grupo4
 *
 */
@Transactional
@Repository
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Lista Usu�rio
	 * @return lista
	 */
	public List<Usuario> lista() {
		return manager.createQuery("select u from Usuario u", Usuario.class)
					.getResultList();
	}
	
	/**
	 * Lista Funcion�rios
	 * @return lista
	 */
	public List<Usuario> listaFuncionarios() {
		return manager.createQuery("select u from Usuario u where u.funcionario=1", Usuario.class)
				.getResultList();
	}
	
	/**
	 * Lista Clientes
	 * @return lista
	 */
	public List<Usuario> listaClientes() {
		return manager.createQuery("select u from Usuario u where u.funcionario=0", Usuario.class)
				.getResultList();
	}
	
	/**
	 * Adiciona Usu�rio
	 * @param usuario
	 */
	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}

	/**
	 * Atualiza Usu�rio
	 * @param usuario
	 */
	public void atualiza(Usuario usuario) {
		manager.merge(usuario);
	}

	/**
	 * Remove Usu�rio
	 * @param usuario
	 */
	public void remove(Usuario usuario) {
		manager.remove(manager.merge(usuario));
	}

	/**
	 * Busca Usu�rio por Id
	 */
	public Usuario busca(Integer id) {
		return manager.find(Usuario.class, id);
	}

	/**
	 * Busca Usu�rio por login e senha
	 * @param login
	 * @param senha
	 * @return usuario
	 */
	public Usuario buscaPor(String login, String senha) {
		try {
			return manager
					.createQuery(
							"select u from Usuario u "
									+ "where u.login = :login and u.senha = :senha", Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
