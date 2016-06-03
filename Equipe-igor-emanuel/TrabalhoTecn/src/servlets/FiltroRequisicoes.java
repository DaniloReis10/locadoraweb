package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.FactoryRequisicoes;

/**
 * Classe responsavel pela inicialização do filtro mapeado no web.xml
 * @author Lucas
 *
 */
public class FiltroRequisicoes implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Método responsavel por formatar a data para o formato dd/MM/yyyy
	 * @return none 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filtro) throws IOException, ServletException {

		HttpServletRequest servletRequest=(HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		String chamada=servletRequest.getRequestURI();
		String nomeClasse=chamada.substring(chamada.indexOf("ajax")+5,chamada.indexOf("."));
		nomeClasse=nomeClasse.substring(nomeClasse.indexOf("ajax")+4)+"Controller";
		
		try {
			FactoryRequisicoes.run(nomeClasse, servletRequest, servletResponse);
			
		} catch (Exception e) {
			e.printStackTrace();
			filtro.doFilter(request, response);  
		}
		
	}
	
	/**
	 * Método invocado ao inicio do filtro. Usado neste contexto apenas para avisar do mesmo via console.
	 * @return none
	 */

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Iniciando Filtro... ");

	}

}