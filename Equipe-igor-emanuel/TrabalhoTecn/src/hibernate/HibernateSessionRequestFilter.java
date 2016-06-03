package hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.StaleObjectStateException;

public class HibernateSessionRequestFilter implements Filter {   
	  
    @SuppressWarnings("unchecked")   
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {   
           
        try {   
        	  
        	if (SessaoUtil.currentSession()==null)
        		SessaoUtil.openSession();

        	SessaoUtil.currentSession().beginTransaction();   

            chain.doFilter(request, response);
            SessaoUtil.currentSession().getTransaction().commit();   
  
        } catch (StaleObjectStateException staleEx) {   
            throw staleEx;   
        } catch (Throwable ex) {   
            ex.printStackTrace();   
            try {   
                if (SessaoUtil.currentSession().getTransaction().isActive()) {   
                	SessaoUtil.currentSession().getTransaction().rollback();   
                }   
            } catch (Throwable rbEx) {   
                 
            }   
            throw new ServletException(ex);   
        }   
    }   
  
    public void init(FilterConfig filterConfig) throws ServletException {}   
  
    public void destroy() {}   
  
}  