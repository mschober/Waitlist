package controllers;

import java.util.List;

import net.sf.oval.constraint.Size;

import models.Applicant;
import models.Contact;
import models.PostalAddress;
import models.contact.PhoneNumber;
import play.data.validation.Email;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Phone;
import play.data.validation.Range;
import play.data.validation.Required;

import play.mvc.Controller;
import utils.Lakewood;
import utils.SimpleEmailValidator;
import utils.data.validation.DoesntStartWith;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void que() {
		List<Applicant> applicants = Lakewood.findAllApplicantsBy(Lakewood.ALL_BY_ID);
		render(applicants);
	}

	public static void post(
			@Required String fname, 
			@Required String lname,

			@Required 
			@Email 
			String email, 
			
			@Required 
			@Match("[0-9]{10}")
			@Range(min = 10, max = 10)
			@DoesntStartWith(0)
			String phoneNumber,
			
			@Required String postalAddress, 
			@Required String city,
			@Required String state, 
			@Required int zip) {
		PhoneNumber number = new PhoneNumber(phoneNumber);
		if (validation.hasErrors()){
			params.flash();
			validation.keep();
		}
		else if (!new SimpleEmailValidator().validate(email))
			System.out.println("invalid email address for: " + email);
		else if (!number.isValid())
			System.out.println("invalid phone number for: " + phoneNumber);
		else {
			PostalAddress address = new PostalAddress(postalAddress, city, state, zip).save();
			Contact contact = new Contact(email, number.toString(), address).save();
			new Applicant(fname, lname, contact).save();
		}

		index();
	}

}