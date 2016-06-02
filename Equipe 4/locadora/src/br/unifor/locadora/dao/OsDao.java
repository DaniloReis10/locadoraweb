package br.unifor.locadora.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.locadora.modelo.Comentario;
import br.unifor.locadora.modelo.Os;
import br.unifor.locadora.modelo.Status;
import br.unifor.locadora.modelo.StatusCarro;


@Transactional
@Repository
public class OsDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Os> lista() {
		return manager.createQuery("select o from Os o ", Os.class)
					.getResultList();
	}
	
	public List<Os> listaAbertas() {
		return manager.createQuery("select o from Os o where o.status='ABERTO'", Os.class)
					.getResultList();
	}
	
	public void adiciona(Os os){
		manager.merge(os);
	}
	
	public void atualiza(Os os){
		manager.merge(os);
	}
	
	public void remove(Os os){
		manager.remove(manager.merge(os));
	}
	
	public Os busca(Integer id){
		return manager.find(Os.class, id);
	}
	
	public List<Os> listaPaginada(int inicio, int quantidade){
		try{
			return manager
					.createQuery("select o from Os o", Os.class)
					.setFirstResult(inicio)
					.setMaxResults(quantidade)
					.getResultList();
		} catch (Exception e){
			return null;
		}
	}
	
	public int contaTodos(){
		try{
			Long count = manager
					.createQuery("select count(o) from Os o", Long.class)
					.getSingleResult();
			return count.intValue();
		} catch (Exception e){
			return 0;
		}
	}
	
	public List<Os> getOsDoUsuario(Integer id){
		try{
			return manager
					.createQuery("select o from Os o where o.responsavel.id = :id", Os.class)
					.setParameter("id", id)
					.getResultList();
		} catch (Exception e){
			return null;
		}
	}
	
	public Os buscaComComentarios(Integer id){
		try{
			Os os = manager.find(Os.class, id);
			if (os !=null) 
				os.getComentarios().size();
			return os;	
			
		} catch (Exception e){
			return null;
		}
	}
	
	public void conclui(Os os){
		os.setFinalizadoEm(new Date());
		os.setStatus(Status.FECHADO);
		os.getCarro().setStatusCarro(StatusCarro.GARAGEM);
		manager.merge(os);
	}
	
	public void comenta(Integer id, Comentario comentario) {
		try {
			Os os = this.busca(id);
			os.comenta(comentario);
		} catch (Exception e) {
		}
	}
	
	public void entrega(Integer id, Comentario comentario){
		try{
			Os os = this.busca(id);
			os.entrega(comentario);
		} catch (Exception e) {
		}

	}
	
	public String acompanha (Os os){
		if (os.getCarro().getStatusCarro().equals("STAND_BY")){
			return "/pages/ciclo/acompanha";
		}
		
		return "/pages/ciclo/ciclo";
	}
	
}
