package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class PrimaryContact extends Model {

	public String address;
	public String email;
	public String phoneNumber;

	public PrimaryContact(String address, String email, String phoneNumber){
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	};
}
