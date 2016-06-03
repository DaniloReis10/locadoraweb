	package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.Controller;

public class FactoryRequisicoes {

	public static Controller run(String nomeClasse, HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {
		
		Controller objeto=null;
		String comando=servletRequest.getParameter("comando");
		
		try {
			Class classe = Class.forName ("controllers."+nomeClasse);
			Class[] construtorClasse = new Class[] { HttpServletRequest.class, HttpServletResponse.class };
			Constructor constructor = classe.getConstructor(construtorClasse);
			objeto = (Controller) constructor.newInstance(new Object[]{servletRequest, servletResponse});

			if (comando!=null)	{
				Method method = classe.getMethod(comando);  
				method.invoke(objeto);
			}
			
		} catch (NoClassDefFoundError e) {
			throw new Exception("Classe "+nomeClasse+" inexistente!", e);
	
		} catch (InvocationTargetException e) {
			throw new Exception("Falha ao executar o método "+servletRequest.getParameter("comando")+" inexistente!", e);
		}
		catch (NoSuchMethodException e) {
			throw new Exception("Método "+servletRequest.getParameter("comando")+" inexistente!", e);
		}
		
		return objeto;
	}

}
