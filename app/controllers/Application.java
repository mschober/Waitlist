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
import play.db.jpa.JPABase;
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
			String boatType,

			@Required 
			@Email 
			String email, 
			
			@Required 
			@Phone
			String phoneNumber,
			
			String postalAddress, 
			String city,
			String state, 
			
			@Range(min=0, max=99999)
			int zip) {
		if (validation.hasErrors()){
			params.flash();
			validation.keep();
		}
		else {
			PhoneNumber number = new PhoneNumber(phoneNumber);
			PostalAddress address = new PostalAddress(postalAddress, city, state, zip).save();
			Contact contact = new Contact(email, number.toString(), address).save();
			Boat boat = null;
			if(boatType.equals("Power"))
				boat = new Boat(BoatType.POWER).save();
			else if(boatType.equals("Sail"))
				boat = new Boat(BoatType.SAIL).save();
				
			new Applicant(fname, lname, contact, boat).save();
		}

		index();
	}

}
