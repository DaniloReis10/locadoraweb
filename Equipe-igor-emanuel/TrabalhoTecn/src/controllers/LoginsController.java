package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import persistencias.Logins;

public class LoginsController extends Controller{
	
	Logins objLogins = new Logins();
	
	public LoginsController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void logarCliente() throws Exception{
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		boolean validacao = objLogins.validarLoginCliente(login, senha);

		retorno.put("root", new JSONObject());
		retorno.getJSONObject("root").put("validacao", validacao);
		
		response.getWriter().write(retorno.toString());
	}
	
	public void logarFuncionario() throws Exception{
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		boolean validacao = objLogins.validarLoginFuncionario(login, senha);

		retorno.put("root", new JSONObject());
		retorno.getJSONObject("root").put("validacao", validacao);
		
		response.getWriter().write(retorno.toString());
	}

}
