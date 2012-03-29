package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Applicant extends Model {

	public String firstName;
	public String lastName;
	
	@OneToOne
	public Contact contact;
	@OneToOne
	public Boat boat;
	public Date date;

	public Applicant(String firstName, String lastName, Contact contact, Boat boat) {
		this.firstName = toCamelCase(firstName);
		this.lastName = toCamelCase(lastName);
		this.contact = contact;
		this.boat = boat;
		this.date = new Date();
	}

	private String toCamelCase(String name) {
		String endOfName = name.toLowerCase().substring(1);
		String firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
		return firstLetter.concat(endOfName);
	}
}
