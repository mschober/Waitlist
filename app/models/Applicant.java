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
	public Date date;

	public Applicant(String firstName, String lastName, Contact contact) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.date = new Date();
	}
}
