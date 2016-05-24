package br.unifor.locadora.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


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
