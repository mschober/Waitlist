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
	public Date date;

	public Applicant(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = new Date();
	}
}
