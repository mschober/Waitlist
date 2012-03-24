package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Email extends Model {

	@ManyToOne
	public Applicant applicant;
	
	public String email;

	public Email(Applicant applicant, String email) {
		this.applicant = applicant;
        this.email = email;
	}

}
