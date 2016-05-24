package br.unifor.locadora.controller.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		
		String valor = value.toString();
		
		if (!valor.matches("((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")){
			throw new ValidatorException( 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"O campo senha não é forte o bastante",
					"A senha deve ter de 6 a 20 caracteres e deve conter números."));
		}
		
	}
	
}
