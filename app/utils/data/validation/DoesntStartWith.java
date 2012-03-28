package utils.data.validation;

import play.data.validation.EmailCheck;

public @interface DoesntStartWith {

	String message() default DoesntStartWithCheck.message;

	char badStartCharacter();

}
