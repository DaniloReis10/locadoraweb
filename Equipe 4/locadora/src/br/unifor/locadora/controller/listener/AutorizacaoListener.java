package br.unifor.locadora.controller.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.unifor.locadora.controller.UsuarioLogado;

public class AutorizacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		String paginaAcessada = context.getViewRoot().getViewId();
		if ("/pages/login.xhtml".equals(paginaAcessada)){
			return;
		}
		
		UsuarioLogado usuarioLogado = context.getApplication()
				.evaluateExpressionGet(context, "#{usuarioLogado}", UsuarioLogado.class);
		
		if (!usuarioLogado.estaLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/pages/login?faces-redirect=true");
			
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
