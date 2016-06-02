package br.unifor.locadora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.locadora.modelo.Usuario;

/**
 * Classe DAO de Usuário
 * @author Grupo4
 *
 */
@Transactional
@Repository
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Lista Usuário
	 * @return lista
	 */
	public List<Usuario> lista() {
		return manager.createQuery("select u from Usuario u", Usuario.class)
					.getResultList();
	}
	
	/**
	 * Lista Funcionários
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
	 * Adiciona Usuário
	 * @param usuario
	 */
	public void adiciona(Usuario usuario) {
		manager.persist(usuario);
	}

	/**
	 * Atualiza Usuário
	 * @param usuario
	 */
	public void atualiza(Usuario usuario) {
		manager.merge(usuario);
	}

	/**
	 * Remove Usuário
	 * @param usuario
	 */
	public void remove(Usuario usuario) {
		manager.remove(manager.merge(usuario));
	}

	/**
	 * Busca Usuário por Id
	 */
	public Usuario busca(Integer id) {
		return manager.find(Usuario.class, id);
	}

	/**
	 * Busca Usuário por login e senha
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
