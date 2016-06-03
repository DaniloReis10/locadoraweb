package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import beans.FuncionarioBean;
import persistencias.Funcionario;
import utils.Container;

public class FuncionariosController extends Controller {
	
	FuncionarioBean beanFuncionarios = new FuncionarioBean();
	Funcionario objFuncionarios = new Funcionario();
	int validacao = 0;
	
	
	public FuncionariosController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		beanFuncionarios = (FuncionarioBean) Container.setBean(beanFuncionarios, request.getParameterMap());
	}
	
	public void cadastrarFuncionario() throws Exception
	{
		try
		{
			retorno.put("root", new JSONObject());
		
			if(objFuncionarios.cadastrar(beanFuncionarios)){
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