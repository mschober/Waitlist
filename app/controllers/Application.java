package controllers;

import java.util.List;

import models.Applicant;
import models.Boat;
import models.Boat.BoatType;
import models.Contact;
import models.PostalAddress;
import models.contact.PhoneNumber;
//import play.data.validation.Email;
import play.data.validation.Range;
import play.data.validation.Required;
import play.mvc.Controller;
import utils.Lakewood;
import utils.SimpleEmailValidator;
import utils.data.validation.Email;
import utils.data.validation.Phone;

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
			@Phone
			String phoneNumber,
			
			@Required String postalAddress, 
			@Required String city,
			@Required String state, 
			
			@Required 
			@Range(min=0, max=99999)
			int zip) {
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
			Boat boat = new Boat(BoatType.POWER).save();
			new Applicant(fname, lname, contact, boat).save();
		}

		index();
	}

}
