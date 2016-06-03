package persistencias;

import java.util.List;

import org.hibernate.StaleObjectStateException;
import hibernate.SessaoUtil;

public class Clientes {
	
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
		
		
		
		public List exibir(){
			
			SessaoUtil.openSession();
			List lista = SessaoUtil.consultar("beans.ClienteBean", "", "", "", "", "s", "id asc", 0, 0);
			SessaoUtil.closeCurrentsession();
		
		return lista;
		}
		
	public boolean excluir(Object ClienteBean) throws Exception{
	
		boolean resultado = false;
		
		try
		{
		
			SessaoUtil.openSession();
			SessaoUtil.deletar(ClienteBean);
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
