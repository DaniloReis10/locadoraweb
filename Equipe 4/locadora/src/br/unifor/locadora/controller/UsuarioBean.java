package br.unifor.locadora.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.unifor.locadora.dao.UsuarioDao;
import br.unifor.locadora.modelo.Usuario;
import br.unifor.locadora.util.FacesUtil;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao dao;
	
	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void adiciona(){
		dao.adiciona(this.usuario);
		this.usuario = new Usuario();
		new FacesUtil().mensagemSucesso("Usu�rio adicionado com sucesso!");
	}
	
	public void lista(){
		this.usuarios = dao.lista();
	}
	
	public void remove(Usuario usuario){
		dao.remove(usuario);
		this.usuarios = dao.lista();
		new FacesUtil().mensagemSucesso("Usu�rio removido com sucesso!");
	}
	
	public void altera(){
		dao.atualiza(usuario);
		new FacesUtil().mensagemSucesso("Usu�rio alterado com sucesso!");
	}
}
