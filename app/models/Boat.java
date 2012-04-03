package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import models.Boat.BoatType;

import play.db.jpa.Model;

@Entity
public class Boat extends Model {

	public String type;
	public int length;
	public int beam;

	public Boat(BoatType type) {
		this(type, 10, 10);
	}
	
	public Boat(BoatType type, int length, int beam) {
		this.type = type.toString();
		this.length = length;
		this.beam = beam;
	}

	public enum BoatType {
		POWER, SAIL;
		
		@Override
		public String toString(){
			return String.valueOf(this.name().charAt(0)) + this.name().substring(1).toLowerCase();
		}
	}

	public Boat setLength(int length) {
		this.length = length;
		this.save();
		return this;
	}

	public Boat setBeam(int beam) {
		this.beam = beam;
		this.save();
		return this;
	}

}
