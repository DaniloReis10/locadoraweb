package br.unifor.locadora.controller.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe de Valida��o se a senha � forte
 * @author Grupo4
 *
 */
@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator {

	/**
	 * Devem haver mai�sculas e min�sculas, entre 6 e 20 caracteres e usar caractere especial
	 */
	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		
		String valor = value.toString();
		
		if (!valor.matches("((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")){
			throw new ValidatorException( 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"O campo senha n�o � forte o bastante",
					"A senha deve ter de 6 a 20 caracteres e deve conter n�meros."));
		}
		
	}
	
}
