package br.unifor.locadora.service;

import br.unifor.locadora.modelo.Usuario;

/**
 * Interface autenticadora para login
 * @author Grupo4
 *
 */
public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}