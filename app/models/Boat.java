package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Boat extends Model {

	public String type;

	public Boat(BoatType type) {
		this.type = type.toString().toLowerCase();
	}
	
	public enum BoatType {
		POWER, SAIL;
		
		@Override
		public String toString(){
			return this.name().toLowerCase();
		}
	}

}
