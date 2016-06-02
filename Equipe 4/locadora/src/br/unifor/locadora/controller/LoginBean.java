package br.unifor.locadora.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.unifor.locadora.modelo.Usuario;
import br.unifor.locadora.service.Autenticador;
import br.unifor.locadora.util.FacesUtil;

/**
 * Classe Bean para Login
 * @author Grupo4
 *
 */

@ManagedBean
@RequestScoped
public class LoginBean {
	private String login;
	private String senha;
	
	@ManagedProperty("#{autenticador}")
	private Autenticador autenticador;
	
	@ManagedProperty("#{usuarioLogado}")
	private UsuarioLogado usuarioLogado;
	
	
	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public Autenticador getAutenticador() {
		return autenticador;
	}
	public void setAutenticador(Autenticador autenticador) {
		this.autenticador = autenticador;
	}
	/**
	 * Método de logar após autenticação
	 * @return redireciona para a página principal (Lista de OS)
	 */
	public String logar(){
		autenticador.autentica(login, senha);
		if (autenticador.autentica(login, senha) != null){
			usuarioLogado.loga(autenticador.autentica(login, senha));
			return "/pages/os/lista?faces-redirect=true";
		} else {
		new FacesUtil().mensagemErro("Login ou senha inválido");
		}
		return null;
	}
	
	
	/**
	 * Método de deslogar
	 * @return redireciona para a tela de login
	 */
	public String deslogar(){
		usuarioLogado.desloga();
		return "/pages/login?faces-redirect=true";
	}
}
