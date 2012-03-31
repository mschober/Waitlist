package utils.data.validation;

import java.util.regex.Pattern;

import play.data.validation.Validation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

@SuppressWarnings("serial")
public class EmailCheck extends AbstractAnnotationCheck<Email> {

    private static final String PLAY_DEFAULT_EMAIL_PATTERN = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[a-zA-Z0-9](?:[\\w-]*[\\w])?";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
	final static String mes = "validation.email";
    static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void configure(Email email) {
        setMessage(email.message());
    }

    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) {
        value = Validation.willBeValidated(value);
        String email = value.toString();
		if (value == null || email.length() == 0) {
            return true;
        }
        return emailPattern.matcher(email).matches();
    }

	public static boolean validate(String emailAddress) {
		return emailPattern.matcher(emailAddress).matches();
	}
    
    
   
}

