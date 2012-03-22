package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Boat extends Model {

	public Double length;
	public Double width;
	public Double keel;

	public Boat(Double length, Double width, Double keel){
		this.length = length;
		this.width = width;
		this.keel = keel;
	}
}
