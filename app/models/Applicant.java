package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Applicant extends Model {

	public String firstName;
	public String lastName;
	public PrimaryContact contact;
	public Boat boat;
	public Date date;

	public Applicant(String firstName, String lastName, PrimaryContact contact, Boat boat) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.boat = boat;
		this.date = new Date();
	}
}
