package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Contact extends Model {

	public String email;

	public Contact(String email) {
        this.email = email;
	}

}