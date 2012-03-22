package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Applicant extends Model {

	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String email;
	public Date date;

	public Applicant(String firstName, String lastName, String address, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.date = new Date();
	}
}
