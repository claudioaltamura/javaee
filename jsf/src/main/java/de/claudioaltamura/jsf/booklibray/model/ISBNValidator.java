package de.claudioaltamura.jsf.booklibray.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("isbnValidator")
public class ISBNValidator implements Validator {
	
	private final static Logger LOGGER = Logger.getLogger(ISBNValidator.class.getName());
	private static final int CORRECT_LENGTH = 15; 

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		LOGGER.log(Level.INFO, "validating: " + arg2);

		String value = arg2.toString();
		
		if(value.length() != CORRECT_LENGTH) {
	      FacesMessage msg =
	              new FacesMessage("ISBN validation failed.",
	              "Please provide correct ISBN Format");
	      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    
	      throw new ValidatorException(msg);
	    }
	}

}
