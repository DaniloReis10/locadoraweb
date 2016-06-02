package br.unifor.locadora.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe Util para mensagens de erro e sucesso
 * @author Grupo4
 *
 */
public class FacesUtil {
	
	private FacesContext facesContext;

	public FacesUtil() {
		
		this.facesContext = FacesContext.getCurrentInstance();
	}
	
	public void mensagemErro (String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public void mensagemSucesso (String mensagem){
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);
	}

}
