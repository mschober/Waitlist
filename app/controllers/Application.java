package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;
import utils.EmailValidator;
import utils.Lakewood;
import utils.PhoneNumberValidator;
import utils.SimpleEmailValidator;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void que() {
		List<Applicant> applicants = Lakewood.findAllApplicantsBy(Lakewood.ALL_BY_ID);
		render(applicants);
	}

	public static void post(@Required String fname, @Required String lname,
			@Required String email, @Required String phoneNumber,
			@Required String postalAddress, @Required String city,
			@Required String state, @Required int zip) {
		if (validation.hasErrors())
			System.out.println("failed required parameters");
		else if (!SimpleEmailValidator.validate(email))
			System.out.println("invalid email address for: " + email);
		else if (!PhoneNumberValidator.validate(phoneNumber))
			System.out.println("invalid phone number for: " + phoneNumber);
		else {
			PostalAddress address = new PostalAddress(postalAddress, city, state, zip).save();
			Contact contact = new Contact(email, phoneNumber, address).save();
			new Applicant(fname, lname, contact).save();
		}

		index();
	}

}