package persistencias;

import org.hibernate.StaleObjectStateException;

import hibernate.SessaoUtil;

/**
 * Classe DAO referente a funcionarios
 * @author Lucas
 *
 */
public class Funcionario {
	
	/**
	 * Método cadastrar funcionarios no banco de dados(tabela: funcionario)
	 * @return resultado da ação (Boolean)
	 */
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

}