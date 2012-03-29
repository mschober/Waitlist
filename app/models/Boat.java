package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Boat extends Model {

	public String type;

	public Boat(String type) {
		this.type = type;
	}

}
