package br.unifor.locadora.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.unifor.locadora.dao.OsDao;
import br.unifor.locadora.modelo.Carro;
import br.unifor.locadora.modelo.Os;
import br.unifor.locadora.modelo.Status;
import br.unifor.locadora.modelo.StatusCarro;
import br.unifor.locadora.modelo.Usuario;
import br.unifor.locadora.util.FacesUtil;

/**
 * Classe Bean para as Ordem de Servi�os
 * @author Grupo4
 *
 */

@ManagedBean
public class OsBean {
	private Os os = new Os();
	private List<Os> oss;
	
	@ManagedProperty("#{osDao}")
	private OsDao osDao;
	
	@PostConstruct
	public void init(){
		this.os.setResponsavel(new Usuario());
		this.os.setCliente(new Usuario());
		this.os.setCarro(new Carro());
	}

	public Os getOs() {
		return os;
	}

	public void setOs(Os os) {
		this.os = os;
	}

	public List<Os> getOss() {
		return oss;
	}

	public void setOss(List<Os> oss) {
		this.oss = oss;
	}

	public OsDao getOsDao() {
		return osDao;
	}

	public void setOsDao(OsDao osDao) {
		this.osDao = osDao;
	}

	/**
	 * Adiciona nova OS
	 */
	public void adiciona(){
		osDao.adiciona(this.os);
		this.os = new Os();
		new FacesUtil().mensagemSucesso("Ordem de Servi�o adicionada com sucesso!");
	}
	
	/**
	 * Lista as Os
	 */
	public void lista(){
		this.oss = osDao.lista();
	}
	
	/**
	 * Lista as Os com status ABERTO
	 */
	public void listaAbertas(){
		this.oss = osDao.listaAbertas();
	}
	
	/**
	 * Remove Os
	 * @param os
	 */
	public void remove(Os os){
		osDao.remove(os);
		this.oss = osDao.lista();
		new FacesUtil().mensagemSucesso("Ordem de Servi�o removida com sucesso!");
	}
	
	/**
	 * Conclu� Os, Status modificado para FECHADO
	 * @param os
	 */
	public void conclui(Os os){
		osDao.conclui(os);
		this.oss = osDao.lista();
		new FacesUtil().mensagemSucesso("Ordem de Servi�o fechada com sucesso!");
	}
	
	/**
	 * Altera/Edita Os
	 * @param os
	 */
	public void altera(Os os){
		osDao.atualiza(os);
		new FacesUtil().mensagemSucesso("Ordem de Servi�o alterada com sucesso!");
	}
	
	//teste
	public void carregaModelo(Os os){
		os.getCarro().setModelo(os.getCarro().getModelo());;
	}
	
	//teste
	public void acompanha(Os os){
		osDao.acompanha(os);
	}
	
}
