package br.unifor.locadora.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.locadora.modelo.Carro;
import br.unifor.locadora.modelo.StatusCarro;

@Transactional
@Repository
public class CarroDao {
	@PersistenceContext
	private EntityManager manager;
	
	public List<Carro> listaDisponiveis(){
		return manager.createQuery("select c from Carro c where c.statusCarro='GARAGEM'", Carro.class)
				.getResultList();
	}
	
	public List<StatusCarro> getTodosOsEstagios(){
		return Arrays.asList(StatusCarro.values());
	}
	
	public Carro carregaModelo(Integer id){
		return manager.find(Carro.class, id);
	}
}
