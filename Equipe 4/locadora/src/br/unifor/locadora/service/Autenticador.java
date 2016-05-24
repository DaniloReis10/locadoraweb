package br.unifor.locadora.service;

import br.unifor.locadora.modelo.Usuario;

public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}