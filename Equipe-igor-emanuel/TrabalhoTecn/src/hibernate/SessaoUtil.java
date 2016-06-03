package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class SessaoUtil {
	
	private static final SessionFactory sessionFactory;      
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>(); 
    
    static {   
        try{                  

            Configuration configuration = new AnnotationConfiguration()
            .addAnnotatedClass(hibernate.HibernateSessionRequestFilter.class)
            .addAnnotatedClass(beans.ClienteBean.class)
            .addAnnotatedClass(beans.FuncionarioBean.class);
            
            configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:8889/trabalho");   
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");   
            configuration.setProperty("hibernate.connection.username", "root");   
            configuration.setProperty("hibernate.connection.password","root");   
            //configuration.setProperty("hibernate.hbm2ddl.auto","create"); //@@@@ CRIAR TABELAS @@@@
            configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.c3p0.acquire_increment","1");
            configuration.setProperty("hibernate.c3p0.idle_test_period","100");
            configuration.setProperty("hibernate.c3p0.max_statements","0");
            configuration.setProperty("hibernate.c3p0.min_size","10");
            configuration.setProperty("hibernate.c3p0.max_size","100");
            configuration.setProperty("hibernate.c3p0.timeout","1800");
           
            sessionFactory = configuration.buildSessionFactory();
	
        }catch (Throwable t){   
            throw new ExceptionInInitializerError(t);   
        }   
    }
    

    public static Session openSession() {  
    	threadLocal.set(sessionFactory.openSession());   
        return threadLocal.get();   
    }   
  
    /**  
     * Fecha a sessão corrente  
     */   
    public static void closeCurrentsession() {   
    	threadLocal.get().close();   
    	threadLocal.set(null);   
    }   
  
    /**  
     * Retorna a sessão corrente  
     *  
     * @return Session: Sessão corrente  
     */   
    public static Session currentSession() {   
        return threadLocal.get();   
    }  
	
    public static boolean inserir(Object object) {
        try 
        {
        	Session session = (Session) threadLocal.get();  
        	session.persist(object);
        	session.flush();
        	return true;
        } 
        catch (Exception e)
        {
            return false;
        }
    }
    
    public static boolean atualizar(Object object) {
        try 
        {
        	Session session = (Session) threadLocal.get();  
        	session.merge(object);
        	session.flush();
        	return true;
        } 
        catch (Exception e)
        {
            return false;
        }
    }
    
    public static boolean deletar(Object object) {
        try 
        {
        	Session session = (Session) threadLocal.get();  
        	session.delete(object);
        	session.flush();  
        	return true;
        } 
        catch (Exception e)
        {
            return false;
        }
    }
    
	@SuppressWarnings("unchecked")
	public static List consultar(String classes,String camposCondicao,String tiposCamposCondicao,String operadorCamposCondicao,String valoresCondicao,String sinalizadorCondicaoPrincipal,String ordenacao,int limite,int pagina) 
	{
		Session session = (Session) threadLocal.get(); 
		Criteria criteriaPrincipal=null;
		Criteria criteriaSecundaria=null;
		
		String relacionamentoAtual="";
		String sinalizadorTemp="";
		String [] vetorClasses=classes.split(",");
		String [] vetorClassesTemp;
		String [] vetorCamposCondicao=camposCondicao.split(",");
		String [] vetorTiposCamposCondicao=tiposCamposCondicao.split(",");
		String [] vetorOperadorCamposCondicao=operadorCamposCondicao.split(",");
		String [] vetorValoresCondicao=valoresCondicao.split(",");
		
		if (sinalizadorCondicaoPrincipal.equals("n"))
			{
			criteriaPrincipal = session.createCriteria(vetorClasses[0]);
			criteriaPrincipal.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			relacionamentoAtual=vetorClasses[0];
			
			if (!ordenacao.equals(""))
				{	
				if (ordenacao.indexOf("asc")!=-1)
					criteriaPrincipal.addOrder(Order.asc(ordenacao.replaceAll(" asc","")));
				
				if (ordenacao.indexOf("desc")!=-1)
					criteriaPrincipal.addOrder(Order.desc(ordenacao.replaceAll(" desc","")));
				}
	
			if (limite!=0)
				{
				criteriaPrincipal.setFirstResult(pagina*limite);
				criteriaPrincipal.setMaxResults(limite);
				}
			
			for (int i=1;i<vetorClasses.length;i++)
				{
				if (i==1)
					sinalizadorTemp=vetorClasses[i];
					else
					sinalizadorTemp+=","+vetorClasses[i];
				}
			
			vetorClassesTemp=sinalizadorTemp.split(",");
			vetorClasses=vetorClassesTemp;
			}
		
		for (int i=0;i<vetorClasses.length;i++)
			{
			if (i==0 && relacionamentoAtual.equals(""))
				{
				criteriaPrincipal = session.createCriteria(vetorClasses[i]);
				criteriaPrincipal.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
				if (!ordenacao.equals(""))
					{	
					if (ordenacao.indexOf("asc")!=-1)
						criteriaPrincipal.addOrder(Order.asc(ordenacao.replaceAll(" asc","")));
					
					if (ordenacao.indexOf("desc")!=-1)
						criteriaPrincipal.addOrder(Order.desc(ordenacao.replaceAll(" desc","")));
					}
	
				if (limite!=0)
					{
					criteriaPrincipal.setFirstResult(pagina*limite);
					criteriaPrincipal.setMaxResults(limite);
					}
				}
			
			if (vetorClasses[i].indexOf("beans")!=-1 && sinalizadorCondicaoPrincipal.equals("s"))
				{
				for(i=0;i<vetorCamposCondicao.length;i++){
				if (vetorTiposCamposCondicao[i].equals("s"))
					criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toLowerCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("S"))
					criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toUpperCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("l"))
					criteriaPrincipal.add(Restrictions.ilike(vetorCamposCondicao[i],"%"+vetorValoresCondicao[i].replaceAll(" ","%")+"%")); 
				}
				i=0;
				if (vetorTiposCamposCondicao[i].equals("i"))
					{
					if (vetorOperadorCamposCondicao[i].equals("="))
						criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<"))
						criteriaPrincipal.add(Restrictions.lt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">"))
						criteriaPrincipal.add(Restrictions.gt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<="))
						criteriaPrincipal.add(Restrictions.le(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">="))
						criteriaPrincipal.add(Restrictions.ge(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("!="))
						criteriaPrincipal.add(Restrictions.ne(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					}
				}
				
				else
				{
				if (!relacionamentoAtual.equals(vetorClasses[i]))
					{
					criteriaSecundaria = criteriaPrincipal.createCriteria(vetorClasses[i]);
					relacionamentoAtual=vetorClasses[i];
					}
				
				if (vetorTiposCamposCondicao[i].equals("s"))
					criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toLowerCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("S"))
					criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toUpperCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("l"))
					criteriaSecundaria.add(Restrictions.ilike(vetorCamposCondicao[i],"%"+vetorValoresCondicao[i].replaceAll(" ","%")+"%"));
				
				if (vetorTiposCamposCondicao[i].equals("i"))
					{
					if (vetorOperadorCamposCondicao[i].equals("="))
						criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<"))
						criteriaSecundaria.add(Restrictions.lt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">"))
						criteriaSecundaria.add(Restrictions.gt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<="))
						criteriaSecundaria.add(Restrictions.le(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">="))
						criteriaSecundaria.add(Restrictions.ge(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("!="))
						criteriaSecundaria.add(Restrictions.ne(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					}
				}
			}

		return criteriaPrincipal.list();

	}
	
	@SuppressWarnings("unchecked")
	public static int findGenericCount(String classes,String camposCondicao,String tiposCamposCondicao,String operadorCamposCondicao,String valoresCondicao,String sinalizadorCondicaoPrincipal) 
	{
		Session session = (Session) threadLocal.get(); 
		Criteria criteriaPrincipal=null;
		Criteria criteriaSecundaria=null;

		String relacionamentoAtual="";
		String sinalizadorTemp="";
		String [] vetorClasses=classes.split(",");
		String [] vetorClassesTemp;
		String [] vetorCamposCondicao=camposCondicao.split(",");
		String [] vetorTiposCamposCondicao=tiposCamposCondicao.split(",");
		String [] vetorOperadorCamposCondicao=operadorCamposCondicao.split(",");
		String [] vetorValoresCondicao=valoresCondicao.split(",");

		if (sinalizadorCondicaoPrincipal.equals("n"))
			{
			criteriaPrincipal = session.createCriteria(vetorClasses[0]);
			criteriaPrincipal.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			relacionamentoAtual=vetorClasses[0];
			
			for (int i=1;i<vetorClasses.length;i++)
				{
				if (i==1)
					sinalizadorTemp=vetorClasses[i];
					else
					sinalizadorTemp+=","+vetorClasses[i];
				}

			vetorClassesTemp=sinalizadorTemp.split(",");
			vetorClasses=vetorClassesTemp;
			}

		for (int i=0;i<vetorClasses.length;i++)
			{
			if (i==0 && relacionamentoAtual.equals(""))
				{
				criteriaPrincipal = session.createCriteria(vetorClasses[i]);
				criteriaPrincipal.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				}
			
			if (vetorClasses[i].indexOf("beans")!=-1 && sinalizadorCondicaoPrincipal.equals("s"))
				{
				if (vetorTiposCamposCondicao[i].equals("s"))
					criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toLowerCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("S"))
					criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toUpperCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("l"))
					criteriaPrincipal.add(Restrictions.ilike(vetorCamposCondicao[i],"%"+vetorValoresCondicao[i].replaceAll(" ","%")+"%")); 
				
				if (vetorTiposCamposCondicao[i].equals("i"))
					{
					if (vetorOperadorCamposCondicao[i].equals("="))
						criteriaPrincipal.add(Restrictions.eq(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<"))
						criteriaPrincipal.add(Restrictions.lt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">"))
						criteriaPrincipal.add(Restrictions.gt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<="))
						criteriaPrincipal.add(Restrictions.le(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">="))
						criteriaPrincipal.add(Restrictions.ge(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("!="))
						criteriaPrincipal.add(Restrictions.ne(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					}
				}
				else
				{
				if (!relacionamentoAtual.equals(vetorClasses[i]))
					{
					criteriaSecundaria = criteriaPrincipal.createCriteria(vetorClasses[i]);
					relacionamentoAtual=vetorClasses[i];
					}
				
				if (vetorTiposCamposCondicao[i].equals("s"))
					criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toLowerCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("S"))
					criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i],vetorValoresCondicao[i].toUpperCase()));	
				
				if (vetorTiposCamposCondicao[i].equals("l"))
					criteriaSecundaria.add(Restrictions.ilike(vetorCamposCondicao[i],"%"+vetorValoresCondicao[i].replaceAll(" ","%")+"%"));
				
				if (vetorTiposCamposCondicao[i].equals("i"))
					{
					if (vetorOperadorCamposCondicao[i].equals("="))
						criteriaSecundaria.add(Restrictions.eq(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<"))
						criteriaSecundaria.add(Restrictions.lt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">"))
						criteriaSecundaria.add(Restrictions.gt(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("<="))
						criteriaSecundaria.add(Restrictions.le(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals(">="))
						criteriaSecundaria.add(Restrictions.ge(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					
					if (vetorOperadorCamposCondicao[i].equals("!="))
						criteriaSecundaria.add(Restrictions.ne(vetorCamposCondicao[i], Integer.parseInt(vetorValoresCondicao[i])));
					}
				}
			}

		return criteriaPrincipal.list().size();
	}
       
}  