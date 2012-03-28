package utils.data.validation;

import java.util.regex.Pattern;

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
    											//"^([\\+][0-9]{1,3}([ \\.\\-]))?([\\(]{1}[0-9]{2,6}[\\)])?([0-9 \\.\\-/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$"
    static Pattern phonePattern = Pattern.compile("^" + AREA_CODE + PREFIX + LINE_NUMBER /*+ EXENSION*/ + "$");

    @Override
    public void configure(Phone phone) {
        setMessage(phone.message());
    }

    @Override
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator)
    throws OValException {
        if (value == null || value.toString().length() == 0) {
            return true;
        }
        return phonePattern.matcher(value.toString()).matches();
    }

}
