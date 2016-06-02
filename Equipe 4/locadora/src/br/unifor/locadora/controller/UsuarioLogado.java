package br.unifor.locadora.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.unifor.locadora.modelo.Usuario;


/**
 * Classe que verifica se o Usuário está logado
 * @author Grupo4
 *
 */
@ManagedBean
@SessionScoped
public class UsuarioLogado implements Serializable {
	private Usuario usuario;
	
	public void loga (Usuario usuario){
		this.usuario = usuario;
	}
	
	public boolean estaLogado(){
		return this.usuario != null;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void desloga(){
		this.usuario=null;
	}
}
