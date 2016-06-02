package br.unifor.locadora.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.locadora.modelo.Carro;
import br.unifor.locadora.modelo.StatusCarro;

/**
 * Classe DAO de Carro 
 * @author Grupo4
 *
 */
@Transactional
@Repository
public class CarroDao {
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Lista carros que estão na Garagem
	 * @return lista
	 */
	public List<Carro> listaDisponiveis(){
		return manager.createQuery("select c from Carro c where c.statusCarro='GARAGEM'", Carro.class)
				.getResultList();
	}
	
	/**
	 * Lista de todos os Status do Carro
	 * @return lista
	 */
	public List<StatusCarro> getTodosOsEstagios(){
		return Arrays.asList(StatusCarro.values());
	}
	
	//teste
	public Carro carregaModelo(Integer id){
		return manager.find(Carro.class, id);
	}
}
