package persistencias;

import org.hibernate.StaleObjectStateException;

import hibernate.SessaoUtil;

/**
 * Classe DAO referente a clientes
 * @author Lucas
 *
 */
public class Clientes {
	
	/**
	 * Método cadastrar cliente no banco de dados(tabela: cliente)
	 * @return resultado da ação (Boolean)
	 */
	public boolean cadastrar(Object ClienteBean) throws Exception {
			
			boolean resultado = false;
			
			try {
				
					SessaoUtil.openSession();
					SessaoUtil.inserir(ClienteBean);
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