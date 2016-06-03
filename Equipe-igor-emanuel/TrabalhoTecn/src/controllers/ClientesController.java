package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import beans.ClienteBean;
import persistencias.Clientes;
import utils.Container;

/**
 * Classe controller referente as acões de clientes
 * @author Lucas
 *
 */
public class ClientesController extends Controller {
	
	ClienteBean beanClientes = new ClienteBean();
	Clientes objClientes = new Clientes();
	int validacao = 0;
	
	
	public ClientesController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		beanClientes = (ClienteBean) Container.setBean(beanClientes, request.getParameterMap());
	}
	
	/**
	 * Método cadastro de cliente após autenticação
	 * @return none
	 */
	public void cadastrarCliente() throws Exception
	{
		try
		{
			retorno.put("root", new JSONObject());
		
			if(objClientes.cadastrar(beanClientes)){
				retorno.getJSONObject("root").put("validacao", validacao);
		}
		}catch(Exception e)
		{
			retorno.getJSONObject("root").put("validacao", validacao);
			e.printStackTrace();
		}
		
		response.getWriter().write(retorno.toString());
	}
	
}