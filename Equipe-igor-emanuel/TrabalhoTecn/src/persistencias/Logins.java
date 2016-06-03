package persistencias;

import java.util.List;

import hibernate.SessaoUtil;

public class Logins {
	
	boolean validacao = false;
	
	public boolean validarLoginCliente(String email, String senha){
		
		SessaoUtil.openSession();
		List lista = SessaoUtil.consultar("beans.ClienteBean", "email,senha", "s,s", "=", ""+email+","+senha+"", "s", "id asc", 0, 0);
		SessaoUtil.closeCurrentsession();
	
		if(lista.size()>0)
			validacao = true;
	
	return validacao;
	}
	
	public boolean validarLoginFuncionario(String email, String senha){
		
		SessaoUtil.openSession();
		List lista = SessaoUtil.consultar("beans.FuncionarioBean", "email,senha", "s,s", "=", ""+email+","+senha+"", "s", "id asc", 0, 0);
		SessaoUtil.closeCurrentsession();
	
		if(lista.size()>0)
			validacao = true;
	
	return validacao;
	}

}
