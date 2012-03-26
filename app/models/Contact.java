package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.contact.PhoneNumber;

import play.db.jpa.Model;
import utils.PhoneNumberValidator;

@Entity
public class Contact extends Model {

	public String email;
	public String phoneNumber;
	
	@OneToOne
	public PostalAddress postalAddress;

	public Contact(String email, String phoneNumber, PostalAddress address) {
        this.email = email;
        this.phoneNumber = new PhoneNumber(phoneNumber).toString();
        this.postalAddress = address;
	}

}