package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import persistencias.Logins;

/**
 * Classe controller resposavel pelo login de funcionarios e clientes
 * @author Lucas
 *
 */
public class LoginsController extends Controller{
	
	Logins objLogins = new Logins();
	
	public LoginsController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	/**
	 * Método responsavel pelo login do cliente
	 * @return none
	 */
	public void logarCliente() throws Exception{
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		boolean validacao = objLogins.validarLoginCliente(login, senha);

		retorno.put("root", new JSONObject());
		retorno.getJSONObject("root").put("validacao", validacao);
		
		response.getWriter().write(retorno.toString());
	}
	
	/**
	 * Método responsavel pelo login do funcionario
	 * @return none
	 */
	public void logarFuncionario() throws Exception{
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		boolean validacao = objLogins.validarLoginFuncionario(login, senha);

		retorno.put("root", new JSONObject());
		retorno.getJSONObject("root").put("validacao", validacao);
		
		response.getWriter().write(retorno.toString());
	}

}
