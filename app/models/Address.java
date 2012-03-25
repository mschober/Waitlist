package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Address extends Model {

	public String address;
	public String city;
	public String state;
	public int zip;

	public Address(String address, String city, String state, int zip) {
		this.address = address;
		this.city = city;
		this.state = state; 
		this.zip = zip;
	}

}
