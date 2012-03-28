package utils.data.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import play.data.validation.Email;
import play.data.validation.Validation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

public class DoesntStartWithCheck extends AbstractAnnotationCheck<DoesntStartWith> {

	final static String message = "cant start with 0";
	static Pattern doesntStartWith = Pattern.compile("[0-9]");
	
	char badStartCharacter;

	  @Override
	  public void configure(DoesntStartWith doesntStartWith) {
	      setMessage(doesntStartWith.message());
	      badStartCharacter = doesntStartWith.badStartCharacter();
	  }

	
	    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) {
	        requireMessageVariablesRecreation();
	        if (value == null) {
	            return true;
	        }
	        if (value instanceof String) {
	            try {
	                Character v = Character.valueOf(value.toString().charAt(0));
	                return v != badStartCharacter;
	            } catch (Exception e) {
	                return false;
	            }
	        }
			return false;
	    }

	    @Override
	    public Map<String, Character> createMessageVariables() {
	        Map<String, Character> messageVariables = new HashMap<String, Character>();
	        messageVariables.put("startingCharacter", badStartCharacter);
	        return messageVariables;
	    }
	
	
}
