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

public class FiltroRequisicoes implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}
	
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

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Iniciando Filtro... ");

	}

}