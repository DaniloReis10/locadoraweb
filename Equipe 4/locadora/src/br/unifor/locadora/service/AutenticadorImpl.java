package br.unifor.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.locadora.dao.UsuarioDao;
import br.unifor.locadora.modelo.Usuario;

/**
 * Classe Service para autenticação de login
 * @author Grupo4
 *
 */
@Service("autenticador")
public class AutenticadorImpl implements Autenticador {

	private UsuarioDao dao;
	
	@Autowired
	public AutenticadorImpl(UsuarioDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Usuario autentica(String login, String senha) {
		Usuario usuario = dao.buscaPor(login, senha);
		return usuario;
	}

}