package utils.data.validation;

import java.util.regex.Pattern;

import utils.PhoneNumberValidator;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

public class PhoneCheck extends AbstractAnnotationCheck<Phone> {

    private static final String AREA_CODE = "([\\(]?[0-9]{3}([ \\.\\-\\)])?)";
	private static final String PREFIX = "([0-9]{3}([ \\.\\-\\)])?)";
	private static final String LINE_NUMBER = "([0-9 \\.\\-/]{4})";
	private static final String EXENSION = "((x|ext|extension)[ ]?[0-9]{1,4})?";
	
	final static String mes = "validation.phone";
    static Pattern phonePattern = Pattern.compile("^" + AREA_CODE + PREFIX + LINE_NUMBER /*+ EXENSION*/ + "$");

    @Override
    public void configure(Phone phone) {
        setMessage(phone.message());
    }

    @Override
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator)
    throws OValException {
        String phoneNumber = value.toString();
        return phonePattern.matcher(phoneNumber).matches() && isTenDigits(phoneNumber);
    }

	private boolean isTenDigits(String phoneNumber) {
		int countNumbers = countNumbers(phoneNumber);
		if(countNumbers == 10)
			return true;
		
		setMessage("Length must be 10 not " + countNumbers);
		return false;
	}

	private int countNumbers(String inPhoneNumber) {
		int numbers = 0;
		for(char c: inPhoneNumber.toCharArray())
			if(PhoneNumberValidator.isANumber(c))
				numbers++;
		return numbers;
	}

	public static boolean validate(String phoneNumber) {
		return phonePattern.matcher(phoneNumber).matches();
	}

}
