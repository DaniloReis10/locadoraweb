package persistencias;

import java.util.List;

import org.hibernate.StaleObjectStateException;

import hibernate.SessaoUtil;

public class Funcionario {
	
	public boolean cadastrar(Object FuncionarioBean) throws Exception {
		
		boolean resultado = false;
		
		try {
			
				SessaoUtil.openSession();
				SessaoUtil.inserir(FuncionarioBean);
				SessaoUtil.currentSession().beginTransaction().commit();
				resultado= true;
				
		}catch(StaleObjectStateException staleException){
			throw staleException;
		}catch(Exception e){
				
			if (SessaoUtil.currentSession().getTransaction().isActive()) 
					SessaoUtil.currentSession().getTransaction().rollback();
			
		}		
		
		return resultado;
	}
	
	
	
	public List exibir(){
		
		SessaoUtil.openSession();
		List lista = SessaoUtil.consultar("beans.FuncionarioBean", "", "", "", "", "s", "id asc", 0, 0);
		SessaoUtil.closeCurrentsession();
	
	return lista;
	}
	
public boolean excluir(Object FuncionarioBean) throws Exception{

	boolean resultado = false;
	
	try
	{
	
		SessaoUtil.openSession();
		SessaoUtil.deletar(FuncionarioBean);
		SessaoUtil.currentSession().beginTransaction().commit();
		SessaoUtil.closeCurrentsession();
		resultado= true;
		
	}catch(StaleObjectStateException staleException)
	{
		throw staleException;
	}catch(Exception e)
	{
			
		if (SessaoUtil.currentSession().getTransaction().isActive()) 
				SessaoUtil.currentSession().getTransaction().rollback();
		
	}		
	return resultado;
	}

}
