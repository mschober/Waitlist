package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Email extends Model {

	@ManyToOne
	public Applicant applicant;
	
	public String address;
	public String city;
	public String state;
	public int zip;

	public Email(Applicant applicant, String address, String city, String state, int zip) {
		this.applicant = applicant;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
	}

}
