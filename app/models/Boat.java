package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Boat extends Model {

	public String type;
	public int length;
	public int beam;

	public Boat(BoatType type) {
		this.type = type.toString();
		this.length = 10;
		this.beam = 10;
	}
	
	public enum BoatType {
		POWER, SAIL;
		
		@Override
		public String toString(){
			return String.valueOf(this.name().charAt(0)) + this.name().substring(1).toLowerCase();
		}
	}

}
