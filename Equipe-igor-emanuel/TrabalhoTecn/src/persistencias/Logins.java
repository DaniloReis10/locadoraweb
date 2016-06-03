package persistencias;

import java.util.List;

import hibernate.SessaoUtil;

/**
 * Classe DAO referente a logins
 * @author Lucas
 *
 */
public class Logins {
	
	boolean validacao = false;
	
	/**
	 * Método responsavel por efetuar o login de clientes checando as credenciais no banco
	 * @return validação (Boolean)
	 */
	public boolean validarLoginCliente(String email, String senha){
		
		SessaoUtil.openSession();
		List lista = SessaoUtil.consultar("beans.ClienteBean", "email,senha", "s,s", "=", ""+email+","+senha+"", "s", "id asc", 0, 0);
		SessaoUtil.closeCurrentsession();
	
		if(lista.size()>0)
			validacao = true;
	
	return validacao;
	}
	
	/**
	 * Método responsavel por efetuar o login de funcionarios checando as credenciais no banco
	 * @return validação (Boolean)
	 */
	public boolean validarLoginFuncionario(String email, String senha){
		
		SessaoUtil.openSession();
		List lista = SessaoUtil.consultar("beans.FuncionarioBean", "email,senha", "s,s", "=", ""+email+","+senha+"", "s", "id asc", 0, 0);
		SessaoUtil.closeCurrentsession();
	
		if(lista.size()>0)
			validacao = true;
	
	return validacao;
	}

}
