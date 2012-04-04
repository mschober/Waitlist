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
		List<Applicant> applicants = Lakewood.findAllApplicants();
		render(applicants);
	}

	public static void post(
			@Required String fname1, 
			@Required String fname2, 

			@Required String lname1,
			@Required String lname2,
			
			@Required 
			String boatType,
			int boatLength,
			int boatBeam,

			@Required 
			@Email 
			String email1, 

			@Required 
			@Email 
			String email2, 

			@Required 
			@Phone
			String phoneNumber1,
			@Required 
			@Phone
			String phoneNumber2,
			
			String postalAddress1, 
			String postalAddress2, 
			String city1,
			String city2,
			String state1, 
			String state2, 
			
			@Range(min=0, max=99999)
			int zip1,
			
			@Range(min=0, max=99999)
			int zip2){
		if (validation.hasErrors()){
			params.flash();
			validation.keep();
		}
		else {
			PhoneNumber number = new PhoneNumber(phoneNumber2);
			PostalAddress address = new PostalAddress(postalAddress1, city1, state1, zip1).save();
			Contact contact = new Contact(email1, number.toString(), address).save();
			
			Boat boat = buildABoat(boatType, boatLength, boatBeam);
			
			new Applicant(fname1, lname1, contact, boat).save();
		}

		index();
	}

	private static Boat buildABoat(String boatType, int boatLength, int boatBeam) {
		Boat boat = null;
		boatLength = (boatLength == 0) ? -1: boatLength;
		boatBeam = (boatBeam == 0) ? -1: boatBeam;
		
		if(boatType.equals("Power"))
			boat = new Boat(BoatType.POWER).save();
		else if(boatType.equals("Sail"))
			boat = new Boat(BoatType.SAIL).save();
		
		boat.setLength(boatLength).setBeam(boatBeam);
		return boat;
	}

}
